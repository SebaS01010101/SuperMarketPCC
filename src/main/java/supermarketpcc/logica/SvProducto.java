package supermarketpcc.logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SvProducto {

    private Connection connection;

    public SvProducto(Connection connection) {
        this.connection = connection;

    }
    public void agregarProducto(String nombre, String volumen, String codigo_de_barras, String tipo){
        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO producto( nombre, codigo_de_barras, volumen) VALUES ('"+nombre+"','"+codigo_de_barras+"','"+volumen+"')";
            statement.executeUpdate(sql);
            // no se como va la id abajo porq es autoincrementable
            switch (tipo){
                case "congelado":
                    //hay que setear las descripciones de cada tipo
                    String temp = "";
                    String sql1 = "INSERT INTO congelado(ID_producto, temperatura, ID_tipo) VALUES ('','"+temp+"','1')";
                    break;
                case "fruta_verdura":
                    String sql2 = "INSERT INTO fruta_verdura(ID_producto, fecha_ingreso, fecha_caducidad, ID_tipo) VALUES ('','','','2')";
                    break;
                case "bebestible":
                    String sql3 = "INSERT INTO bebestible(ID_producto, tipo, ID_tipo) VALUES ('','3','')";
                    break;
                case "alimento":
                    String sql4 = "INSERT INTO alimento(ID_producto, ID_tipo) VALUES ('','4')";
                    break;
                case "no_alimento":
                    String sql5 = "INSERT INTO no_alimento(ID_producto, descripcion) VALUES ('','')";
                    break;

            }
            // deberia actualizarse en la base
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Producto> obtenerProductos() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT p.ID_producto, nombre, a.tipo AS tipo_a, t.tipo AS tipo_t, volumen, codigo_de_barras " +
                    "FROM producto p " +
                    "INNER JOIN bebestible t ON t.ID_producto = p.ID_producto " +
                    "INNER JOIN tipo a ON t.ID_tipo = a.ID_tipo;";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("ID_producto");
                String nombre = resultSet.getString("nombre");
                Double volumen = resultSet.getDouble("volumen");
                String codigoBarras = resultSet.getString("codigo_de_barras");
                String tipo = resultSet.getString("tipo_t");
                Producto producto = new Bebestible(id, nombre, codigoBarras, volumen, tipo);
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
        return productos;
    }
}