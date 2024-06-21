import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class ConexionSQL {
    private Connection connection;
    private final static String host = "jdbc:mysql://localhost/supermercado_inventario";
    private final static String user = "root";
    private final static String password = "";

    public void conexionBD() {
        try {
            connection = getConnection(host, user, password);
            System.out.println("Conexión establecida");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("No se ha podido establecer la conexión");
        }
    }

    public void createTableProductos() {
        try (Statement statement = connection.createStatement()) {
            String consult = "CREATE TABLE IF NOT EXISTS productos (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "nombre VARCHAR(50) NOT NULL, " +
                    "precio DECIMAL(10, 2) NOT NULL, " +
                    "cantidad INT NOT NULL)";
            statement.executeUpdate(consult);
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    public void createProduct(String nombre, java.math.BigDecimal precio, int cantidad) {
        try {
            String consult = "INSERT INTO productos (nombre, precio, cantidad) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(consult)) {
                preparedStatement.setString(1, nombre);
                preparedStatement.setBigDecimal(2, precio);
                preparedStatement.setInt(3, cantidad);
                preparedStatement.executeUpdate();
                System.out.println("Producto añadido");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    public void displayProducts() {
        try {
            String consult = "SELECT * FROM productos";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(consult);
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("Nombre: " + resultSet.getString("nombre"));
                    System.out.println("Precio: " + resultSet.getBigDecimal("precio"));
                    System.out.println("Cantidad: " + resultSet.getInt("cantidad"));
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }
}
