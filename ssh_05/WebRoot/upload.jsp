<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>许广略牛逼！</title>
  </head>
	<style type="text/css">
   	 span{
   		 color:red;
   		 }
	</style>
  <body>
   <s:form action="upload" enctype="multipart/form-data" namespace="/">
   		<s:file name="upload" label="请选择文件上传"/>
   		<s:submit value="上传"/>
   </s:form>
  </body>
</html>
