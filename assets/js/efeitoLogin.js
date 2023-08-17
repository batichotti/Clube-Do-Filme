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
  telaRegistro.style.animation = "cardLogin 0.5s backwards";
  telaRegistro.style.animationFillMode = "backwards;";
  telaRegistro.setAttribute("hidden", "");
}
