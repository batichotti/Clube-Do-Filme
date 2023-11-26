package servlets;

import DAOs.DAOGenre;
import DAOs.DAOMovieGenres;
import DAOs.DAOMovies;
import DAOs.DAOProductionCountry;
import Entidades.Genre;
import Entidades.Movie;
import Entidades.MovieGenres;
import Entidades.MovieGenresPK;
import Entidades.ProductionCountry;
import Entidades.ProductionCountryPK;
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
public class acaoGeneroHas extends HttpServlet {

    protected void processRequest(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)
            throws jakarta.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nextJSP = "/projetoDW/cadastroGeneros.jsp";
            try {
                HttpSession session = request.getSession();
                if (String.valueOf(session.getAttribute("role")).equals("1")) {
                    DAOMovies daoMovies = new DAOMovies();
                    DAOGenre daoGenre = new DAOGenre();
                    DAOProductionCountry daoProductionCountry = new DAOProductionCountry();

                    String acao2 = String.valueOf(request.getParameter("acao2"));
                    switch (acao2) {
                        case "buscar":

                            MovieGenres target = new MovieGenres();

                            try {
                                DAOMovieGenres daoMovieGenres = new DAOMovieGenres();
                                Movie film = daoMovies.obter(Integer.valueOf(String.valueOf(request.getParameter("listaOpcoes2"))));
                                Genre genero = daoGenre.obter(Integer.valueOf(String.valueOf(request.getParameter("listaOpcoes"))));
                                MovieGenresPK mgpk = new MovieGenresPK();
                                mgpk.setGenreId(genero.getGenreId());
                                mgpk.setMovieId(film.getMovieId());
                                session.setAttribute("lop", mgpk.getGenreId());
                                session.setAttribute("lop2", mgpk.getMovieId());
                                target = daoMovieGenres.obter(mgpk);
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
                            //ARRUMAR
                            Genre selecionado = daoGenre.obter(Integer.valueOf("1"));
                            ProductionCountryPK vaiseradicionado = new ProductionCountryPK();
                            vaiseradicionado.setCountryId(selecionado.getGenreId());
                            vaiseradicionado.setMovieId(Integer.valueOf(String.valueOf(session.getAttribute("id"))));
                            ProductionCountry tchau = daoProductionCountry.obter(vaiseradicionado);

                            for (ProductionCountry m : daoProductionCountry.encontrarPaisesPorFilmeId("1")) {
                                try {
                                    ProductionCountryPK pk_del = new ProductionCountryPK();
                                    pk_del.setCountryId(m.getProductionCountryPK().getCountryId());
                                    pk_del.setMovieId(m.getProductionCountryPK().getMovieId());
                                    ProductionCountry prod_del = daoProductionCountry.obter(pk_del);
                                    daoProductionCountry.remover(prod_del);
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                            }

                            tchau = new ProductionCountry();
                            tchau.setProductionCountryPK(vaiseradicionado);
                            tchau.setProductionCountrycol("adicionado pelo programa");

                            daoProductionCountry.inserir(tchau);
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
