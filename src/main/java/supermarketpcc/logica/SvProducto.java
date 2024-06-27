package supermarketpcc.logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SvProducto {

    private Connection connection;

    public SvProducto(Connection conexion) {
        this.connection = conexion;
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