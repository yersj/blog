package servlets;

import DBManager.DBManager;
import model.Author;
import model.Comment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addComment", value = "/addComment")
public class addComment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        Author currentUser=(Author) request.getSession().getAttribute("CURRENT_USER");
        if(currentUser!=null){
            String content=request.getParameter("comment");
            Long blogId=Long.parseLong(request.getParameter("blogId"));
            Comment comment=new Comment();
            comment.setAuthor_id(currentUser.getId());
            comment.setBlog_id(blogId);
            comment.setComment(content);
            DBManager.addComment(comment);
            response.sendRedirect("/main#commentBlock");

        }
    }
}
