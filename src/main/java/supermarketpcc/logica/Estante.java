package supermarketpcc.logica;

import java.util.*;

public class Estante extends Inventario implements Organizador {

    private String tipo;
    private double volumenMax;
    private double volumenActual;
    private List<Producto> productosEstante;

    public Estante(String nombre, String tipo, double volumenMax) {
        super(nombre);
        this.tipo = tipo;
        this.volumenMax = volumenMax;
        this.volumenActual = 0;
        this.productosEstante = new ArrayList<>();

    }

    public boolean puedeAgregarProducto(Producto producto) {
        return volumenActual + producto.getVolumen() <= volumenMax;
    }

    public void agregarProducto(Producto producto) {
        if (puedeAgregarProducto(producto)) {
            volumenActual += producto.getVolumen();
            productosEstante.add(producto);
            System.out.println("Producto agregado al estante de " + tipo);
        } else {
            System.out.println("No hay suficiente espacio en el estante de " + tipo);
        }
    }

    public List<Producto> getProductos() {
        return productosEstante;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Estante{" +
                (super.toString()) +
                "productos = " + productosEstante +
                "volumenActual=" + volumenActual +
                ", tipo='" + tipo + '\'' +
                ", volumenMax=" + volumenMax +
                '}';
    }

    @Override
    public void ordenar() {
        productosEstante.sort(Comparator.comparing(Producto::getId));
    }
}