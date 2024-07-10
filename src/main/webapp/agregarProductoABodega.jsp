<%@ page import="supermarketpcc.logica.Sistema" %>
<%@ page import="supermarketpcc.logica.Producto" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.File" %>
<%@ page import="supermarketpcc.logica.Bodega" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.5.2/css/all.css" crossorigin="anonymous">
    <link rel="stylesheet" href="css/sidebar.css">
    <link rel="stylesheet" href="css/agregarProductosA.css">
    <title></title>
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
            <a href="agregarProductoAEstante.jsp">Agregar Producto a Estante</a>
            <a href="mostrarEstante.jsp">Mostrar Estante</a>
            <h5>Bodega</h5>
            <a href="agregarProductoABodega.jsp">Agregar Producto a Bodega</a>
            <a href="mostrarBodega.jsp">Mostrar Bodega</a>
            <h5>Usuarios</h5>
            <a href="RegistrarUsuario.jsp">Registrar Usuario</a>
        </nav>
    </div>

    <div class="form">
        <h2>Agregar Producto A Bodega</h2>
        <form action="" method="post">

            <div class="productoIngresado">
                <label for="idProducto">ID Producto</label>
                <input type="text" name="idProducto" id="idProducto" required>
            </div>

            <input type="submit" value="Agregar">

        </form>
    </div>
        <!-- Codigo java llamado al formulario y serializa listado de estantes -->

    <%
        if (request.getParameter("idProducto") != null) {
            int idProducto = Integer.parseInt(request.getParameter("idProducto"));
            Sistema sistema = new Sistema();
            Bodega bodega = sistema.deserializableBodega();
            sistema.cargarProductoBodega(idProducto);
            sistema.serializableBodega(bodega);
        }
    %>

    </div>

</body>
</html>
