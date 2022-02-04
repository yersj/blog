package servlets;

import DBManager.DBManager;
import model.Author;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "profile", value = "/profile")
public class profile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Author author=(Author) request.getSession().getAttribute("CURRENT_USER");
        if(author!=null){
            request.getRequestDispatcher("/profile.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     Author author=(Author) request.getSession().getAttribute("CURRENT_USER");
     String redirect="/login.jsp";
     if(author!=null){
         String fullName=request.getParameter("full_name");
         author.setName(fullName);
         redirect="/profile.jsp?Error";
         if(DBManager.updateName(author)){
             redirect="/profile.jsp?profile-success";
         }
     }

     request.getRequestDispatcher(redirect).forward(request,response);
    }
}
