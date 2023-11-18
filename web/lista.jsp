<%-- 
    Document   : lista
    Created on : 18 de nov. de 2023, 10:39:23
    Author     : Mateus
--%>

<%@page import="Entidades.Genre"%><%@page import="DAOs.DAOGenre"%>
<%@page import="Entidades.Keyword"%><%@page import="DAOs.DAOKeyword"%>
<%@page import="Entidades.ProductionCompany"%><%@page import="DAOs.DAOProductionCompany"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entidades.Movie"%><%@page import="DAOs.DAOMovies"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="./assets/css/styleEfeitos.css" />
        <link rel="stylesheet" href="./assets/css/styleLandingPage.css" />
        <link rel="stylesheet" href="./assets/css/styleFilmeIndividual.css" />
        <link rel="stylesheet" href="assets/css/styleAdm.css" /> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%String list_var = String.valueOf(session.getAttribute("listar"));%>
        <title>Listar</title>
    </head>
    <body>
        <div class="d-flex gap column-gap-2 ps-5" style="display: flex; flex-direction: row;">
            <h1 class=".img-fluid">🧼</h1>
            <a href="
               <%
                   switch (list_var) {
                       case "1":
                           out.println("cadastroFilmes.jsp");
                           break;
                       case "2":
                           out.println("cadastroGeneros.jsp");
                           break;
                       case "3":
                           out.println("cadastroPalavrasChaves.jsp");
                           break;
                       case "4":
                           out.println("cadastroProdutora.jsp");
                           break;
                   }
               %>
               "><h1>Clube do Filme</h1></a>
        </div>
        <hr/>
        <%
            if (String.valueOf(session.getAttribute("role")).equals("0") || String.valueOf(session.getAttribute("role")).equals("null")) {
                response.sendRedirect("index.jsp");
            }
            DAOMovies daoMovies = new DAOMovies();
            DAOGenre daoGenre = new DAOGenre();
            DAOKeyword daoKeyword = new DAOKeyword();
            DAOProductionCompany daoProdutora = new DAOProductionCompany();
            switch (list_var) {
                case "1":
                    for (Movie m : daoMovies.list()) {
                        out.println("<p>" + String.valueOf(m.getMovieId()) + " - " + m.getTitle() + "</p>");
                    }
                    break;
                case "2":
                    for (Genre g : daoGenre.list()) {
                        out.println("<p>" + String.valueOf(g.getGenreId()) + " - " + g.getGenreName() + "</p>");
                    }
                    break;
                case "3":
                    for (Keyword k : daoKeyword.list()) {
                        out.println("<p>" + String.valueOf(k.getKeywordId()) + " - " + k.getKeywordName() + "</p>");
                    }
                    break;
                case "4":
                    for (ProductionCompany p : daoProdutora.list()) {
                        out.println("<p>" + String.valueOf(p.getCompanyId()) + " - " + p.getCompanyName() + "</p>");
                    }
                    break;
            }
        %>
    </body>
</html>
