package supermarketpcc.logica;

import Servlet.SvProducto;

import java.sql.*;
import java.util.*;

public class Sistema {

    private Inventario inventario;
    private SvProducto svProducto;
    private Connection connection;

    public Sistema() {
        this.inventario = new Inventario(1, "Inventario Principal");
        this.svProducto = new SvProducto();
        this.connection = new ConexionSQL().conexionBD();
    }

    public void agregarEstante() {
        inventario.agregarEstante("No Alimento", new Estante(1, "Estante No Alimento", "No Alimento", 100));
        inventario.agregarEstante("Alimento", new Estante(2, "Estante Alimento", "Alimento", 200));
        inventario.agregarEstante("Congelados", new Estante(3, "Estante Congelados", "Congelados", 150));
        inventario.agregarEstante("Bebestibles", new Estante(4, "Estante Bebestibles", "Bebestibles", 120));
        inventario.agregarEstante("Frutas y Verduras", new Estante(5, "Estante Frutas y Verduras", "Frutas y Verduras", 180));
    }

    public void agregarProductoEstante(Producto producto, String tipoEstante) {
        Estante estante = inventario.obtenerEstante(tipoEstante);
        if (estante != null) {
            estante.agregarProducto(producto);
        } else {
            System.out.println("Estante de tipo " + tipoEstante + " no existe.");
        }
    }

    public void cargarProductosEnEstantes(int id) {

        Producto producto = buscarProductoPorId(id);

        if(producto != null){
            Map<Class<? extends Producto>, String> tipoEstanteMap = new HashMap<>();
            tipoEstanteMap.put(Congelado.class, "Congelados");
            tipoEstanteMap.put(FrutaVerdura.class, "Frutas y Verduras");
            tipoEstanteMap.put(Bebestible.class, "Bebestibles");
            tipoEstanteMap.put(Alimento.class, "Alimento");
            tipoEstanteMap.put(NoAlimento.class, "No Alimento");

            String tipoEstante = tipoEstanteMap.get(producto.getClass());

            if (tipoEstante != null) {
                Estante estante = obtenerEstante(tipoEstante);
                if (estante != null) {
                    estante.agregarProducto(producto);
                } else {
                    System.out.println("Estante de tipo " + tipoEstante + " no existe.");
                }
            } else {
                System.out.println("Tipo de producto desconocido: " + producto.getNombre());
            }
        }

    }

    public Estante obtenerEstante(String tipoEstante) {
        return inventario.obtenerEstante(tipoEstante);
    }
    public void mostrarProductosEnEstantes() {
        inventario.mostrarProductosEnEstantes();
    }

    //intento para jsp seba
    public List<Producto> obtenerProductos(String tipoEstante) {
        return inventario.obtenerProductos(tipoEstante);
    }

    public Producto buscarProductoPorId(int id) {
        List<Producto> productos = svProducto.obtenerProductos();

        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        System.out.println("Producto con ID " + id + " no encontrado.");
        return null;
    }

    public void agregarProductoBodega(Producto producto) {
        Bodega bodega = new Bodega(1, "Bodega Principal");
        bodega.agregarProducto(producto);
    }

    public boolean ingresarUsuario(String imputUsuario, String inputContrasenia) {
        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM usuario WHERE usuario='"+imputUsuario+"' AND contrasenia='"+inputContrasenia+"' ";
            statement.executeQuery(sql);
            if (statement.getResultSet().next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void registrarUsuario(String inputNombre, String inputUsuario, String inputContrasenia, String inputRol) {
        try {
            PreparedStatement prepareStatement = null;
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO usuario(nombre, usuario, contrasenia, ID_rol) VALUES ('"+inputNombre+"','"+inputUsuario+"','"+inputContrasenia+"','"+inputRol+"')";
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
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
