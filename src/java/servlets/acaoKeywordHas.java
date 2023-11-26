/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import DAOs.DAOKeyword;
import DAOs.DAOMovieKeywords;
import DAOs.DAOMovies;
import Entidades.Keyword;
import Entidades.Movie;
import Entidades.MovieKeywords;
import Entidades.MovieKeywordsPK;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateus
 */
public class acaoKeywordHas extends HttpServlet {

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
            String nextJSP = "/projetoDW/cadastroPalavrasChaves.jsp";
            try {
                HttpSession session = request.getSession();
                if (String.valueOf(session.getAttribute("role")).equals("1")) {
                    DAOMovies daoMovies = new DAOMovies();
                    DAOKeyword daoKeyword = new DAOKeyword();
                    DAOMovieKeywords daoMovieKeywords = new DAOMovieKeywords();

                    String acao2 = String.valueOf(request.getParameter("acao2"));
                    switch (acao2) {
                        case "buscar":

                            MovieKeywords target = new MovieKeywords();

                            try {
                                Movie film = daoMovies.obter(Integer.valueOf(String.valueOf(request.getParameter("listaOpcoes2"))));
                                Keyword genero = daoKeyword.obter(Integer.valueOf(String.valueOf(request.getParameter("listaOpcoes"))));
                                MovieKeywordsPK mgpk = new MovieKeywordsPK();
                                mgpk.setKeywordId(genero.getKeywordId());
                                mgpk.setMovieId(film.getMovieId());
                                session.setAttribute("lop", mgpk.getKeywordId());
                                session.setAttribute("lop2", mgpk.getMovieId());
                                target = daoMovieKeywords.obter(mgpk);
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
                            Keyword selecionado = daoKeyword.obter(Integer.valueOf(String.valueOf(request.getParameter("listaOpcoes"))));
                            MovieKeywordsPK vaiseradicionado = new MovieKeywordsPK();
                            vaiseradicionado.setKeywordId(selecionado.getKeywordId());
                            vaiseradicionado.setMovieId(Integer.valueOf(String.valueOf(request.getParameter("listaOpcoes2"))));
                            MovieKeywords tchau = new MovieKeywords();

                            tchau.setMovieKeywordsPK(vaiseradicionado);
                            tchau.setMovieKeywordscol("adicionado pelo programa");

                            daoMovieKeywords.inserir(tchau);
                            session.setAttribute("acao2", "buscar");
                            break;
                        case "excluir":
                            Keyword selecao = daoKeyword.obter(Integer.valueOf(String.valueOf(request.getParameter("listaOpcoes"))));
                            MovieKeywordsPK vaiserexcluido = new MovieKeywordsPK();
                            vaiserexcluido.setKeywordId(selecao.getKeywordId());
                            vaiserexcluido.setMovieId(Integer.valueOf(String.valueOf(request.getParameter("listaOpcoes2"))));
                            MovieKeywords tchautchau = daoMovieKeywords.obter(vaiserexcluido);
                            
                            daoMovieKeywords.remover(tchautchau);
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
        try {
            processRequest(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(acaoKeywordHas.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(acaoKeywordHas.class.getName()).log(Level.SEVERE, null, ex);
        }
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