package supermarketpcc.logica;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeleteProdutct {
    private Connection connection;

    public DeleteProdutct() {
        this.connection = new ConexionSQL().conexionBD();
    }

    public void eliminarPorID(int id) {
        PreparedStatement preparedStatement = null;
        try {
            String sql = "DELETE FROM producto WHERE ID_producto = " + id + "";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            // Cerrar los recursos
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
        public void eliminarTodoProducto (String codigo){
            PreparedStatement preparedStatement = null;
            try {
                String sql = "DELETE FROM producto WHERE codigo_de_barra = " + codigo + "";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        public void eliminarPorNombre (String nombre){

            try {
                String sql = "DELETE FROM producto WHERE nombre = %" + nombre + "";
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
        public void eliminarDeEstante () {

        }
        public void eliminarDeBodega () {

        }
    }