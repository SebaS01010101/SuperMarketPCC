package supermarketpcc.logica;
import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {
        ConexionSQL conexionSQL = new ConexionSQL();
        conexionSQL.conexionBD();
        SvProducto svProducto = new SvProducto(conexionSQL.getConnection());
        System.out.println(svProducto.obtenerProductos());
    }
}
