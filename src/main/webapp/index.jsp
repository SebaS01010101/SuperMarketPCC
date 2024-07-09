<%@ page import="java.sql.*" %>
<%@ page import="supermarketpcc.logica.Sistema" %>
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
    <!-- Login Form -->
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

<!-- Codigo para poder "iniciar sesion" -->

<%
    if (request.getParameter("usuario") != null && request.getParameter("contrasena") != null) {

        Sistema sistema = new Sistema();

        String inputNombre = request.getParameter("usuario");
        String inputContrasena = request.getParameter("contrasena");

            if (sistema.ingresarUsuario(inputNombre, inputContrasena)) {
                response.sendRedirect("Home.jsp");
            } else {
                out.println("<div style='color:red; text-align:center; margin-top:20px;'>Usuario o contraseña incorrectos.</div>");
            }

    }

%>

</body>
</html>
