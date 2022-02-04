package servlets;

import DBManager.DBManager;
import model.Author;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager.setConnection();
        request.setAttribute("blogs",DBManager.getAllBlogs());
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String redirect="/login.jsp?emailError";

        Author author = DBManager.getAuthor(email);


        if (author != null) {
            redirect="/login.jsp?passwordError";
            if (author.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("CURRENT_USER", author);
                request.getRequestDispatcher("/index.jsp").forward(request,response);

            }
            else {
                request.getRequestDispatcher(redirect).forward(request,response);
            }
        }else{
            request.getRequestDispatcher(redirect).forward(request,response);
        }
    }
}
