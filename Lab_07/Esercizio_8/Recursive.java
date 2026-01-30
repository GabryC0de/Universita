// se sulla linea di comando vengono forniti due o piu' parametri, oppure nessun parametro, il programma termina con una segnalazione di errore 
// se il parametro fornito non è un numero intero positivo, il programma termina con una segnalazione di errore
// se il parametro ricevuto e' un numero intero positivo, il programma visualizza sull'uscita la somma dei primi n numeri interi calcolata con un algoritmo ricorsivo. 

public class Recursive {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Errore: inserire un solo numero intero positivo.");
            System.exit(1);
        }

        int n;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Errore: il parametro non è un intero valido.");
            System.exit(1);
            return;
        }

        if (n <= 0) {
            System.err.println("Errore: inserire un numero intero positivo (>0).");
            System.exit(1);
        }

        System.out.println(sum(n));
    }

    private static int sum(int n) {
        if (n == 1) return 1;
        return n + sum(n - 1);
    }
}