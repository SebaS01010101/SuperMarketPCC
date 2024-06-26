import java.sql.*;

public class ConexionSQL {
    private Connection connection;
    private final static String host = "jdbc:mysql://localhost/supermercado_inventario";
    private final static String user = "root";
    private final static String password = "";

    public void conexionBD() {
        try {
            connection = DriverManager.getConnection(host, user, password);
            System.out.println("Conexión establecida");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("No se ha podido establecer la conexión");
        }
    }
    public void obtenerProducto(){
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT p.ID_producto, nombre, a.tipo, t.tipo ,volumen, codigo_de_barras FROM producto p INNER JOIN bebestible t ON t.ID_producto = p.ID_producto INNER JOIN tipo a\n" +
                    "  ON t.ID_tipo = a.ID_tipo;";
            ResultSet resultSet = statement.executeQuery(sql);

            // Leer los resultados
            while (resultSet.next()) {
                int id = resultSet.getInt("ID_producto");
                String nombre = resultSet.getString("nombre");
                String tipo = resultSet.getString("t.tipo");
                String descripcion = resultSet.getString("a.tipo");
                String volumen = resultSet.getString("volumen");
                String codigo_de_barras = resultSet.getString("codigo_de_barras");
                System.out.println("ID: " + id + ", Nombre: " + nombre+", Descripcion: "+ descripcion+", Tipo: " + tipo + ", Volumen: " + volumen+ ", Codigo de barras: " + codigo_de_barras);
            }

            // Cerrar los recursos
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void cerrarConexion(){
        try{
            if (connection != null && !connection.isClosed()){
                connection.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException("No se ha podido cerrar la conexión");
        }
    }

}
