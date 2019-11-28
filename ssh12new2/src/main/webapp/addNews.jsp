
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加新闻</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div id="section">
    <div class="container">
        <div class="row text-center">
            <div class="align-left"><h3></h3></div>
            <div class="col-md-12 form-group">
    <s:form action="news_addNews" method="POST" namespace="/">
    <table width="400" border="1" class="table table-active">
        <tr>
            <th width="100" class="text-center">标题</th>
            <th>
                <input type="text" name="news.title" class="form-control" placeholder="标题输入">
            </th>
        </tr>
        <tr>
            <th width="100" class="text-center">类型</th>
            <th align="lift">
                <select name="category_id">
                    <option value="0">--请选择新闻类型--</option>
                    <s:iterator value="categories" var="Category" status="stu">
                        <option value="<s:property value="#Category.id"/>"><s:property value="#Category.categoryName"/></option>
                    </s:iterator>
                </select>
            </th>
        </tr>
        <tr style="height: 200px">
            <th width="100" class="text-center">内容</th>
            <th align="lift">
                <textarea name="news.content" class="form-control" rows="8"></textarea>
            </th>
        </tr>
        <tr>
            <th width="100" class="text-center">来源</th>
            <th align="lift">
                <input type="text" name="news.source" class="form-control" placeholder="来源信息">
            </th>
        </tr>
        <tr>
            <s:submit value="添加" class="btn btn-info"/>
        </tr>
    </table>
    </s:form>
                <br/>
                <h3><s:property value="error"/></h3>
            </div>
        </div>
    </div>
</div>
</body>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>
