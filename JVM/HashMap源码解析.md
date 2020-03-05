# HashMap源码解析

## 1、核心属性

```java
// 缺省table大小
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
// table最大长度
static final int MAXIMUM_CAPACITY = 1 << 30;
// 缺省负载因子大小
static final float DEFAULT_LOAD_FACTOR = 0.75f;
// 树化阈值
static final int TREEIFY_THRESHOLD = 8;
// 树降级为链表的阈值
static final int UNTREEIFY_THRESHOLD = 6;
// 树化的另一个参数，当哈希表中的所有元素个数超过64个，才会允许树化
 static final int MIN_TREEIFY_CAPACITY = 64;
```

```java
// 哈希表
transient Node<K,V>[] table;
// 当前哈希表中元素个数
transient int size;
// 当前哈希表结构修改次数
transient int modCount;
// 扩容阈值，当哈希表中的元素超过阈值，触发扩容
int threshold;
// 负载因子，默认赋值为0.75，可自行修改
//threshold = capacity * loadFactor = 表大小 * 0.75
final float loadFactor;
```



## 2、Node<K,V>

```java
static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            /*
            这里的hash值由外边计算得到并直接输入，并非自行计算
            路由寻址公式：（table.length-1）& node.hash 得到 放在table中的哪个具体桶位
            （16-1）& 1122 => B0000 0000 111 & B0100 0110 0010 => B0010 => 2
            */
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                    Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }
```



## 3、初始化方法

```java
// initialCapacity 传入的table大小，loadFactor 传入的负载因子
public HashMap(int initialCapacity, float loadFactor) {
    	
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                                               initialCapacity);
        //initialCapacity大于最大值则设置为最大值（1 << 30）
    	if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
    	//加载因子不能小于0和非法检验
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                                               loadFactor);
        this.loadFactor = loadFactor;
   		//调用方法tableSizeFor(initialCapacity)
        this.threshold = tableSizeFor(initialCapacity);
    }
// 总结：数据检验操作

------调用tableSizeFor(initialCapacity)------

```

```java
/*
  作用：返回一个大于或等于当前值cap的一个数字，并且这个数字一定是2的次方数
  假设 cap = 10
  n = 10 - 1 => 9
  
  1001 | 0100 => 1101 (此时1101为n新的赋值)
  1101 | 0011 => 1111
  1111 | 1111 => 1111
  ..
  最终，1111 => 15
  return 15 + 1
  
  一开始的 n = cap - 1 ，是为了防止2的次方数扩容。例如n为16，那么经过运行之后会变成32
*/ 
static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
// 总结：无论你设置的table长度是多少，最终table数组的长度一定是2的次方数
```



## 4、put( )

```java
public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

------调用hash(Object key)------

------调用putVal(hash(key), key, value, false, true)------

```

```java
// 作用：让key的hash值的高16位也参与路由运行,减少哈希碰撞
static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

// 异或：不同返回1，相同则返回0
假设 hash = 0010 0101 1010 1100 0011 1111 0010 1110 （hash方法为本地方法）
计算过程
    	   0010 0101 1010 1100 0011 1111 0010 1110
    	   ^
    	   0000 0000 0000 0000 0010 0101 1010 1100 
    	   ---------------------------------------
      =>   0010 0101 1010 1100 0001 1010 1000 0010
```

```java
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
    
        Node<K,V>[] tab;  // tab：引用当前的hashMap散列表
    	Node<K,V> p; // p：表示当前散列表的元素
    	int n, i; // n：表示散列表数组的长度  i：表示路由寻址 结果
    
//		将table赋值给tab，进而判断tab中是否有数值，若无，则调用resize()进行扩容，并将其长度赋值给n
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
    
/*
        i = (n - 1) & hash 路由寻址公式得到应该放在哪个桶，将数值赋值给变量i，进而判断该位置是否有		    数值，若无，则创建newNode(hash, key, value, null)将原来的 k-v 作为参数传递进去该table[i]
        得到(p = tab[i = (n - 1) & hash])，后续需要使用
*/
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);

        else {
//			e：node的临时元素，不为null的话，找到了一个与当前插入的key-value一致的元素
//          k：表示临时的一个key
            Node<K,V> e; K k;
            
// 			表示桶位中的该元素，与你当前插入的元素的key完全一致。后续需要进行替换操作
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            
// 			判断红黑树
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            
//			此时进入链表的情况，同时说明链表的头元素与我们插入的key不一致            
            else {
//				循环检查链表中的元素                
                for (int binCount = 0; ; ++binCount) {
//					如果p.next为空，则说明已经到链表的末尾了，但此时还没有一个和你一致的元素，那么就传					递参数 新建一个Node作为新元素                    
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
//                      在末尾新建一个Node后，判断是否超过8（由于for循环从0开始，故此										TREEIFY_THRESHOLD - 1=7，当binCount为7的时候，链表已有8个元素）
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
//                  如果e和传递进来的参数都相同，说明找到了相同key的node元素，则break跳出for循环，进					入到if (e != null) { }语句 
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
//					这里是将下一个元素e传递给p，意味着位数逐渐向下执行，属于for循环的一部分，每次都会						循环调用，不是上面的if语句内容                  
                    p = e;
                }
            }
//			e不等于null，条件成立说明，找到了一个与你插入元素key完全一致的数据，进行替换            
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
//		表示散列表结构被修改的次数，替换Node元素的value不计数    
        ++modCount;
//		插入新元素，size自增，如果自增后的值大于扩容阈值，则触发扩容    
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
```



## 5、resize( )

```java
//为了解决哈希冲突导致的链化影响查询效率的问题，扩容会缓解该问题
final Node<K,V>[] resize() {
/*	
		oldTab：引用扩容前的哈希表
		oldCap：表示扩容之前table数组的长度
		oldThr：表示扩容之前的扩容阈值，触发本次扩容的阈值
		
		newCap；扩容之后table数组的大小
		newThr：扩容之后，下次再次触发的条件
*/
        Node<K,V>[] oldTab = table; 
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
    
        int newCap, newThr = 0;

//		oldCap > 0 : 说明之前的table长度大于0，HashMap已经初始化过了，此次是正常扩容    
        if (oldCap > 0) {
//			扩容之前的table数组大小已经达到最大阈值后，则不扩容，同时设置扩容条件为int最大值
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            
//			oldCap左移一位实现数值翻倍，并且赋值给newCap，newCap小于数组最大值限制 且 扩容之前的阈值 			   大于等于 16。这种情况，则下次扩容的阈值 等于当前阈值翻倍            
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }
    
/*		
		oldCap = 0，oldThr（扩容前的阈值） > 0 说明在构造方法初始化时有传入 阈值参数
    	1.new HashMap(initCap,loadFactor)
    	2.new HashMap(initCap)
    	3.new HashMap(map) 并且这个map有数据
    	将旧的扩容阈值给新的数组。假设旧的数组超过12后进行扩容，那么说明旧的数组中有超过12位的数组可以给		  新的数组大小
*/
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
    
    
//		oldCap = 0 , oldThr = 0 对于 HashMap() 构造器方法      
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY; 									//16
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);     //12
        }
//		newThr为0时，通过newCap和loadFactor计算出一个newThr    
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }

//		将新的阈值传递给 全局变量threshold，创建并赋值给新的table    
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
            Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
   
// 		说明hashmap本次扩容之前，table不为null
        if (oldTab != null) {
//			循环遍历 table中的桶位
            for (int j = 0; j < oldCap; ++j) {
//				定义临时遍历e
                Node<K,V> e;
//				说明当前桶位中有数据，但数据具体是单个数据还是链表或红黑树并不确定 
                if ((e = oldTab[j]) != null) {
//					将旧table的元素设置为null，方便JVM垃圾回收
                    oldTab[j] = null;
                    
//					1、说明桶位中只有一个数据，地址寻址公式得到元素 新的newtable位置，并将e扔进去
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
//					2、判断当前节点是否树化
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
//					3、桶位已经形成链表
                    else { // preserve order
//						低位链表：存放在扩容之后的数组的下标位置，与当前数组的下标位置一致
                        Node<K,V> loHead = null, loTail = null;
//						高位链表：存放在扩容之后的数组的下标位置为 当前数组的下标位置 + 扩容之前数组的								 长度
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
//						将其原来lotail后面的链表断掉并将其 放在newtable中
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }
```



## 6、get( )

```java
final Node<K,V> getNode(int hash, Object key) {
/*
		tab:引用之前hashmap的散列表
		first:桶位中的头元素
		e:临时node元素
		n:table数组长度
*/    
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
//			1、定位出来的头元素 即为寻找的数据
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
//			2、下一个元素不为null，说明可能为链表或者红黑树
            if ((e = first.next) != null) {
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
//				3、桶位形成链表。当找不到元素的时候，会执行e = e.next，对下一个元素重新循环
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }
```



## 7、remove( )

```java
final Node<K,V> removeNode(int hash, Object key, Object value,
                               boolean matchValue, boolean movable) {
/*
		tab：引用当前hashmap中的散列表
		p：当前node元素（寻址结果 赋值给 p）
		n：表示散列表数组长度
		index：表示寻址结果
*/
        Node<K,V>[] tab; Node<K,V> p; int n, index;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (p = tab[index = (n - 1) & hash]) != null) {
/*			
			说明路由的桶位都是有数据的，需要进行查找操作，并且删除
			node：查找到的结果
			e：当前Node的下一个元素
*/
            Node<K,V> node = null, e; K k; V v;
            
//			1、当前桶位中的元素 即为 要删除的元素，将要查找的元素赋值给node            
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                node = p;
//			说明当前桶位为 链表 或红黑树            
            else if ((e = p.next) != null) {
                if (p instanceof TreeNode)
                    node = ((TreeNode<K,V>)p).getTreeNode(hash, key);
                else {
//					链表的情况，e = e.next循环遍历链表中的下一个元素，将要查找的元素赋值给node
                    do {
                        if (e.hash == hash &&
                            ((k = e.key) == key ||
                             (key != null && key.equals(k)))) {
                            node = e;
                            break;
                        }
                        p = e;
                    } while ((e = e.next) != null);
                }
            }
//			上边的先找到要删除数据node，在下边进行删除
            if (node != null && (!matchValue || (v = node.value) == value ||
                                 (value != null && value.equals(v)))) {
//				1、node为树节点，进行树节点移除操作
                if (node instanceof TreeNode)
                    ((TreeNode<K,V>)node).removeTreeNode(this, tab, movable);
//				2、桶位元素即为查找结果，则将该元素的下一个元素放至桶位中
                else if (node == p)
                    tab[index] = node.next;
//				3、说明为链表中的元素，将当前元素的下一个元素 设置为 要删除的下一个元素，和链表中删除一					个元素的方法一样，将p的尾结点指向 下下一个节点的头结点即可
                else
                    p.next = node.next;
                ++modCount;
                --size;
                afterNodeRemoval(node);
                return node;
            }
        }
        return null;
    }
```



## 8、replace( )

```java
 public boolean replace(K key, V oldValue, V newValue) {
        Node<K,V> e; V v;
        if ((e = getNode(hash(key), key)) != null &&
            ((v = e.value) == oldValue || (v != null && v.equals(oldValue)))) {
            e.value = newValue;
            afterNodeAccess(e);
            return true;
        }
        return false;
    }


    public V replace(K key, V value) {
        Node<K,V> e;
        if ((e = getNode(hash(key), key)) != null) {
            V oldValue = e.value;
            e.value = value;
            afterNodeAccess(e);
            return oldValue;
        }
        return null;
    }
```







## 附：

查看当前类中的所有方法：ALT+7

返回上次查看代码的位置：ctrl+alt+方向键 