package supermarketpcc.logica;
import Servlet.SvProducto;

import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {
        SvProducto svProducto = new SvProducto();
        DeleteProduct deleteProdutct = new DeleteProduct();
        List<Producto> productos = svProducto.obtenerProductos();
        for (Producto producto : productos) {
            System.out.println(producto);
        }
        deleteProdutct.eliminarPorID(1);

    }
}
