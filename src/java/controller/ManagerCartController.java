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
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.account;
import model.cart;
import model.product;

/**
 *
 * @author quang
 */
@WebServlet(name = "ManagerCartController", urlPatterns = {"/managercart"})
public class ManagerCartController extends HttpServlet {

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

        List<cart> listC = cdao.getCartByCustomerID(customer_id);
        List<product> listP = pdao.getAllProduct();

        double totalMoney = 0;
        for (cart o : listC) {
            for (product p : listP) {
                if (o.getProduct_id() == p.getProduct_id()) {
                    totalMoney = totalMoney + (o.getQuantity() * p.getProduct_price());
                }
            }
        }

        request.setAttribute("listC", listC);
        request.setAttribute("listP", listP);
        request.setAttribute("totalMoney", totalMoney);

        request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);

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
