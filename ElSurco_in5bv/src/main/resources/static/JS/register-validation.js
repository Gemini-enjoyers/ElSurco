document.addEventListener("DOMContentLoaded", function() {
    const password = document.getElementById("userPassword");
    const confirm = document.getElementById("confirmPassword");
    const form = document.getElementById("registerForm");

    function validatePassword() {
        if (password.value !== confirm.value) {
            confirm.setCustomValidity("Las contraseñas no coinciden");
        } else {
            confirm.setCustomValidity("");
        }
    }

    // Se ejecuta cada vez que el usuario escribe en los campos
    password.addEventListener("change", validatePassword);
    confirm.addEventListener("keyup", validatePassword);
});