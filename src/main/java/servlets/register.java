package servlets;

import DBManager.DBManager;
import model.Author;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "register", value = "/register")
public class register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.getRequestDispatcher("/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String redirect="/register.jsp?passwordError";


        String email=request.getParameter("email");
      String password=request.getParameter("password");
      String rePassword=request.getParameter("re_password");
      String fullName=request.getParameter("full_name");
      if(password.equals(rePassword)){
          redirect="/register.jsp?emailError";
          Author author= (Author) DBManager.getAuthor(email);
          if(author==null){
              Author newAuthor=new Author(null,fullName,email,password);
              if(DBManager.addAuthor(newAuthor)) {
                  redirect = "/register.jsp?success";
              }
          }
      }

      request.getRequestDispatcher(redirect).forward(request,response);
    }
}
