/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ProviderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Import;
import model.Provider;
import model.account;
import model.product;

/**
 *
 * @author DanPC
 */
@WebServlet(name = "AddImport", urlPatterns = {"/addImport"})
public class AddImport extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddImport</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddImport at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        ProviderDAO provider = new ProviderDAO();
        List<Provider> list = provider.getListProviderName();
        List<product> listProduct = provider.getAllProduct();
        HttpSession session = request.getSession();
        account a = (account) session.getAttribute("acc");
        int manager_id = a.getIdAccount();
        Import listImport = provider.getListImportByID(manager_id);
        request.setAttribute("listProvider", list);
        request.setAttribute("listP", listProduct);
        request.setAttribute("listImport", listImport);
        request.getRequestDispatcher("AddImport.jsp").forward(request, response);

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
        ProviderDAO provider = new ProviderDAO();

//        int product_id = Integer.parseInt(request.getParameter("product_id"));
//        int product_import_quantity = Integer.parseInt(request.getParameter("product_import_quantity"));
//        int product_import_size = Integer.parseInt(request.getParameter("product_import_size"));
        String import_date = request.getParameter("import_date");
        HttpSession session = request.getSession();
        account a = (account) session.getAttribute("acc");
        int manager_id = a.getIdAccount();
//        int manager_id = Integer.parseInt(request.getParameter("manager_id"));
        int provider_id = Integer.parseInt(request.getParameter("provider_id"));
//        double total_price = Double.parseDouble(request.getParameter("total_price"));
        String note = request.getParameter("note");

        int count = Integer.parseInt(request.getParameter("count"));

//        if (count != 0) {
//            int product_id = Integer.parseInt(request.getParameter("product_id"));
//            int product_import_quantity = Integer.parseInt(request.getParameter("product_import_quantity"));
//            int product_import_size = Integer.parseInt(request.getParameter("product_import_size"));
//            provider.AddNewImport(product_id, product_import_quantity, product_import_size, import_date, manager_id, provider_id, total_price, note);
//        }
        for (int i = 0; i <= count; i++) {
            if (i == 0) {
                int product_id = Integer.parseInt(request.getParameter("product_id-" + i));
                int product_import_quantity = Integer.parseInt(request.getParameter("product_import_quantity-0"));
                int product_import_size = Integer.parseInt(request.getParameter("product_import_size-0"));
                provider.AddNewImport(product_id, product_import_quantity, product_import_size, import_date, manager_id, provider_id, note);
            } else {
                int product_id = Integer.parseInt(request.getParameter("product_id-" + i));
                int product_import_quantity = Integer.parseInt(request.getParameter("product_import_quantity-0-" + i));
                int product_import_size = Integer.parseInt(request.getParameter("product_import_size-0-" + i ));
                provider.AddNewImport(product_id, product_import_quantity, product_import_size, import_date, manager_id, provider_id, note);
            }
        }

        response.sendRedirect("managerImportProduct");
//        try ( PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ssss</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ssss at " + count + "</h1>");
//            out.println("</body>");
//    }
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
