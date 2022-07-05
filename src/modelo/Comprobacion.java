package modelo;

public class Comprobacion {

    public boolean esNumerico(String text) {
        try {
            int num = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
