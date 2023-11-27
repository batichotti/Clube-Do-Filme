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
        <link rel="stylesheet" href="assets/css/styleBuscar.css" />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
            crossorigin="anonymous"
            />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%String list_var = String.valueOf(session.getAttribute("listar"));%>
        <title>Listar</title>
    </head>
    <body class="w-100 bodyBuscar">
        <header class="d-flex justify-content-between align-items-center pt-4 w-100">
            <div class="d-flex gap column-gap-2 ps-5" style="display: flex; flex-direction: row;">
                <h1 class=".img-fluid" style="font-size: 8vh;">🧼</h1>
                <a class="linkBuscar" href="
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
                               out.println("cadastroProdutoras.jsp");
                               break;
                       }
                   %>
                   "><h1 style="font-size: 8vh">Clube do<span class="marcado" style="border-radius: 20px;">Filme</span></h1></a>
            </div>
        </header>
        <hr/>
        <main class="filmesBuscados">
            <ul class="d-flex flex-column flex-lg-wrap gap row-gap-2">
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
                                out.println("<li class='linkBuscar'><a><p>" + String.valueOf(m.getMovieId()) + " - " + m.getTitle() + "</p></a></li>");
                            }
                            break;
                        case "2":
                            for (Genre g : daoGenre.list()) {
                                out.println("<li class='linkBuscar'><a><p>" + String.valueOf(g.getGenreId()) + " - " + g.getGenreName() + "</p></a></li>");
                            }
                            break;
                        case "3":
                            for (Keyword k : daoKeyword.list()) {
                                out.println("<li class='linkBuscar'><a><p>" + String.valueOf(k.getKeywordId()) + " - " + k.getKeywordName() + "</p></a></li>");
                            }
                            break;
                        case "4":
                            for (ProductionCompany p : daoProdutora.list()) {
                                out.println("<li class='linkBuscar'><a><p>" + String.valueOf(p.getCompanyId()) + " - " + p.getCompanyName() + "</p></a></li>");
                            }
                            break;
                    }
                %>
            </ul>
        </main>
    </body>
</html>
