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
    <form class="" action="">

        <div class="grupo usuario">
            <label for="usuario"> Usuario: </label>
            <input type="text" name="usuario" id="usuario" required>
        </div>

        <div class="grupo contraseña">
            <div class="flexbox">
                <label for="contraseña">Contraseña: </label>
                <input type="password" name="contraseña" id="contraseña" required>
            </div>

            <div class="flexbox">
                <label for="confirmarContraseña">Confirmar Contraseña: </label>
                <input type="password" name="confirmarContraseña" id="confirmarContraseña" required>
            </div>

            <input type="submit" value="Registrar">
        </div>

    </form>
</div>

</body>
</html>
