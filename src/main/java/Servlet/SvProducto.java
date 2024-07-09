package Servlet;

import supermarketpcc.logica.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.time.LocalDate;

public class SvProducto {

    private Connection connection;
    List<Producto> productos = new ArrayList<>();

    public SvProducto() {
        this.connection = new ConexionSQL().conexionBD();
    }
//Metodo para agregar producto a la base de datos
    public int agregarProducto(String nombre, Double volumen, String codigoBarras) {
        int ultimaID = 0;
        try (Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO producto( nombre, codigo_de_barras, volumen) VALUES ('" + nombre + "','" + codigoBarras + "','" + volumen + "')";
            int query = statement.executeUpdate(sql);
            if (query > 0) {
                try (ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID()")) {
                    if (resultSet.next()) {
                        ultimaID = resultSet.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(ultimaID);
        return ultimaID;

    }
//Obtener todos los productos de la base de datos y pasarlos a una lista
    public List<Producto> obtenerProductos() {

        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT p.ID_producto, nombre, t.tipo, volumen, codigo_de_barras FROM producto p " +
                    "INNER JOIN tipo_producto a ON p.ID_producto = a.ID_producto " +
                    "INNER JOIN tipo t ON t.ID_tipo = a.ID_tipo;";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("ID_producto");
                String nombre = resultSet.getString("nombre");
                Double volumen = resultSet.getDouble("volumen");
                String codigoBarras = resultSet.getString("codigo_de_barras");
                String tipo = resultSet.getString("tipo");

                Producto producto = null;

                switch (tipo) {
                    case "congelado":
                        producto = getCongelado(id, nombre, volumen, codigoBarras);
                        break;
                    case "fruta_verdura":
                        producto = getFrutaVerdura(id, nombre, volumen, codigoBarras);
                        break;
                    case "bebestible":
                        producto = getBebestible(id, nombre, volumen, codigoBarras);
                        break;
                    case "alimento":
                        producto = new Alimento(id, nombre, codigoBarras, volumen);
                        break;
                    case "no_alimento":
                        producto = getNoAlimento(id, nombre, volumen, codigoBarras);
                        break;
                }
                if (producto != null) {
                    productos.add(producto);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }
//Metodos para obtener los productos de la base de datos{
    public Producto getCongelado(int id, String nombre, double volumen, String codigoBarras) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT temperatura FROM congelado WHERE ID_producto = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                int temperatura = resultSet.getInt("temperatura");
                return new Congelado(id, nombre, codigoBarras, volumen, temperatura);
            }
        }
        return null;
    }

    public Producto getFrutaVerdura(int id, String nombre, double volumen, String codigoBarras) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT fecha_ingreso, fecha_caducidad FROM fruta_verdura WHERE ID_producto = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Date fechaIngreso = resultSet.getDate("fecha_ingreso");
                Date fechaCaducidad = resultSet.getDate("fecha_caducidad");
                return new FrutaVerdura(id, nombre, codigoBarras, volumen, fechaIngreso, fechaCaducidad);
            }
        }
        return null;
    }

    public Producto getBebestible(int id, String nombre, double volumen, String codigoBarras) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT tipo FROM bebestible WHERE ID_producto = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String tipoBebestible = resultSet.getString("tipo");
                return new Bebestible(id, nombre, codigoBarras, volumen, tipoBebestible);
            }
        }
        return null;
    }

    public Producto getNoAlimento(int id, String nombre, double volumen, String codigoBarras) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT descripcion FROM no_alimento WHERE ID_producto = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String descripcion = resultSet.getString("descripcion");
                return new NoAlimento(id, nombre, codigoBarras, volumen, descripcion);
            }
        }
        return null;
    }
    //}Fin metodos obtener productos


//Metodos insertar congelado{
    public void insertCongelado(String nombre, double volumen, String codigoBarras, int temperatura) throws SQLException {
        int ultimaID = agregarProducto(nombre, volumen, codigoBarras);
        try (Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO congelado(ID_producto, temperatura, ID_tipo) VALUES ('"+ultimaID+"','" + temperatura + "','1')";
            statement.executeUpdate(sql);
            insertTipoProductoCongelado(ultimaID);
        }
    }
    public void insertTipoProductoCongelado(int ultimaID) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO tipo_producto(ID_tipo, ID_producto) VALUES ('1','" + ultimaID + "')";
            statement.executeUpdate(sql);
        }
    }
    //}Fin metodos insertar congelado

//Metodos insertar fruta verdura{
    public void insertFrutaVerdura(String nombre, double volumen, String codigoBarras) throws SQLException {
        int ultimaID = agregarProducto(nombre, volumen, codigoBarras);
        Date fechaIngresoSQL = Date.valueOf(LocalDate.now());
        LocalDate fechaIngresoLocal = fechaIngresoSQL.toLocalDate();
        LocalDate fechaCaducidadLocal = fechaIngresoLocal.plusDays(7);
        Date fechaCaducidadSQL = Date.valueOf(fechaCaducidadLocal);

        try (Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO fruta_verdura(ID_producto, fecha_ingreso, fecha_caducidad, ID_tipo) VALUES ('" + ultimaID + "','" + fechaIngresoSQL + "','" + fechaCaducidadSQL + "','2')";
            statement.executeUpdate(sql);
            insertTipoProductoFrutaVerdura(ultimaID);
        }
        System.out.println(nombre + " " + volumen + " " + codigoBarras + " " + fechaIngresoSQL + " " + fechaCaducidadSQL);
    }
    public void insertTipoProductoFrutaVerdura(int ultimaID) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO tipo_producto(ID_tipo, ID_producto) VALUES ('2','" + ultimaID + "')";
            statement.executeUpdate(sql);
        }
    }
    //}Fin metodos insertar fruta verdura

//Metodos insertar bebestible{
    public void insertBebestible(String nombre, double volumen, String codigoBarras, String tipo) throws SQLException {
        int ultimaID = agregarProducto(nombre, volumen, codigoBarras);
        try (Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO bebestible(ID_producto, tipo, ID_tipo) VALUES ('" + ultimaID + "','" + tipo + "','3')";
            statement.executeUpdate(sql);
            insertTipoProductoBebestible(ultimaID);
        }
    }
    public void insertTipoProductoBebestible(int ultimaID) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO tipo_producto(ID_tipo, ID_producto) VALUES ('3','" + ultimaID + "')";
            statement.executeUpdate(sql);
        }
    }
    //}Fin metodos insertar bebestible

    //Metodos Insertar alimento{
    public void insertAlimento(String nombre, double volumen, String codigoBarras) throws SQLException {
        int ultimaID = agregarProducto(nombre, volumen, codigoBarras);
        try (Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO alimento(ID_producto, ID_tipo) VALUES ('" + ultimaID + "','4')";
            statement.executeUpdate(sql);
            insertTipoProductoAlimento(ultimaID);
        }
    }

    public void insertTipoProductoAlimento(int ultimaID) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO tipo_producto(ID_tipo, ID_producto) VALUES ('4','" + ultimaID + "')";
            statement.executeUpdate(sql);
        }
    }
    //}Fin metodos insertar alimento

    //Metodos insertar no alimento{
    public void insertNoAlimento(String nombre, double volumen, String codigoBarras, String descripcion) throws SQLException {
        int ultimaID = agregarProducto(nombre, volumen, codigoBarras);
        try (Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO no_alimento(ID_producto, descripcion) VALUES ('"+ultimaID+"','" + descripcion + "')";
            statement.executeUpdate(sql);
            insertTipoProductoNoAlimento(ultimaID);
        }
    }
    public void insertTipoProductoNoAlimento(int ultimaID) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO tipo_producto(ID_tipo, ID_producto) VALUES ('5','" + ultimaID + "')";
            statement.executeUpdate(sql);
        }
    }
//}Fin metodos insertar no alimento
}
