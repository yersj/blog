package servlets;

import DBManager.DBManager;
import model.Author;
import model.Blog;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addBlog", value = "/addBlog")
public class addBlog extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.getRequestDispatcher("/addBlog.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        Author author=(Author) request.getSession().getAttribute("CURRENT_USER");

        Long authorId=author.getId();
        Blog blog=new Blog(null,title,content,authorId);
        if(DBManager.addBlog(blog)){
            request.getRequestDispatcher("/addBlog.jsp?success").forward(request,response);
        }else {
            request.getRequestDispatcher("/addBlog.jsp?error").forward(request,response);
        }
    }
}
