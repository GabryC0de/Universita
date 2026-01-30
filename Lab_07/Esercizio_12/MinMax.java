// Scrivere una classe eseguibile che

// riceve da riga di comando due numeri interi dim e n;
// crea un array di dimensione dim, contenente numeri interi casuali compresi
// tra 1 e n, e lo visualizza a standard output;
// cerca il valore minimo tra quelli contenuti nell'array, tramite un algoritmo
// ricorsivo.
// Si consiglia di scrivere un metodo ricorsivo statico che effettui la ricerca
// e che restituisca un numero intero >= 0
// rappresentante il valore minimo trovato.

// Suggerimento: in alternativa al metodo Math.random(), si puo` utilizzare il
// metodo con firma int nextInt(int k) della classe
// java.util.Random. Prima di usarlo leggere attentamente l'interfaccia pubblica
// della classe java.util.Random.

// Provare a creare l'oggetto Random sia con il suo costruttore senza parametri,
// che con quello che ha come parametro un seed (un intero long).
// Verificare che nel secondo caso, anche eseguendo il programma piu' volte la
// sequenza generata con lo stesso seed e' sempre la stessa,
// mentre con il costruttore senza parametri no.

public class MinMax {
    public static int arrayMin(int min, int index, int[] arr) {
        if (index == arr.length)
            return min;
        if (arr[index] < min) {
            return arrayMin(arr[index], index + 1, arr);
        }
        return arrayMin(min, index + 1, arr);
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Numero di parametri incorretto!");
            System.exit(0);
        }

        try {
            int dim = Integer.parseInt(args[0]);
            int n = Integer.parseInt(args[1]);
            int[] arr = new int[dim];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = 1 + (int) (Math.random() * (n + 1));
            }

            System.out.println(arrayMin((int) Double.POSITIVE_INFINITY, 0, arr));
        } catch (NumberFormatException e) {
            System.err.println("I parametri inseriti non sono validi!");
            System.exit(0);
        }
    }
}
