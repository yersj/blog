<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 01.02.2022
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@include file="head.jsp" %>

    <script src="/tinymce/tinymce.min.js" referrerpolicy="origin"></script>


    <script>tinymce.init({
        selector: 'textarea',
    });</script>

</head>
<body>
<%@include file="nav.jsp" %>

<div class="container">
    <div class="row">

        <div class="col-lg-6 m-auto mt-3">
            <%
                if(request.getParameter("success")!=null){
            %>
            <div class="alert alert-success" role="alert">
                You added new blog!
            </div>
            <%
                }
            %>
            <%
                if(request.getParameter("error")!=null){
            %>
            <div class="alert alert-danger" role="alert">
                Some error!
            </div>
            <%
                }
            %>
            <form action="/addBlog" method="post">
                <div class="mt-3 form-group">
                    <label>Title: </label>
                    <input type="text" class="form-control" name="title">
                </div>
                <div class="mt-3 form-group">
                    <label>Content: </label>
                    <textarea name="content" class="form-control" cols="30" rows="10"></textarea>
                </div>
                <div class="mt-3 form-group">
                    <button class="btn btn-success">Add Blog</button>
                </div>

            </form>
        </div>
    </div>
</div>

</body>
</html>
