
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>新闻内容</title>
</head>
<body>
     <h2 align="center"><s:property value="news.title"/> </h2>
     <div style="text-align :center;">
         <p>来源:<s:property value="news.source" />&nbsp;&nbsp;&nbsp;&nbsp;发布时间:<s:property value="news.issueTime"/> </p>
     </div>
     <hr/>
     <div style="text-indent:2em;">
         <s:property value="news.content" />
     </div>

</body>
</html>
