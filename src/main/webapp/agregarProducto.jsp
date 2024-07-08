
<%@page import="Servlet.SvProducto" %>
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
            <form method="post">

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
                        <option value="default">Seleccione Tipo</option>
                        <option value="1">Congelados</option>
                        <option value="2">Fruta y Verdura</option>
                        <option value="3">Bebestible</option>
                        <option value="4">Alimento</option>
                        <option value="5">No alimento</option>
                    </select>
                </div>

                <div class="temperatura">
                    <label for="temperatura" id="labelTemperatura">Temperatura: </label>
                    <input type="number" name="temperatura" id="temperatura" required> 
                </div>

                <div class="tipoBebestible">
                    <label for="tipoBebestible" id="labelTipoBebestible">Tipo bebestible:</label>
                    <select name="tipoBebestible" id="tipoBebestible">
                        <option value="default">Seleccionar Tipo Bebestible</option>
                        <option value="1">Alcoholica</option>
                        <option value="2">No alcoholica</option>
                    </select>
                </div>

                <div class="descripcion">
                    <label for="descripcion" id="labelDescripcion">Descripción: </label>
                    <input type="text" name="descripcion" id="descripcion" required>  
                </div>

                <input type="submit" value="Registrar" >
            </form>
        </div>
    </div>


    <%
        if (request.getParameter("nombre") != null && request.getParameter("codigoBarras") != null && request.getParameter("volumen") != null && request.getParameter("tipoProducto") != null){

            SvProducto svProducto = new SvProducto();
              String nombre = request.getParameter("nombre");
                String codigoBarras = request.getParameter("codigoBarras");
                Double volumen = Double.parseDouble(request.getParameter("volumen")) ;
                String tipoProducto = request.getParameter("tipoProducto");
                if (tipoProducto == "1"){
                    int temperatura = Integer.parseInt(request.getParameter("temperatura"));
                    svProducto.agregarProducto(nombre, volumen,codigoBarras , tipoProducto);
                    svProducto.insertCongelado(temperatura);
                } else if (tipoProducto == "2") {
                    svProducto.agregarProducto(nombre, volumen,codigoBarras , tipoProducto);
                    svProducto.insertFrutaVerdura();
                } else if (tipoProducto == "3") {
                    String tipoBebestible = request.getParameter("tipoBebestible");
                    svProducto.agregarProducto(nombre, volumen,codigoBarras , tipoProducto);
                    svProducto.insertBebestible(tipoBebestible);
                } else if (tipoProducto == "4") {
                    String descripcion = request.getParameter("descripcion");
                    svProducto.agregarProducto(nombre, volumen,codigoBarras , tipoProducto);
                    svProducto.insertNoAlimento(descripcion);
                }else if (tipoProducto == "5") {
                    svProducto.agregarProducto(nombre, volumen,codigoBarras , tipoProducto);
                }

        }
    %>


    <script src="js/agregarProducto.js"></script>
  </body>
</html>
