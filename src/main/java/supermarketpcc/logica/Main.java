package supermarketpcc.logica;
import java.awt.color.ProfileDataException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {
        SvProducto svProducto = new SvProducto();
        List<Producto> productos = svProducto.obtenerProductos();
        for (Producto producto : productos) {
            System.out.println(producto);
        }

    }
}
