/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import DAOs.DAOProductionCompany;
import DAOs.DAOMovieCompany;
import DAOs.DAOMovies;
import Entidades.ProductionCompany;
import Entidades.Movie;
import Entidades.MovieCompany;
import Entidades.MovieCompanyPK;
import jakarta.servlet.http.HttpSession;
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
public class acaoProdutoraHas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nextJSP = "/projetoDW/cadastroProdutoras.jsp";
            try {
                HttpSession session = request.getSession();
                if (String.valueOf(session.getAttribute("role")).equals("1")) {
                    DAOMovies daoMovies = new DAOMovies();
                    DAOProductionCompany daoProductionCompany = new DAOProductionCompany();
                    DAOMovieCompany daoMovieProductionCompanys = new DAOMovieCompany();

                    String acao2 = String.valueOf(request.getParameter("acao2"));
                    switch (acao2) {
                        case "buscar":

                            MovieCompany target = new MovieCompany();

                            try {
                                Movie film = daoMovies.obter(Integer.valueOf(String.valueOf(request.getParameter("listaOpcoes2"))));
                                ProductionCompany genero = daoProductionCompany.obter(Integer.valueOf(String.valueOf(request.getParameter("listaOpcoes"))));
                                MovieCompanyPK mgpk = new MovieCompanyPK();
                                mgpk.setCompanyId(genero.getCompanyId());
                                mgpk.setMovieId(film.getMovieId());
                                session.setAttribute("lop", mgpk.getCompanyId());
                                session.setAttribute("lop2", mgpk.getMovieId());
                                target = daoMovieProductionCompanys.obter(mgpk);
                            } catch (Exception e) {
                                target = null;
                            }
                            
                            if (target == null) {
                                session.setAttribute("acao2", "adicionar");
                            } else {
                                session.setAttribute("acao2", "excluir");
                            }

                            break;
                        case "adicionar":
                            ProductionCompany selecionado = daoProductionCompany.obter(Integer.valueOf(String.valueOf(request.getParameter("listaOpcoes"))));
                            MovieCompanyPK vaiseradicionado = new MovieCompanyPK();
                            vaiseradicionado.setCompanyId(selecionado.getCompanyId());
                            vaiseradicionado.setMovieId(Integer.valueOf(String.valueOf(request.getParameter("listaOpcoes2"))));
                            MovieCompany tchau = new MovieCompany();

                            tchau.setMovieCompanyPK(vaiseradicionado);
                            tchau.setMovieCompanycol("adicionado pelo programa");

                            daoMovieProductionCompanys.inserir(tchau);
                            session.setAttribute("acao2", "buscar");
                            break;
                        case "excluir":
                            ProductionCompany selecao = daoProductionCompany.obter(Integer.valueOf(String.valueOf(request.getParameter("listaOpcoes"))));
                            MovieCompanyPK vaiserexcluido = new MovieCompanyPK();
                            vaiserexcluido.setCompanyId(selecao.getCompanyId());
                            vaiserexcluido.setMovieId(Integer.valueOf(String.valueOf(request.getParameter("listaOpcoes2"))));
                            MovieCompany tchautchau = daoMovieProductionCompanys.obter(vaiserexcluido);
                            
                            daoMovieProductionCompanys.remover(tchautchau);
                            session.setAttribute("acao2", "buscar");
                            break;
                        case "cancelar":
                            session.setAttribute("acao2", "buscar");
                            break;
                        default:
                            throw new AssertionError();
                    }
                }
            } catch (Exception e) {
                //nextJSP = e.getMessage();
                System.out.println("123");
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
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
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
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
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
