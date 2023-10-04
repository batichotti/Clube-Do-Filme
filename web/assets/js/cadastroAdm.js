function aparecerTela() {
  const escolhas = document.querySelectorAll(".escolha");
  const filmes = document.querySelector("#filmes");
  let caminho;
  for (i = 0; i < escolhas.length; i++) {
    if (escolhas[i].checked) {
      caminho = escolhas[i].value;
    }
  }

  caminho == 0 ? renderizar(filmes) : esconder(filmes);
  caminho == 1 ? renderizar(elenco) : esconder(elenco);
  caminho == 2 ? renderizar(palavrasChave) : esconder(palavrasChave);
  caminho == 3 ? renderizar(generos) : esconder(generos);
  caminho == 4 ? renderizar(produtora) : esconder(produtora);

  function renderizar(tela) {
    try {
      tela.attributes.removeNamedItem("hidden");
    } catch (error) {}
  }
  function esconder(tela) {
    try {
      tela.setAttribute("hidden", "");
    } catch (error) {}
  }
}
