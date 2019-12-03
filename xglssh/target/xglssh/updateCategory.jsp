
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>新闻类型修改页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div id="section" align="lift">
    <div class="container">
        <div class="row text-center">
            <h3>更新新闻类型：</h3>
            <div class="col-md-12">
    <s:form action="category_updatedCategory" namespace="/">
        <s:hidden name="category.id" value="%{category.id}"/>
        <s:textfield name="category.categoryName" label="类型名"/>
        <s:submit value="更新" class="btn btn-info"/>
    </s:form>
            </div>
        </div>
    </div>
</div>
</body>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>
