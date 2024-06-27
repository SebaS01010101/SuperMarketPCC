<%--
  Created by IntelliJ IDEA.
  User: vicen
  Date: 26-06-2024
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar Productos</title>
    <link rel="stylesheet" href="css/registrarProducto.css">
</head>
<body>
  <body>
    <div class="sidebar">
        <div class="logo">
            <h1>Registrar Productos</h1>
        </div>
        <nav>
            <a href="Home.jsp">Home</a>
            <a href="ListadoProductos.jsp">Listado de Productos</a>
            <a href="RegistrarProducto.jsp">Registrar Productos</a>
        </nav>
    </div>
  
  <form action="RegistrarProducto" method="post">
    <div class="grupo nombre">
      <label for="nombre">Nombre: </label>
      <input type="text" name="nombre" id="nombre" required>
    </div>
    <div class="grupo "></div>

  </form>
</body>
</html>
