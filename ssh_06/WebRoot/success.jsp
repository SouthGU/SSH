<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
  </head>
  
  <body>
   用户名:<s:property value="name"/><br>
  密码:<s:property value="password1"/><br>
  年龄:<s:property value="age"/><br>
  生日:<s:property value="birthday"/><br>
  email:<s:property value="email"/><br>
  </body>
</html>
