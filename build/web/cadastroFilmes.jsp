<!DOCTYPE html>
<%@page import="Entidades.ProductionCountry"%>
<%@page import="Entidades.ProductionCountryPK"%>
<%@page import="DAOs.DAOProductionCountry"%>
<%@page import="DAOs.DAOCountry"%>
<%@page import="Entidades.Country"%>
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
                if (!String.valueOf(session.getAttribute("where")).equals("filme")) {
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
                    <a href="./cadastroFilmes.jsp">Cadastro Filmes</a>
                    <a href="./cadastroGeneros.jsp">Cadastro Generos</a>
                    <a href="./cadastroPalavrasChaves.jsp">Cadastro Palavras-chaves</a>
                    <a href="./cadastroProdutoras.jsp">Cadastro Produtoras</a>
                </div>
            </nav>
        </header>

        <main class="mainAdm pt-5 pb-5">
            <form id="filmes" class="telaCadastro p-5" method="post" name="filmes" action="acaoFilme">
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
                                       try {
                                           if (!(id.equals("null")) && (String.valueOf(session.getAttribute("acao")).equals("alterar"))) {
                                               out.println("value='" + String.valueOf(daoMovies.obter(Integer.valueOf(id)).getBudget()) + "'");
                                           }
                                       } catch (Exception e) {
                                           out.println("value=\'\'");
                                       }

                                   %>
                                   />
                        </div>
                        </tr>
                        <tr>
                        <div class="d-flex column-gap-2 cadastros">
                            <label class="fs-4" for="titulo">Titulo: </label>
                            <input id="titulo" name="titulo" type="text"
                                   <%                                       try {
                                           if (!(id.equals("null")) && (String.valueOf(session.getAttribute("acao")).equals("alterar"))) {
                                               out.println("value='" + String.valueOf(daoMovies.obter(Integer.valueOf(id)).getTitle()) + "'");
                                           }
                                       } catch (Exception e) {
                                           out.println("value=\'\'");
                                       }
                                   %>/>
                        </div>
                        </tr>
                        <tr>
                        <div class="d-flex column-gap-2 cadastros">
                            <label class="fs-4" for="duracao">Duracao: </label>
                            <input id="duracao" name="duracao" type="number"
                                   <%
                                       try {
                                           if (!(id.equals("null")) && (String.valueOf(session.getAttribute("acao")).equals("alterar"))) {
                                               out.println("value='" + String.valueOf(daoMovies.obter(Integer.valueOf(id)).getRuntime()) + "'");
                                           }
                                       } catch (Exception e) {
                                           out.println("value=\'\'");
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
                                       try {
                                           if (!(id.equals("null")) && (String.valueOf(session.getAttribute("acao")).equals("alterar"))) {
                                               out.println("value='" + String.valueOf(daoMovies.obter(Integer.valueOf(id)).getOverview()) + "'");
                                           }
                                       } catch (Exception e) {
                                           out.println("value=\'\'");
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
                                       try {
                                           if (!(id.equals("null")) && (String.valueOf(session.getAttribute("acao")).equals("alterar"))) {
                                               out.println("value='" + String.valueOf(daoMovies.obter(Integer.valueOf(id)).getHomepage()) + "'");
                                           }
                                       } catch (Exception e) {
                                           out.println("value=\'\'");
                                       }
                                   %>
                                   />
                        </div>
                        </tr>
                    </table>
                    <div class="d-flex column-gap-2 align-items-center">
                        <input
                            id="periferico"
                            type="checkbox"
                            class="botaoPeriferico"
                            onclick="perifericos(pais)"
                            />
                        <label for="periferico">Adicionar País</label>
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
            </form>

            <form id="pais" class="telaCadastro p-5" hidden method="post" action="acaoPais">
                <div class="principal">
                    <h1 class="fs-1">País</h1>
                    <div class="d-flex column-gap-2 cadastros">
                        <select id="listaOpcoes" name="listaOpcoes" style="color: white; background-color: black;">
                            <% DAOCountry daoPC = new DAOCountry(); %>
                            <% for (Country c : daoPC.listInOrderNome()) {%>
                            <option value="<%= c.getCountryId()%>"><%= c.getCountryName()%></option>
                            <% } %>
                        </select>

                    </div>
                </div>
                <button type="submit" class="botaoAdm botaoAdd">Adicionar</button>
            </form>
        </main>

        <script>
            function selectElement(id, valueToSelect) {
                let element = document.getElementById(id);
                element.value = valueToSelect;
            }

            selectElement('listaOpcoes', <%
                String country = "null";
                DAOProductionCountry daoProdCount = new DAOProductionCountry();
                try {
                    String movie_title = daoMovies.obter(Integer.valueOf(String.valueOf(session.getAttribute("id")))).getTitle();

                    try {
                        for (ProductionCountry m : daoProdCount.encontrarPaisesPorFilmeId(movie_title)) {
                            country = String.valueOf(m.getProductionCountryPK().getCountryId());
                        }
                    } catch (Exception e) {
                        if (country.equals("null")) {
                            out.print("139");
                        } else {
                            out.print("140");
                        }
                    }

                    if (!country.equals("null")) {
                        out.print(country);
                    }
                } catch (Exception e) {
                    out.print(e.getMessage());
                }
            %>);

        </script>
        <script src="./assets/js/cadastroAdm.js"></script>
    </body>
</html>
