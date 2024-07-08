<%@ page import="java.sql.*" %>
<%@ page import="supermarketpcc.logica.Sistema" %>
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
        <a href="agregarProducto.jsp">Registrar Productos</a>
        <a href="RegistrarUsuario.jsp">Registrar Usuario</a>
        <a href="EliminarProducto.jsp">Eliminar Producto</a>
    </nav>
</div>


    <div class="container-form">
        <h2>Registro</h2>
        <form action="" method="post">
    
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
                <select name="rol" id="rol">
                    <option value="0">Seleccione un rol</option>
                    <option value="1">admin</option>
                    <option value="2">empleado</option>
                </select>
            </div>
        
            <input type="submit" value="Registrar">
        </form>
    </div>
    
   
<%
        if (request.getParameter("usuario") != null && request.getParameter("contrasena") != null && request.getParameter("confirmarContrasena") != null) {
            Sistema sistema = new Sistema();
            String inputNombre = request.getParameter("nombre");
            String inputUsuario = request.getParameter("usuario");
            String inputContrasena = request.getParameter("contrasena");
            String inputRol = request.getParameter("rol");

            sistema.registrarUsuario(inputNombre, inputUsuario, inputContrasena, inputRol);
        }
    %>

</body>
</html>
