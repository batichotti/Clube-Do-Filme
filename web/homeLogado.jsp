<%-- 
    Document   : homeLogado
    Created on : 19 de set. de 2023, 16:17:46
    Author     : Mateus Cohuzer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
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

  <body class="w-100">
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
          <h1 class="segredo">***** do *****</h1>
        </div>
        <nav class="d-flex justify-content-around align-items-center pe-5 w-50">
          <div class="d-flex gap column-gap-5">
            <a href="#">Filmes</a>
            <a href="#">Novidades</a>
            <a href="#">Categorias</a>
          </div>
          <input
            type="text"
            class="inputBuscar rounded-pill"
            placeholder="Buscar"
          />

          <img src="./assets/images/icons/iconConta.png" class="rounded"></img>
        </nav>
      </header>

      <span class="camadaTransparente w-100"></span>
      <!-- SE o usuario nao for logado -->
      <aside class="linkRegistro w-100 h-75 d-flex justify-content-end" hidden>
        <div
          class="d-flex flex-column align-items-center justify-content-center w-50"
        >
          <h2>Bem vindo ao <span class="segredo">***** do *****</span> ...</h2>
          <h4>Deseja um <mark>passeio</mark> por nossas ferramentas? Veja <mark>abaixo</mark>!</h4>
          <nav class="d-flex column-gap-2">
            <button class="botaoRegistro btn">Filmes avaliados</button>
            <a class="botaoRegistro btn">Seus favoritos</a>
          </nav>
        </div>
      </aside>

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
    </aside>

    <!-- importacao js -->
    <script src="./assets/js/efeitosGerais.js"></script>
    <script src="./assets/js/mudarPalavras.js"></script>
    <script src="./assets/js/cursor.js"></script>
    <script src="./assets/js/slideFIlmes.js"></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
      crossorigin="anonymous"
    ></script>
  </body>
</html>

