<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.5.2/css/all.css" crossorigin="anonymous">
    <link rel="stylesheet" href="css/sidebar.css">
    <link rel="stylesheet" href="css/eliminarProducto.css">
    <title>Home</title>
</head>
<body>
<div class="sidebar">
    <div class="logo">
        <a href="Home.jsp" class="linkHome">
            <i class="fa-solid fa-shop icon"></i>
            <h2>Supermercado PCC</h2>
        </a>

    </div>
    <nav>
        <a href="ListadoProductos.jsp">Listado de Productos</a>
        <a href="MenuRegistrarProducto.jsp">Registrar Productos</a>
        <a href="RegistrarUsuario.jsp">Registrar Usuario</a>
        <a href="EliminarProducto.jsp">Eliminar Producto</a>
    </nav>
</div>
<div class="container">

    <div class="form">
        <h3>Eliminar por id</h3>
        <form action="EliminarProducto" method="post">
            <label for="id">Id:</label>
            <input type="text" id="id" name="id" required>
            <input type="submit" value="Eliminar">
    </div>

    <div class="form">
        <h3>Eliminar por nombre</h3>
        <form action="EliminarProducto" method="post">
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" required>
            <input type="submit" value="Eliminar">
    </div>
    <div class="form">
        <h3>Eliminar por codigo de barras</h3>
        <form action="EliminarProducto" method="post">
            <label for="codigo">Codigo de barras:</label>
            <input type="text" id="codigo" name="codigo" required>
            <input type="submit" value="Eliminar">
    </div>

</div>




</body>
</html>
