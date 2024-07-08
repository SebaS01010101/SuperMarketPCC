package supermarketpcc.logica;

import Servlet.SvProducto;

import java.util.*;

public class Sistema {

	private Inventario inventario;
	private SvProducto svProducto;

	public Sistema() {
		this.inventario = new Inventario(1, "Inventario Principal");
		this.svProducto = new SvProducto();
	}

	public void agregarEstante() {
		inventario.agregarEstante("No Alimento", new Estante(1, "Estante No Alimento", "No Alimento", 100));
		inventario.agregarEstante("Alimento", new Estante(2, "Estante Alimento", "Alimento", 200));
		inventario.agregarEstante("Congelados", new Estante(3, "Estante Congelados", "Congelados", 150));
		inventario.agregarEstante("Bebestibles", new Estante(4, "Estante Bebestibles", "Bebestibles", 120));
		inventario.agregarEstante("Frutas y Verduras", new Estante(5, "Estante Frutas y Verduras", "Frutas y Verduras", 180));
	}

	public void agregarProducto(Producto producto, String tipoEstante) {
		Estante estante = inventario.obtenerEstante(tipoEstante);
		if (estante != null) {
			estante.agregarProducto(producto);
		} else {
			System.out.println("Estante de tipo " + tipoEstante + " no existe.");
		}
	}

	public void cargarProductosEnEstantes() {
		List<Producto> productos = svProducto.obtenerProductos();

		Map<Class<? extends Producto>, String> tipoEstanteMap = new HashMap<>();
		tipoEstanteMap.put(Congelado.class, "Congelados");
		tipoEstanteMap.put(FrutaVerdura.class, "Frutas y Verduras");
		tipoEstanteMap.put(Bebestible.class, "Bebestibles");
		tipoEstanteMap.put(Alimento.class, "Alimento");
		tipoEstanteMap.put(NoAlimento.class, "No Alimento");

		productos.forEach(producto -> {
			String tipoEstante = tipoEstanteMap.get(producto.getClass());
			if (tipoEstante != null) {
				agregarProducto(producto, tipoEstante);
			} else {
				System.out.println("Tipo de producto desconocido: " + producto.getNombre());
			}
		});

	}

	public void mostrarProductosEnEstantes() {
		inventario.mostrarProductosEnEstantes();
	}

	//intento para jsp seba
	public List<Producto> obtenerProductos(String tipoEstante) {
		return inventario.obtenerProductos(tipoEstante);
	}

	public void registrarUsuario() {

		throw new UnsupportedOperationException();
	}

	public void ingresarUsuario() {

		throw new UnsupportedOperationException();
	}

	public void eliminarUsuario() {

		throw new UnsupportedOperationException();
	}

	/**
	 * @param producto
	 */
	public void registrarProducto(Producto producto) {

		throw new UnsupportedOperationException();
	}

	public void eliminarProducto() {

		throw new UnsupportedOperationException();
	}

	/**
	 * @param producto
	 */
	public void actualizarProducto(Producto producto) {

		throw new UnsupportedOperationException();
	}

	public void asignarEstanteProducto() {

		throw new UnsupportedOperationException();
	}

	public void mostrarUbicacionProducto() {

		throw new UnsupportedOperationException();
	}
}
