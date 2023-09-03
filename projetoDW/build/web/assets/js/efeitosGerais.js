function animacaoCard() {
  const telaRegistro = document.querySelector("#telaRegistro");
  const desfoque = document.querySelector("#desfoque");

  let acao =
    telaRegistro.attributes.getNamedItem("hidden") === null
      ? cards("fechar", telaRegistro, desfoque)
      : cards("abrir", telaRegistro, desfoque);
}

function animacaoCardLogin() {
  const telaLogin = document.querySelector("#telaLogin");
  const desfoque = document.querySelector("#desfoque");

  let acao =
    telaLogin.attributes.getNamedItem("hidden") === null
      ? cards("fechar", telaLogin, desfoque)
      : cards("abrir", telaLogin, desfoque);
}

function cards(acao, tela, desfoque) {
  if (acao === "abrir") {
    tela.attributes.removeNamedItem("hidden");
    desfoque.style.zIndex = "3";
  } else {
    desfoque.style.zIndex = "-2";
    tela.setAttribute("hidden", "");
  }
}

function slideFilmes() {
  const cardFilmes = document.querySelector("#cardFilmes");
  const distanciaPercorrida =
    window.innerHeight - cardFilmes.getBoundingClientRect().top;

  // navbar
  let acaoNavbar =
    distanciaPercorrida > 80
      ? (navbar.style.animation = "navbarAparecer 0.5s forwards")
      : (navbar.style.animation = "navbarFechar 0.5s forwards");
}

window.addEventListener("scroll", slideFilmes);
