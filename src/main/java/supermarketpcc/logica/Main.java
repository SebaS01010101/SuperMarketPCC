package supermarketpcc.logica;
import Servlet.SvProducto;

import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {
        SvProducto svProducto = new SvProducto();
        DeleteProduct deleteProdutct = new DeleteProduct();
        List<Producto> productos = svProducto.obtenerProductos();
        System.out.println("Productos congelados");
        svProducto.productos.stream().filter( p -> p instanceof Congelado).forEach(p -> System.out.println(p));
        System.out.println("Productos bebestibles");
        svProducto.productos.stream().filter( p -> p instanceof Bebestible).forEach(p -> System.out.println(p));

    }
}
