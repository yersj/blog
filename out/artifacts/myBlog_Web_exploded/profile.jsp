<%--
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
         <div class="row">
             <div class="mt-5 col-lg-6 m-auto">
                 <form action="/profile" method="post">
                     <%
                         if(request.getParameter("profile-success")!=null){
                     %>
                     <div class="alert alert-success" role="alert">
                        Updated Successfully!
                     </div>
                     <%
                         }
                     %>
                     <%
                         if(request.getParameter("Error")!=null){
                     %>
                     <div class="alert alert-danger" role="alert">
                         Ups, Error!
                     </div>
                     <%
                         }
                     %>

                     <div class="mt-3">
                         <label>Email:</label>
                         <input type="text" class="form-control mt-3 bg-light" value="<%=author.getEmail()%>" readonly>
                     </div>

                     <div class="mt-3">
                         <label>Full Name:</label>
                         <input type="text" name="full_name" class="form-control mt-3" value="<%=author.getName()%>">
                     </div>

                     <div class="mt-3">
                         <button class="btn btn-success">UPDATE PROFILE</button>
                     </div>
                 </form>
             </div>
         </div>
     </div>
</body>
</html>
