<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Device List</title>
    <link rel="stylesheet" href="../css/devices.css">
</head>
<body>
    <h1>Device List</h1>
            <p>${listSize}</p>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Type</th>
        </tr>
        <c:forEach items="${devicesAttribute}" var="device">
            <tr>
                <td>${device.brand}</td>
                <td>${device.model}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
