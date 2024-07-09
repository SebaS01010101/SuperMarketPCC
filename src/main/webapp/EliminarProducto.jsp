<%@ page import="supermarketpcc.logica.DeleteProduct" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.5.2/css/all.css" crossorigin="anonymous">
    <link rel="stylesheet" href="css/sidebar.css">
    <link rel="stylesheet" href="css/eliminarProducto.css">
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

<!-- Formularios para borrar productos -->
<div class="container">

    <div class="form">
        <h3>Eliminar por id</h3>
        <form action="" method="post">
            <label for="id">Id:</label>
            <input type="text" id="id" name="id" required>
            <input type="submit" value="Eliminar">
        </form>
    </div>
    <%
        DeleteProduct deleteProduct = new DeleteProduct();
        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            deleteProduct.eliminarPorID(id);
        }
    %>

    <div class="form">
        <h3>Eliminar por nombre</h3>
        <form action="" method="post">
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" required>
            <input type="submit" value="Eliminar">
        </form>
    </div>
    <%
        if (request.getParameter("nombre") != null) {
            String nombre = request.getParameter("nombre");
            deleteProduct.eliminarPorNombre(nombre);
        }
    %>

    <div class="form">
        <h3>Eliminar por codigo de barras</h3>
        <form action="" method="post">
            <label for="codigo">Codigo de barras:</label>
            <input type="text" id="codigo" name="codigo" required>
            <input type="submit" value="Eliminar">
        </form>
    </div>
    <%
        if (request.getParameter("codigo") != null) {
            String codigo = request.getParameter("codigo");
            deleteProduct.eliminarTodoProducto(codigo);
        }

    %>


</div>



</body>
</html>
