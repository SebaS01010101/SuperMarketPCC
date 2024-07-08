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
            <a href="MenuRegistrarProducto.jsp">Registrar Productos</a>
            <a href="RegistrarUsuario.jsp">Registrar Usuario</a>
            <a href="EliminarProducto.jsp">Eliminar Producto</a>
        </nav>
    </div>
    

<div class="container-form">
    <h2>Registro</h2>
    <form class="" action="">

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

</body>
</html>
