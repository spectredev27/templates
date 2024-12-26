<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
    <head>
        <title>Java in Static Page Example</title>
        <link rel="stylesheet" href="../css/style.css">
    </head>
    <body>
	    <%
	        String greetings = "Rendered by JSP";
        %>
        <p class="bluetext"><%= greetings %></p>
    </body>
</html>
