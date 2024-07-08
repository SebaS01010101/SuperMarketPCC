package supermarketpcc.logica;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class Inventario implements Mostrar {

	Collection<Producto> productos;
	private int id;
	private String nombre;
	private Connection connection;
	private HashMap<String, Estante> estantes;

	public Inventario(int id, String nombre){
		this.connection = new ConexionSQL().conexionBD();
		this.id = id;
		this.nombre = nombre;
		this.estantes = new HashMap<>();
		this.productos = new ArrayList<>();
	}


	public void agregarEstante(String tipo, Estante estante) {
		estantes.put(tipo, estante);
	}

	public Estante obtenerEstante(String tipo) {
		return estantes.get(tipo);
	}

	public void mostrarProductosEnEstantes() {
		estantes.forEach((tipo, estante) -> {
			Collection<Producto> productosEnEstante = productos.stream()
					.filter(producto -> producto.getClass().getSimpleName().equals(tipo))
					.collect(Collectors.toList());
			estante.mostrarProductos(productosEnEstante);
		});
	}
	//intento para jsp seba
	public List<Producto> obtenerProductos(String tipoEstante){
		Estante estante = obtenerEstante(tipoEstante);
		if(estante != null) {
			return estante.getProductos();
		}else{
			return new ArrayList<>();
		}

	}
	public Producto buscarProductoPorNombre(String nombre) {
		try {
			String sql = "SELECT p.`ID_producto`, `nombre`, ID_tipo,`codigo_de_barras`, `volumen`  FROM `producto` p INNER JOIN tipo_producto t ON t.ID_producto = p.ID_producto; WHERE ID_producto =" + nombre + "";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nombre);

			int rowsAffected = preparedStatement.executeUpdate();

			System.out.println("Número de filas afectadas: " + rowsAffected);
			// Cerrar los recursos
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		throw new UnsupportedOperationException();
	}

	/**
	 * @param codigo
	 */
	public Producto buscarProductoPorCodigoBarra(String codigo) {

		try {
			String sql = "SELECT p.`ID_producto`, `nombre`, ID_tipo,`codigo_de_barras`, `volumen`  FROM `producto` p INNER JOIN tipo_producto t ON t.ID_producto = p.ID_producto; WHERE ID_producto =" + codigo + "";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, codigo);

			int rowsAffected = preparedStatement.executeUpdate();

			System.out.println("Número de filas afectadas: " + rowsAffected);
			// Cerrar los recursos
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new UnsupportedOperationException();
	}

	/**
	 * @param id
	 */
	public Producto buscarProductoId(int id) {

		try {
			String sql = "SELECT p.`ID_producto`, `nombre`, ID_tipo,`codigo_de_barras`, `volumen`  FROM `producto` p INNER JOIN tipo_producto t ON t.ID_producto = p.ID_producto; WHERE ID_producto =" + id + "";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			int rowsAffected = preparedStatement.executeUpdate();

			System.out.println("Número de filas afectadas: " + rowsAffected);
			// Cerrar los recursos
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		throw new UnsupportedOperationException();
	}

	public void listarProductos() {

	}

	@Override
	public void mostrar() {

	}

	@Override
	public String toString() {
		return "Inventario{" +
				"productos=" + productos +
				", id=" + id +
				", nombre='" + nombre + '\'' +
				", estantes=" + estantes +
				'}';
	}
}