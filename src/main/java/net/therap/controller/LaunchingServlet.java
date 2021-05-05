package net.therap.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author sadia.afroz
 * @since 5/5/21
 */
@WebServlet("/home")
public class LaunchingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session == null || session.getAttribute("sesionid") == null) {
            req.getRequestDispatcher("WEB-INF/view/login.jsp").forward(req, resp);
        }
        else {
            resp.sendRedirect("login"); // already loggedin first window
        }

    }
}
