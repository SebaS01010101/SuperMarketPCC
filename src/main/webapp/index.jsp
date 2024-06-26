<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/index.css">
    <title>Login</title>
</head>
<body>
<h1>Supermercado PCC</h1>

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
        <a href="Home.jsp">Regresar</a>
    </form>
</div>
</body>
</html>
