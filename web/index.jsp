<%@ page import="java.util.List" %>
<%@ page import="model.Blog" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="DBManager.DBManager" %>
<%@ page import="model.Comment" %><%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 31.01.2022
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp" %>
</head>
<body>

<%@include file="nav.jsp" %>
<div class="container">
    <div class="row mt-4">
        <div class="col-12 mx-auto ">
            <%
                ArrayList<Blog> list = (ArrayList<Blog>) request.getAttribute("blogs");

                for (Blog blog : list) {

            %>
            <div class="card text-center mt-5">
                <div class="card-header">
                    <%=blog.getTitle()%>
                </div>
                <div class="card-body">
                    <p class="card-text"><%=blog.getContent()%>
                    </p>

                </div>
                <div class="card-footer text-muted">
                    Author: <%=DBManager.getAuthorById(blog.getAuthor_id()).getName()%>
                </div>

            </div>
            <div>
                <div class="mt-3">
                    <%
                        Author currentUser = (Author) request.getSession().getAttribute("CURRENT_USER");

                        if (currentUser != null) {

                    %>
                    <form action="/addComment?blogId=<%=blog.getId()%>" method="post">
                        <textarea class="form-control" name="comment"></textarea>
                        <button class="btn btn-success btn-sm mt-3">ADD COMMENT</button>
                    </form>
                    <%
                    } else {
                    %>
                    <textarea class="form-control"></textarea>
                    <p><a href="/login" class="btn btn-link">sign in </a>to leave a comment</p>
                    <%
                        }
                    %>
                </div>
                <div id="commentBlock">
                    <div class="list-group">
                        <%
                            ArrayList<Comment> list1 = (ArrayList<Comment>) request.getAttribute("comments");
                            if (list1 != null) {
                                for (Comment c : list1) {

                                    if (c.getBlog_id().equals(blog.getId())) {

                        %>


                         <div class="d-flex justify-content-between border col-12 mb-2">
                             <div class="ms-2">
                                 <p class="mb-1"><%=c.getComment()%>
                                 </p>
                                 <h6 class="mb-1"><%=DBManager.getAuthorById(c.getAuthor_id()).getName()%>
                                 </h6>

                             </div>
                           <%
                               if(currentUser!=null){
                             if(currentUser.getId()==c.getAuthor_id()){
                           %>
                             <div class="me-2">
                                 <a href="/editComment?commentId=<%=c.getId()%>" style="width: fit-content" class="mt-2 btn btn-primary">Edit comment</a>
                                 <a href="/deleteComment?commentId=<%=c.getId()%>" style="width: fit-content" class="mt-2 btn btn-danger">Delete comment</a>

                             </div>

                             <%
                                     }
                                 }
                             %>

                         </div>



                        <%
                                    }
                                }
                            }
                        %>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</div>
</body>
</html>
