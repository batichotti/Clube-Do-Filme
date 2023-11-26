/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import DAOs.DAOMovies;
import Entidades.Movie;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Mateus
 */
public class search extends HttpServlet {

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
            out.println("<link rel=\"stylesheet\" href=\"./assets/css/styleEfeitos.css\" />\n"
                    + "        <link rel=\"stylesheet\" href=\"./assets/css/styleLandingPage.css\" />\n"
                    + "        <link rel=\"stylesheet\" href=\"./assets/css/styleFilmeIndividual.css\" />\n"
                    + "        <link rel=\"stylesheet\" href=\"assets/css/styleAdm.css\" /> ");
            out.println("<title>Servlet search</title>");
            out.println("<style>\n"
                    + "    a {\n"
                    + "      text-decoration: none;\n"
                    + "      position: relative;\n"
                    + "      color: #FFFFFF;\n"
                    + "    }\n"
                    + "\n"
                    + "    a:hover::after {\n"
                    + "      content: ''; \n"
                    + "      display: block; \n"
                    + "      position: absolute;\n"
                    + "      bottom: -2px; \n"
                    + "      left: 0; \n"
                    + "      width: 100%;\n"
                    + "      height: 2px; \n"
                    + "      background-color: #FFFFFF;\n"
                    + "    }\n"
                    + "    p {"
                    + "      font-size: 30px;"
                    + "    }\n"
                    + "  </style>");
            out.println("</head>");
            out.println("<body>");

            out.println("<div class=\"d-flex gap column-gap-2 ps-5\" style=\"display: flex; flex-direction: row;\">\n"
                    + "            <h1 class=\".img-fluid\">🧼</h1>\n"
                    + "            <a href=\"/projetoDW/index.jsp\"><h1>Clube do Filme</h1></a>\n"
                    + "        </div>");
            out.println("<hr/>");

            String buscado = String.valueOf(request.getParameter("target"));
            DAOMovies daoMovies = new DAOMovies();

            for (Movie m : daoMovies.searchByTitle(buscado)) {
                out.println("<a href='/projetoDW/filme.jsp?id=" + String.valueOf(m.getMovieId()) + "'> <p>" + m.getTitle() + "</p></a>");
            }
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
