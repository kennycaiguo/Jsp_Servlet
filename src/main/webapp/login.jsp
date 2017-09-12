<%--
  Created by IntelliJ IDEA.
  User: zjz
  Date: 2017/8/15
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link type="text/css" rel="stylesheet" href="static/bootstrap/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="static/mycss/mycss.css">
<script src="static/myjs/notNull.js" type="text/javascript"></script>
<html>
<head>
    <title>登录页面</title>
</head>
<body class="container">
<form action="/login" method="post" class="form-horizontal" name="loginForm">
    <div class="form-group">
        <div class="col-md-4">
            <input type="text" class="form-control" name="firstName" placeholder="Please enter first_name">
        </div>
        <div class="col-md-2">
            <input type="submit" value="login" class="btn btn-info" onclick="return check(this)">
        </div>
    </div>
</form>
<p class="msg">
    <%
        Object obj = request.getAttribute("msg");
        if (obj!=null){
            out.println(obj.toString());
        }
    %>
</p>
</body>
</html>
