import * as th from "three";
import { GLTFLoader } from "three/addons/loaders/GLTFLoader.js";

// configuracoes
const canvas = document.querySelector("#sabao");
const scene = new th.Scene();
const renderizador = new th.WebGLRenderer({ antialias: true, canvas });

renderizador.setSize(window.innerHeight, window.innerWidth);
document.body.appendChild(renderizador.domElement);

const camera = new th.PerspectiveCamera(
  100,
  window.innerHeight / window.innerWidth,
  0.1,
  1000
);

camera.position.z = 5;

const luz = new th.DirectionalLight(0xffffff, 1); //ambient light nao funciona
luz.position.set(2, 2, 5);
scene.add(luz);

const loader = new GLTFLoader();

function animate() {
  requestAnimationFrame(animate);
  loader.load(
    "fight_club_soap.glb",
    function (glb) {
      const modeloComEscala = glb.scene;
      modeloComEscala.scale.set(0.03, 0.03, 0.03);
      modeloComEscala.position.set(0, 2, 0);
      scene.add(modeloComEscala);
    },
    undefined,
    function (error) {
      console.error(error);
    }
  );
  renderizador.render(scene, camera);
}
animate();
