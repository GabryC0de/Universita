// Realizzare la classe ArrayUtil che contiene al suo interno il metodo resize visto in classe, 
// con l'aggiunta della possibilita' che il valore del parametro esplicito newLength sia minore di quella dell'array. 

// In questo caso restituire un array con lo stesso contenuto (fino alla nuova dimensione) e troncato alla dimensione indicata.
// Realizzare una versione di resize che ridimensiona un array di int e una che ridimensiona un array di double
// Il nome del metodo puo' rimanere invariato. Questa proprieta' si chiama "sovraccarico".
// Il compilatore e' in grado di distinguere tra le due in base al tipo di parametro passato.

public class ArrayUtil {

    public static double[] resize(double[] oldArray, int newLength) {
        double[] newArray = new double[newLength];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = oldArray[i];
            if (i == oldArray.length - 1) {
                break;
            }
        }
        return newArray;
    }

    public static int[] resize(int[] oldArray, int newLength) {
        int[] newArray = new int[newLength];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = oldArray[i];
            if (i == oldArray.length - 1) {
                break;
            }
        }
        return newArray;
    }
}
