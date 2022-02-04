<%@ page import="java.util.List" %>
<%@ page import="model.Blog" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="DBManager.DBManager" %><%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 31.01.2022
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%@include file="head.jsp"%>
</head>
<body>
    <%@include file="nav.jsp"%>
    <div class="container">
        <div class="row mt-4">
            <div class="col-12 mx-auto ">
                <%
                    ArrayList<Blog> list= (ArrayList<Blog>) request.getAttribute("blogs");

                    for(Blog blog:list){

                %>
                <div class="card text-center mb-3">
                    <div class="card-header">
                        <%=blog.getTitle()%>
                    </div>
                    <div class="card-body">
                        <p class="card-text"><%=blog.getContent()%></p>

                    </div>
                    <div class="card-footer text-muted">
                        <%=DBManager.getAuthorById(blog.getAuthor_id()).getName()%>
                    </div>
                    <div class="card-body">
                        <a href="/comments?blogId=<%=blog.getId()%>">Comments</a>
                    </div>

                </div>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</body>
</html>
