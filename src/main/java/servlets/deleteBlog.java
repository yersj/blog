package servlets;

import DBManager.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteBlog", value = "/deleteBlog")
public class deleteBlog extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("blogs", DBManager.getAllBlogs());

        Long id=Long.parseLong(request.getParameter("blogId"));
     if(DBManager.deleteBlog(id)){

         request.getRequestDispatcher("/editBlogs.jsp?deleted").forward(request,response);

     }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
