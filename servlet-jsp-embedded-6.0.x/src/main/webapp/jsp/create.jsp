<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Device List</title>
    <link rel="stylesheet" href="../css/devicespost.css">
</head>
<body>
    <h2>Add new device</h2>
    <form action="/devices" method="POST">
        <label>First Name</label>
        <input type="text" name="firstName">
        <br>

        <% if (request.getAttribute("isFirstNameValid") != null && request.getAttribute("isFirstNameValid").equals("false")) { %>
            <p class="error-message">Please provide first name.</p>
        <% } %>

        <label>Last Name</label>
        <input type="text" name="lastName">
        <br>

        <% if (request.getAttribute("isLastNameValid") != null && request.getAttribute("isLastNameValid").equals("false")) { %>
            <p class="error-message">Please provide last name.</p>
        <% } %>

        <button type="submit" value="Submit">Add new device</button>
    </form>

    <% if (request.getAttribute("isFormValid") != null && request.getAttribute("isFormValid").equals("true")) { %>
        <p class="success-message">Success</p>
    <% } %>
</body>
</html>
