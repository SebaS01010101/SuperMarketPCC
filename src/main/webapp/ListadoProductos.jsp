
<%@ page import="java.sql.*" %>

<%@ page import="java.sql.ResultSet" %>
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
        <a href="RegistrarProducto.jsp">Registrar Productos</a>
    </nav>
</div>

<div class="main-content">
    <h1>Listado de Productos</h1>
    <%
        Connection connection;
        String host = "jdbc:mysql://localhost:3306/supermercado_inventario"; // Specify port if not default
        String user = "root";
        String password = "";

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(host, user, password);

            Statement s = connection.createStatement();
            request.setCharacterEncoding("UTF-8");

            String sql = "SELECT p.ID_producto, nombre, t.tipo, volumen, codigo_de_barras FROM producto p " +
                    "INNER JOIN tipo_producto a ON p.ID_producto = a.ID_producto " +
                    "INNER JOIN tipo t ON t.ID_tipo = a.ID_tipo ORDER BY ID_producto ASC;";
            ResultSet rs = s.executeQuery(sql);

            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<td>ID</td>");
            out.println("<td>Nombre</td>");
            out.println("<td>Tipo de producto</td>");
            out.println("<td>Volumen</td>");
            out.println("<td>Codigo de barras</td>");
            out.println("</tr>");

            while(rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("ID_producto") + "</td>");
                out.println("<td>" + rs.getString("nombre") + "</td>");
                out.println("<td>" + rs.getString("t.tipo") + "</td>");
                out.println("<td>" + rs.getDouble("volumen") + "</td>");
                out.println("<td>" + rs.getString("codigo_de_barras") + "</td>");

                out.println("</tr>");
            }

            out.println("</table>");

        } catch (ClassNotFoundException e) {
            out.println("Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            out.println("SQL error: " + e.getMessage());
        }
    %>
</div>
</body>
</html>
