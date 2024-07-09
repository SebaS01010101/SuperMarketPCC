<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.5.2/css/all.css" crossorigin="anonymous">
    <link rel="stylesheet" href="css/sidebar.css">
    <link rel="stylesheet" href="css/home.css">
    <title>Home</title>
</head>
<body>
    S
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
        <a href="agregarProductoAEstante.jsp">Agregar Producto a Estante</a>
        <a href="mostrarEstante.jsp">Mostrar Estante</a>
        <h5>Bodega</h5>
        <a href="bodega.jsp">Bodega</a>
        <h5>Usuarios</h5>
        <a href="RegistrarUsuario.jsp">Registrar Usuario</a>
    </nav>
</div>

<div class="main-content">
    <header>
        <h2>Bienvenido, "usuario"</h2>
        <a href="" class="logout-btn">
            <i class="fa-solid fa-door-closed"></i>
            Cerrar Sesión</a>
    </header>
    </section>
</div>

</body>
</html>
