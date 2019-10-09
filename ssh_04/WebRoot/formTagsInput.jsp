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
    <s:form action="formTagsDemo" namespace="/a">
    	<s:textfield name="username" label="姓名"/>
    	<s:password name="password" label="密码"/>
    	<s:radio name="gender" list="{'男','女'}" label="性别"/>
    	<s:checkboxlist name="sports" 
    	list="#{'网球':'网球','乒乓球':'乒乓球','lq':'篮球','yy':'游泳','pb':'跑步' }"/>
    	<s:select name="books" 
		list="{'小说','诗歌','古典文学','现代文学'}" value="{'小说','现代文学'}"
		label="爱好文学书" size="5" multiple="true" headerKey="-1" 
		headerValue="--请选择喜欢的书籍---" emptyOption="true"/>
    	<s:textarea name="message" rows="6" cols="45" label="留言"/>
    	<s:submit value="提交表单"/>
    	<s:reset value="重置表单"/>
    
    </s:form>
  </body>
</html>
