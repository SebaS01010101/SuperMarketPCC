
<%@ page import="java.sql.*" %>

<%@ page import="java.sql.ResultSet" %>
<%@ page import="supermarketpcc.logica.Alimento" %>
<%@ page import="java.util.List" %>
<%@ page import="supermarketpcc.logica.Producto" %>
<%@ page import="Servlets.SvProducto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/listadoProductos.css">
    <link rel="stylesheet" href="css/sidebar.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.5.2/css/all.css" crossorigin="anonymous">
    <title>Listado de Productos</title>
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


    <div class="main-content">
        <h2>Listado de Productos</h2>

        <%
        try {
            SvProducto productoService = new SvProducto();
            List<Producto> productos = productoService.obtenerProductos();

            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<td>ID</td>");
            out.println("<td>Nombre</td>");
            out.println("<td>Volumen</td>");
            out.println("<td>Codigo de barras</td>");
            out.println("</tr>");

            for (Producto producto : productos) {
                out.println("<tr>");
                out.println("<td>" + producto.getId() + "</td>");
                out.println("<td>" + producto.getNombre() + "</td>");
                out.println("<td>" + producto.getVolumen() + "</td>");
                out.println("<td>" + producto.getCodigoBarras() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");

        } catch (Exception e) {
            out.println("SQL error: " + e.getMessage());
        }
    %>
    </div>
</body>
</html>
