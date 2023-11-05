/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;
import model.profile;
import model.Role;
import model.account;

/**
 *
 * @author DanPC
 */
@WebServlet(name = "AddNewProfile", urlPatterns = {"/addNewProfile"})
public class AddNewProfile extends HttpServlet {

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
        AccountDAO dao = new AccountDAO();
        List<Role> list = dao.getAllRole();
        request.setAttribute("list", list);
        request.getRequestDispatcher("AddProfile.jsp").forward(request, response);

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
//        int profile_id = Integer.parseInt(request.getParameter("profile_id"));
        
//        HttpSession session = request.getSession();
//        account a = (account) session.getAttribute("acc");
//        int profile_id = a.getAccount_id();
        
        String full_name = request.getParameter("full_name");
        String image = request.getParameter("image");
        String phone = request.getParameter("phone");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String dob = request.getParameter("dob"); // Cần chuyển đổi chuỗi thành đối tượng Date
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        int role_id = Integer.parseInt(request.getParameter("role_id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");

//        String errorMessage = "";
        AccountDAO dao = new AccountDAO();
//        int profile_id = dao.AddNewProfile(full_name, image, phone, phone, gender, address, email);

//        dao.addNewProfile(profile_id,full_name, image, phone, gender, dob, address, email); 
        
        dao.addNewAccount(role_id, username, password);
        int profile_id = dao.getProfileIDByUsername(username);
        dao.insertProfile(profile_id, full_name, phone, dob, gender, address, email);
        response.sendRedirect("allAccount");
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
