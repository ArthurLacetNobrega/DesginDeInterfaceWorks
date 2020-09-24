document.getElementById("ligar").innerHTML = "Ligar";
document.getElementById("desligar").innerHTML = "Desligar";

function ligar() {
  document.getElementById("lampada").src = "images/pic_bulbon.gif";
}

function desligar() {
  document.getElementById("lampada").src = "images/pic_bulboff.gif";
}

function soma(a, b) {
  console.log(a + b);
}
function divisao(a, b) {
  console.log(a - b);
}

function mult(a, b) {
  return a * b;
}

function sub(a, b) {
  return a - b;
}
