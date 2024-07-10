<%@ page import="supermarketpcc.logica.Sistema" %>
<%@ page import="supermarketpcc.logica.Producto" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.File" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.5.2/css/all.css" crossorigin="anonymous">
    <link rel="stylesheet" href="css/sidebar.css">
    <link rel="stylesheet" href="css/Listados.css">
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
            <a href="agregarProductoAEstante.jsp">Agregar Producto a Estante</a>
            <a href="mostrarEstante.jsp">Mostrar Estante</a>
            <h5>Bodega</h5>
            <a href="bodega.jsp">Bodega</a>
            <h5>Usuarios</h5>
            <a href="RegistrarUsuario.jsp">Registrar Usuario</a>
        </nav>
    </div>

    <div class="content">
        <h2>Bodega</h2>
    <%
        File archivo = new File("bodega.json");
        Sistema sistema = new Sistema();
        List<Producto> productos;
        if (archivo.exists()){
             productos = sistema.deserializableBodega().getProductos();
        }else {
            sistema.serializableBodega();
            productos = sistema.deserializableBodega().getProductos();
        }

        if (productos != null && !productos.isEmpty()) {
            out.println("<table>");
            out.println("<tr><th>Nombre</th><th>Stock</th></tr>");
            for (Producto producto : productos) {
                out.println("<tr>");
                out.println("<td>" + producto.getNombre() + "</td>");
               // out.println("<td>" + producto.getStock() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } else {
            out.println("<p>No hay productos en la bodega.</p>");
        }
    %>

    </div>

</body>
</html>
