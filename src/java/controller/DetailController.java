/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.brand;
import model.category;
import model.product;
import model.productSize;

/**
 *
 * @author quang
 */
@WebServlet(name = "DetailController", urlPatterns = {"/detail"})
public class DetailController extends HttpServlet {

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
        ProductDAO dao = new ProductDAO();

        int id = Integer.parseInt(request.getParameter("id"));
        String bid = request.getParameter("bid");
        String cid = request.getParameter("cid");
        String mess1 = (String) request.getAttribute("mess1");
        String mess2 = (String) request.getAttribute("mess2");

        if (mess1 != null) {
            request.setAttribute("mess1", mess1);
        }
        
        if (mess2 != null) {
            request.setAttribute("mess2", mess2);
        }

        product p = dao.getProductByID(id);
        List<brand> listB = dao.getAllBrand();
        List<String> listPS = dao.getAllProductSizes();
        List<productSize> listS = dao.getProductSizeByID(id);
        List<product> listRP = dao.getTopRelatedProduct(bid, cid);

        request.setAttribute("listRP", listRP);
        request.setAttribute("detail", p);
        request.setAttribute("listB", listB);
        request.setAttribute("listPS", listPS);
        request.setAttribute("listS", listS);

        request.getRequestDispatcher("Product.jsp").forward(request, response);
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

