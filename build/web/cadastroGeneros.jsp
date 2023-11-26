<%@page import="DAOs.DAOMovieGenres"%>
<%@page import="Entidades.Genre"%>
<%@page import="DAOs.DAOGenre"%>
<!DOCTYPE html>
<%@page import="Entidades.Movie"%> <%@page import="DAOs.DAOMovies"%>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Cadastro</title>
        <link rel="stylesheet" href="./assets/css/styleEfeitos.css" />
        <link rel="stylesheet" href="./assets/css/styleLandingPage.css" />
        <link rel="stylesheet" href="./assets/css/styleFilmeIndividual.css" />
        <link rel="stylesheet" href="./assets/css/styleAdm.css" />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
            crossorigin="anonymous"
            />
    </head>
    <body class="bodyAdm">
        <% DAOGenre daoGenre = null;
            if (String.valueOf(session.getAttribute("role")).equals("0")
                    || String.valueOf(session.getAttribute("role")).equals("null")) {
                response.sendRedirect("index.jsp");
            } else {
                daoGenre = new DAOGenre();
            }

            String acao = "";
            try {
                acao = String.valueOf(session.getAttribute("acao"));
                if (acao.equals("null")) {
                    acao = "buscar";
                }
                if (!String.valueOf(session.getAttribute("where")).equals("genero")) {
                    acao = "buscar";
                    session.setAttribute("acao2", "buscar");
                    session.setAttribute("lop", "");
                    session.setAttribute("lop2", "");
                }
            } catch (Exception e) {
                acao = "buscar";
            }
            session.setAttribute("acao", acao);
            session.setAttribute("where", "genero");
            if (String.valueOf(session.getAttribute("role")).equals("0") || String.valueOf(session.getAttribute("role")).equals("null")) {
                response.sendRedirect("index.jsp");
            } else {
                daoGenre = new DAOGenre();
            }
        %>
        <header
            id="headerTop"
            class="d-flex justify-content-between align-items-center pt-4 w-100"
            >
            <div class="d-flex gap column-gap-2 ps-5">
                <!-- <img src="" alt="Logo" class=".img-fluid"> -->
                <a href="index.jsp"
                   ><h1>
                        Cadastro - <%out.println(String.valueOf(session.getAttribute("nick")));%>
                    </h1></a
                >
            </div>
            <nav class="d-flex justify-content-around align-items-center pe-5 w-50">
                <div class="d-flex gap column-gap-4">
                    <a href="./cadastroFilmes.jsp">Cadastro Filmes</a>
                    <a href="./cadastroGeneros.jsp">Cadastro Generos</a>
                    <a href="./cadastroPalavrasChaves.jsp">Cadastro Palavras-chaves</a>
                    <a href="./cadastroProdutoras.jsp">Cadastro Produtoras</a>
                </div>
            </nav>
        </header>

        <main class="mainAdm pt-5 pb-5">
            <form
                id="generos"
                method="post"
                class="telaCadastro p-5"
                action="acaoGenero"
                >
                <div class="principal row-gap-2">
                    <h1 class="fs-1">Generos</h1>
                    <div class="d-flex column-gap-2 cadastros">
                        <label class="fs-4" for="idGenre">ID do Gênero: </label>
                        <input id="idGenre" name="idGenre" type="number" min="1" required
                               <%
                                   String id = "null";
                                   try {
                                       id = String.valueOf(session.getAttribute("id"));
                                   } catch (Exception e) {
                                       id = "null";
                                   }
                                   if (!(id.equals("null")) && !(String.valueOf(session.getAttribute("acao")).equals("buscar"))) {
                                       out.println("value='" + id + "'");
                                       out.println("readonly");
                                   }
                               %>/>
                    </div>
                    <div class="d-flex column-gap-2 cadastros">
                        <label class="fs-4" for="genre_name">Nome gênero: </label>
                        <input id="genre_name" name="genre_name" type="text"
                               <%
                                   try {
                                       if (!(id.equals("null")) && (String.valueOf(session.getAttribute("acao")).equals("alterar"))) {
                                           out.println("value='" + String.valueOf(daoGenre.obter(Integer.valueOf(id)).getGenreName()) + "'");
                                       }
                                   } catch (Exception e) {
                                       out.println("value=\'\'");
                                   }
                               %>
                               />
                    </div>
                    <div class="d-flex column-gap-2 align-items-center">
                        <input
                            id="periferico"
                            type="checkbox"
                            class="botaoPeriferico"
                            onclick="perifericos(generoHas)"
                            />
                        <label for="periferico">Adicionar generos</label>
                    </div>
                </div>

                <div class="botoesCRUD d-flex flex-column row-gap-2">
                    <button
                        name="acao"
                        value="buscar"
                        class="botaoAdm buscar"
                        <%if (!(acao.equals("buscar"))) {
                                out.println("hidden");
                            }%>
                        >
                        Buscar
                    </button>
                    <button
                        name="acao"
                        value="listar"
                        class="botaoAdm buscar"
                        <%if (!(acao.equals("buscar"))) {
                                out.println("hidden");
                            }%>
                        >
                        Listar
                    </button>
                    <button
                        name="acao"
                        value="alterar"
                        class="botaoAdm alterar"
                        <%if (!(acao.equals("alterar"))) {
                                out.println("hidden");
                            }%>
                        >
                        Alterar
                    </button>
                    <button
                        name="acao"
                        value="excluir"
                        class="botaoAdm excluir"
                        <%if (!(acao.equals("alterar"))) {
                                out.println("hidden");
                            }%>
                        >
                        Excluir
                    </button>
                    <button
                        name="acao"
                        value="cancelar"
                        class="botaoAdm excluir"
                        <%if ((acao.equals("buscar"))) {
                                out.println("hidden");
                            }%>
                        >
                        Cancelar
                    </button>
                    <button
                        name="acao"
                        value="salvar"
                        class="botaoAdm excluir"
                        <%if (!(acao.equals("salvar"))) {
                                out.println("hidden");
                            }%>
                        >
                        Salvar
                    </button>
                </div>
                <!-- CHAMA O GENERO -->
            </form>

            <form id="generoHas" class="telaCadastro p-5" hidden method="post" action="acaoGeneroHas">
                <div class="principal" style="flex-direction: row; width: 100%;align-content: space-around;justify-content: space-between;">
                    <div class="d-flex column-gap-2 cadastros">
                        <h1 class="fs-1"><label for="listaOpcoes2">Filme</label></h1>
                        <select id="listaOpcoes2" name="listaOpcoes2" style="color: white; background-color: black;">
                            <% DAOMovies daoMovies = new DAOMovies();%>
                            <% for (Movie c : daoMovies.listInOrderNome()) {%>
                            <option value="<%= c.getMovieId()%>"><%= c.getTitle()%></option>
                            <% } %>
                        </select>
                    </div>
                    <div class="d-flex column-gap-2 cadastros">
                        <h1 class="fs-1"><label for="listaOpcoes">Gênero</label></h1>
                        <select id="listaOpcoes" name="listaOpcoes" style="color: white; background-color: black;">
                            <% DAOGenre daoPC = new DAOGenre();
                                String acao2 = "null";
                                try {
                                    acao2 = String.valueOf(session.getAttribute("acao2"));
                                } catch (Exception e) {
                                    acao2 = "buscar";
                                    session.setAttribute("acao2", "buscar");
                                }
                                if (acao2.equals("null")) {
                                    acao2 = "buscar";
                                    session.setAttribute("acao2", "buscar");
                                }
                            %>
                            <% for (Genre c : daoGenre.list()) {%>
                            <option value="<%= c.getGenreId()%>"><%= c.getGenreName()%></option>
                            <% } %>
                        </select>
                    </div>
                    <div class="botoesCRUD d-flex flex-column row-gap-2">
                        <button name="acao2"  value="cancelar" class="botaoAdm excluir"
                                <%if ((acao2.equals("buscar"))) {
                                        out.println("hidden");
                                    }%>
                                >
                            Cancelar
                        </button>
                        <button name="acao2"  value="adicionar" class="botaoAdm excluir"
                                <%if (!(acao2.equals("adicionar"))) {
                                        out.println("hidden");
                                    }%>
                                >
                            Adicionar
                        </button>
                        <button name="acao2"  value="excluir" class="botaoAdm excluir"
                                <%if (!(acao2.equals("excluir"))) {
                                        out.println("hidden");
                                    }%>
                                >
                            Excluir
                        </button>
                        <button name="acao2"  value="buscar" class="botaoAdm excluir"
                                <%if (!(acao2.equals("buscar"))) {
                                        out.println("hidden");
                                    }%>
                                >
                            Buscar
                        </button>
                    </div>
                </div>
            </form>
        </main>

        <script>
            function selectElement(id, valueToSelect) {
                let element = document.getElementById(id);
                element.value = valueToSelect; //valueToSelect == id do banco de dados
            }

            <%
                if (!String.valueOf(session.getAttribute("acao2")).equals("buscar")) {
                    out.print("selectElement('listaOpcoes', " + String.valueOf(session.getAttribute("lop")) + ");");
                    out.print("selectElement('listaOpcoes2', " + String.valueOf(session.getAttribute("lop2")) + ");");
                }
            %>

        </script>
        <script src="./assets/js/cadastroAdm.js"></script>
    </body>
</html>
