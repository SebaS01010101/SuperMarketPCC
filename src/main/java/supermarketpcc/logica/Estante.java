package supermarketpcc.logica;

import java.io.Serializable;
import java.util.*;


public class Estante extends Inventario implements Organizador, Serializable {

    private String tipo;
    private double volumenMax;
    private double volumenActual;
    private List<Producto> productos;


    public Estante(){

    }

    public Estante( String nombre, String tipo, double volumenMax) {
        super(nombre);
        this.tipo = tipo;
        this.volumenMax = volumenMax;
        this.volumenActual = 0;
        this.productos = new ArrayList<>();

    }

    public boolean puedeAgregarProducto(Producto producto) {
        return volumenActual + producto.getVolumen() <= volumenMax;
    }

    public void agregarProducto(Producto producto) {
        if (puedeAgregarProducto(producto)) {
            volumenActual += producto.getVolumen();
            productos.add(producto);
            System.out.println("Producto agregado al estante de " + tipo);
        } else {
            System.out.println("No hay suficiente espacio en el estante de " + tipo);
        }
    }

    public void mostrarProductos(Collection<Producto> productos) {
        System.out.println("Estante: " + tipo + " (Volumen máximo: " + volumenMax + ", Volumen actual: " + volumenActual + ")");
        productos.forEach(producto -> System.out.println(" - " + producto.getNombre() + " (Volumen: " + producto.getVolumen() + ")"));
    }

    //intento para jsp seba

    public List<Producto> getProductos() {
        return productos;
    }


    public void eliminarProductoEstante() {

        throw new UnsupportedOperationException();
    }

    public void agregarEstante() {

        throw new UnsupportedOperationException();

    }

    public String getTipo() {
        return tipo;
    }

    public double getVolumenMax() {
        return volumenMax;
    }

    public double getVolumenActual() {
        return volumenActual;
    }

    @Override
    public String toString() {
        return "Estante{" +
                (super.toString()) +
                "productos = " + productos +
                "volumenActual=" + volumenActual +
                ", tipo='" + tipo + '\'' +
                ", volumenMax=" + volumenMax +
                '}';
    }

    @Override
    public void ordenar() {
        throw new UnsupportedOperationException();

    }
}