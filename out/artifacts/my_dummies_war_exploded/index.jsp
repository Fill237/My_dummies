<%@ page import="ru.appline.logic.Model"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <h1> Home page for working with users</h1>
  Enter ID user ( 0 - see all user)
  <br/>
  Available: <%
  Model model = Model.getInstance();
  out.print(model.getFromList().size());
  %>
  <form method="get" action="get">
    <label>ID:
    <input type="text" name="id"><br/>
    </label>
    <button type="submit">Search</button>
  </form>
  <a href="addUser.html">Create new user</a>
  </body>
</html>
