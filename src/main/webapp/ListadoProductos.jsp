<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/listadoProductos.css">
    <title>Listado de Productos</title>
</head>
<body>
    <div class="sidebar">
        <div class="logo">
            <h2>Supermercado PCC</h2>
        </div>
        <nav>
            <a href="Home.jsp">Home</a>
            <a href="ListadoProductos.jsp">Listado de Productos</a>
            <a href="registrar_producto.jsp">Registrar Productos</a>
        </nav>
    </div>

    <div class="main-content">
        <h1>Listado de Productos</h1>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Precio</th>
                <th>Cantidad</th>
            </tr>
            </thead>
            <%-- --%>
            <tbody>

                <tr>
                    <td></td>
                    <td></td>
                    <td>Arroz blanco</td>
                    <td>2.50</td>
                    <td>100</td>
                </tr>

            </tbody>
        </table>
    </div>
</body>
</html>
