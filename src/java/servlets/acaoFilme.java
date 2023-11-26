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
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Mateus
 */
public class acaoFilme extends HttpServlet {

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

            HttpSession session = request.getSession();
            String nextJSP = "";
            Movie movie = new Movie();
            String acao = request.getParameter("acao");
            if (String.valueOf(session.getAttribute("role")).equals("1")) {
                DAOMovies daoMovies = new DAOMovies();
                String target = "null";
                switch (acao) {
                    case "buscar":
                                try {
                        target = daoMovies.obter(Integer.valueOf(request.getParameter("idFilme"))).getTitle();
                    } catch (Exception e) {
                        target = "null";
                    }
                    if (target.equals("null")) {
                        session.setAttribute("acao", "salvar");
                    } else {
                        session.setAttribute("acao", "alterar");
                    }
                    session.setAttribute("id", String.valueOf(request.getParameter("idFilme")));
                    nextJSP = "/projetoDW/cadastroFilmes.jsp";
                    break;
                    case "alterar":
                        movie = new Movie();
                        movie.setMovieId(Integer.valueOf(String.valueOf(request.getParameter("idFilme"))));
                        movie.setTitle(String.valueOf(request.getParameter("titulo")));
                        movie.setOverview(String.valueOf(request.getParameter("sinopse")));
                        movie.setRuntime(Integer.valueOf(request.getParameter("duracao")));
                        movie.setBudget(Integer.valueOf(String.valueOf(request.getParameter("orcamento"))));
                        movie.setHomepage(String.valueOf(request.getParameter("homepage")));

                        try {
                            daoMovies.atualizar(movie);
                            session.setAttribute("acao", "buscar");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        nextJSP = "/projetoDW/cadastroFilmes.jsp";
                        break;
                    case "excluir":
                        movie = daoMovies.obter(Integer.valueOf(String.valueOf(request.getParameter("idFilme"))));

                        try {
                            daoMovies.remover(movie);
                            session.setAttribute("acao", "buscar");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        nextJSP = "/projetoDW/cadastroFilmes.jsp";
                        break;
                    case "salvar":
                        movie = new Movie();
                        movie.setMovieId(Integer.valueOf(String.valueOf(request.getParameter("idFilme"))));
                        movie.setTitle(String.valueOf(request.getParameter("titulo")));
                        movie.setOverview(String.valueOf(request.getParameter("sinopse")));
                        movie.setRuntime(Integer.valueOf(String.valueOf(request.getParameter("duracao"))));
                        movie.setBudget(Integer.valueOf(String.valueOf(request.getParameter("orcamento"))));
                        movie.setHomepage(String.valueOf(request.getParameter("homepage")));

                        try {
                            daoMovies.inserir(movie);
                            session.setAttribute("acao", "buscar");
                        } catch (Exception e) {
                            System.out.println(e);
                        }

                        nextJSP = "/projetoDW/cadastroFilmes.jsp";
                        break;
                    case "cancelar":
                        session.setAttribute("acao", "buscar");
                        session.setAttribute("id", "null");
                        nextJSP = "/projetoDW/cadastroFilmes.jsp";
                        break;
                    case "listar":
                        session.setAttribute("listar", "1");
                        nextJSP = "/projetoDW/lista.jsp";
                        break;
                    default:
                        throw new AssertionError();
                }
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
