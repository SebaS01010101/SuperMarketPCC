package supermarketpcc.logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQL {

    private Connection connection = null;
    private final static String host = "jdbc:mysql://localhost/supermercado_inventario";
    private final static String user = "root";
    private final static String password = "";

    public Connection conexionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(host, user, password);
            System.out.println("Conexión establecida");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("No se ha podido establecer la conexión");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
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
