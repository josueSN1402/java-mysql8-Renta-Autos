package tables;

import java.util.Date;

public class Reservas {

    private int cod_Reserva;
    private Date fecha_inicio_res;
    private Date fecha_final_res;
    private double precio_acordado;

    private String dni;
    private int cod_Ofi_1_r;
    private int cod_Ofi_2_r;
    private String modelo;

    public int getCod_Reserva() {
        return cod_Reserva;
    }

    public void setCod_Reserva(int cod_Reserva) {
        this.cod_Reserva = cod_Reserva;
    }

    public Date getFecha_inicio_res() {
        return fecha_inicio_res;
    }

    public void setFecha_inicio_res(Date fecha_inicio_res) {
        this.fecha_inicio_res = fecha_inicio_res;
    }

    public Date getFecha_final_res() {
        return fecha_final_res;
    }

    public void setFecha_final_res(Date fecha_final_res) {
        this.fecha_final_res = fecha_final_res;
    }

    public double getPrecio_acordado() {
        return precio_acordado;
    }

    public void setPrecio_acordado(double precio_acordado) {
        this.precio_acordado = precio_acordado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getCod_Ofi_1_r() {
        return cod_Ofi_1_r;
    }

    public void setCod_Ofi_1_r(int cod_Ofi_1_r) {
        this.cod_Ofi_1_r = cod_Ofi_1_r;
    }

    public int getCod_Ofi_2_r() {
        return cod_Ofi_2_r;
    }

    public void setCod_Ofi_2_r(int cod_Ofi_2_r) {
        this.cod_Ofi_2_r = cod_Ofi_2_r;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
