document.addEventListener("DOMContentLoaded", function () {
    const radioButtons = document.querySelectorAll('input[name="user-select"]');
    const rows = document.querySelectorAll("tbody tr");

    rows.forEach((row, index) => {
        row.addEventListener("click", function () {
        radioButtons[index].checked = true;

        // Get the data from the selected row
        const cells = row.querySelectorAll("td");
        const id = cells[1].textContent;
        const firstName = cells[2].textContent;
        const lastName = cells[3].textContent;
        const mark = cells[4].textContent;

        // Fill the form with the selected data
        const inputs = document.querySelectorAll('input[type="text"]');
        inputs[0].value = id;
        inputs[1].value = firstName;
        inputs[2].value = lastName;
        inputs[3].value = mark;
        });
    });
});

document.addEventListener("DOMContentLoaded", function () {
    const addButton = document.querySelector(".bg-primary");
    const updateButton = document.querySelector(".bg-secondary");
    const deleteButton = document.querySelector(".bg-danger");
    const inputs = document.querySelectorAll('input[type="text"]');
    const tbody = document.querySelector("tbody");
    const radioButtons = document.querySelectorAll('input[name="user-select"]');

    // Add new user
    addButton.addEventListener("click", function () {
        const id = inputs[0].value;
        const firstName = inputs[1].value;
        const lastName = inputs[2].value;
        const mark = inputs[3].value;

        if (id && firstName && lastName && mark) {
        const newRow = document.createElement("tr");
        newRow.className = "border-b hover:bg-gray-50";

        newRow.innerHTML = `
                            <td class="py-3 px-4">
                                <div class="flex items-center justify-center">
                                    <label class="inline-flex items-center">
                                        <input type="radio" name="user-select" class="hidden peer">
                                        <span class="w-5 h-5 border border-gray-300 rounded-full flex items-center justify-center peer-checked:border-primary peer-checked:border-2">
                                            <span class="w-3 h-3 rounded-full bg-primary opacity-0 peer-checked:opacity-100"></span>
                                        </span>
                                    </label>
                                </div>
                            </td>
                            <td class="py-3 px-4">${id}</td>
                            <td class="py-3 px-4">${firstName}</td>
                            <td class="py-3 px-4">${lastName}</td>
                            <td class="py-3 px-4">${mark}</td>
                        `;

        tbody.appendChild(newRow);

        // Clear form
        inputs.forEach((input) => (input.value = ""));

        // Add event listener to the new row
        const newRadioButton = newRow.querySelector('input[name="user-select"]');
        newRow.addEventListener("click", function () {
            newRadioButton.checked = true;

            const cells = newRow.querySelectorAll("td");
            inputs[0].value = cells[1].textContent;
            inputs[1].value = cells[2].textContent;
            inputs[2].value = cells[3].textContent;
            inputs[3].value = cells[4].textContent;
        });
        }
    });

    // Update selected user
    updateButton.addEventListener("click", function () {
        const selectedRadio = Array.from(radioButtons).find(
        (radio) => radio.checked,
        );

        if (selectedRadio) {
        const row = selectedRadio.closest("tr");
        const cells = row.querySelectorAll("td");

        cells[1].textContent = inputs[0].value;
        cells[2].textContent = inputs[1].value;
        cells[3].textContent = inputs[2].value;
        cells[4].textContent = inputs[3].value;
        }
    });

    // Delete selected user
    deleteButton.addEventListener("click", function () {
        const selectedRadio = Array.from(radioButtons).find(
        (radio) => radio.checked,
        );

        if (selectedRadio) {
        const row = selectedRadio.closest("tr");
        row.remove();

        // Clear form
        inputs.forEach((input) => (input.value = ""));
        }
    });
});