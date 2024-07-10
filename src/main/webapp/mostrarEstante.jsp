<%@ page import="java.util.List" %>
<%@ page import="supermarketpcc.logica.*" %>
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
        <a href="agregarProductoABodega.jsp">Agregar Producto a Bodega</a>
        <a href="mostrarBodega.jsp">Mostrar Bodega</a>
        <h5>Usuarios</h5>
        <a href="RegistrarUsuario.jsp">Registrar Usuario</a>
    </nav>
</div>

<!-- Codigo java que genera los estantes de forma separada y ordenada -->
<div class="content">
    <%
        Sistema sistema = new Sistema();
        List<Estante> estantes = sistema.deserializableEstantes();
        if (estantes != null && !estantes.isEmpty()) {
            for (Estante estante : estantes) {
                estante.ordenar();
                out.println("<h2>Estante: " + estante.getNombre() + " - " + estante.getTipo() + "</h2>");
                List<Producto> productos = estante.getProductos();
                if (productos != null && !productos.isEmpty()) {
                    out.println("<table>");
                    out.println("<tr><th>ID</th><th>Nombre</th><th>Código de Barras</th>");

                    switch (estante.getTipo().toLowerCase()) {
                        case "congelados":
                            out.println("<th>Temperatura</th>");
                            break;
                        case "bebestibles":
                            out.println("<th>Tipo de Bebestible</th>");
                            break;
                        case "no alimento":
                            out.println("<th>Descripción</th>");
                            break;
                        case "frutas y verduras":
                            out.println("<th>Fecha de Ingreso</th><th>Fecha de Caducidad</th>");
                            break;
                    }
                    out.println("</tr>");

                    for (Producto producto : productos) {
                        out.println("<tr><td>" + producto.getId() + "</td><td>" + producto.getNombre() + "</td><td>" + producto.getCodigoBarras() + "</td>");

                        if (producto instanceof Congelado) {
                            out.println("<td>" + ((Congelado)producto).getTemperatura() + "°C</td>");
                        } else if (producto instanceof Bebestible) {
                            out.println("<td>" + ((Bebestible) producto).getTipo()+ "</td>");
                        } else if (producto instanceof NoAlimento) {
                            out.println("<td>" + ((NoAlimento)producto).getDescripcion() + "</td>");
                        } else if (producto instanceof FrutaVerdura) {
                            FrutaVerdura fv = (FrutaVerdura) producto;
                            out.println("<td>" + fv.getFechaIngreso() + "</td><td>" + fv.getFechaCaducidad() + "</td>");
                        }
                        out.println("</tr>");
                    }
                    out.println("</table>");
                } else {
                    out.println("<p>No hay productos en este estante.</p>");
                }
            }
        } else {
            out.println("<p>No hay estantes disponibles.</p>");
        }
    %>

</div>

</body>
</html>
