package supermarketpcc.logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SvProducto {

    private Connection connection;

    public SvProducto() {
    this.connection = new ConexionSQL().conexionBD();
    }
    public void agregarProducto(String nombre, String volumen, String codigo_de_barras, String tipo){
        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO producto( nombre, codigo_de_barras, volumen) VALUES ('"+nombre+"','"+codigo_de_barras+"','"+volumen+"')";
            statement.executeUpdate(sql);
            // no se como va la id abajo porq es autoincrementable
            switch (tipo){
                case "congelado":
                    try {
                    //hay que setear las descripciones de cada tipo
                    System.out.print("Ingrese la temperatura del producto");
                    String temp = "";
                    String sql1 = "INSERT INTO congelado(temperatura, ID_tipo) VALUES ('"+temp+"','1')";
                    statement.executeQuery(sql1);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "fruta_verdura":
                    try {
                    System.out.print("Ingrese la fecha de ingreso del producto");

                    System.out.print("Ingrese la fecha de caducidad del producto");

                    String sql2 = "INSERT INTO fruta_verdura(fecha_ingreso, fecha_caducidad, ID_tipo) VALUES ('','','2')";
                    statement.executeQuery(sql2);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    break;
                case "bebestible":
                    try {
                    System.out.print("Ingrese clase del producto");
                     String tipo_bebestible = "";
                    String sql3 = "INSERT INTO bebestible( tipo, ID_tipo) VALUES ('"+tipo_bebestible+"','3')";
                    statement.executeQuery(sql3);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "alimento":
                    try {
                    String sql4 = "INSERT INTO alimento(ID_tipo) VALUES ('4')";
                    statement.executeQuery(sql4);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "no_alimento":
                    try {
                    String descripcion = "";
                    String sql5 = "INSERT INTO no_alimento(descripcion) VALUES ('"+descripcion+"')";
                    statement.executeQuery(sql5);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

            }
            // deberia actualizarse en la base
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Producto> obtenerProductos()  {
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
                System.out.println("Producto encontrado: " + producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }


        return productos;
    }
}