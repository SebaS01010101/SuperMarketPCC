<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.5.2/css/all.css" crossorigin="anonymous">
    <title>Login</title>
</head>
<body>
    <div class="logo">
        <i class="fa-solid fa-shop icon"></i>
        <h1>Supermercado PCC</h1>
    </div>
    

<div class="container-form">
    <h2>Login</h2>
    
    <form class="formulario" action="" method="post">
        <div class="grupo">
            <label for="usuario">Usuario:</label>
            <input type="text" name="usuario" id="usuario" required>
        </div>

        <div class="grupo">
            <label for="contrasena">Contraseña:</label>
            <input type="password" name="contrasena" id="contrasena" required>
        </div>

        <input type="submit" value="Ingresar">
    </form>
</div>

<%
    if (request.getParameter("usuario") != null && request.getParameter("contrasena") != null) {
        Connection connection;
        String host = "jdbc:mysql://localhost:3306/supermercado_inventario";
        String user = "root";
        String password = "";


        String inputNombre = request.getParameter("usuario");
        String inputContrasena = request.getParameter("contrasena");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(host, user, password);

            Statement s = connection.createStatement();
            request.setCharacterEncoding("UTF-8");

            String sql = "SELECT usuario, contrasenia FROM usuario where usuario ='" + inputNombre + "'and contrasenia ='" + inputContrasena + "';";
            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                response.sendRedirect("Home.jsp");
            } else {
                out.println("<div style='color:red; text-align:center; margin-top:20px;'>Usuario o contraseña incorrectos.</div>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

%>

</body>
</html>
