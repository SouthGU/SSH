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
    
    <title>My JSP 'register.jsp' starting page</title>

  </head>
  
  <body>
   <s:form action="Register" namespace="/">
   	<s:textfield name="name" label="用户名"/>
   	<s:password name="password1" label="密码"/>
   	<s:password name="password2" label="确认密码"/>
   	<s:textfield name="age" label="年龄"/>
   	<s:textfield name="birthday" label="生日"/>
   	<s:textfield name="email" label="email*"/>
   	<s:submit value="提交"/>
   </s:form>
   
   
  </body>
</html>
