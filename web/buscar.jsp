<%-- 
    Document   : buscar
    Created on : 26 de nov. de 2023, 19:06:30
    Author     : mrmar
--%>

<%@page import="Entidades.Movie"%>
<%@page import="DAOs.DAOMovies"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Buscar</title>
        <link rel="stylesheet" href="./assets/css/styleEfeitos.css" />
        <link rel="stylesheet" href="./assets/css/styleLandingPage.css" />
        <link rel="stylesheet" href="assets/css/styleBuscar.css" />

        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
            crossorigin="anonymous"
            />
    </head>
    <body class="w-100 bodyBuscar">
        <header
            id="headerTop"
            class="d-flex justify-content-between align-items-center pt-4 w-100"
            >
            <div class="d-flex gap column-gap-2 ps-5">
                <h1 class=".img-fluid">🧼</h1>
                <a href="index.jsp" class="linkBuscar"><h1>Clube do Filme</h1></a>
            </div>
            <nav class="d-flex justify-content-end align-items-center w-50">
                <form action="buscar.jsp" method="post" class="">
                    <input
                        type="text"
                        class="inputBuscar w-75 rounded-pill"
                        placeholder="Buscar"
                        id="buscar"
                        name="target"
                        />
                </form>
            </nav>
        </header>
        <%
            String buscado = String.valueOf(request.getParameter("target"));
            DAOMovies daoMovies = new DAOMovies();
        %>
        <main class="filmesBuscados">
            <ul class="d-flex flex-column flex-lg-wrap gap row-gap-2">
                <h1>Filmes com o termo: <span class="marcado"><%=buscado%></span></h1>
                <%
                    for (Movie m : daoMovies.searchByTitle(buscado)) {
                        out.println("<li class='linkBuscar'><a href='/projetoDW/filme.jsp?id=" + String.valueOf(m.getMovieId()) + "'> <p>" + m.getTitle() + "</p></a></li>");
                    }
                %>
            </ul>
        </main>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
            crossorigin="anonymous"
        ></script>
    </body>
</html>
