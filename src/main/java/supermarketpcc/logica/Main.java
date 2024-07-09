package supermarketpcc.logica;

import Servlet.SvProducto;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SvProducto svProducto = new SvProducto();
        // contador de productos con mismo codigo de barras
        List<Producto> productos = svProducto.obtenerProductos();
        productos.stream().forEach(producto -> {
            System.out.println(producto.getCodigoBarras());
        });

    }
}
