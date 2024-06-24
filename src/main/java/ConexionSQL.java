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
            String sql = "SELECT ID_alimento, nombre, tipo, volumen, codigo_de_barras\n" +
                    "FROM producto p\n" +
                    "INNER JOIN alimento a ON a.ID_alimento = p.ID_producto;";
            ResultSet resultSet = statement.executeQuery(sql);

            // Leer los resultados
            while (resultSet.next()) {
                int id = resultSet.getInt("ID_alimento");
                String nombre = resultSet.getString("nombre");
                String tipo = resultSet.getString("tipo");
                String volumen = resultSet.getString("volumen");
                String codigo_de_barras = resultSet.getString("codigo_de_barras");
                System.out.println("ID: " + id + ", Nombre: " + nombre+", tipo: " + tipo + ", volumen: " + volumen+ ", codigo_de_barras: " + codigo_de_barras);
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
