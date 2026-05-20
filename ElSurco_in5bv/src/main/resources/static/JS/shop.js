// ===================================================
// 1. CONTROL DEL SIDEBAR
// ===================================================
document.addEventListener("DOMContentLoaded", () => {
    const toggleBtn = document.getElementById("categories-toggle-btn");
    const sidebar = document.getElementById("shop-sidebar");

    if (toggleBtn && sidebar) {
        toggleBtn.addEventListener("click", () => {
            sidebar.classList.toggle("collapsed");
        });
    } else {
        console.warn("Sidebar no encontrado.");
    }
});

// Función para actualizar el DOM del contador
function actualizarInterfazCarrito() {
    // 1. Conseguir el usuario correcto desde tu span oculto
    const userHolder = document.getElementById("username-holder");
    const username = userHolder ? userHolder.getAttribute("data-username") : "invitado";

    // 2. Armar la llave dinámica
    const cartKey = `elsurco_cart_${username}`;
    const carrito = JSON.parse(localStorage.getItem(cartKey)) || [];

    // 3. Calcular el total de cantidades
    const totalArticulos = carrito.reduce((sum, item) => sum + item.cantidad, 0);

    // 4. Modificar el span del HTML
    const contadorSpan = document.getElementById("contador-carrito");
    if (contadorSpan) {
        contadorSpan.textContent = totalArticulos;

        // Si el carrito no está vacío lo muestra, si está vacío se oculta de forma premium
        if (totalArticulos > 0) {
            contadorSpan.style.display = "inline-block";
        } else {
            contadorSpan.style.display = "none";
        }
    }
}

// Ejecutar automáticamente al cargar la tienda para pintar el estado guardado
document.addEventListener("DOMContentLoaded", function() {
    actualizarInterfazCarrito();
});

// ===================================================
// 2. FUNCIÓN MEDIADORA (Conecta el HTML con la lógica)
// ===================================================
function capturarYAgregar(boton) {
    // Leemos el usuario
    const username = document.getElementById("username-holder")?.getAttribute("data-username") || "invitado";

    // 🛡️ Validación de seguridad
    if (username === "invitado" || username === "anonymousUser" || username.trim() === "") {
        alert("¡Hola! Para añadir productos a tu canasta en El Surco, inicia sesión primero. 👨‍🌾");
        window.location.href = "/login";
        return;
    }

    // Capturamos los datos del botón
    const id = boton.getAttribute("data-id");
    const name = boton.getAttribute("data-name");
    const desc = boton.getAttribute("data-description");
    const price = boton.getAttribute("data-price");
    const img = 'https://images.unsplash.com/photo-1542838132-92c53300491e?auto=format&fit=crop&w=300&q=80';
    actualizarInterfazCarrito()
    agregarAlCarrito(id, name, desc, price, img);
}

// ===================================================
// 3. MOTOR DE ALMACENAMIENTO
// ===================================================
function agregarAlCarrito(idProducto, nombre, descripcion, precio, imagen) {
    const username = document.getElementById("username-holder")?.getAttribute("data-username") || "invitado";
    const CART_KEY = `elsurco_cart_${username}`;

    let cart = JSON.parse(localStorage.getItem(CART_KEY)) || [];

    const existe = cart.find(item => item.id == idProducto);

    if (existe) {
        existe.quantity += 1;
    } else {
        cart.push({
            id: idProducto,
            name: nombre,
            description: descripcion,
            price: parseFloat(precio),
            image: imagen,
            quantity: 1
        });
    }

    localStorage.setItem(CART_KEY, JSON.stringify(cart));
    alert(`¡${nombre} añadido a tu canasta de El Surco! 🌾`);
}

