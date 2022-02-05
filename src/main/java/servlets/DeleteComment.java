package servlets;

import DBManager.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteComment", value = "/deleteComment")
public class DeleteComment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager.setConnection();
        Long id=Long.parseLong(request.getParameter("commentId"));
        DBManager.deleteComment(id);
        System.out.println(id);
        response.sendRedirect("/main");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
