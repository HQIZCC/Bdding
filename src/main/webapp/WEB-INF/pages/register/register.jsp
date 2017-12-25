<%--
  Created by IntelliJ IDEA.
  User: HQ
  Date: 2017/12/13
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../base.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="${ctx}/staticfile/img/favicon.png">

    <title>Budding登录页面</title>

    <!-- Bootstrap CSS -->
    <link href="${ctx}/staticfile/css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="${ctx}/staticfile/css/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="${ctx}/staticfile/css/elegant-icons-style.css" rel="stylesheet" />
    <link href="${ctx}/staticfile/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles -->
    <link href="${ctx}/staticfile/css/style.css" rel="stylesheet">
    <link href="${ctx}/staticfile/css/style-responsive.css" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
    <!--[if lt IE 9]>
    <script src="${ctx}/staticfile/js/html5shiv.js"></script>
    <script src="${ctx}/staticfile/js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="login-img3-body">

<div class="container">

    <form class="login-form" action="${ctx}/user/register.action" method="post">
        <div class="login-wrap">
            <p class="login-img"><i class="icon_lock_alt"></i></p>
            <div class="input-group">
                <span class="input-group-addon"><i class="icon_profile"></i></span>
                <input type="text" class="form-control" placeholder="用户名" name="username" autofocus>
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="icon_key_alt"></i></span>
                <input type="password" class="form-control" placeholder="密码" name="password">
            </div>

            <div class="input-group">
                <input type="radio" name="role" checked="checked" value="0"/>我要投标
                <input type="radio" name="role" value="1"/>我要招标
            </div>


            <h2 style="align-content: center;color: #8A6343">${error}</h2>
            <button class="btn btn-info btn-lg btn-block" type="submit">注册</button>
        </div>
    </form>

</div>


</body>
</html>

