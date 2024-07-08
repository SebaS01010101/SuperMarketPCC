package supermarketpcc.logica;
import Servlet.SvProducto;

import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {
        Sistema sistema = new Sistema();
        sistema.agregarEstante();
        sistema.cargarProductosEnEstantes(1); // Cambia el ID 1 por el ID del producto que deseas agregar
        sistema.mostrarProductosEnEstantes();

    }
}
