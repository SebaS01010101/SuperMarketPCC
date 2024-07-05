package supermarketpcc.logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class Inventario implements Mostrar {

	Collection<Producto> Productos;
	private int id;
	private String nombre;
	private Connection connection;

	public Inventario() {
		this.connection = new ConexionSQL().conexionBD();
	}
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
		try {
			String sql = "SELECT p.`ID_producto`, `nombre`, ID_tipo,`codigo_de_barras`, `volumen`  FROM `producto` p INNER JOIN tipo_producto t ON t.ID_producto = p.ID_producto; WHERE ID_producto ="+nombre+"";
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
	 * 
	 * @param codigo
	 */
	public Producto buscarProductoPorCodigoBarra(String codigo) {

		try {
			String sql = "SELECT p.`ID_producto`, `nombre`, ID_tipo,`codigo_de_barras`, `volumen`  FROM `producto` p INNER JOIN tipo_producto t ON t.ID_producto = p.ID_producto; WHERE ID_producto ="+codigo+"";
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
	 * 
	 * @param id
	 */
	public Producto buscarProductoId(int id) {

		try {
			String sql = "SELECT p.`ID_producto`, `nombre`, ID_tipo,`codigo_de_barras`, `volumen`  FROM `producto` p INNER JOIN tipo_producto t ON t.ID_producto = p.ID_producto; WHERE ID_producto ="+id+"";
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

		throw new UnsupportedOperationException();
	}

	@Override
	public void mostrar() {

	}
}