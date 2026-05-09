const botao = document.getElementById("botao-home");
// pega o botão do HTML pelo id e guarda na variável

if (botao) {
    // garante que o botão existe antes de tentar usá-lo

    botao.addEventListener("click", function () {
        // detecta o clique no botão

        window.location.href = "/temperatura";
        // quando clicar, o navegador vai para a rota do Spring Boot

    });
}