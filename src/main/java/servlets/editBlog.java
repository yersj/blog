package servlets;

import DBManager.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "editBlog", value = "/editBlog")
public class editBlog extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("blogs", DBManager.getAllBlogs());
        Long blogId=Long.parseLong(request.getParameter("blogId"));
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        if(DBManager.updateBlog(blogId,title,content)){
            request.getRequestDispatcher("/editBlogs.jsp?success").forward(request,response);
        }
    }
}
