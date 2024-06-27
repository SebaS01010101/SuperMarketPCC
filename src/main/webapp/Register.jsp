<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/register.css">
    <title>Register</title>
</head>
<body>

<h1>Supermercado PCC</h1>

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
