<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
   <h3>文件上传成功！</h3>
   <h3>上传文件为：<s:property value="uploadFileName"/></h3>
   <h3>上传文件的类型为：<s:property value="uploadContentType"/></h3>
  </body>
</html>
