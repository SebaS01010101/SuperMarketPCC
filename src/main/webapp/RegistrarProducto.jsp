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
    <link rel="stylesheet" href="css/sidebar.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.5.2/css/all.css" crossorigin="anonymous">

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
  
    <div class="main-content">
      <h1>Registrar Producto</h1>
      <form action="registrarProducto">
        <div class="form-grupo">
          <label for="nombre">Nombre:</label>
          <input type="text" name="nombre" id="nombre" required>
        </div>
        <div class="form-grupo">
          <label for="codigoDeBarras">Codigo de barras</label>
          <input type="text" name="codigoDeBarras" id="codigoDeBarras" required>
        </div>
        <div class="form-grupo">
          <label for="volumen">volumnen</label>
          <input type="text" name="volumen" id="volumen" required>
        </div>
        <div class="form-grupo">
          
        </div>

        <input type="submit" value="Registrar">
      </form>
    </div>
    
  </body>
</html>
