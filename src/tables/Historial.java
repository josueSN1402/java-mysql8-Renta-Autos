package tables;

public class Historial {

    private int cod_Historial;
    private String descripcion;
    private String num_matricula;
    private int cod_alquiler;

    public int getCod_Historial() {
        return cod_Historial;
    }

    public void setCod_Historial(int cod_Historial) {
        this.cod_Historial = cod_Historial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNum_matricula() {
        return num_matricula;
    }

    public void setNum_matricula(String num_matricula) {
        this.num_matricula = num_matricula;
    }

    public int getCod_alquiler() {
        return cod_alquiler;
    }

    public void setCod_alquiler(int cod_alquiler) {
        this.cod_alquiler = cod_alquiler;
    }
}
