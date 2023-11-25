package servlets;

import DAOs.DAOCountry;
import DAOs.DAOGenre;
import DAOs.DAOMovies;
import DAOs.DAOProductionCountry;
import Entidades.Country;
import Entidades.Genre;
import Entidades.Movie;
import Entidades.MovieGenres;
import Entidades.ProductionCountry;
import Entidades.ProductionCountryPK;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mateus
 */
public class acaoGeneroHas extends HttpServlet {

    protected void processRequest(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)
            throws jakarta.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nextJSP = "/projetoDW/telaAdm.jsp";
            try {
                HttpSession session = request.getSession();
                if (String.valueOf(session.getAttribute("role")).equals("1")) {
                    DAOMovies daoMovies = new DAOMovies();
                    DAOGenre daoGenre = new DAOGenre();
                    DAOProductionCountry daoProductionCountry = new DAOProductionCountry();
                    DAOCountry daoCountry = new DAOCountry();

                    String acao2 = String.valueOf(session.getAttribute("acao2"));
                    switch (acao2) {
                        case "buscar":

                            MovieGenres target = new MovieGenres();

                            try {
                                Movie film = daoMovies.obter(Integer.valueOf(String.valueOf(request.getParameter("listaOpcoes2"))));
                                Genre genero = daoGenre.obter(Integer.valueOf(String.valueOf(request.getParameter("listaOpcoes"))));
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
                            Country selecionado = daoCountry.obter(Integer.valueOf("1"));
                            ProductionCountryPK vaiseradicionado = new ProductionCountryPK();
                            vaiseradicionado.setCountryId(selecionado.getCountryId());
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
