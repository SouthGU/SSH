## IDEA搭建Hibernate教程

[入门搭建教程](https://blog.csdn.net/weixin_44486072/article/details/90106174)

### 一、注意事项：

```xml
<!-- 配置hibernate的映射文件所在的位置,注意前面的包路径采用"."，类路径采用"/" -->
<mapping resource="com.demo.domain/User.hbm.xml"/>
```

<img src="./img/10.png"  />

### 二、创建Maven工程，完整架构目录如下

<img src="./img/11.png"  />

### 三、POM.xml

```xml
<dependencies>
    <dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-core</artifactId>
      <version>5.4.2.Final</version>
    </dependency>
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>5.1.38</version>
    </dependency>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
    </dependency>
  </dependencies>
```



### 四、 **核心配置文件hibernate.cfg.xml** 

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
        <property name="bibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql:///hibernate?useUnicode=true&amp;characterEncoding=UTF-8</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password">12345678</property>
        <property name="hibernate.show_sql">true</property>
        <property name="hibernate.format_sql">true</property>
        <property name="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</property>
        <property name="dialect">org.hibernate.dialect.MySQL5Dialect</property>
        <property name="hibernate.hbm2ddl.auto">update</property>
        <property name="current_session_context_class">thread</property>
        <mapping resource="domain/Person.hbm.xml"/>
    </session-factory>
</hibernate-configuration>
```



### 五、 **实体类domain.Person**

```java
package domain;

/**
 * @Auther: sise.xgl
 * @Date: 2019/10/22/10:46
 * @Description:
 */
public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private String sno;
    private char sex;
    
    get/set
}

```



### 六、 **映射文件domain/Person.hbm.xml** 

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-mapping PUBLIC
        "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
<hibernate-mapping package="domain">
    <class name="Person" table="person">
        <id name="id">
            <generator class="native"/>
        </id>
        <property name="name" type="java.lang.String" length="12" not-null="true" column="username"/>
        <property name="age" type="integer"/>
        <property name="sno" type="java.lang.String"/>
        <property name="sex" type="character"/>
    </class>
</hibernate-mapping>
```

### 

### 七、编写HibernateDao

```java
package dao;

import domain.Person;

public interface HibernateDao {
    public void addPerson(Person person);
    public void updatePerson(Person person);
    public void deletePerson(Person person);
    public Person getPersonById(Integer id);
}

```



### 八、HibernateUtil工具类

```java
package utils;

public class HibernateUtil {
    // SessionFactory全局只需要有一个就可以了
    //因为它的创建和销毁需要消耗大量的资源，初始化信息会比较多,并且它是线程安全的，可以在多线程的环境下使用它
    private static SessionFactory sf;
    private HibernateUtil(){}
    static {
        // new Configuration():代表配置文件的一个对象
        // .configure():读取默认的配置文件hibernate.cfg.xml
        Configuration cfg= new Configuration().configure();
        sf = cfg.buildSessionFactory();
        }

    //获取全局唯一的SessionFactory
     public static Session getSession(){
            Session session  = sf.getCurrentSession();
            return session;
        }
}

```



### 九、编写HibernateDaoImpl

```java
package dao.impl;

public class HibernateDaoImpl implements HibernateDao {
    public void addPerson(Person person) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction(); // 开启事务
        try {
        session.persist(person);
        tx.commit();					
        }catch (Exception e){
            if(null!=tx) tx.rollback(); // 回滚事务
            e.printStackTrace();
        }
    }

    public void updatePerson(Person person) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(person);
            tx.commit();
        }catch (Exception e){
            if(null!=tx) tx.rollback();
            e.printStackTrace();
        }
    }

    public void deletePerson(Person person) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(person);
            tx.commit();
        }catch (Exception e){
            if(null!=tx) tx.rollback();
            e.printStackTrace();
        }
    }

    public Person getPersonById(Integer id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Person person = (Person) session.get(Person.class, id);
        tx.commit();
        return person;
    }
}

```



### 十、编写测试类

```java
public class HiernateTest {

        HibernateDao hibernateDao = new HibernateDaoImpl();

        @Test
        public void addPerson(){
            Person person1 = new Person();
            person1.setName("Jack");
            person1.setSno("200192001");
            person1.setSex('男');
            person1.setAge(22);
        }

        @Test
        public void getPersonById(){
            Person p2 = hibernateDao.getPersonById(2);
            System.out.println(
                            "学号："+p2.getSno()+ "\n"+
                            "姓名："+p2.getName()+"\n"+
                            "性别："+p2.getSex()+"\n"+
                            "年龄："+p2.getAge()
            );
        }

        @Test
        public void updatePerson(){
            Person person = hibernateDao.getPersonById(2);
            person.setAge(39);
            hibernateDao.updatePerson(person);
            System.out.println("修改后："+person.getId()+"."+person.getName()+":"+person.getAge());
        }

        @Test
        public void deletePerson(){
            Person p2 = hibernateDao.getPersonById(1);
            hibernateDao.deletePerson(p2);
            Person p22 = hibernateDao.getPersonById(1);
            if(p22==null) System.out.println("Sorry,John已被删除！");
        }
}

```

