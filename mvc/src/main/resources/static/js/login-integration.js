document.addEventListener("DOMContentLoaded", function () {
  const passwordToggle = document.getElementById("passwordToggle");
  const passwordInput = document.getElementById("password");

  // Toggle password visibility
  if (passwordToggle) {
    passwordToggle.addEventListener("click", function () {
      const type =
        passwordInput.getAttribute("type") === "password" ? "text" : "password";
      passwordInput.setAttribute("type", type);
      this.querySelector("i").classList.toggle("fa-eye");
      this.querySelector("i").classList.toggle("fa-eye-slash");
    });
  }

  // Form validation
  const loginForm = document.querySelector("form");
  if (loginForm) {
    loginForm.addEventListener("submit", function (e) {
      const email = document.getElementById("email").value.trim();
      const password = document.getElementById("password").value.trim();

      if (!email || !password) {
        e.preventDefault();
        alert("Vui lòng nhập đầy đủ thông tin!");
        return false;
      }
    });
  }
});
