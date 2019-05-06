<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>登录界面</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <!--判断是否为空-->
    <style type="text/css">
        body{
            font-family: 微软雅黑;
            background-image: url("castle.jpg");
        }
    </style>


    <script type="text/javascript">
        function login(form){
            if(form.username.value == ""){
                alert("用户不能为空！");
                return false;
            }
            if(form.password.value == ""){
                alert("密码不能为空！");
                return false;
            }
        }
    </script>
</head>

<body>

<div style="margin-top:270px;" align="center">
    <h1 style="font-family: Cambria" style="margin-top:250px;" align="center">
        Login
    </h1>
    <form method="post"  action="/UserSevlet?state=login" onSubmit="return login(this);">
        Username：<input type="text" name="username" ><br><br>
        Password：<input type="password" name="password" ><br>
        <br>
        <input type="submit" value="login">      <input type="reset" value="reset"><br><br>

        <a href="/UserSevlet?state=enrol">没有账号？立即注册</a>
    </form>
</div>
</body>
</html>