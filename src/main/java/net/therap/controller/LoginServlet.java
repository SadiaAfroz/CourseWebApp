package net.therap.controller;

import net.therap.dao.AdminDao;
import net.therap.model.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author sadia.afroz
 * @since 4/27/21
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("welcome");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        AdminDao adminDao = new AdminDao();
        Admin admin = adminDao.check(username, password);
        if (admin != null) {
            HttpSession session = req.getSession();
            session.setAttribute("sesionid", admin.getId());
            doGet(req, resp);
        } else {
            resp.sendRedirect("home");
        }
    }
}
