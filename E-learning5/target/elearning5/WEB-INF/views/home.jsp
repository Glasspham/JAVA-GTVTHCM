<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div id="debug-info" style="margin-bottom: 20px; padding: 10px; border: 1px solid #ccc; background-color: #f9f9f9;">
    <h3>Debug Info:</h3>
    <p>Students list is empty: ${empty students}</p>
    <p>Students list size: ${fn:length(students)}</p>
    <c:if test="${not empty students}">
        <p>First student ID: ${students[0].id}</p>
        <p>First student Name: ${students[0].firstName} ${students[0].lastName}</p>
    </c:if>
</div>