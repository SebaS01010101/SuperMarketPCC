package supermarketpcc.logica;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeleteProdutct {
    private Connection connection;

    public DeleteProdutct(Connection connection) {
        this.connection = connection;
    }

    public void eliminarPorID(int id) {

        try {
            String sql = "DELETE FROM producto WHERE id = "+id+"";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id); // Reemplaza 1 con el ID que quieras eliminar

            int rowsAffected = preparedStatement.executeUpdate();
            Producto producto;

            System.out.println("Número de filas afectadas: " + rowsAffected);
            // Cerrar los recursos
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void eliminarTodoProducto(String codigo) {

        try {
            String sql = "DELETE FROM producto WHERE codigo_de_barras = "+codigo+"";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, codigo); // Reemplaza 1 con el ID que quieras eliminar

            int rowsAffected = preparedStatement.executeUpdate();
            Producto producto;

            System.out.println("Número de filas afectadas: " + rowsAffected);
            // Cerrar los recursos
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void eliminarPorNombre(String nombre) {

        try {
            String sql = "DELETE FROM producto WHERE nombre = %"+nombre+"";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombre); // Reemplaza 1 con el ID que quieras eliminar

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Número de filas afectadas: " + rowsAffected);

            // Cerrar los recursos
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void eliminarDeEstante(){

    }
    public void eliminarDeBodega(){

    }
}
