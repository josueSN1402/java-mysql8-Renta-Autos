package tables;

public class Modelos {

    private String cod_Modelo;
    private int potencia;
    private String marca;
    private int precio;

    public String getCod_Modelo() {
        return cod_Modelo;
    }

    public void setCod_Modelo(String cod_Modelo) {
        this.cod_Modelo = cod_Modelo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
