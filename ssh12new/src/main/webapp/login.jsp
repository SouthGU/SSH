
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>百度登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        body{
            text-align: center;
        }
    </style>
</head>
<body class="text-center">
<div class="container">
    <div class="row text-center ">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form class="form-signin" action="LoginAction" method="post" namespace="/">
                <p></p>
                <h1 class="h3 mb-3 font-weight-normal">用户登录</h1>
                <label class="sr-only">账号</label>
                <s:textfield name="user.username" type="text"  class="form-control" placeholder="账号"/>
                <p></p>
                <label for="inputPassword" class="sr-only">密码</label>
                <s:textfield name="user.password" type="password" id="inputPassword" class="form-control" placeholder="密码"/>
                <p></p>
                <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
                <p class="mt-5 mb-3 text-muted">北京百度科技有限公司© 2018-2019</p>
            </form>
            <br/>
        </div>
    </div>
</div>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>