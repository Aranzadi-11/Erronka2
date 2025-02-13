document.addEventListener("DOMContentLoaded", function () {
    const botoiak = document.querySelectorAll(".gehitu-saskira");

    botoiak.forEach(botoia => {
        botoia.addEventListener("click", function () {
            // Corregir el acceso a los atributos data- (en minúsculas)
            const izena = this.getAttribute("data-izena");
            const argazkia = this.getAttribute("data-argazkia");
            const prezioa = this.getAttribute("data-prezioa");

            // Obtener el carrito actual o inicializarlo como un arreglo vacío
            let carrito = JSON.parse(sessionStorage.getItem("saskia")) || [];

            // Añadir el producto al carrito
            carrito.push({ Izena: izena, Argazkia_URL: argazkia, Prezioa: prezioa });

            // Guardar el carrito actualizado en sessionStorage
            sessionStorage.setItem("saskia", JSON.stringify(carrito));

            // Mostrar mensaje de éxito
            alert("Produktua saskira gehitu da!");

            // Actualizar el número de productos en el carrito
            const saskiaKopurua = document.getElementById("saskia-kopurua");
            saskiaKopurua.textContent = carrito.length;
        });
    });
});
