
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>新闻内容</title>
    <style type="text/css">
        body{
            align-text:center;
        }
    </style>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-dark navbar-expand-md sticky-top" style="background: #6c757d">
    <div class="container">
        <a class="navbar-brand" href="/New/NewSystem.jsp"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">首页</font></font></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#mynav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="navbar-collapse collapse" id="mynav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a href="#" class="nav-link"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">  </font></font></a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">  </font></font></a>
                </li>
            </ul>

            <form action="/New/news_findNewsByTitle" method="post" class="ml-3">
                <div class="input-group custom-search-form">
                    <input class="form-control" name="title" type="text" placeholder="新闻标题">
                    <div class="input-group-append">
                        <span class="input-group-btn">
                                <button class="btn btn-success" type="submit" style="background: #007bff">
                                    <i class="fa fa-search">查询</i>
                                </button>
                        </span>
                    </div>
                </div>
            </form>

            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a href="login.jsp" class="nav-link"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">  </font></font></a></li>
            </ul>
        </div>
    </div>
</nav>


<h2 align="center"><s:property value="news.title"/> </h2>
<div style="text-align :center;">
    <p>来源:<s:property value="news.source" />&nbsp;&nbsp;&nbsp;&nbsp;发布时间:<s:property value="news.issueTime"/> </p>
</div>
<hr/>
<div style="text-indent:2em;">
    <s:property value="news.content" />
</div>

</body>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>
