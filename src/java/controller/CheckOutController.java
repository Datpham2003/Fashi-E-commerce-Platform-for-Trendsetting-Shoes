/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import dao.CartDAO;
import dao.CheckOutDAO;
import dao.ProductDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import model.account;
import model.cart;
import model.product;
import model.productSize;

/**
 *
 * @author quang
 */
public class CheckOutController extends HttpServlet {

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
        CheckOutDAO cdao = new CheckOutDAO();
        ProductDAO pdao = new ProductDAO();
        CartDAO cadao = new CartDAO();

        HttpSession session = request.getSession();
        account a = (account) session.getAttribute("acc");
        if (a == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

        int account_id = adao.getAccountIDByUsername(a.getUsername());

        int customer_id = adao.getCustomerIDByAccountID(account_id);

        String name = request.getParameter("name");

        String country = request.getParameter("country");

        String address = request.getParameter("address");

        String city = request.getParameter("city");

        String phone = request.getParameter("phone");

        String note = request.getParameter("mess");

        String coupon_code = request.getParameter("code");

        List<cart> listC = cdao.getAllCartByCustomerID(customer_id);

        List<product> listP = pdao.getAllProduct();
        
        List<productSize> listPS = pdao.getProductSize();
        
        //del cart after checkout
        for (cart o : listC) {
            for (product p : listP) {
                if (o.getProduct_id() == p.getProduct_id()) {
                    cdao.insertCheckOut(customer_id, name, o.getProduct_id(), o.getQuantity(), p.getProduct_price() * o.getQuantity(),
                             Date.valueOf(LocalDate.now()), o.getProduct_size(), address, phone, note, coupon_code);
                }
            }
        }
        
        //update Product_Size table
        for (cart o : listC) {
            for (productSize s : listPS) {
                if (o.getProduct_id() == s.getProduct_id() && o.getProduct_size().equalsIgnoreCase(s.getSize())) {
                    pdao.updateProductSize(o.getProduct_id(), o.getProduct_size(), s.getQuantity()- o.getQuantity());
                }
            }
        }
               
        cadao.deleteCartByCustomerID(customer_id);
        
        response.sendRedirect("loadtracking");

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
