<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
  <head>

  </head>
  
  <body>
   <p>姓名：<s:property value="username"/></p>
   <p>密码：<s:property value="password"/></p>
   <p>性别：<s:property value="gender"/></p>
   <p>爱好的运动：<s:property value="sports"/></p>
   <p>喜爱的文学书：<s:property value="books"/></p>
   <p>留言：<s:property value="message"/></p>
  </body>
</html>
