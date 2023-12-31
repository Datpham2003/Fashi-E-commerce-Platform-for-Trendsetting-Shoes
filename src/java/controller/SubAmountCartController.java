/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import dao.CartDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.account;
import model.productSize;

/**
 *
 * @author quang
 */
public class SubAmountCartController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            AccountDAO adao = new AccountDAO();
            CartDAO cdao = new CartDAO();
            ProductDAO pdao = new ProductDAO();

            HttpSession session = request.getSession();
            account a = (account) session.getAttribute("acc");
            if (a == null) {
                response.sendRedirect("login");
                return;
            }
            int account_id = adao.getAccountIDByUsername(a.getUsername());

            int customer_id = adao.getCustomerIDByAccountID(account_id);

            int product_id = Integer.parseInt(request.getParameter("product_id"));

            int quantity = Integer.parseInt(request.getParameter("quantity"));

            String size = request.getParameter("size");

            productSize checkSize = pdao.getQuantityBySizeAndPID(product_id, size);

            if (quantity <= 1) {
                request.setAttribute("err2", "Invalid");
                request.getRequestDispatcher("managercart").forward(request, response);
            } else {
                quantity -= 1;
                cdao.editAmountAndSizeCart(product_id, quantity, customer_id, size);
                request.getRequestDispatcher("managercart").forward(request, response);
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
