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
	<s:form action="login" namespace="/">
		<s:textfield name="name" label="用户名"/>
		<s:password name="password1" label="密码"/>
		<s:submit value="登录"/>
	</s:form>
  </body>
</html>
