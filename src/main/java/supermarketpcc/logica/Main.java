package supermarketpcc.logica;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        ConexionSQL conexionSQL = new ConexionSQL();
        conexionSQL.conexionBD();
        List<Producto> productos = conexionSQL.obtenerProducto();
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
}
