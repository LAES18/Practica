public class Vehiculo {
    private String tipo;
    private String placa;

    public Vehiculo(String tipo, String placa) {
        this.tipo = tipo;
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPlaca() {
        return placa;
    }

    @Override
    public String toString() {
        return tipo + " con placa " + placa;
    }
}
