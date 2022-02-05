<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 31.01.2022
  Time: 18:42
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
          <div class="row mt-5">
              <div class="col-lg-6 m-auto">
                  <h4 class="mb-3">
                      LOGIN
                  </h4>
                  <%
                       if(request.getParameter("emailError")!=null){
                  %>
                  <div class="alert alert-warning mt-3" role="alert">
                      Email incorrect!
                  </div>
                  <%
                      }
                  %>

                  <%
                      if(request.getParameter("passwordError")!=null){
                  %>
                  <div class="alert alert-warning" role="alert">
                      Password incorrect!
                  </div>
                  <%
                      }
                  %>
                  <form action="/login" method="post">
                      <div class="mt-3 form-group">
                          <label>Email: </label>
                          <input type="email" class="form-control" name="email">
                      </div>
                      <div class="mt-3 form-group">
                          <label>Password: </label>
                          <input type="password" class="form-control" name="password">
                      </div>
                      <div class="mt-3 form-group">
                          <button class="btn btn-success">Login</button>
                      </div>

                  </form>
              </div>
          </div>
      </div>

</body>
</html>
