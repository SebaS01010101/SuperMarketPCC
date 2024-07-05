<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/register.css">
    <link rel="stylesheet" href="css/sidebar.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.5.2/css/all.css" crossorigin="anonymous">
    <title>Register</title>
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
            <a href="Register.jsp">Registrar Productos</a>
        </nav>
    </div>

<div class="container-form">
    <h2>Registro</h2>
    <form class="" action="" method="post">

        <div class="grupo nombre">
            <label for="nombre">Nombre: </label>
            <input type="text" name="nombre" id="nombre" required>
        </div>

        <div class="grupo usuario">
            <label for="usuario"> Usuario: </label>
            <input type="text" name="usuario" id="usuario" required>
        </div>

        <div class="grupo contraseña">
            <div class="flexbox">
                <label for="contrasena">Contraseña: </label>
                <input type="password" name="contrasena" id="contrasena" required>
            </div>

            <div class="flexbox">
                <label for="confirmarContrasena">Confirmar Contraseña: </label>
                <input type="password" name="confirmarContrasena" id="confirmarContrasena" required>
            </div>
        </div>

        <div class="grupo rol">
            <label for="rol">Rol: </label>
            <input type="text" name="rol" id="rol">
        </div>
        <input type="submit" value="Registrar">
    </form>

</div>
    <%
        if (request.getParameter("usuario") != null && request.getParameter("contrasena") != null && request.getParameter("confirmarContrasena") != null) {
            Connection connection;
            String host = "jdbc:mysql://localhost:3306/supermercado_inventario";
            String user = "root";
            String password = "";


            String inputNombre = request.getParameter("nombre");
            String inputUsuario = request.getParameter("usuario");
            String inputContrasena = request.getParameter("contrasena");
            String inputRol = request.getParameter("rol");

            try {
                PreparedStatement ps = null;
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(host, user, password);

                Statement s = connection.createStatement();
                request.setCharacterEncoding("UTF-8");

                String sql = "INSERT INTO `usuario`(`nombre`, `usuario`, `contrasenia`, `ID_rol`) VALUES ('"+inputNombre+"','"+inputUsuario+"','"+inputContrasena+"','"+inputRol+"')";
                ps = connection.prepareStatement(sql);
                ps.executeUpdate();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    %>

</body>
</html>
