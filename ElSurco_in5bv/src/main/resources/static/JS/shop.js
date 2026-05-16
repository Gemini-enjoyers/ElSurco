document.addEventListener("DOMContentLoaded", () => {
    const toggleBtn = document.getElementById("categories-toggle-btn");
    const sidebar = document.getElementById("shop-sidebar");

    // Verificamos que ambos elementos existan en la página antes de agregar el evento
    if (toggleBtn && sidebar) {
        toggleBtn.addEventListener("click", () => {
            sidebar.classList.toggle("collapsed");
        });
    } else {
        console.warn("No se encontraron los elementos '#categories-toggle-btn' o '#shop-sidebar' en el DOM.");
    }
});