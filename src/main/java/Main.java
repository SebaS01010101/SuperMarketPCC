public class Main {
    public static void main(String[] args) {
        ConexionSQL conexionSQL = new ConexionSQL();
        conexionSQL.conexionBD();
        conexionSQL.obtenerProducto();
    }
}
