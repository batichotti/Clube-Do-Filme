const cursor = document.querySelector("#cursor");

window.onpointermove = (e) => {
  const { clientX, clientY } = e;

  cursor.animate(
    {
      left: `${clientX}px`,
      top: `${clientY}px`,
    },
    { duration: 5000, fill: "forwards" }
  );
};
