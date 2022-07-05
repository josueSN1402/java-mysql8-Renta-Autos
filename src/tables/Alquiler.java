package tables;

import java.util.Date;

public class Alquiler {

    private int cod_Alquiler;
    private Date fecha_inicio_al;
    private Date fecha_final_al;
    private String dni;
    private int cod_Ofi_1_a;
    private int cod_Ofi_2_a;
    private String num_matricula;
    private int cod_reserva;

    public int getCod_Alquiler() {
        return cod_Alquiler;
    }

    public void setCod_Alquiler(int cod_Alquiler) {
        this.cod_Alquiler = cod_Alquiler;
    }

    public Date getFecha_inicio_al() {
        return fecha_inicio_al;
    }

    public void setFecha_inicio_al(Date fecha_inicio_al) {
        this.fecha_inicio_al = fecha_inicio_al;
    }

    public Date getFecha_final_al() {
        return fecha_final_al;
    }

    public void setFecha_final_al(Date fecha_final_al) {
        this.fecha_final_al = fecha_final_al;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getCod_Ofi_1_a() {
        return cod_Ofi_1_a;
    }

    public void setCod_Ofi_1_a(int cod_Ofi_1_a) {
        this.cod_Ofi_1_a = cod_Ofi_1_a;
    }

    public int getCod_Ofi_2_a() {
        return cod_Ofi_2_a;
    }

    public void setCod_Ofi_2_a(int cod_Ofi_2_a) {
        this.cod_Ofi_2_a = cod_Ofi_2_a;
    }

    public String getNum_matricula() {
        return num_matricula;
    }

    public void setNum_matricula(String num_matricula) {
        this.num_matricula = num_matricula;
    }

    public int getCod_reserva() {
        return cod_reserva;
    }

    public void setCod_reserva(int cod_reserva) {
        this.cod_reserva = cod_reserva;
    }
}
