
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>新闻修改页面</title>
    <style type="text/css">
        td{
            border:1px solid #000;
        }
        table {
            width: 500px;
            border: 0px;
            cellspacing: 0px;
            cellpadding: 0px;
        }
    </style>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div id="section">
    <div class="container">
        <div class="row">
                <h3>修改新闻：</h3>
            <div class="col-md-12">
                <div class="row">
                    <s:form action="news_updateNews" method="POST" namespace="/">
        <table class="table table-bordered">
                <input  type="text" name="news.id" value="<s:property value="news.id"/> " hidden="hidden"/>
            <tr>
                <td width="100">标题</td>
                <td>
                    <input type="text" name="news.title" value="<s:property value="news.title"/>"/>
                </td>
            </tr>
            <tr>
                <th width="100">类型</th>
                <th>
                    <select name="category_id">
                        <s:iterator value="categories" var="Category">
                            <option value="<s:property value="#Category.id"/>" id="option"><s:property value="#Category.categoryName"/></option>
                        </s:iterator>
                    </select>
                </th>
            </tr>
            <tr style="height: 200px">
                <th width="100">内容</th>
                <th>
                    <textarea name="news.content" class="form-control"><s:property value="news.content"/></textarea>
                </th>
            </tr>
            <tr>
                <th width="100">来源</th>
                <th align="lift">
                    <input type="text" name="news.source" value="<s:property value="news.source"/>"/>
                </th>
            </tr>
            <tr>
                <s:submit value="修改"  class="btn btn-info" />
            </tr>
        </table>
    </s:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    var option = document.getElementsByTagName("option");
    for(var i=0;i<option.length;i++) {
        if (option[i].value ==<s:property value="news.category.id"/>) {
            option[i].selected = true;  //相等则选中
        }
    }
</script>
</html>
