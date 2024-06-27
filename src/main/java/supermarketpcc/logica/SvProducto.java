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
        List<Producto> productos = null;
        try {
            productos = new ArrayList<>();
            Statement statement = connection.createStatement();
            String sql = "SELECT p.ID_producto, nombre, a.tipo, t.tipo ,volumen, codigo_de_barras FROM producto p INNER JOIN bebestible t ON t.ID_producto = p.ID_producto INNER JOIN tipo a\n" +
                    "  ON t.ID_tipo = a.ID_tipo;";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("ID_producto");
                String nombre = resultSet.getString("nombre");
                String tipo = resultSet.getString("t.tipo");
                String descripcion = resultSet.getString("a.tipo");
                String volumen = resultSet.getString("volumen");
                String codigo_de_barras = resultSet.getString("codigo_de_barras");
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Descripcion: " + descripcion + ", Tipo: " + tipo + ", Volumen: " + volumen + ", Codigo de barras: " + codigo_de_barras);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;

    }


}
