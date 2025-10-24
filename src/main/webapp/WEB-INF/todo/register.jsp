<%--
  Created by IntelliJ IDEA.
  User: geuni
  Date: 25. 10. 23.
  Time: 오후 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Register</title>
</head>
<body>
<form action="/todo/register" method="post">
    <div>
        <label for="title"></label>
        <input type="text" name="title" id="title" placeholder="INSERT TITLE">
    </div>
    <div>
        <label for="dueDate"></label>
        <input type="date" name="dueDate" id="dueDate">
    </div>
    <div>
        <button type="submit">REGISTER</button>
        <button type="reset">RESET</button>
    </div>
</form>
</body>
</html>
