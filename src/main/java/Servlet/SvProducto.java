package Servlet;

import supermarketpcc.logica.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SvProducto {

    private Connection connection;
    List<Producto> productos = new ArrayList<>();

    public SvProducto() {
        this.connection = new ConexionSQL().conexionBD();
    }

    public void agregarProducto(String nombre, Double volumen, String codigoBarras, String tipo) {
        try (Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO producto( nombre, codigo_de_barras, volumen) VALUES ('" + nombre + "','" + codigoBarras + "','" + volumen + "')";
            ResultSet resultSet = statement.executeQuery(sql);
            nombre = resultSet.getString("nombre");
            volumen = resultSet.getDouble("volumen");
            codigoBarras = resultSet.getString("codigo_de_barras");
            tipo = resultSet.getString("tipo");




        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

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

    private Producto getCongelado(int id, String nombre, double volumen, String codigoBarras) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT temperatura FROM congelado WHERE ID_producto = " + id;
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                int temperatura = rs.getInt("temperatura");
                return new Congelado(id, nombre, codigoBarras, volumen, temperatura);
            }
        }
        return null;
    }

    private Producto getFrutaVerdura(int id, String nombre, double volumen, String codigoBarras) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT fecha_ingreso, fecha_caducidad FROM fruta_verdura WHERE ID_producto = " + id;
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                Date fechaIngreso = rs.getDate("fecha_ingreso");
                Date fechaCaducidad = rs.getDate("fecha_caducidad");
                return new FrutaVerdura(id, nombre, codigoBarras, volumen, fechaIngreso, fechaCaducidad);
            }
        }
        return null;
    }

    private Producto getBebestible(int id, String nombre, double volumen, String codigoBarras) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT tipo FROM bebestible WHERE ID_producto = " + id;
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                String tipoBebestible = rs.getString("tipo");
                return new Bebestible(id, nombre, codigoBarras, volumen, tipoBebestible);
            }
        }
        return null;
    }

    private Producto getNoAlimento(int id, String nombre, double volumen, String codigoBarras) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT descripcion FROM no_alimento WHERE ID_producto = " + id;
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                String descripcion = rs.getString("descripcion");
                return new NoAlimento(id, nombre, codigoBarras, volumen, descripcion);
            }
        }
        return null;
    }
    private void insertCongelado(double temperatura) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO congelado(ID_producto, temperatura, ID_tipo) VALUES ('','"+temperatura+"','1')";
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                sql = "INSERT INTO `tipo_producto`(`ID_tipo`) VALUES ('1')";
                statement.executeQuery(sql);

            }
        }
    }

    private void insertFrutaVerdura(Date fechaIngreso, Date fechaCaducidad) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO fruta_verdura(ID_producto, fecha_ingreso, fecha_caducidad, ID_tipo) VALUES ('','"+fechaIngreso+"','"+fechaCaducidad+"','2')";
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                sql = "INSERT INTO `tipo_producto`(`ID_tipo`) VALUES ('2')";
                statement.executeQuery(sql);

            }
        }
    }

    private void insertBebestible(String tipo) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO bebestible(tipo, ID_tipo) VALUES ('"+tipo+"','3')";
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                sql = "INSERT INTO `tipo_producto`(`ID_tipo`) VALUES ('3')";
                statement.executeQuery(sql);

            }
        }

    }
    private void insertAlimento() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO alimento(ID_tipo) VALUES ('4')";
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                sql = "INSERT INTO `tipo_producto`(`ID_tipo`) VALUES ('4')";
                statement.executeQuery(sql);

            }
        }

    }

    private void insertNoAlimento(String descripcion) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO no_alimento(ID_producto, descripcion) VALUES ('','"+descripcion+"')";
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                sql = "INSERT INTO `tipo_producto`(`ID_tipo`) VALUES ('5')";
                statement.executeQuery(sql);

            }
        }

    }
}
