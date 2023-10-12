/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import DAOs.DAOUser;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Mateus Cohuzer
 */
public class login extends HttpServlet {

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
            try {
                String email = String.valueOf(request.getParameter("email"));
                String senha = String.valueOf(request.getParameter("senha"));
                HttpSession session = request.getSession();

                DAOUser daoUser = new DAOUser();

                try {
                    if (email.equals(daoUser.obter(email).getEmail()) && senha.equals(daoUser.obter(email).getPassword())) {
                        if (email.equals("null")) {
                            out.println("<p style='color:red;'>Login inválido</p>");
                        } else {
                            session.setAttribute("logado", "True");
                            session.setAttribute("nick", String.valueOf(daoUser.obter(email).getNick()));
                            session.setAttribute("email", email);
                            session.setAttribute("senha", senha);
                            session.setAttribute("role", String.valueOf(daoUser.obter(email).getRole()));
                            //out.println("<p>" + String.valueOf(session.getAttribute("nick")) + " -> " + String.valueOf(daoUser.obter(email).getRole()) + "</p>");
                        }
                    } else if (String.valueOf(session.getAttribute("nick")).equals("null")) {
                        out.println("👌 Efetue seu login");
                    } else {
                        out.println("<p style='color:red;'>Login inválido</p>");
                    }
                } catch (Exception e) {
                    out.println("<p>" + String.valueOf(session.getAttribute("logado")) + "</p>");
                    out.println(String.valueOf("<p>" + session.getAttribute("nick")) + "</p>");
                    out.println("<p>" + e.getMessage() + "</p>");
                }
                response.sendRedirect("index.jsp");
            } catch (Exception e) {
                out.write(e.getMessage());
            }
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
