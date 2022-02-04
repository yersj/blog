<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 31.01.2022
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
 <%@include file="head.jsp"%>
</head>
<body>
<%@include file="author.jsp"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/#">MyBlog</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <%
                 if(online){
                %>
                <li class="nav-item">
                <li class="nav-item">
                    <a class="nav-link" href="/profile"><%=author.getName()%></a>
                </li>
                    <a class="nav-link"  href="/main">All blogs</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/editBlogs">My blogs</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/addBlog">Add blog</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/logout">Logout</a>
                </li>


                <%
                    }else{
                %>
                <li class="nav-item">
                    <a class="nav-link"  href="/main">All blogs</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="/login">Sign in</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/register">Sign up</a>
                </li>
                <%
                 }
                %>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
</body>
</html>
