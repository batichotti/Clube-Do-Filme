function animacaoCard() {
  const telaRegistro = document.querySelector("#telaRegistro");
  const desfoque = document.querySelector("#desfoque");

  if (telaRegistro.attributes.getNamedItem("hidden") === null) {
    fecharCard(telaRegistro, desfoque);
  } else {
    telaRegistro.attributes.removeNamedItem("hidden");
    desfoque.style.zIndex = "3";
  }
}

function fecharCard(telaRegistro, desfoque) {
  desfoque.style.zIndex = "-2";
  telaRegistro.setAttribute("hidden", "");
}

function navbarInferior() {
  const navbar = document.querySelector("#navbar");
  navbar.style.animation = "navbarAparecer 0.5s forwards"
}

function navbarInferiorFechar() {
  const navbar = document.querySelector("#navbar");
  navbar.style.animation = "navbarFechar 0.5s forwards";
}
