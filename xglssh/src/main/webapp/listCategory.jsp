<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>新闻类型查询页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    </head>
<body>
<s:form name="listCategory">
<div id="section" align="lift">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h3 class="align-left">查看新闻类型：</h3>
    <table class="table table-striped table-bordered" >
        <tr class="text-center">
            <th width="100">序号</th>
            <th width="100">类型名</th>
            <th width="150">操作</th>
        </tr>
<%--statuts表示当前的迭代状态--%>
        <s:iterator value="categories" var="Category" status="stu">
            <tr class="text-center">
                <td ><s:property value="#stu.count"/> </td>
                <td ><s:property value="#Category.CategoryName"/> </td>
                <td>
<button class="btn btn-secondary" onclick="update(<s:property value="#Category.id"/>)">修改</button>
<button class="btn btn-danger" onclick="deleteCategory(<s:property value="#Category.id"/>)">删除</button>
                </td>
            </tr>
        </s:iterator>
    </table>
    <br/>
<%--定义错误提示--%>
    <h3><s:property value="error"/></h3>
            </div>
        </div>
    </div>
</div>
</s:form>
</body>
<script>
    function update(id) {
        document.listCategory.action = "/New/category_updateCategory.action?id=" + id;
        document.listCategory.submit();
    }
    function deleteCategory (id) {
        document.listCategory.action = "/New/category_deleteCategory.action?id=" + id;
        document.listCategory.submit();
    }
</script>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>

