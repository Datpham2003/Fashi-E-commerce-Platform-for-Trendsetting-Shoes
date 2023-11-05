/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import dao.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.account;
import model.profile;

/**
 *
 * @author acer
 */
@WebServlet(name = "LoginControl", urlPatterns = {"/LoginControl"})
public class LoginControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("pass");

        LoginDAO LoginDAO = new LoginDAO();
        account a = LoginDAO.checkLogin(username, password);

        if (a == null) {
            request.setAttribute("mess", "Wrong username or pass");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("acc", a);
            Cookie u = new Cookie("userC", username);
            Cookie p = new Cookie("passC", password);
            u.setMaxAge(Integer.MAX_VALUE);
            p.setMaxAge(Integer.MAX_VALUE);
            response.addCookie(u);
            response.addCookie(p);

            // Redirect to appropriate page based on role
            int roleId = a.getIdRole(); // Assuming getRoleId() returns the role ID
            switch (roleId) {
                case 1:
                    response.sendRedirect("home"); // Replace "customerPage" with the appropriate URL for the customer page
                    break;
                case 2:
                    response.sendRedirect("manageProduct"); // Replace "managerPage" with the appropriate URL for the manager page
                    break;
                case 3:
                    response.sendRedirect("allAccount"); // Replace "adminPage" with the appropriate URL for the admin page
                    break;
                case 4:
                    response.sendRedirect("order"); // Replace "businessStaffPage" with the appropriate URL for the business staff page
                    break;
                case 5:
                    response.sendRedirect("ship"); // Replace "shipperPage" with the appropriate URL for the shipper page
                    break;
                default:
                    response.sendRedirect("defaultPage"); // Replace "defaultPage" with the appropriate URL for the default page
                    break;
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
