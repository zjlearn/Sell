<#import "spring.ftl" as spring>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>登录</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <script type="text/javascript" src="<@spring.url '/Scripts/jquery-3.1.1.min.js'/>"></script>
    <script type="text/javascript" src="<@spring.url '/Scripts/jquery.md5.js'/>"></script>
    <script type="text/javascript" src="<@spring.url  '/Scripts/sell.js'/>"> </script>

</head>

<body>

<div class="container">
    <div class="jumbotron">
        <h1 class="text-center">
            <em><strong>欢迎</strong></em>
        </h1>
    </div>

    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">优购商城</a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/Sell/login"><span class="glyphicon glyphicon-user"></span> 登录</a></li>
                <li><a href="/Sell"><span class="glyphicon glyphicon-log-in"></span> 首页</a></li>
            </ul>
        </div>
    </nav>

    <div class="row">
        <div class="col-md-4">
            <img alt="140x140" src="/pic/index.jpg"  class="img-circle col-md-offset-2 img-responsive" />
        </div>
        <div class="col-md-4">

        </div>

        <div class="col-md-4">
            <form class="form-horizontal form-group" autocomplete="on"  onsubmit="encry(); return true;" action="/Sell/login/user">
                <div class="control-group">
                    <label class="control-label" for="name">用户</label>
                    <div class="controls">
                        <input id="name" name="name" type="text" />
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label" for="inputPassword">密码</label>
                    <div class="controls">
                        <input id="password" name="password" type="password" />
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <label class="checkbox"><input type="checkbox" /> Remember me</label> <button class="btn" type="submit">登陆</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
