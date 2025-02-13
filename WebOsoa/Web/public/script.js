document.addEventListener("DOMContentLoaded", function () {
    const botoiak = document.querySelectorAll(".gehitu-saskira");

    botoiak.forEach(botoia => {
        botoia.addEventListener("click", function () {
           
            const izena = this.getAttribute("data-izena");
            const argazkia = this.getAttribute("data-argazkia");
            const prezioa = this.getAttribute("data-prezioa");

           
            let carrito = JSON.parse(sessionStorage.getItem("saskia")) || [];

            
            carrito.push({ Izena: izena, Argazkia_URL: argazkia, Prezioa: prezioa });

            
            sessionStorage.setItem("saskia", JSON.stringify(carrito));

            
            alert("Produktua saskira gehitu da!");

            
            const saskiaKopurua = document.getElementById("saskia-kopurua");
            saskiaKopurua.textContent = carrito.length;
        });
    });
});
