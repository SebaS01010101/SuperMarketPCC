package supermarketpcc.logica;

import java.util.*;

public class Inventario implements Mostrar {

	Collection<Producto> Productos;
	private int id;
	private String nombre;

	/**
	 * 
	 * @param producto
	 * @param cantidad
	 */
	public void modificarCantidadProducto(Producto producto, int cantidad) {

		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nombre
	 */
	public Producto buscarProductoPorNombre(String nombre) {

		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param codigo
	 */
	public Producto buscarProductoPorCodigoBarra(String codigo) {

		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public Producto buscarProductoId(int id) {

		throw new UnsupportedOperationException();
	}

	public void listarProductos() {

		throw new UnsupportedOperationException();
	}

	@Override
	public void mostrar() {

	}
}