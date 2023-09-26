<%-- 
    Document   : filme
    Created on : 25 de set. de 2023, 14:00:24
    Author     : Mateus Cohuzer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entidades.User"%>
<%@page import="DAOs.DAOUser"%>
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
                <h1>Clube do Filme</h1>
            </div>
            <nav class="d-flex justify-content-around align-items-center pe-5 w-50">
                <div class="d-flex gap column-gap-5">
                    <a href="filme.html">Filmes</a>
                    <a href="filme.jsp">Filmes (jsp)</a>
                    <a href="#">
                        <%
                            User usuario = new User();
                            DAOUser daoUsuarios = new DAOUser();
                            try {
                                out.println(daoUsuarios.obter(String.valueOf(session.getAttribute("nick"))).getNick());
                            } catch (Exception e) {
                                out.println("Login");
                            }
                        %>
                    </a>
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
                            out.println("Nome do filme");
                        %>
                    </h1>
                    <div class="rating debug">⭐⭐⭐⭐⭐</div>
                    <h5>139 min | Drama</h5>
                    <h6>support group, dual identity, nihilism, rage and hate, insomnia, dystopia, violence</h6>
                </div>
                <img src="assets/images/bgClubeDoFilme.jpeg" alt="fotoFilme" />
            </section>

            <aside class="sinopse debug">
                A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression into a shocking new form of therapy.
                Their concept catches on, with underground "fight clubs" forming in every town, until an eccentric gets in the way and ignites an
                out-of-control spiral toward oblivion.
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
                <div class="debug">seu favorito</div>
            </section>
        </main>
    </body>
</html>