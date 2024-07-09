<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.5.2/css/all.css" crossorigin="anonymous">
    <link rel="stylesheet" href="css/sidebar.css">
    <link rel="stylesheet" href="css/home.css">
    <title>Home</title>
</head>
<body>
<!-- Side Bar -->
<div class="sidebar">
    <div class="logo">
        <a href="Home.jsp" class="linkHome">
            <i class="fa-solid fa-shop icon"></i>
            <h2>Supermercado PCC</h2>
        </a>

    </div>
    <nav>
        <h5>Productos</h5>
        <a href="ListadoProductos.jsp">Listado de Productos</a>
        <a href="agregarProducto.jsp">Registrar Productos</a>
        <a href="EliminarProducto.jsp">Eliminar Producto</a>
        <h5>Estantes</h5>
        <a href="agregarEstantes.jsp">Agregar Estante</a>
        <h5>Bodega</h5>
        <a href="bodega.jsp">Bodega</a>
        <h5>Usuarios</h5>
        <a href="RegistrarUsuario.jsp">Registrar Usuario</a>
    </nav>
</div>
<!-- Formulario -->
<div class="form">
    <form action="" method="post">
            <div class="nombre">
                <label for="nombre">Nombre: </label>
                <input type="text" name="nombre" id="nombre" required>
            </div>

            <div class="tipoEstante">
                <label for="tipoEstante">Tipo de Estante:</label>
                <select name="tipoEstante" id="tipoEstante" required>
                    <option value="">Seleccione Tipo</option>
                    <option value="1">Congelados</option>
                    <option value="2">Fruta y Verdura</option>
                    <option value="3">Bebestible</option>
                    <option value="4">Alimento</option>
                    <option value="5">No alimento</option>
                </select>
            </div>

            <div class="volumenMax">
                <label for="volumenMax">Volumen Máximo: </label>
                <input type="text" name="volumenMax" id="volumenMax" required>
            </div>
    </form>
</div>
</body>
</html>