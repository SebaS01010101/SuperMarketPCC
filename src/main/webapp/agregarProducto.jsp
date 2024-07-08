<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head> 
    
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.5.2/css/all.css" crossorigin="anonymous">
    <link rel="stylesheet" href="css/sidebar.css">
    <link rel="stylesheet" href="css/agregarProducto.css">
    <title>Registrar Productos</title>
   
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

    <div class="container">
        <h2>Registrar</h2>
        <div class="form">
            <form action="" method="post">

                <div class="nombre">
                    <label for="nombre">Nombre: </label>
                    <input type="text" name="nombre" id="nombre" required>
                </div>
                <div class="codigoBarras">
                    <label for="codigoBarras">Código de Barras: </label>
                    <input type="text" name="codigoBarras" id="codigoBarras" required>
                </div>

                <div class="volumen">
                    <label for="volumen">Volumen: </label>
                    <input type="text" name="volumen" id="volumen" required>
                </div>

                <div class="tipoProducto select">
                    <label for="tipoProducto">Tipo de Producto:</label>
                    <select name="tipoProducto" id="tipoProducto">
                        <option value="default">Seleccionar Tipo</option>
                        <option value="1">Congelados</option>
                        <option value="2">Fruta y Verdura</option>
                        <option value="3">Bebestible</option>
                        <option value="4">Alimento</option>
                        <option value="5">No alimento</option>
                    </select>
                </div>

                <div class="temperatura">
                    <label for="temperatura" id="labelTemperatura">Temperatura: </label>
                    <option disabled>
                        <input type="number" name="temperatura" id="temperatura" required> 
                    </option>
                </div>

                <div class="tipoBebestible select">
                    <label for="tipoBebestible" id="labelTipoBebestible">Tipo bebestible:</label>
                    <option disabled>
                        <select name="tipoBebestible" id="tipoBebestible">Tipo Bebestible</select>
                    </option>
                </div>

                <div class="descripcion">
                    <label for="descripcion" id="labelDescripcion">Descripción: </label>
                    <option disabled>
                      <input type="text" name="descripcion" id="descripcion" required>  
                    </option>
                </div>

                <input type="submit" value="Registrar">
            </form>
        </div>
    </div>
    <script src="js/agregarProducto.js"></script>
  </body>
</html>
