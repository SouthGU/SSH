
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>新闻显示页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<style type="text/css">
    body{
        align-text:center;
    }
</style>
<body>
<div id="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
    <s:form action="news_findNewsByCategoryName" namespace="/" method="POST" name="listnew" >
        <div style="width: 600px;height: 50px;align:center;border: black">
        </div>

        <div class="col-md-8 offset-3">
<%--            将category_id传递到action，然后获取新闻类型--%>
            <select name="category_id">
                <option value="0" selected>--请选择新闻类型--</option>
                <s:iterator value="categories" var="Category" status="stu">
                    <option value="<s:property value="#Category.id"/>"><s:property value="#Category.categoryName"/></option>
                </s:iterator>
            </select>
            <input type="submit" value="查看新闻" class="btn btn-info"/>
        </div>

        <div style="width: 600px;height: 20px;align:center;border: black">
        </div>
    <br/>
        <div class="col">
    <table class="table table-striped table-bordered">
        <tr align="center">
            <th width="100">序号</th>
            <th width="100">标题</th>
            <th width="200">发布时间</th>
            <th width="100">类型</th>
            <th width="150">操作</th>
        </tr>


        <s:iterator value="pageBean.list" var="newsList" status="stu">
            <tr align="center">
                    <td><s:property value="#stu.count"/> </td>
<%--                    查看新闻的具体内容，将新闻ID传递给action--%>
                    <td ><s:a href="/New/news_findNewsContent.action?id=%{#newsList.id}"><s:property value="#newsList.title"/></s:a> </td>
                    <td ><s:property value="#newsList.issueTime"/> </td>
                    <td ><s:property value="#newsList.category.categoryName"/> </td>
                    <td >
                    <button class="btn btn-secondary"><s:a href="/New/news_getNewsByid.action?id=%{#newsList.id}">修改</s:a></button>
                    <button class="btn btn-danger"><s:a href="/New/news_deleteNews.action?id=%{#newsList.id}">删除</s:a></button>
            </tr>
        </s:iterator>
        <tr align="center">
            <td colspan="5">
                第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页     
                <s:if test="pageBean.page!=1">
                    <a href="/New/news_listNews.action?page=1">首页</a>|
                    <a href="/New/news_listNews.action?page=<s:property value="pageBean.page-1"/>">上一页</a>|
                </s:if>
                <s:if test="pageBean.page!=pageBean.totalPage">
                    <a href="/New/news_listNews.action?page=<s:property value="pageBean.page+1"/>">下一页</a>|
                    <a href="/New/news_listNews.action?page=<s:property value="pageBean.totalPage"/>">尾页</a>
                </s:if>
            </td>
        <tr align="center">
    </table>
            <br/>
            <%--定义错误信息--%>
            <h3><s:property value="error"/></h3>
        </div>
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
