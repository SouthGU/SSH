<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lueshen
  Date: 2019/10/23
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table width="300" border="1">
    <tr align="center" style="background-color: #bbb666">
        <th>姓名</th>
        <th>密码</th>
    </tr>
    <s:iterator value="users" var="user">
        <tr>
            <td><s:property value="#user.name"/></td>
            <td><s:property value="#user.password"/></td>
        </tr>
    </s:iterator>

</table>
</body>
</html>
