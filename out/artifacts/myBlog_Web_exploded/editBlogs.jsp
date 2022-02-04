<%@ page import="model.Blog" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 02.02.2022
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <%@include file="head.jsp"%>

    <script src="/tinymce/tinymce.min.js" referrerpolicy="origin"></script>
    <script>tinymce.init({
        selector: 'textarea',
    });</script>

</head>
<body>
 <%@include file="nav.jsp"%>
 <div class="container">
     <div class="row">

             <div class="col-lg-12 m-auto mt-3">
                 <%
                     if(request.getParameter("deleted")!=null){
                 %>
                 <div class="alert alert-warning" role="alert">
                     Blog deleted!
                 </div>
                 <%
                     }
                 %>

                 <%
                     if(request.getParameter("success")!=null){
                 %>
                 <div class="alert alert-warning" role="alert">
                     Blog edited!
                 </div>
                 <%
                     }
                 %>
                    <% ArrayList<Blog> list= (ArrayList<Blog>) request.getAttribute("blogs");
                     Author currentUser=(Author) request.getSession().getAttribute("CURRENT_USER");

                     for(Blog blog:list){

                         if(blog.getAuthor_id().equals(currentUser.getId())){

                 %>
                 <div class="card text-center mb-3">
                     <div class="card-header">
                         <%=blog.getTitle()%>
                     </div>
                     <div class="card-body">
                         <p class="card-text"><%=blog.getContent()%></p>
                         <a class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Edit</a>



                         <!-- Modal -->
                         <div class="modal fade" id="exampleModal">
                             <div class="modal-dialog">
                                 <div class="modal-content">
                                     <div class="modal-header">
                                         <h5 class="modal-title" id="exampleModalLabel">Modify blog</h5>
                                         <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                     </div>
                                     <div class="modal-body">
                                         <form action="/editBlog?blogId=<%=blog.getId()%>" method="post">
                                             <div class="mt-3 form-group">
                                                 <label>Title: </label>

                                                 <input type="text" value="<%=blog.getTitle()%>" class="form-control" name="title">
                                             </div>
                                             <div class="mt-3 form-group">
                                                 <label>Content: </label>
                                                 <textarea name="content" class="form-control" cols="30" rows="10"><%=blog.getContent()%></textarea>
                                             </div>
                                             <div class="mt-3 form-group">
                                                 <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                 <button type="submit" class="btn btn-primary">Save changes</button>
                                             </div>

                                         </form>
                                     </div>

                                 </div>
                             </div>
                         </div>

                         <a href="/deleteBlog?blogId=<%=blog.getId()%>" class="btn btn-danger">Delete</a>
                     </div>

                 </div>
                 <%
                     }
                     }


                 %>
             </div>


 </div>
 </div>
</body>
</html>
