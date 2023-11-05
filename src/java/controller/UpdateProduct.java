/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ProductDAO;
import dao.StoreDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import model.brand;
import model.category;
import model.product;
import model.productSize;

/**
 *
 * @author DanPC
 */
@MultipartConfig
@WebServlet(name = "UpdateProduct", urlPatterns = {"/updateProduct"})
public class UpdateProduct extends HttpServlet {

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
            out.println("<title>Servlet UpdateProduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateProduct at " + request.getContextPath() + "</h1>");
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

        int product_id = Integer.parseInt(request.getParameter("product_id"));
        StoreDAO product = new StoreDAO();
        product pro = product.getProductById(product_id);
        List<productSize> ps = product.getListProductSize();
        List<category> cat = product.getListCategory();
        List<brand> brand = product.getListBrand();

        request.setAttribute("listPro", pro);
        request.setAttribute("listPs", ps);
        request.setAttribute("listCat", cat);
        request.setAttribute("listBrand", brand);
        request.getRequestDispatcher("UpdateProduct.jsp").forward(request, response);
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
        StoreDAO dao = new StoreDAO();

        try {
            Part filePart = request.getPart("new_product_image");
            String fileName = filePart.getSubmittedFileName();
            String extension = fileName.substring(fileName.lastIndexOf("."));
            String uniqueFileName = generateUniqueFileName(fileName, extension); // Tạo tên tệp mới duy nhất

            String uploadPath = getServletContext().getRealPath("") + File.separator + "img/products" + File.separator + uniqueFileName;

            try ( InputStream input = filePart.getInputStream()) {
                Files.copy(input, new File(uploadPath).toPath());
            }

            String product_image = "img/products/" + uniqueFileName;
            String product_name = request.getParameter("product_name");
            Double product_price = Double.parseDouble(request.getParameter("product_price"));
            String product_description = request.getParameter("product_description");
            int category_id = Integer.parseInt(request.getParameter("category_id"));
            int brand_id = Integer.parseInt(request.getParameter("brand_id"));
            int product_id = Integer.parseInt(request.getParameter("product_id"));

            dao.UpdateProductByProductID(product_id, product_image, product_name, product_price, product_description, category_id, brand_id);
            response.sendRedirect("manageProduct");
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý ngoại lệ theo cách phù hợp
        }
    }

    private String generateUniqueFileName(String fileName, String extension) {
        String uniqueFileName = fileName;
        int count = 0;
        File file = new File(getServletContext().getRealPath("") + File.separator + "img/products" + File.separator + uniqueFileName);

        while (file.exists()) {
            count++;
            String newFileName = fileName.substring(0, fileName.lastIndexOf(".")) + "(" + count + ")" + extension;
            file = new File(getServletContext().getRealPath("") + File.separator + "img/products" + File.separator + newFileName);
            uniqueFileName = newFileName;
        }

        return uniqueFileName;
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
