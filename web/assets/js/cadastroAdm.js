function aparecerTela() {
  const escolhas = document.querySelectorAll(".escolha");
  let caminho;
  for (i = 0; i < escolhas.length; i++) {
    if (escolhas[i].checked) {
      caminho = escolhas[i].value;
    }
  }

  caminho == 0 ? decisao(true, filmes) : decisao(false, filmes);
  caminho == 2 ? decisao(true, palavrasChave) : decisao(false, palavrasChave);
  caminho == 3 ? decisao(true, generos) : decisao(false, generos);
  caminho == 4 ? decisao(true, produtora) : decisao(false, produtora);

  function decisao(acao, tela) {
    if (acao) return tela.attributes.removeNamedItem("hidden");
    tela.setAttribute("hidden", "");
  }
}

function perifericos(crud) {
  try {
    crud.attributes.removeNamedItem("hidden");
  } catch (error) {
    crud.setAttribute("hidden", "");
  }
}
