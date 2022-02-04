package servlets;

import DBManager.DBManager;
import model.Comment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "comments", value = "/comments")
public class comments extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     Long blogId=Long.parseLong(request.getParameter("blogId"));
        List<Comment> comments= (List<Comment>) DBManager.getCommentsByBlogId(blogId);
        request.setAttribute("comments",comments);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
