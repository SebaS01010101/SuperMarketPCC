package supermarketpcc.logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
                String sql = "DELETE FROM producto WHERE codigo_de_barras = " + codigo + "";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.executeUpdate();
                System.out.println("Producto eliminado");
            } catch (SQLException e) {
                System.err.println("Error al eliminar el producto");
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
            PreparedStatement preparedStatement = null;
            try {
                String sql = "DELETE FROM producto WHERE nombre LIKE '%" + nombre + "%'";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                connection.close();
                System.out.println("Producto eliminado");
            } catch (SQLException e) {
                System.err.println("Error al eliminar el producto");
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
        public void eliminarDeEstante () {

        }
        public void eliminarDeBodega () {

        }
    }