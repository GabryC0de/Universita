public class QuadraticEquation {
    
    public double a = 0;
    public double b = 0;
    public double c = 0;

    /*
     * Costruttore: riceve i coefficienti a, b, c dell'equazione quadratica
     * e inizializza i campi di esemplare secondo i valori ricevuti
     */
    public QuadraticEquation(double acoeff, double bcoeff, double ccoeff) {
        a = acoeff;
        b = bcoeff;
        c = ccoeff;
    }

    /*
     * Restituisce la prima delle due soluzioni dell'equazione quadratica,
     * usando la ben nota formula...
     */
    public double getSolution1() {
        return (-b + (Math.sqrt(Math.pow(b, 2) - 4 * a * c))) / 2;
    }

    /*
     * Restituisce la seconda delle due soluzioni dell'equazione quadratica,
     * usando la ben nota formula...
     */
    public double getSolution2() {
        return (-b - (Math.sqrt(Math.pow(b, 2) - 4 * a * c))) / 2;
    }

    /*
     * Restituisce il numero di soluzioni che ha l'equzione
     */
    public int hasSolutions() {
        double solution = Math.pow(a, 2) - 4 * a * c;
        if (solution > 0) {
            return 2;
        } else if (solution == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /*
     * Offre la possibilità di scegliere uno dei coefficienti
     * e di assegnargli un nuovo valore
     */

    public void editEquation(char coeff, double newCoeff) {
        switch (coeff) {
            case 'a':
                a = newCoeff;
            case 'b':
                b = newCoeff;
            case 'c':
                c = newCoeff;
            default:
                System.out.println("Il coefficiente inserito non è valido!");
        }
    }
}