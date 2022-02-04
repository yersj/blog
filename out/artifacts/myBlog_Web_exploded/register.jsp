<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 31.01.2022
  Time: 18:21
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
             <div class="col-lg-6 m-auto">
                 <%
                  if(request.getParameter("emailError")!=null){
                 %>
                 <div class="alert alert-warning" role="alert">
                    such Email already registered!
                 </div>
                 <%
                     }
                 %>
                 <%
                     if(request.getParameter("passwordError")!=null){
                 %>
                 <div class="alert alert-warning" role="alert">
                     passwords does not match!
                 </div>
                 <%
                     }
                 %>
                 <%
                     if(request.getParameter("success")!=null){
                 %>
                 <div class="alert alert-success" role="alert">
                     Successfully registered!
                 </div>
                 <%
                     }
                 %>
                 <h4 class="mb-3 mt-4">
                     SIGN UP
                 </h4>
                 <form action="/register" method="post">
                     <div class="mb-3">
                         <label class="form-label">Email address: </label>
                         <input type="email" class="form-control" name="email" required placeholder="Email" >

                     </div>
                     <div class="mb-3">
                         <label class="form-label">Password: </label>
                         <input type="password" class="form-control" name="password" required placeholder="Password" >

                     </div>

                     <div class="mb-3">
                         <label class="form-label">Confirm password: </label>
                         <input type="password" class="form-control" name="re_password"  required placeholder="Repeat password">

                     </div>
                     <div class="mb-3">
                         <label class="form-label">Full Name: </label>
                         <input type="text" class="form-control" name="full_name" required placeholder="Enter Full Name" >

                     </div>
                     <button type="submit" class="btn btn-dark">SIGN UP</button>
                 </form>
             </div>
         </div>
     </div>
</body>
</html>
