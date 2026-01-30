public class Interruttore {

    public static boolean light = false;
    private boolean status;
    // Costruttore: inizializza l'interruttore in stato "down". Assumiamo "down"
    // corrisponda a false e "up" a true

    public Interruttore() {
        status = false;
    }

    // Metodo di accesso della variabile di esemplare interruttore
    public boolean getStatusInterruttore() {
        return status;
    }

    // Metodo di accesso alla variabile statica lampadina
    public boolean isBulbOn() {
        return light;
    }

    // Modificatore: cambia lo stato dell'interruttore (e della lampadina!)
    public void changeStatus() {
        status = !status;
        light = !light;
    }

    // Stampa lo stato dell'interruttore: up/down a seconda che status sia true o
    // false
    public String printStatus() {
        if (light)
            return "On";
        else
            return "Off";
    }
}