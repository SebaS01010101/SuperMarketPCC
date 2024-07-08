package supermarketpcc.logica;
import Servlets.SvProducto;

import java.sql.SQLException;
import java.util.List;


public class Main {

    public static void main(String[] args) throws SQLException {
        SvProducto svProducto = new SvProducto();
        DeleteProdutct deleteProdutct = new DeleteProdutct();
        List<Producto> productos = svProducto.obtenerProductos();
        for (Producto producto : productos) {
            System.out.println(producto);
        }
        deleteProdutct.eliminarPorID(1);



}
