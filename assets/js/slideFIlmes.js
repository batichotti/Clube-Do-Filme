const controlesSlide = document.querySelectorAll(".controleSlide");
const filmes = document.querySelectorAll(".filme");
const maximoFilmes = filmes.length;
let filmeAtual = 0;

controlesSlide.forEach((botao) =>{
    botao.addEventListener("click", e =>{
        e.target.classList.contains("slideEsquerdo") ? filmeAtual -= 1 : filmeAtual += 1;
        filmeAtual >= maximoFilmes ? filmeAtual = 0 : filmeAtual;
        filmeAtual < 0 ? filmeAtual = maximoFilmes - 1 : filmeAtual;

        filmes[filmeAtual].scrollIntoView({
            behavior: "smooth",
            inline: "center"
        });
    })
})