<%--
  Created by IntelliJ IDEA.
  User: lueshen
  Date: 2019/10/24
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

<body>
<s:form action="login">
<s:textfield name="username" label="用户名"/>
<s:password  name="password" label="密码"/>
<s:submit value="登录"/>
</s:form>
</body>
</html>