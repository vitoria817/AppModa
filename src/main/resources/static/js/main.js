
const botaoHome = document.getElementById("botao-home");

if (botaoHome) {
    botaoHome.addEventListener("click", function () {
        window.location.href = "/temperatura";
    });
}

const botaoTemperatura = document.getElementById("botaoTemperatura");

if (botaoTemperatura) {
    botaoTemperatura.addEventListener("click", function () {
        window.location.href = "/guarda-roupa";
    });
}