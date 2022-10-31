/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookControl;

import control.ProjectDAO;
import entity.Author;
import entity.BookDetail;
import entity.Publisher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thanh Phuc
 */
@WebServlet(name = "UpdateBookControl", urlPatterns = {"/update"})
public class UpdateBookControl extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateControl at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("bid");
        ProjectDAO dao = new ProjectDAO();
        BookDetail book = dao.getBookByID(id);
        request.setAttribute("book", book);
        request.getRequestDispatcher("updateBook.jsp").forward(request, response);
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
        String ID_author = null;
        String ID_publisher = null;
        String id = request.getParameter("id");
        String image = request.getParameter("img");
        String name = request.getParameter("book_name");
        String author = request.getParameter("author");
        String language = request.getParameter("language");
        String type = request.getParameter("type");
        String publisher = request.getParameter("publisher");
        String year = request.getParameter("publishing_year");
        String amount = request.getParameter("amount");
        ProjectDAO dao = new ProjectDAO();
        List<Author> listAu = dao.authorCheck();
        for (Author list : listAu) {
            if (list.getAuthor_name().equalsIgnoreCase(author)) {
                ID_author = list.getId();
                break;
            }
        }
        if (ID_author == null) {
            dao.insertAuthor(author);
            List<Author> listAuNew = dao.authorCheck();
            for (Author list : listAuNew) {
                if (list.getAuthor_name().equalsIgnoreCase(author)) {
                    ID_author = list.getId();
                    break;
                }
            }
        }
        List<Publisher> listPub = dao.publisherCheck();
        for (Publisher list : listPub) {
            if (list.getPublisher_name().equalsIgnoreCase(publisher)) {
                ID_publisher = list.getId();
                break;
            }
        }
        if (ID_publisher == null) {
            dao.insertPublisher(publisher);
            List<Publisher> listPubNew = dao.publisherCheck();
            for (Publisher list : listPubNew) {
                if (list.getPublisher_name().equalsIgnoreCase(publisher)) {
                    ID_publisher = list.getId();
                    break;
                }
            }
        }
        dao.updateBook(id,ID_author, ID_publisher, image, name, language, type, year, amount);
        response.sendRedirect("DetailBook");
        
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
