
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>模糊查询显示页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<style type="text/css">
    body{
        align-text:center;
    }
</style>
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
                <li class="nav-item"><a href="login.jsp" class="nav-link"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> </font></font></a></li>
            </ul>
        </div>
    </div>
</nav>

<div id="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <s:form action="news_findNewsByCategoryName" namespace="/" method="POST" name="listnew" >
                    <div style="width: 600px;height: 50px;align:center;border: black">
                    </div>
                    <div style="width: 600px;height: 20px;align:center;border: black">
                    </div>
                    <br/>
                    <div class="col">
                        <table class="table table-striped table-bordered">
                            <tr align="center">
                                <th>序号</th>
                                <th>发布方</th>
                                <th>标题</th>
                                <th>时间</th>
                            </tr>

                            <s:iterator value="newsList" var="newsList" status="stu">
                                <tr align="center">
                                    <td><s:a href="/New/news_findNews.action?id=%{#newsList.id}"><s:property value="#stu.count"/> </s:a></td>
                                    <td><s:a href="/New/news_findNews.action?id=%{#newsList.id}"><s:property value="#newsList.source"/> </s:a></td>
                                    <td><s:a href="/New/news_findNews.action?id=%{#newsList.id}"><s:property value="#newsList.title"/></s:a> </td>
                                    <td><s:a href="/New/news_findNews.action?id=%{#newsList.id}"><s:property value="#newsList.issueTime"/> </s:a></td>
                                </tr>
                            </s:iterator>
                        </table>
                        <br/>
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
