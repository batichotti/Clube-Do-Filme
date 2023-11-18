<%-- 
    Document   : filme
    Created on : 25 de set. de 2023, 14:00:24
    Author     : Mateus Cohuzer
--%>

<%@page import="Entidades.ProductionCountry"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entidades.User"%>
<%@page import="Entidades.Movie"%>
<%@page import="Entidades.Genre"%>
<%@page import="DAOs.DAOUser"%>
<%@page import="DAOs.DAOMovies"%>
<%@page import="DAOs.DAOMovieCompany"%>
<%@page import="DAOs.DAOProductionCountry"%>
<%@page import="DAOs.DAOMovieGenres"%>
<%@page import="DAOs.DAOMovieKeywords"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Filme</title>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="./assets/css/styleEfeitos.css" />
        <link rel="stylesheet" href="./assets/css/styleLandingPage.css" />
        <link rel="stylesheet" href="./assets/css/styleFilmeIndividual.css" />
    </head>
    <body>
        <header
            id="headerTop"
            class="d-flex justify-content-between align-items-center pt-4 w-100"
            >
            <div class="d-flex gap column-gap-2 ps-5">
                <!-- <img src="" alt="Logo" class=".img-fluid"> -->
                <h1 class=".img-fluid">🧼</h1>
                <a href="index.jsp"><h1>Clube do Filme</h1></a>
            </div>
            <nav class="d-flex justify-content-around align-items-center pe-5 w-50">
                <div class="d-flex gap column-gap-5">
                    <a href="filme.html">Filmes</a>
                    <a href="filme.jsp">Filmes (jsp)</a>
                    <%
                        DAOUser daoUser = new DAOUser();
                        DAOMovies daoMovies = new DAOMovies();
                        DAOMovieGenres daoMovieGenres = new DAOMovieGenres();
                        DAOMovieKeywords daoMovieKeywords = new DAOMovieKeywords();
                        DAOMovieCompany daoMovieCompany = new DAOMovieCompany();
                        DAOProductionCountry daoProductionCountry = new DAOProductionCountry();
                        User usuario = new User();
                        Movie movie = new Movie();
                        String is_logged = "False";
                        
                        try{
                            is_logged = String.valueOf(session.getAttribute("logado"));
                            if(is_logged.equals("True")){
                                out.println("<a href='deslogin'>Deslogar</a>");
                            } else {
                                out.println("<a>Login</a>");
                            }
                        }catch(Exception e){
                            out.println("<a>Login (Err): "+e+"</a>");
                        }

                        if(String.valueOf(session.getAttribute("role")).equals("1") && String.valueOf(session.getAttribute("logado")).equals("True")){
                            out.println("<a href='telaAdm.jsp'> ADM </a>");
                        }
                        
                        String id = String.valueOf(request.getParameter("id"));
                        if (!id.equals("null") && !id.equals("")) {
                            try{
                                movie = daoMovies.obter(Integer.valueOf(id));
                            } catch(Exception bangcock){
                                id = "err";
                            }
                        } else if (id.equals("null")){
                            id="null";
                        } else {
                            id="err";
                        }
                    %>
                </div>
                <input
                    type="text"
                    class="inputBuscar rounded-pill"
                    placeholder="Buscar"
                    />
            </nav>
        </header>

        <main class="text-center w-100 debug mt-3">
            <section class="infoFilme">
                <div class="info">
                    <h1>
                        <%
                            if(id.equals("null")){
                                out.println("Insira um id");
                            }else if (id.equals("err")){
                                out.println("ID inválido");
                            } else {
                                try{
                                    out.println(String.valueOf(movie.getTitle()));
                                }catch(Exception salzburg){
                                    out.println("ID Inválido");
                                    movie = new Movie();
                                    id = "err";
                                }
                            }
                        %>
                    </h1>
                    
                    <h5>
                        <%
                            if(!id.equals("null") && !id.equals("err")){
                                int x = 0;
                                for(String i : daoMovieCompany.getCompanyByMovieTitle(String.valueOf(movie.getTitle()))){
                                    x += 1;
                                    if(!(daoMovieCompany.getCompanyByMovieTitle(String.valueOf(movie.getTitle())).size() == x)){
                                        out.println(i + ", ");
                                    } else {
                                        out.println(i);
                                    }
                                }
                            }
                        %>
                    </h5>
                    
                    <h5 style="color: gold">
                        <%
                            if(!id.equals("null") && !id.equals("err")){
                                int x = 0;
                                for(ProductionCountry i : daoProductionCountry.encontrarPaisesPorFilmeId(String.valueOf(movie.getTitle()))){
                                    x += 1;
                                    if(!(daoProductionCountry.encontrarPaisesPorFilmeId(String.valueOf(movie.getTitle())).size() == x)){
                                        out.println(i.getCountry().getCountryName() + ", ");
                                    } else {
                                        out.println(i.getCountry().getCountryName());
                                    }
                                }
                            }
                        %>
                    </h5>
                    <h5>
                        <%
                            if(!id.equals("null") && !id.equals("err")){
                                out.println(String.valueOf(movie.getRuntime()) + " min");
                            }
                        %>
                         | 
                        <%
                            if(!id.equals("null") && !id.equals("err")){
                                for(String i : daoMovieGenres.getGenresByMovieTitle(String.valueOf(movie.getTitle()))){
                                    out.println(i + " ");
                                }
                            }
                        %></h5>
                    <h6>
                        <%
                            if(!id.equals("null") && !id.equals("err")){
                                int x = 0;
                                for(String i : daoMovieKeywords.getKeywordsByMovieTitle(String.valueOf(movie.getTitle()))){
                                    x += 1;
                                    if(!(daoMovieKeywords.getKeywordsByMovieTitle(String.valueOf(movie.getTitle())).size() == x)){
                                        out.println(i + ", ");
                                    } else {
                                        out.println(i);
                                    }
                                }
                            }
                        %>
                    </h6>
                </div>
                <img src="assets/images/bgClubeDoFilme.jpeg" alt="fotoFilme" />
            </section>

            <aside class="sinopse debug">
                <%
                    if(!id.equals("null") && !id.equals("err")){
                        if(!String.valueOf(movie.getHomepage()).equals("null") && !String.valueOf(movie.getHomepage()).equals("")){
                            out.println("<p>WHERE TO WATCH: <a href='"+String.valueOf(movie.getHomepage())+"' target='_blank'> "+String.valueOf(movie.getHomepage())+" </a></p>");
                            out.println("<br/>");
                        }
                        out.println(String.valueOf(movie.getOverview()));
                    }
                %>
            </aside>

            <section class="areaUser debug">
                <div class="comentarios debug">
                    Lorem ipsum dolor sit amet consectetur
                </div>

                <div>
                    <h6>Sua avaliação</h6>
                </div>

                <div>
                    <h6>Escreva um comentario!</h6>
                    <input type="text" name="comentario" class="inputComentario" id="comentario" />
                </div>
                <div class="debug">Seu favorito</div>
            </section>
        </main>
    </body>
</html>