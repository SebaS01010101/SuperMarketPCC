package supermarketpcc.logica;

public class Bebestible extends Alimento {

    private String tipo;


    public Bebestible(int id, String nombre, String codigoBarras, Double volumen, String tipo) {
        super(id, nombre, codigoBarras, volumen);
        this.tipo = tipo;
    }


    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Bebestible{" + (super.toString()) +
                "tipo='" + tipo + '\'' +
                '}';
    }
}