<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Random" %>
<!DOCTYPE html>
    <head>
        <title>Java in Static Page Example</title>
    </head>
    <body>
        <h1>Java in Static Page Example</h1>
	    <%
            String[] arr = {"What's up?", "Hello", "It's a nice day today!"};
            int randomIndex = new Random().nextInt(arr.length);
	        String greetings = arr[randomIndex];
        %>
        <p><%= greetings %></p>
        <a href="jsp/java.jsp" target="_blank">Java</a>
        <a href="/devices" target="_blank">Devices</a>
        <a href="jsp/create.jsp" target="_blank">Add new device</a>
    </body>
</html>
