document.addEventListener("DOMContentLoaded", () => {
    // 1. Obtener el usuario logueado desde Spring Security mapeado en el HTML
    const userHolder = document.getElementById("username-holder");
    const username = userHolder ? userHolder.getAttribute("data-username") : "invitado";

    // Generamos una llave única para este usuario en el almacenamiento del navegador
    const CART_KEY = `elsurco_cart_${username}`;

    // Actualizar el título de la página
    document.getElementById("cart-user-title").textContent = username;

    // Elementos del DOM
    const emptyView = document.getElementById("empty-cart-view");
    const fullView = document.getElementById("full-cart-view");
    const itemsContainer = document.getElementById("cart-items-container");
    const summaryCount = document.getElementById("summary-count");
    const summaryTotal = document.getElementById("summary-total");

    // 2. Cargar el carrito del usuario desde localStorage
    let cart = JSON.parse(localStorage.getItem(CART_KEY)) || [];

    function renderCart() {
        if (cart.length === 0) {
            emptyView.classList.remove("d-none");
            fullView.classList.add("d-none");
            return;
        }

        emptyView.classList.add("d-none");
        fullView.classList.remove("d-none");
        itemsContainer.innerHTML = ""; // Limpiar vista previa

        let totalCartPrice = 0;

        cart.forEach(item => {
            const itemSubtotal = item.price * item.quantity;
            totalCartPrice += itemSubtotal;

            const itemRow = document.createElement("div");
            itemRow.className = "cart-item-row";
            itemRow.innerHTML = `
                <div class="item-image-wrapper">
                    <img src="${item.image || 'https://images.unsplash.com/photo-1542838132-92c53300491e?auto=format&fit=crop&w=150&q=80'}" alt="${item.name}">
                </div>

                <div class="item-details">
                    <h3 class="item-title">${item.name}</h3>
                    <p class="item-description">${item.description || 'Fresco de temporada'}</p>
                </div>

                <div class="item-quantity-actions">
                    <div class="d-flex align-items-center gap-2">
                        <input type="number" class="form-control quantity-input"
                               value="${item.quantity}" min="1" data-id="${item.id}">
                    </div>
                </div>

                <div class="item-pricing">
                    <span class="item-price-unit">Q${item.price.toFixed(2)} c/u</span>
                    <span class="item-price-subtotal">Q${itemSubtotal.toFixed(2)}</span>
                </div>

                <div class="item-remove-action">
                    <button class="btn-remove-item" data-id="${item.id}">×</button>
                </div>
            `;

            itemsContainer.appendChild(itemRow);
        });

        // Actualizar valores del panel de resumen
        summaryCount.textContent = cart.length;
        summaryTotal.textContent = `Q${totalCartPrice.toFixed(2)}`;

        // Enganchar eventos a los nuevos botones dinámicos
        setupEventListeners();
    }

    function setupEventListeners() {
        // Escuchar cambios en los inputs de cantidad
        document.querySelectorAll(".quantity-input").forEach(input => {
            input.addEventListener("change", (e) => {
                const productId = e.target.getAttribute("data-id");
                const newQty = parseInt(e.target.value);

                if (newQty >= 1) {
                    const product = cart.find(item => item.id == productId);
                    if (product) {
                        product.quantity = newQty;
                        saveCart();
                        renderCart();
                    }
                }
            });
        });

        // Escuchar clics en los botones de remover ítem
        document.querySelectorAll(".btn-remove-item").forEach(button => {
            button.addEventListener("click", (e) => {
                const productId = e.target.getAttribute("data-id");
                cart = cart.filter(item => item.id != productId);
                saveCart();
                renderCart();
            });
        });
    }

    function saveCart() {
        localStorage.setItem(CART_KEY, JSON.stringify(cart));
    }

    // Inicializar la renderización al cargar la página
    renderCart();
});