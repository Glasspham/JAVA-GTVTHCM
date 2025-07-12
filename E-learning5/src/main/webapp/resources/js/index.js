document.addEventListener("DOMContentLoaded", function () {
    const idInput = document.getElementById("txtID");
    const firstNameInput = document.getElementById("txtFirstName");
    const lastNameInput = document.getElementById("txtLastName");
    const markInput = document.getElementById("txtMark");
    let lastSelectedRadio = null;
    document.querySelectorAll('input[name="user-select"]').forEach(function (radio) {
        radio.addEventListener("click", function (e) {
            if (lastSelectedRadio === radio) {
                idInput.value = "";
                firstNameInput.value = "";
                lastNameInput.value = "";
                markInput.value = "";
                radio.checked = false;
                lastSelectedRadio = null;
                e.stopPropagation();
                return;
            }
            const row = radio.closest("tr");
            const cells = row.querySelectorAll("td");
            idInput.value = cells[1].textContent.trim();
            firstNameInput.value = cells[2].textContent.trim();
            lastNameInput.value = cells[3].textContent.trim();
            markInput.value = cells[4].textContent.trim();
            lastSelectedRadio = radio;
            e.stopPropagation();
        });
    });
});
