<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>新闻类型发布</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div id="section" align="lift">
    <div class="container">
        <h3 class="align-left"></h3>
        <div class="row text-center"><br/>
            <s:form action="category_addCategory" namespace="/" method="POST">
                <s:textfield name="category.categoryName" label="类型名" class="form-control"/>
                <s:submit value="添加" class="btn btn-info"/>
            </s:form>
        </div>
    </div>
</div>
</body>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>
