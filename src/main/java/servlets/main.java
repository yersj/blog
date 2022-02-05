package servlets;

import DBManager.DBManager;
import model.Blog;
import model.Comment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "main", value = "/main")
public class main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager.setConnection();
        request.setAttribute("blogs",DBManager.getAllBlogs());


     ArrayList<Comment> allComments=(ArrayList<Comment>) DBManager.getAllComments();
     request.setAttribute("comments",allComments);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
