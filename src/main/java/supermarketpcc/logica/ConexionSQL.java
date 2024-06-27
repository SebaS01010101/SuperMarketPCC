package supermarketpcc.logica;

import java.sql.*;
import java.util.List;

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


    public Connection getConnection() {
        if (connection == null) {
            conexionBD();
        }
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
