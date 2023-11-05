/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import dao.ProfileDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import model.account;
import model.profile;

/**
 *
 * @author acer
 */
@WebServlet(name = "ProfileController", urlPatterns = {"/profile"})
public class ProfileController extends HttpServlet {

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

        HttpSession session = request.getSession();
        account a = (account) session.getAttribute("acc");
        AccountDAO accDAO = new AccountDAO();
        ProfileDAO proDAO = new ProfileDAO();       
        if (a == null) {
            response.sendRedirect("Login.jsp");
        }else {
            int profile_id = proDAO.getProfileByAccountID(a.getIdAccount());  
            profile Profile = proDAO.getProfile(profile_id);
            request.setAttribute("profile_id", a.getIdProfile());
            request.setAttribute("profile", Profile);
            request.getRequestDispatcher("Profile.jsp").forward(request, response);
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
        
//        HttpSession session = request.getSession();
//        account a = (account) session.getAttribute("acc");
//        ProfileDAO proDAO = new ProfileDAO();
//        
//        
//        String full_name = request.getParameter("inputFullName");        
//        String phone = request.getParameter("inputPhone");
//        String dob = request.getParameter("inputBirthday");
//        String getGender = request.getParameter("gender");
//        
//        int gender = 0;
//        if(getGender.equals("male")){
//            gender = 1;
//        }else {
//            gender = 0;
//        }
//        String address = request.getParameter("inputAddress");
//        String email = request.getParameter("inputEmailAddress"); 
//        
//        int profile_id = proDAO.getProfileByAccountID(a.getIdAccount());
//        profile p = proDAO.checkProfileID(profile_id);
//        if(p == null){            
//            proDAO.insertProfile(profile_id, full_name, phone, dob, gender, address, email);
//             response.sendRedirect("Home.jsp");
//        }else{
//            proDAO.updateProfile(full_name, phone, dob, gender, address, email, profile_id);
//             response.sendRedirect("Home.jsp");
//        }
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
