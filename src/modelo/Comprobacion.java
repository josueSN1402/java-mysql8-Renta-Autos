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

    public boolean isDouble(String text) {
        try {
            double num = Double.parseDouble(text);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
