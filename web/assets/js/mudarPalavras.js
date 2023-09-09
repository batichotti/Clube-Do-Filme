const hitboxes = document.querySelectorAll(".segredo");

hitboxes.forEach((hitbox) => {
  hitbox.addEventListener("mouseenter", (e) => {
    hitbox.innerHTML = "Clube do Filme";
  });
});
