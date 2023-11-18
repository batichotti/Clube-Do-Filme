/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import DAOs.DAOMovies;
import DAOs.DAOCountry;
import DAOs.DAOProductionCountry;
import Entidades.ProductionCountry;
import Entidades.ProductionCountryPK;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Mateus
 */
public class acaoPais extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nextJSP = "/ProjetoDW/acaoPais";
            try {
                HttpSession session = request.getSession();
                if (String.valueOf(session.getAttribute("role")).equals("1")) {
                    DAOMovies daoMovies = new DAOMovies();
                    DAOProductionCountry daoProductionCountry = new DAOProductionCountry();

                    String new_country = request.getParameter("listaOpcoes"); //id

                    String movie_title = daoMovies.obter(Integer.valueOf(String.valueOf(session.getAttribute("id")))).getTitle();
                    String old_country = "1";
                    try {
                        for (ProductionCountry m: daoProductionCountry.encontrarPaisesPorFilmeId( movie_title )) {
                            old_country = String.valueOf( m.getCountry().getCountryId() );
                        }
                    } catch (Exception e) {
                        old_country = "1";
                    }

                    String act_movie = String.valueOf(daoMovies.obter(Integer.valueOf(String.valueOf(session.getAttribute("id")))).getMovieId());

                    ProductionCountryPK pcpk = new ProductionCountryPK();
                    if (!(old_country.equals("null"))) {
                        pcpk.setCountryId(Integer.valueOf(old_country));
                        pcpk.setMovieId(Integer.valueOf(act_movie));
                        ProductionCountry tchau = daoProductionCountry.obter(pcpk);
                        daoProductionCountry.remover(tchau);
                    }

                    pcpk.setCountryId(Integer.valueOf(new_country));
                    pcpk.setMovieId(Integer.valueOf(act_movie));
                    ProductionCountry added = new ProductionCountry(pcpk);
                    daoProductionCountry.inserir(added);

                }
            } catch (Exception e) {
                nextJSP = e.getMessage();
            }
            response.sendRedirect(nextJSP);
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    }

}
