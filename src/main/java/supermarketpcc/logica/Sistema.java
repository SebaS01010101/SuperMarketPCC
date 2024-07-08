package supermarketpcc.logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Sistema {
	Connection connection;


	public void registrarUsuario(String inputNombre, String inputUsuario, String inputContrasenia, String inputRol) {
		try {
			PreparedStatement prepareStatement = null;
			Statement statement = connection.createStatement();
			String sql = "INSERT INTO `usuario`(`nombre`, `usuario`, `contrasenia`, `ID_rol`) VALUES ('"+inputNombre+"','"+inputUsuario+"','"+inputContrasenia+"','"+inputRol+"')";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		throw new UnsupportedOperationException();
	}

	public void ingresarUsuario() {

		throw new UnsupportedOperationException();
	}

	public void eliminarUsuario() {

		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param producto
	 */
	public void registrarProducto(Producto producto) {

		throw new UnsupportedOperationException();
	}

	public void eliminarProducto() {

		throw new UnsupportedOperationException();
	}

	/**
	 * 
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