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
    public List<Producto> obtenerProducto(){
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
        return null;
    }
    public void agregarProducto(String nombre, String volumen, String codigo_de_barras, String tipo){
        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO `producto`( `nombre`, `codigo_de_barras`, `volumen`) VALUES ('"+nombre+"','"+codigo_de_barras+"','"+volumen+"')";
            statement.executeUpdate(sql);
            // no se como va la id abajo porq es autoincrementable
            switch (tipo){
                case "congelado":
                    //hay que setear las descripciones de cada tipo
                    String temp = "";
                    String sql1 = "INSERT INTO `congelado`(`ID_producto`, `temperatura`, `ID_tipo`) VALUES ('','"+temp+"','1')";
                    break;
                case "fruta_verdura":
                    String sql2 = "INSERT INTO `fruta_verdura`(`ID_producto`, `fecha_ingreso`, `fecha_caducidad`, `ID_tipo`) VALUES ('','','','2')";
                    break;
                case "bebestible":
                    String sql3 = "INSERT INTO `bebestible`(`ID_producto`, `tipo`, `ID_tipo`) VALUES ('','3','')";
                    break;
                case "alimento":
                    String sql4 = "INSERT INTO `alimento`(`ID_producto`, `ID_tipo`) VALUES ('','4')";
                    break;
                case "no_alimento":
                    String sql5 = "INSERT INTO `no_alimento`(`ID_producto`, `descripcion`) VALUES ('','')";
                    break;

            }
            // deberia actualizarse en la base
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
