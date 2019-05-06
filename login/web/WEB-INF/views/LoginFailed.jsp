<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/6/18
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<style type="text/css">
    body{
        font-family: 微软雅黑;
        background-image: url("castle.jpg");
    }
</style>
<head>
    <title>登录失败</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body style="margin-top:270px;" align="center">
帐户名正确，密码错误！请返回重新登录 <br><br>
<!--注意此处的action中的路径写法-->
<form action="/index.jsp">
    <input type = "submit" value = "返回">
</form>

</body>
</html>
