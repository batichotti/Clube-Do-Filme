<!DOCTYPE html>
<%@page import="Entidades.Movie"%> <%@page import="DAOs.DAOMovies"%>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Cadastro - Filmes</title>
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
        <% DAOMovies daoMovies = null;
            String acao = "";
            try {
                acao = String.valueOf(session.getAttribute("acao"));
                if (acao.equals("null")) {
                    acao = "buscar";
                }
            } catch (Exception e) {
                acao = "buscar";
            }
            session.setAttribute("acao", acao);
            session.setAttribute("where", "filme");
            if (String.valueOf(session.getAttribute("role")).equals("0")
                    || String.valueOf(session.getAttribute("role")).equals("null")) {
                response.sendRedirect("index.jsp");
            } else {
                daoMovies = new DAOMovies();
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
                    <!-- <input
                                  class="escolha"
                                  id="escolhaFilme"
                                  name="escolha"
                                  type="radio"
                                  value="0"
                                  onclick="aparecerTela()"
                                  />
                              <label for="escolhaFilme">Filme</label>
                              <input
                                  class="escolha"
                                  id="escolhaPalavras-chave"
                                  name="escolha"
                                  type="radio"
                                  value="2"
                                  onclick="aparecerTela()"
                                  />
                              <label for="escolhaPalavras-chave">Palavras Chave</label>
                              <input
                                  class="escolha"
                                  id="escolhaGeneros"
                                  name="escolha"
                                  type="radio"
                                  value="3"
                                  onclick="aparecerTela()"
                                  />
                              <label for="escolhaGeneros">G�neros</label>
                              <input
                                  class="escolha"
                                  id="escolhaProdutora"
                                  name="escolha"
                                  type="radio"
                                  value="4"
                                  onclick="aparecerTela()"
                                  />
                              <label for="escolhaProdutora">Produtora</label>
                          </div>
                      </nav> -->
                    <a href="./cadastroFilmes.jsp">Cadastro Filmes</a>
                    <a href="./cadastroGeneros.jsp">Cadastro Generos</a>
                    <a href="./cadastroPalavrasChaves.jsp">Cadastro Palavras-chaves</a>
                    <a href="./cadastroProdutoras.jsp">Cadastro Produtoras</a>
                </div>
            </nav>
        </header>

        <main class="mainAdm pt-5 pb-5">
            <form id="filmes" class="telaCadastro p-5" method="post" name="filmes" action="acao">
                <div class="principal">
                    <table>
                        <tr>
                        <h1 class="fs-1">FILME</h1>
                        <div class="d-flex column-gap-2 cadastros">
                            <label class="fs-4" for="idFilme">ID do filme: </label>
                            <input id="idFilme" name="idFilme" type="number" min="1" required
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
                                   %>
                                   />
                        </div>
                        </tr>
                        <tr>
                        <div class="d-flex column-gap-2 cadastros">
                            <label class="fs-4" for="orcamento">Orcamento: </label>
                            <input id="orcamento" name="orcamento" type="number"
                                   <%
                                       if (!(id.equals("null")) && (String.valueOf(session.getAttribute("acao")).equals("alterar"))) {
                                           out.println("value='" + String.valueOf(daoMovies.obter(Integer.valueOf(id)).getBudget()) + "'");
                                       }
                                   %>
                                   />
                        </div>
                        </tr>
                        <tr>
                        <div class="d-flex column-gap-2 cadastros">
                            <label class="fs-4" for="titulo">Titulo: </label>
                            <input id="titulo" name="titulo" type="text"
                                   <%
                                       if (!(id.equals("null")) && (String.valueOf(session.getAttribute("acao")).equals("alterar"))) {
                                           out.println("value='" + String.valueOf(daoMovies.obter(Integer.valueOf(id)).getTitle()) + "'");
                                       }
                                   %>/>
                        </div>
                        </tr>
                        <tr>
                        <div class="d-flex column-gap-2 cadastros">
                            <label class="fs-4" for="duracao">Duracao: </label>
                            <input id="duracao" name="duracao" type="number"
                                   <%
                                       if (!(id.equals("null")) && (String.valueOf(session.getAttribute("acao")).equals("alterar"))) {
                                           out.println("value='" + String.valueOf(daoMovies.obter(Integer.valueOf(id)).getRuntime()) + "'");
                                       }
                                   %>
                                   />
                        </div>
                        </tr>
                        <tr>
                        <div class="d-flex column-gap-2 cadastros">
                            <label class="fs-4" for="impressoes">Sinopse: </label>
                            <input id="sinopse" name="sinopse" type="text"
                                   <%
                                       if (!(id.equals("null")) && (String.valueOf(session.getAttribute("acao")).equals("alterar"))) {
                                           out.println("value='" + String.valueOf(daoMovies.obter(Integer.valueOf(id)).getOverview()) + "'");
                                       }
                                   %>
                                   />
                        </div>
                        </tr>
                        <tr>
                        <div class="d-flex column-gap-2 cadastros">
                            <label class="fs-4" for="homepage">Homepage: </label>
                            <input id="homepage" name="homepage" type="text"
                                   <%
                                       if (!(id.equals("null")) && (String.valueOf(session.getAttribute("acao")).equals("alterar"))) {
                                           out.println("value='" + String.valueOf(daoMovies.obter(Integer.valueOf(id)).getHomepage()) + "'");
                                       }
                                   %>
                                   />
                        </div>
                        </tr>
                    </table>
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
            </form>
        </main>
        <script src="./assets/js/cadastroAdm.js"></script>
    </body>
</html>
