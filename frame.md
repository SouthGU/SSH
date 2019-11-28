分为左右两边，每次左边请求的时候都应该制定target的名称。同时target的名称为右边frame的name属性。

```html
第一部分：架构页
<frameset cols="30%,*">
    <frame src="admin.jsp">
    <frame src="index.jsp" name="content">
</frameset>

第二部分：(admin.jsp左边选项)
<a  href="/action" target="content">
   类型查看       
</a>

第三部分：(index.jsp右边页面，会随着时间发生而更改页面)
由于在左侧已经规定了返回的页面要显示在右边 target="content"，右边的页面会随着服务端传递回来的JSP页面而更改
```

