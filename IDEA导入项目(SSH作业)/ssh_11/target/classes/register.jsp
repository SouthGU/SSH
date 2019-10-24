<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lueshen
  Date: 2019/10/23
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form action="addRegister" namespace="/">
    <s:textfield name="name" label="用户名"/>
    <s:password name="password" label="密码"/>
    <s:password name="password2" label="确认密码"/>
    <s:submit value="注册"/>
</s:form>
</body>
</html>
