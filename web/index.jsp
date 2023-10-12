<%-- 
    Document   : index
    Created on : 25 de set. de 2023, 18:15:28
    Author     : Mateus Cohuzer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entidades.User"%>
<%@page import="DAOs.DAOUser"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="./assets/css/styleEfeitos.css" />
        <link rel="stylesheet" href="./assets/css/styleLandingPage.css" />

        <title>Clube do Filme</title>
    </head>

    <body class="w-100 bodyLanding">
        <main class="w-100 h-100">
            <div id="cursor"></div>
            <span id="desfoque" class="w-100 h-100"></span>

            <nav
                id="navbar"
                class="d-flex justify-content-center align-items-center column-gap-4 rounded-pill"
                onmouseenter="navbarInferior()"
                >
                <a href=""
                   ><img src="./assets/images/icons/iconFavoritos.png" alt="❤"
                      /></a>
                <a href=""
                   ><img src="./assets/images/icons/iconConta.png" alt="👦"
                      /></a>
                <a href=""
                   ><img src="./assets/images/icons/iconPesquisa.png" alt="🔍"
                      /></a>
            </nav>

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
                            User usuario = new User();
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
                        %>
                    </div>
                    <input
                        type="text"
                        class="inputBuscar rounded-pill"
                        placeholder="Buscar"
                        />
                </nav>
            </header>

            <span class="camadaTransparente w-100"></span>
            <aside class="linkRegistro w-100 h-75 d-flex justify-content-end" hidden>
                <div
                    class="d-flex flex-column align-items-center justify-content-center w-50"
                    >
                    <h5>
                        1ª regra do clube do filme: <mark>Descubra</mark> novos filmes.
                    </h5>
                    <h5>2ª regra do clube do filme: <mark>Avalie</mark> novos filmes.</h5>
                    <h5>3ª regra do clube do filme: <mark>Salve</mark> novos filmes.</h5>
                    <%
                        if(String.valueOf(session.getAttribute("logado")).equals("False")){
                            out.println("<h2>Ainda não está cadastrado? Registre-se!</h2>");
                        }
                    %>
                    <nav>
                        <button
                            type="button"
                            class="botaoRegistro btn"
                            onclick="animacaoCard()"
                            <%
                            if(String.valueOf(session.getAttribute("logado")).equals("True")){
                                out.println("hidden");
                            }
                            %>
                            >
                            Registrar
                        </button>
                        <button
                            type="button"
                            class="botaoLogin btn btn-outline-secondary"
                            onclick="animacaoCardLogin()"
                            <%
                            if(String.valueOf(session.getAttribute("logado")).equals("True")){
                                out.println("hidden");
                            }
                            %>
                            >
                            Já tenho uma conta
                        </button>
                    </nav>
                </div>
            </aside>

            <article id="telaRegistro" hidden>
                <div
                    class="cabecalhoRegistro w-100 d-flex justify-content-between align-items-center p-2 pe-4 ps-4"
                    >
                    <h3>Registro</h3>
                    <a onclick="animacaoCard()"
                       ><img
                            src="./assets/images/icons/iconFecharBranco.png"
                            class=".img-fluid"
                            alt="X"
                            /></a>
                </div>
                <form
                    id="formRegistro"
                    action="registro"
                    method="post"
                    class="corpoRegistro d-flex flex-column w-100 h-100 p-4 row-gap-3"
                    >
                    <div class="inputRegistro d-flex align-items-center column-gap-2">
                        <label for="nome">Nome: </label>
                        <input
                            id="nome"
                            name="nome"
                            type="text"
                            class="inputBuscar input-group-text h-75 w-75 p-2"
                            placeholder="Digite seu nome..."
                            />
                    </div>
                    <div class="inputRegistro d-flex align-items-center column-gap-2">
                        <label for="email">Email: </label>
                        <input
                            id="email"
                            name="email"
                            type="email"
                            class="inputBuscar input-group-text h-75 w-75 p-2"
                            placeholder="Digite seu email..."
                            />
                    </div>
                    <div class="inputRegistro d-flex align-items-center column-gap-2">
                        <label for="senha">Senha: </label>
                        <input
                            id="senha"
                            name="senha"
                            type="password"
                            class="inputBuscar input-group-text h-75 w-75 p-2"
                            placeholder="Digite sua senha..."
                            />
                    </div>
                    <button type="submit" class="botaoRegistro btn">Registrar</button>
                </form>
            </article>

            <article id='telaLogin' hidden>
                <div
                    class="cabecalhoRegistro w-100 d-flex justify-content-between align-items-center p-2 pe-4 ps-4"
                    >
                    <h3>Login</h3>
                    <a onclick="animacaoCardLogin()"
                       ><img
                            src="./assets/images/icons/iconFecharBranco.png"
                            class=".img-fluid"
                            alt="X"
                            /></a>
                </div>
                <form
                    id="formLogin"
                    method="post"
                    action="login"
                    class="corpoRegistro d-flex flex-column w-100 h-100 p-4 row-gap-3"
                    >
                    <div
                        class="inputRegistro d-flex align-items-center column-gap-2 w-100"
                        >
                        <label for="email">Email: </label>
                        <input
                            id="email"
                            name="email"
                            type="text"
                            class="inputEntrar input-group-text p-2"
                            placeholder="Digite seu email..."
                            />
                    </div>
                    <div
                        class="inputRegistro d-flex align-items-center column-gap-2 w-100"
                        >
                        <label for="senha">Senha: </label>
                        <input
                            id="senha"
                            name="senha"
                            type="password"
                            class="inputEntrar input-group-text p-2"
                            placeholder="Digite sua senha..."
                            />
                    </div>
                    <button type="submit" class="botaoLogin btn">Entrar</button>
                    <%
                      String email = String.valueOf(session.getAttribute("email"));
                      String senha = String.valueOf(session.getAttribute("senha"));

                      daoUser = new DAOUser();

                      try {
                        if (email.equals(daoUser.obter(email).getEmail()) && senha.equals(daoUser.obter(email).getPassword())) {
                            if (email.equals("null")) {
                                out.println("<p style='color:red;'>Efetue seu login</p>");
                            }
                        } else if (String.valueOf(session.getAttribute("nick")).equals("null")) {
                            out.println("👌 Efetue seu login");
                        } else {
                            out.println("<p style='color:red;'>Login inválido</p>");
                        }
                    } catch (Exception e) {
                        out.println("<p> Erro:" + e.getMessage() + "</p>");
                    }
                    %>
                </form>
            </article>
        </main>

        <aside
            id="cardFilmes"
            class="cardFilmes d-flex flex-column align-items-center justify-content-center w-100 h-75"
            >
            <h1>Filmes em destaque</h1>

            <aside class="container w-100">
                <button class="botaoDireito control" aria-label="Next image">▶</button>
                <button class="botaoEsquerdo control" aria-label="Previous Image">
                    ◀
                </button>
                <div class="gallery-wrapper">
                    <div class="gallery">
                        <img
                            src="./assets/images/placeholder.png"
                            class="item current-item"
                            alt=""
                            />
                        <img
                            src="./assets/images/placeholder.png"
                            class="item current-item"
                            alt=""
                            />
                        <img
                            src="./assets/images/placeholder.png"
                            class="item current-item"
                            alt=""
                            />
                        <img
                            src="./assets/images/placeholder.png"
                            class="item current-item"
                            alt=""
                            />
                        <img
                            src="./assets/images/placeholder.png"
                            class="item current-item"
                            alt=""
                            />
                        <img
                            src="./assets/images/placeholder.png"
                            class="item current-item"
                            alt=""
                            />
                    </div>
                </div>
            </aside>
        </aside>

        <!-- importacao js -->
        <script src="./assets/js/efeitosGerais.js"></script>
        <script src="./assets/js/cursor.js"></script>
        <script src="./assets/js/slideFIlmes.js"></script>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
            crossorigin="anonymous"
        ></script>
    </body>
</html>
