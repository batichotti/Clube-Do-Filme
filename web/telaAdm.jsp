<!DOCTYPE html>
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
      <%
          if(String.valueOf(session.getAttribute("role")).equals("0") || String.valueOf(session.getAttribute("role")).equals("null")){
            response.sendRedirect("index.jsp");
          }
      %>
    <header
      id="headerTop"
      class="d-flex justify-content-between align-items-center pt-4 w-100"
    >
      <div class="d-flex gap column-gap-2 ps-5">
        <!-- <img src="" alt="Logo" class=".img-fluid"> -->
      <a href="index.jsp"><h1>Cadastro - <% out.println(String.valueOf(session.getAttribute("nick"))); %></h1></a>
      </div>
      <nav class="d-flex justify-content-around align-items-center pe-5 w-50">
        <div class="d-flex gap column-gap-4">
          <input
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
          <label for="escolhaGeneros">Gêneros</label>
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
      </nav>
    </header>

    <main class="mainAdm pt-5 pb-5">
      <form id="filmes" class="telaCadastro p-5" hidden>
        <div class="principal">
          <table>
            <tr>
              <h1 class="fs-1">FILME</h1>
              <div class="d-flex column-gap-2 cadastros">
                <label class="fs-4" for="idFilme">ID do filme: </label>
                <input id="idFilme" name="idFilme" type="text" />
              </div>
            </tr>
            <tr>
              <div class="d-flex column-gap-2 cadastros">
                <label class="fs-4" for="orcamento">Orçamento: </label>
                <input id="orcamento" name="orcamento" type="number" />
              </div>
            </tr>
            <tr>
              <div class="d-flex column-gap-2 cadastros">
                <label class="fs-4" for="titulo">Título: </label>
                <input id="titulo" name="titulo" type="text" />
              </div>
            </tr>
            <tr>
              <div class="d-flex column-gap-2 cadastros">
                <label class="fs-4" for="duracao">Duração: </label>
                <input id="duracao" name="duracao" type="number" />
              </div>
            </tr>
            <tr>
              <div class="d-flex column-gap-2 cadastros">
                <label class="fs-4" for="impressoes">Impressões: </label>
                <input id="impressoes" name="impressoes" type="text" />
              </div>
            </tr>
            <tr>
              <div class="d-flex column-gap-2 cadastros">
                <label class="fs-4" for="homepage">Homepage: </label>
                <input id="homepage" name="homepage" type="text" />
              </div>
            </tr>
          </table>
        </div>
        <button action="submit" class="botaoAdm">Cadastrar</button>
      </form>

      <form id="produtora" class="telaCadastro p-5" hidden>
        <div class="principal">
          <h1 class="fs-1">Produtora</h1>
          <div class="d-flex column-gap-2 cadastros">
            <label class="fs-4" for="idFilme">ID do filme: </label>
            <input id="idFilme" name="idFilme" type="number" />
          </div>
          <div class="d-flex column-gap-2 cadastros">
            <label class="fs-4" for="idProdutora">ID da produtora: </label>
            <input id="idProdutora" name="idProdutora" type="number" />
          </div>
          <div class="d-flex column-gap-2 align-items-center">
            <input
              id="periferico"
              type="checkbox"
              class="botaoPeriferico"
              onclick="perifericos(produtoraAdd)"
            />
            <label for="periferico">Adicionar produtora</label>
          </div>
        </div>
        <button action="submit" class="botaoAdm">Cadastrar</button>

        <!-- CHAMA O PRODUTORA -->
      </form>
      <form id="palavrasChave" class="telaCadastro p-5" hidden>
        <div class="principal">
          <h1 class="fs-1">Palavras Chave</h1>
          <div class="d-flex column-gap-2 cadastros">
            <label class="fs-4" for="idFilme">ID do filme: </label>
            <input id="idFilme" name="idFilme" type="number" />
          </div>
          <div class="d-flex column-gap-2 cadastros">
            <label class="fs-4" for="idPalavraChave">ID palavraChave: </label>
            <input id="idPalavraChave" name="idPalavraChave" type="number" />
          </div>
          <div class="d-flex column-gap-2 align-items-center">
            <input
              id="periferico"
              type="checkbox"
              class="botaoPeriferico"
              onclick="perifericos(palavraChave)"
            />
            <label for="periferico">Adicionar palavras</label>
          </div>
        </div>
        <button action="submit" class="botaoAdm">Cadastrar</button>

        <!-- CHAMA O PALAVRA -->
      </form>
      <form id="generos" class="telaCadastro p-5" hidden>
        <div class="principal">
          <h1 class="fs-1">Gêneros</h1>
          <div class="d-flex column-gap-2 cadastros">
            <label class="fs-4" for="idFilme">ID do filme: </label>
            <input id="idFilme" name="idFilme" type="number" />
          </div>
          <div class="d-flex column-gap-2 cadastros">
            <label class="fs-4" for="idPalavraChave">ID gênero: </label>
            <input id="idPalavraChave" name="idPalavraChave" type="number" />
          </div>
          <div class="d-flex column-gap-2 align-items-center">
            <input
              id="periferico"
              type="checkbox"
              class="botaoPeriferico"
              onclick="perifericos(genero)"
            />
            <label for="periferico">Adicionar gêneros</label>
          </div>
        </div>
        <button action="submit" class="botaoAdm">Cadastrar</button>

        <!-- CHAMA O GENERO -->
      </form>

      <form id="palavraChave" class="telaCadastro p-5" hidden>
        <div class="principal">
          <h1 class="fs-1">Palavra Chave</h1>
          <div class="d-flex column-gap-2 cadastros">
            <label class="fs-4" for="idFilme">ID da palavra: </label>
            <input id="idFilme" name="idFilme" type="number" />
          </div>
          <div class="d-flex column-gap-2 cadastros">
            <label class="fs-4" for="idPalavraChave">Nome: </label>
            <input id="idPalavraChave" name="idPalavraChave" type="text" />
          </div>
        </div>
        <button action="submit" class="botaoAdm botaoAdd">Adicionar</button>
      </form>
      <form id="genero" class="telaCadastro p-5" hidden>
        <div class="principal">
          <h1 class="fs-1">Gênero</h1>
          <div class="d-flex column-gap-2 cadastros">
            <label class="fs-4" for="idFilme">ID do gênero: </label>
            <input id="idFilme" name="idFilme" type="number" />
          </div>
          <div class="d-flex column-gap-2 cadastros">
            <label class="fs-4" for="idPalavraChave">Nome: </label>
            <input id="idPalavraChave" name="idPalavraChave" type="text" />
          </div>
        </div>
        <button action="submit" class="botaoAdm botaoAdd">Adicionar</button>
      </form>
      <form id="produtoraAdd" class="telaCadastro p-5" hidden>
        <div class="principal">
          <h1 class="fs-1">Produtora</h1>
          <div class="d-flex column-gap-2 cadastros">
            <label class="fs-4" for="idFilme">ID da produtora: </label>
            <input id="idFilme" name="idFilme" type="number" />
          </div>
          <div class="d-flex column-gap-2 cadastros">
            <label class="fs-4" for="idPalavraChave">Nome: </label>
            <input id="idPalavraChave" name="idPalavraChave" type="text" />
          </div>
        </div>
        <button action="submit" class="botaoAdm botaoAdd">Adicionar</button>
      </form>
    </main>
    <script src="./assets/js/cadastroAdm.js"></script>
  </body>
</html>
