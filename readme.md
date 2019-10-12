## 标题格式

标题中间记得加空格，二级标题以上都有分割线.



## 段落格式

这是一级标题下面的文字，末尾添加两个空格以上表示换行

或者使用空行来换行。

*斜体文字*- --> 一个星号包围

**粗体文字** --> 两个星号包围

三个以上的空行星号表示分割线

****

~~删除线~~ --> 两个波浪线表示删除线

<u>下划线</u> --> < u > 包围

脚注[^要注解的文字] 加上[^]内容



## 列表格式

- 无序第一项 --> 一个星号加空格
- 无序第二项
- 无序第三项    



1. 有序第一项 --> 数字加点
2. 有序第二项



1. 有序嵌套无序
   * 换到第二行删除2.，然后继续使用无序列表即可
   * 无序第二行

2. 有序列表

   * 使用ctrl+[ 删除缩进即可

   * 对于排序记得增加缩进或者减少缩进



## 列表区块

> 区块引用
>
> ">"后直接输入文字，区块可多重嵌套.
>
> 1. 嵌套有序列表
>
> * 嵌套无序列表
>
>   > 增加缩进后可以实现反嵌套.



## 代码格式

代码片段：用`号包围起来

`cout<<"Typora是世界上最好的语言."`

代码区块：用```先显示出代码区块，继而在里面输入代码和指定语言

```php
<?php
echo "php是世界上最好的语言"
?>	
```



## 链接格式

[链接名称] (链接地址) --> 中间不加空格

学习网站：[菜鸟教程](https://www.runoob.com/markdown/md-link.html)

省略链接地址：使用<>输入网站地址 

<http://www.baidu.com>

高级链接：链接使用变量代替，在文档末尾附带变量地址[] [变量名]

[Google][1]



## 图片格式

本地相对路径：

![描述图片关键字，代替文字防止网络波动](img\1570845723(1).jpg "悬浮图片上的文字")

网络图片路径：（可用高级链接方式：[1]:http://....com）

![可不写](https://www.runoob.com/wp-content/uploads/2019/03/A042DF30-C232-46F3-8436-7D6C35351BBD.jpg "菜鸟教程图片")

使用<img width=“50%” 实现缩放功能

<img src="https://www.runoob.com/wp-content/uploads/2019/03/A042DF30-C232-46F3-8436-7D6C35351BBD.jpg" width="50%s">





## 表格格式

从其他地方赋值粘贴即可

| 表头 | 表头 |  表头  |
| :--: | :--: | :----: |
| 谷歌 | 地图 | 浏览器 |
| 火狐 | 地图 | 浏览器 |



## 高级技巧

1. 支持的HTML元素

目前支持的 HTML 元素有：`<kbd> <b> <i> <em> <sup> <sub> <br>`等，例如：

使用 <kbd>Ctrl</kbd>+<kbd>Alt</kbd>+<kbd>Del</kbd> 重启电脑 --> 记得要加结束符</ kbd>

2. 转义 --> 加斜杠 \ 

**文本加粗**

\*\* 正常显示星号 \*\*

 









高级链接地址：[链接变量名]：[地址]

[1]: http://www.google.com/







