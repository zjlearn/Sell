<#import "spring.ftl" as spring>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>优购商城</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="<@spring.url'/Scripts/jquery-3.1.1.min.js'/>"></script>
    <script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

<!--存取Session中的User-->
<#if Session["user"]?exists>
    <#assign user = Session["user"]>
</#if>

<div class="container">
    <div class="row">
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">优购商城</a>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/Sell">首页</a></li>
                    <li><a href="/Sell/settleAccount">购物车</a></li>
                <#if user ?exists>
                    <li><a href="/Sell/account">账务</a></li>
                    <li><a href="/Sell/public">发布</a></li>
                    <li><a href="/Sell/login">退出</a></li>
                <#else >
                    <li><a href="/Sell/login">登录</a></li>
                </#if>
                </ul>
            </div>
        </nav>
    </div>
</div>

