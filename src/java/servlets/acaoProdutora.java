/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import DAOs.DAOProductionCompany;
import Entidades.ProductionCompany;
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
public class acaoProdutora extends HttpServlet {

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
            ProductionCompany produtora = new ProductionCompany();
            String acao = request.getParameter("acao");
            if (String.valueOf(session.getAttribute("role")).equals("1")) {
                DAOProductionCompany daoProdutora = new DAOProductionCompany();
                String target = "null";
                switch (acao) {
                    case "buscar":
                                try {
                        target = daoProdutora.obter(Integer.valueOf(request.getParameter("idProdutora"))).getCompanyName();
                    } catch (Exception e) {
                        target = "null";
                    }
                    if (target.equals("null")) {
                        session.setAttribute("acao", "salvar");
                    } else {
                        session.setAttribute("acao", "alterar");
                    }
                    session.setAttribute("id", String.valueOf(request.getParameter("idProdutora")));
                    nextJSP = "/projetoDW/cadastroProdutoras.jsp";
                    break;
                    case "alterar":
                        produtora = new ProductionCompany();
                        produtora.setCompanyId(Integer.valueOf(String.valueOf(request.getParameter("idProdutora"))));
                        produtora.setCompanyName(String.valueOf(request.getParameter("produtora")));

                        try {
                            daoProdutora.atualizar(produtora);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        nextJSP = "/projetoDW/cadastroProdutoras.jsp";
                        break;
                    case "excluir":
                        produtora = daoProdutora.obter(String.valueOf(request.getParameter("idProdutora")));

                        try {
                            daoProdutora.remover(produtora);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        nextJSP = "/projetoDW/cadastroProdutoras.jsp";
                        break;
                    case "salvar":
                        produtora = new ProductionCompany();
                        produtora.setCompanyId(Integer.valueOf(String.valueOf(request.getParameter("idProdutora"))));
                        produtora.setCompanyName(String.valueOf(request.getParameter("produtora")));

                        try {
                            daoProdutora.inserir(produtora);
                        } catch (Exception e) {
                            System.out.println(e);
                        }

                        nextJSP = "/projetoDW/cadastroProdutoras.jsp";
                        break;
                    case "cancelar":
                        session.setAttribute("acao", "buscar");
                        session.setAttribute("id", "null");
                        nextJSP = "/projetoDW/cadastroProdutoras.jsp";
                        ;
                        break;
                    case "listar":
                        session.setAttribute("listar", "4");
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
