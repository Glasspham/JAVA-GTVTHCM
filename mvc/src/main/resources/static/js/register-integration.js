document.addEventListener("DOMContentLoaded", function () {
  const firstNameInput = document.getElementById("firstName");
  const lastNameInput = document.getElementById("lastName");
  const fullNameHidden = document.getElementById("fullNameHidden");
  const passwordToggle = document.getElementById("passwordToggle");
  const confirmPasswordToggle = document.getElementById(
    "confirmPasswordToggle"
  );
  const passwordInput = document.getElementById("password");
  const confirmPasswordInput = document.getElementById("confirmPassword");
  const emailInput = document.getElementById("email");

  // Gộp họ và tên thành fullName
  function updateFullName() {
    const firstName = firstNameInput.value.trim();
    const lastName = lastNameInput.value.trim();
    fullNameHidden.value = `${firstName} ${lastName}`.trim();
  }

  firstNameInput.addEventListener("input", updateFullName);
  lastNameInput.addEventListener("input", updateFullName);

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

  if (confirmPasswordToggle) {
    confirmPasswordToggle.addEventListener("click", function () {
      const type =
        confirmPasswordInput.getAttribute("type") === "password"
          ? "text"
          : "password";
      confirmPasswordInput.setAttribute("type", type);
      this.querySelector("i").classList.toggle("fa-eye");
      this.querySelector("i").classList.toggle("fa-eye-slash");
    });
  }

  // Kiểm tra email đã tồn tại
  if (emailInput) {
    emailInput.addEventListener("blur", function () {
      const email = this.value.trim();
      if (email) {
        fetch("/auth/check-email", {
          method: "POST",
          headers: {
            "Content-Type": "application/x-www-form-urlencoded",
          },
          body: "email=" + encodeURIComponent(email),
        })
          .then((response) => response.json())
          .then((exists) => {
            if (exists) {
              showError(emailInput, "Email này đã được sử dụng!");
            } else {
              clearError(emailInput);
            }
          })
          .catch((error) => {
            console.error("Error checking email:", error);
          });
      }
    });
  }

  function showError(input, message) {
    const errorElement = input.parentNode.querySelector(".error-message");
    if (errorElement) {
      errorElement.textContent = message;
      errorElement.style.display = "block";
    }
    input.classList.add("error");
  }

  function clearError(input) {
    const errorElement = input.parentNode.querySelector(".error-message");
    if (errorElement) {
      errorElement.style.display = "none";
    }
    input.classList.remove("error");
  }
});
