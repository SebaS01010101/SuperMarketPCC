package supermarketpcc.logica;

public class Usuario implements Mostrar {

	private String nombre;
	private String usuario;
	private String contrasenia;
	private String rol;

	public Usuario(String nombre, String usuario, String contrasenia, String rol) {
		this.nombre = nombre;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.rol = rol;
	}

	@Override
	public void mostrar() {

	}
}