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
                    <h1>Clube do Filme</h1>
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
                                    if(is_logged.equals("True") && !String.valueOf(session.getAttribute("nick")).equals("null")){
                                        out.println("<a href='deslogin'> Deslogar </a>");
                                    } else {
                                        out.println("<a>Login</a>");
                                    }
                                }catch(Exception e){
                                    out.println("<a>Login (Err)</a>");
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
            <!-- SE o usuario nao for logado -->
            <aside class="linkRegistro w-100 h-75 d-flex justify-content-end" hidden>
                <div
                    class="d-flex flex-column align-items-center justify-content-center w-50"
                    >
                    <h5>
                        1ª regra do clube do filme: <mark>Descubra</mark> novos filmes.
                    </h5>
                    <h5>2ª regra do clube do filme: <mark>Avalie</mark> novos filmes.</h5>
                    <h5>3ª regra do clube do filme: <mark>Salve</mark> novos filmes.</h5>
                    <h2>Ainda não está cadastrado? Registre-se!</h2>
                    <nav>
                        <button
                            type="button"
                            class="botaoRegistro btn"
                            onclick="animacaoCard()"
                            >
                            Registrar
                        </button>
                        <button
                            type="button"
                            class="botaoLogin btn btn-outline-secondary"
                            onclick="animacaoCardLogin()"
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
                    method="post"
                    action="index.jsp"
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
                    <%
                        session = request.getSession();
                        String nome = String.valueOf(request.getParameter("nome"));
                        String email = String.valueOf(request.getParameter("email"));
                        String senha = String.valueOf(request.getParameter("senha"));

                        daoUser = new DAOUser();
                        usuario = new User();

                        List<User> listinha = daoUser.listInOrderId();
                        boolean is_mail_unique = true;
                        for (int i = 0; i < listinha.size(); i++) {
                            if (listinha.get(i).getEmail().equals(email)) {
                                is_mail_unique = false;
                            }
                        }

                        if (is_mail_unique) {
                            usuario.setEmail(email);
                            usuario.setNick(nome);
                            usuario.setPassword(senha);
                            usuario.setRole(0);
                            daoUser.inserir(usuario);
                            session.setAttribute("logado", "True");
                            session.setAttribute("nick", nome);
                        } else {
                            out.println(String.valueOf(session.getAttribute("nick")));
                        }
                    %>
                </form>
            </article>

            <article id="telaLogin" hidden>
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
                    action="index.jsp"
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
                            type="text"
                            class="inputEntrar input-group-text p-2"
                            placeholder="Digite sua senha..."
                            />
                    </div>
                    <button type="submit" class="botaoLogin btn">Entrar</button>
                    <%
                      session = request.getSession();
                      email = String.valueOf(request.getParameter("email"));
                      senha = String.valueOf(request.getParameter("senha"));

                      daoUser = new DAOUser();
                      usuario = new User();

                      try {
                        if (email.equals(daoUser.obter(email).getEmail()) && senha.equals(daoUser.obter(email).getPassword()) && !String.valueOf(session.getAttribute("nick")).equals("null")) {
                          session.setAttribute("logado", "True");
                          session.setAttribute("nick", String.valueOf(daoUser.obter(email).getNick()));
                          out.println("<p>"+String.valueOf(session.getAttribute("nick"))+"</p>");
                      } else if(String.valueOf(session.getAttribute("nick")).equals("null")){
                        out.println("👌 Efetue seu login");
                      } else {
                          out.println("<p>Erro no login</p>");
                      }
                } catch (Exception e) {
                    out.println("<p>"+String.valueOf(session.getAttribute("logado"))+"</p>");
                    out.println(String.valueOf("<p>"+session.getAttribute("nick"))+"</p>");
                    out.println("<p>"+e.getMessage()+"</p>");
                }
                    %>
                </form>
            </article>
        </main>

        <!-- Parte dos filmes -->
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
