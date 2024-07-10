package supermarketpcc.logica;

import java.util.*;

public class Bodega extends Inventario implements Organizador {

    List<Producto> productos ;
    public Bodega( String nombre) {
        super(nombre);
       this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public int stockProducto(Producto producto){
        int stock = 0;
        for (Producto p: productos) {
            if (p.equals(producto)){
                stock++;
            }
        }
        return stock;
    }

    @Override
    public String toString() {
        return "Bodega{" +
                "productos=" + productos +
                '}';
    }

    @Override
    public void ordenar() {
        productos.sort(Comparator.comparing(Producto::getNombre));
    }


}