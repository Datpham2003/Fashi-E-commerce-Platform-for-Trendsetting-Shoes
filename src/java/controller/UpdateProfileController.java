/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.AccountDAO;
import dao.ProfileDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name="UpdateProfileController", urlPatterns={"/UpdateProfileController"})
public class UpdateProfileController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
        int profile_id = proDAO.getProfileByAccountID(a.getIdAccount());
                 
        String full_name = request.getParameter("inputFullName");        
        String phone = request.getParameter("inputPhone");
        String dob = request.getParameter("inputBirthday");
        String getGender = request.getParameter("gender");       
        int gender = 0;
        if(getGender.equals("male")){
            gender = 1;
        }else {
            gender = 0;
        }
        String address = request.getParameter("inputAddress");
        String email = request.getParameter("inputEmailAddress");        
        
        profile p = proDAO.checkProfileID(profile_id);
        if(p == null){            
            proDAO.insertProfile(profile_id, full_name, phone, dob, gender, address, email);
             response.sendRedirect("profile");
        }else{
            proDAO.updateProfile(full_name, phone, dob, gender, address, email, profile_id);
             response.sendRedirect("profile");
        }        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
