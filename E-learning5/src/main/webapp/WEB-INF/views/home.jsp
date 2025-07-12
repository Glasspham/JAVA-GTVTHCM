<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>User Management System</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/remixicon/4.6.0/remixicon.min.css" />
    <style>
      :where([class^="ri-"])::before {
          content: "\f3c2";
      }
      /* Simple CSS for layout and table */
      body {
          background: #f3f4f6;
          font-family: Arial, sans-serif;
      }
      .container {
          max-width: 900px;
          margin: 40px auto;
          background: #fff;
          border-radius: 8px;
          box-shadow: 0 2px 8px #0001;
          padding: 24px;
      }
      h1 {
          font-size: 2rem;
          color: #0284c7;
          margin-bottom: 16px;
      }
      table {
          width: 100%;
          border-collapse: collapse;
          margin-bottom: 24px;
      }
      th,
      td {
          padding: 12px 8px;
          border-bottom: 1px solid #e5e7eb;
          text-align: left;
      }
      th {
          background: #0284c7;
          color: #fff;
      }
      tr:hover {
          background: #f1f5f9;
      }
      .form-row {
          display: flex;
          align-items: center;
          margin-bottom: 12px;
      }
      .form-label {
          width: 100px;
          background: #f1f5f9;
          padding: 8px;
          color: #374151;
          border-radius: 4px;
      }
      .form-input {
          flex: 1;
          padding: 8px;
          border: 1px solid #d1d5db;
          border-radius: 4px;
          margin-left: 8px;
      }
      .btn {
          padding: 8px 20px;
          border: none;
          border-radius: 6px;
          color: #fff;
          font-weight: bold;
          margin-right: 8px;
          cursor: pointer;
      }
      .btn-add {
          background: #0284c7;
      }
      .btn-update {
          background: #f59e0b;
      }
      .btn-delete {
          background: #dc2626;
      }
      .btn:active {
          opacity: 0.8;
      }
      .radio-cell {
          text-align: center;
      }
      .radio-cell input[type="radio"] {
          accent-color: #0284c7;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <h1><i class="ri-user-settings-line"></i> Manage Users</h1>
      <table>
        <thead>
          <tr>
            <th>Choose</th>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Mark</th>
          </tr>
        </thead>
        <tbody>
          <c:if test="${not empty students}">
            <c:forEach items="${students}" var="student">
              <tr>
                <td class="radio-cell">
                  <input type="radio" name="user-select" />
                </td>
                <td>${student.id}</td>
                <td>${student.firstName}</td>
                <td>${student.lastName}</td>
                <td>${student.marks}</td>
              </tr>
            </c:forEach>
          </c:if>
        </tbody>
      </table>
      <form action="manageStudent" method="post">
        <div class="form-row">
          <div class="form-label">ID</div>
          <input type="text" name="txtID" id="txtID" class="form-input" placeholder="Enter ID" />
        </div>
        <div class="form-row">
          <div class="form-label">First Name</div>
          <input type="text" name="txtFirstName" id="txtFirstName" class="form-input" placeholder="Enter first name" />
        </div>
        <div class="form-row">
          <div class="form-label">Last Name</div>
          <input type="text" name="txtLastName" id="txtLastName" class="form-input" placeholder="Enter last name" />
        </div>
        <div class="form-row">
          <div class="form-label">Mark</div>
          <input type="text" name="txtMark" id="txtMark" class="form-input" placeholder="Enter mark" />
        </div>
        <div style="margin-top: 16px;">
          <button type="submit" name="btnManageStudent" value="add" class="btn btn-add"><i class="ri-add-line"></i> Add</button>
          <button type="submit" name="btnManageStudent" value="update" class="btn btn-update"><i class="ri-refresh-line"></i> Update</button>
          <button type="submit" name="btnManageStudent" value="delete" class="btn btn-delete"><i class="ri-delete-bin-line"></i> Delete</button>
        </div>
      </form>
    </div>
    <script>
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
    </script>
  </body>
</html>