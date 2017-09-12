<%@ page import="com.exam.entity.Film" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zjz
  Date: 2017/8/15
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link type="text/css" rel="stylesheet" href="static/bootstrap/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="static/mycss/mycss.css">
<script src="static/myjs/notNull.js" type="text/javascript"></script>
<html>
<head>
    <title>电影列表</title>
</head>

<body class="container">
<div style="float: right"><a href="add.jsp" class="btn btn-info">新增</a></div>
<br/>
<div>
<table>
    <thead>
    <th class="col-md-1">ID</th>
    <th class="col-md-2">电影名</th>
    <th class="col-md-8">简介</th>
    <th class="col-md-1">语言</th>
    <th class="col-md-2">删除</th>
    <th class="col-md-2">编辑</th>
    </thead>
    <tbody>

    <%--<c:forEach items="films" var="film">--%>
    <%--<tr>--%>
    <%--<td>${film.filmId }</td>--%>
    <%--<td>${film.title }</td>--%>
    <%--<td>${film.description }</td>--%>
    <%--<td>${film.name }</td>--%>
    <%--<td><a href="delete?id=${film.filmId }">删除</a> </td>--%>
    <%--<td><a href="update?id=${film.filmId }">修改</a> </td>--%>
    <%--</tr>--%>
    <%--</c:forEach>--%>
    <%
        List<Film> films = (List<Film>) request.getAttribute("films");
        if(films==null||films.size()<1){
            out.println("当前没有电影信息");
        }else {
            for (Film film:films){
    %>
    <tr>
        <td><%= film.getFilmId()%></td>
        <td><%= film.getTitle()%></td>
        <td><%= film.getDescription()%></td>
        <td><%= film.getName()%></td>
        <td><a href="delete?id=<%= film.getFilmId()%>">删除</a>
        <td><a href="toEdit?id=<%= film.getFilmId()%>">修改</a>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</div>
</body>
</html>
