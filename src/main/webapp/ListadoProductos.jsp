<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="supermarketpcc.logica.Producto" %>
<%@ page import="supermarketpcc.logica.ConexionSQL" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/listadoProductos.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css" crossorigin="anonymous">
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
            <a href="RegistrarProducto.jsp">Registrar Productos</a>
        </nav>
    </div>

    <div class="main-content">
        <h1>Listado de Productos</h1>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Codigo</th>
                <th>Volumen</th>
                <th>Accion</th>
            </tr>
            </thead>
            <%
                ConexionSQL conexionSQL = new ConexionSQL();
                conexionSQL.conexionBD();
                List<Producto> productos = conexionSQL.obtenerProducto();
            %>
            <tbody>
            <% for(Producto producto : productos){%>
                <tr>
                    <td><%= producto.getId() %></td>
                    <td><%= producto.getNombre() %></td>
                    <td><%= producto.getCodigoBarras() %></td>
                    <td><%= producto.getVolumen() %></td>
                    <td style="display: flex; width: 230px;">
                        <form name="eliminar" action="EliminarProducto" method="post">
                            <button type="submit" class="" style="background-color: red;margin-right: 5px;">
                                <i class="fas fa-info-circle"></i> Eliminar
                            </button>
                            <input type="hidden" name="id" value="">
                        </form>
                        <form name="editar" action="EditarProducto" method="post">
                            <button type="submit" class="" style="background-color: green;">
                                <i></i> Editar
                            </button>
                            <input type="hidden" name="id" value="">
                        </form>
                    </td>
                </tr>
            <%
                    }
            %>
            </tbody>
        </table>
    </div>
</body>
</html>
