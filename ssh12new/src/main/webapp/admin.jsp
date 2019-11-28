
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>百度小后台</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4">
            <div id="ulli">
                <ul style="list-style:none" class="list-group">
                    <a href="#" class="list-group-item active"  style="background: #28a745">
                        <h3 class="list-group-item-heading">
                            类型管理
                        </h3>
                    </a>
                    <a  href="/New/category_listCategory" target="content" class="list-group-item">
                        <h4 class="list-group-item-heading">
                            类型查看
                        </h4>
                    </a>
                    <a href="addCategory.jsp" target="content" class="list-group-item">
                        <h4 class="list-group-item-heading">
                            类型发布
                        </h4>
                    </a>
                    <a href="#" class="list-group-item active" style="background: #28a745">
                        <h3 >
                            新闻管理
                        </h3>
                    </a>
                    <a href="/New/news_listNews" target="content" class="list-group-item">
                        <h4 class="list-group-item-heading">
                            新闻查看
                        </h4>
                    </a>
                    <a href="/New/news_listCategoryName" target="content" class="list-group-item">
                        <h4 class="list-group-item-heading">
                            新闻发布
                        </h4>
                    </a>

                </ul>
            </div>
        </div>
    </div>
</div>
<style type="text/css">
    #ulli{
        height:300px;
        width:300px;
        float:left;
        padding:5px;
    }
</style>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>