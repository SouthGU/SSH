
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="/struts-tags" %>
<html>
<head>
    <title>百度新闻首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        .oo
        {
            border:2px solid #a1a1a1;
            padding:10px 40px;
            width:300px;
            border-radius:12px;
        }
        li{
            list-style-type :none;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <nav class="navbar navbar-dark  navbar-expand-md sticky-top"style="background: #6c757d">
                <a class="navbar-brand" href="#"><font style="vertical-align: inherit;color: #fdfdfe">百度天下事</font></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#mynav">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="navbar-collapse collapse" id="mynav">
                    <form action="/New/news_findNewsByTitle" method="post" class="offset-4">
                        <div class="input-group custom-search-form">
                            <input class="form-control" name="title" type="text" placeholder="请输入想要看的新闻关键字">
                            <div class="input-group-append">
                                <span class="input-group-btn">
                                        <button class="btn btn-success" type="submit" style="background: #007bff">
                                            <i class="fa fa-search">百度一下</i>
                                        </button>
                                </span>
                            </div>
                        </div>
                    </form>

                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item"><a href="login.jsp" class="nav-link"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;color: #fdfdfe">登陆</font></font></a></li>
                    </ul>
                </div>
            </nav>
        </div>
        <br/>
        <div class="col-sm-12">
            <br/>
        </div>
<%--        <!-- 第二部分左右分布 -->--%>
<%--        <div class="col-sm-4 oo">--%>
<%--            <div id="accordion">--%>
<%--                <div class="card">--%>
<%--                    <h3>百度热搜榜</h3>--%>
<%--                    <s:iterator value="newsList1" var="newsList1" status="stu">--%>
<%--                        <div class="card-header">--%>
<%--                            <a class="card-link" data-toggle="collapse" href="#collapseOne">--%>

<%--                                <li>--%>
<%--                                    <s:a href="/New/news_findNews.action?id=%{#newsList1.id}">--%>
<%--                                        <s:property value="#newsList1.title"/>--%>
<%--                                        &nbsp;&nbsp;--%>
<%--                                        <s:property value="#newsList1.issueTime"/>--%>
<%--                                    </s:a>--%>

<%--                                </li>--%>

<%--                            </a>--%>
<%--                        </div>--%>
<%--                    </s:iterator>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>

        <!-- 轮播图 -->
        <div class="col-sm-12">
            <s:iterator value="categories" var="categories" status="stu">
                <div class="oo col-sm-12" style="float:left;margin-left:20px">
                    <div>
                        <h3>
                            <s:property value="#categories.CategoryName"/>
                        </h3>
                        <div class="card">
                            <s:iterator value="newses" var="newses">
                                <div class="card-header">
                                    <s:if test="#categories.CategoryName == #newses.category.CategoryName">
                                        <li>
                                            <s:a href="/New/news_findNews.action?id=%{#newses.id}">
                                                <s:property value="#newses.title"/>
                                                <s:date name="#newses.issueTime" nice="false"/>
                                            </s:a>
                                        </li>
                                    </s:if>
                                </div>
                            </s:iterator>
                        </div>
                    </div>
                </div>
            </s:iterator>
        </div>
        <div class="col-sm-12">
            <p></p>
        </div>

        <div class="offset-4">
            <s:form action="news_findNewsByTime"  namespace="/" method="POST">
                <div>
                    <center>
                        <input type="text" name="start" id="start" style="width: 120px;height: 35px" placeholder="开始时间"/>&nbsp;
                        <input type="text" name="end" id="end" style="width: 120px;height: 35px" placeholder="截止时间"/>&nbsp;
                        <input type="submit" value="搜一搜" class="btn btn-info">
                    </center>
                </div>
            </s:form>
        </div>
        <div class="col-md-12">
            <s:form action="news_findNewsByCategoryName" namespace="/" method="POST" name="listnew" >
                <div class="col">
                    <table class="table table-striped table-bordered">
                        <s:iterator value="newsList" var="newsList" status="stu">
                            <tr align="center">
                                <!--<td> </td>-->
                                <td><s:a href="/New/news_findNews.action?id=%{#newsList.id}">
                                    <s:property value="#newsList.title"/>|
<%--                                    <s:property value="#newsList.content"/>--%>
                                    <s:property value="#newsList.issueTime"/>
                                </s:a>
                                </td>
                            </tr>
                        </s:iterator>
                        </tr>
                    </table>

                    <br/>
                    <h3><s:property value="error"/></h3>
                </div>
            </s:form>
        </div>





    </div>
</div>
</div>

<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<script>
    $(function(){
        $( "#start" ).datepicker({dateFormat: 'yy-mm-dd'});
        $( "#end" ).datepicker({dateFormat: 'yy-mm-dd'});
    })
</script>

</html>