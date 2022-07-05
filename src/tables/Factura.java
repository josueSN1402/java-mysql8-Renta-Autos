package tables;

import java.util.Date;

public class Factura {

    private int num_Factura;
    private Date fecha;
    private double total;
    private double precio;
    private double igv;
    private String dni;
    private int cod_Alquiler;

    public int getNum_Factura() {
        return num_Factura;
    }

    public void setNum_Factura(int num_Factura) {
        this.num_Factura = num_Factura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getCod_Alquiler() {
        return cod_Alquiler;
    }

    public void setCod_Alquiler(int cod_Alquiler) {
        this.cod_Alquiler = cod_Alquiler;
    }
}
