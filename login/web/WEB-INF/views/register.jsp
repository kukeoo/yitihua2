<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/6/19
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style type="text/css">
    body{
        font-family: 微软雅黑;
        background-image: url("castle.jpg");
    }
</style>
<head>
    <title>注册界面</title>
</head>
<body style="margin-top:270px;" align="center">
<form action="/UserSevlet?state=doregister" method="post">
    <input type="text" name="username" placeholder="用户名" id="username" autocomplete="off">
    <input type="password" name="password" placeholder="密码" id="password">
    <p id="true"></p>
    <input type="submit" name="确定" id="submit" onclick="return check()">
</form>
<a href="/index.jsp"><button>取消</button></a>
</body>
</html>
