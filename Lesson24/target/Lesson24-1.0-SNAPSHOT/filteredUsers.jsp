<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="filteredUsers" method="post">
    <br><br>
    <h1>Filter users</h1>
    <br><br>
    Prefix: <input name="prefix" />
    <input type="submit" value="Submit" />
</form>
</body>
</html>
