
<%@ page import="Servlet.SvProducto" %>
<%@ page import="supermarketpcc.logica.Producto" %>
<%@ page import="java.util.List" %>
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
            <a href="agregarProducto.jsp">Registrar Productos</a>
            <a href="RegistrarUsuario.jsp">Registrar Usuario</a>
            <a href="EliminarProducto.jsp">Eliminar Producto</a>
        </nav>
    </div>

    <div class="main-content">
        <h2>Listado de Productos</h2>
        <table>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Codigo de barra</th>
                <th>Volumen</th>
            </tr>
<%
        try {
            SvProducto sv = new SvProducto();
            List<Producto> productos = sv.obtenerProductos();
            for (Producto producto : productos) {
                 out.println("<tr>");
                out.println("<td>" + producto.getId() + "</td>");
                out.println("<td>" + producto.getNombre() + "</td>");
                out.println("<td>" + producto.getCodigoBarras() + "</td>");
                out.println("<td>" + producto.getVolumen() + "</td>");
                out.println("</tr>");
            }

        }catch (Exception e){
            out.println("Error: " + e.getMessage());
        }

    %>
        </table>
    </div>
</body>
</html>
