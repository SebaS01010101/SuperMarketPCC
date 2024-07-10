<%@ page import="supermarketpcc.logica.Sistema" %>
<%@ page import="supermarketpcc.logica.Estante" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.5.2/css/all.css" crossorigin="anonymous">
    <link rel="stylesheet" href="css/sidebar.css">
    <link rel="stylesheet" href="css/agregarEstante.css">
    <title>Home</title>
</head>
<body>
<!-- Side Bar -->
<div class="sidebar">
    <div class="logo">
        <a href="Home.jsp" class="linkHome">
            <i class="fa-solid fa-shop icon"></i>
            <h2>Supermercado PCC</h2>
        </a>

    </div>
    <nav>
        <h5>Productos</h5>
        <a href="ListadoProductos.jsp">Listado de Productos</a>
        <a href="agregarProducto.jsp">Registrar Productos</a>
        <a href="EliminarProducto.jsp">Eliminar Producto</a>
        <h5>Estantes</h5>
        <a href="agregarEstantes.jsp">Agregar Estante</a>
        <a href="agregarProductoAEstante.jsp">Agregar Producto a Estante</a>
        <a href="mostrarEstante.jsp">Mostrar Estante</a>
        <h5>Bodega</h5>
        <a href="agregarProductoABodega.jsp">Agregar Producto a Bodega</a>
        <a href="mostrarBodega.jsp">Mostrar Bodega</a>
        <h5>Usuarios</h5>
        <a href="RegistrarUsuario.jsp">Registrar Usuario</a>
    </nav>
</div>
<!-- Formulario -->
<div class="form">
    <form method="post">
            <div class="nombre">
                <label for="nombre">Nombre: </label>
                <input type="text" name="nombre" id="nombre" required>
            </div>

            <div class="tipoEstante">
                <label for="tipoEstante">Tipo de Estante:</label>
                <select name="tipoEstante" id="tipoEstante" required>
                    <option value="">Seleccione Tipo</option>
                    <option value="Congelados">Congelados</option>
                    <option value="Frutas y Verduras">Fruta y Verdura</option>
                    <option value="Bebestibles">Bebestible</option>
                    <option value="Alimento">Alimento</option>
                    <option value="No Alimento">No alimento</option>
                </select>
            </div>

            <div class="volumenMax">
                <label for="volumenMax">Volumen Máximo: </label>
                <input type="text" name="volumenMax" id="volumenMax" required>
            </div>

          <input type="submit" value="Agregar">
    </form>
</div>

<!-- Codigo java del formulario
 Toma los parametros del formulario y los agrega a la lista de estantes
 -->
<%
    Sistema sistema = new Sistema();
    List<Estante> estantes = sistema.deserializableEstantes();
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        try {
            String nombre = request.getParameter("nombre");
            String tipoEstante = request.getParameter("tipoEstante");
            int volumenMax = Integer.parseInt(request.getParameter("volumenMax"));

            Estante nuevoEstante = new Estante(nombre, tipoEstante, volumenMax);
            estantes.add(nuevoEstante);
            sistema.serializableEstantes();

           out.println("Estante agregado correctamente.");
        } catch (NumberFormatException e) {
            out.println("Error: Volumen máximo debe ser un número entero.");
        } catch (Exception e) {
            out.println("Error al agregar estante: " + e.getMessage());
        }
    }
%>

</body>
</html>
