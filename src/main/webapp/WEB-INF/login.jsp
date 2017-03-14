<%--
  Created by IntelliJ IDEA.
  User: zj
  Date: 2017/2/13
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form name="form1" action="login_action.jsp" method="post">
    <table width="200" border="1">
        <tr>
            <td colspan="2">登录窗口</td>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" size="10"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" size="10"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   name="submit" value="登录"> <a href="register.
    jsp">注册新用户</a></td>
        </tr>
    </table>
</form>
</body>
</html>
