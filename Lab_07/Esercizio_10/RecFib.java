import java.util.Scanner;
import java.util.InputMismatchException;

// Scrivere una classe eseguibile RecFib.java il cui metodo main riceva un numero intero dalla riga di comando,
//  oppure (nel caso in cui non vengano forniti argomenti sulla riga di comando) chieda all'utente un numero intero n
// visualizzi l'n-esimo numero di Fibonacci, calcolato usando un algoritmo ricorsivo
public class RecFib {

    public static int[] fib = { 1, 2 };
    public static int num;

    public static int RecursiveFib(int[] fib, int count) {

        if (num == 1) {
            return 1;
        } else if (num == 0) {
            return 0;
        } else {
            if (count > 0) {
                int previousFib = fib[1];
                fib[1] += fib[0];
                fib[0] = previousFib;
                count--;
                return RecursiveFib(fib, count);
            } else {
                return fib[1];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserire un numero intero maggiore di 0: ");
        boolean inputValido = false;
        while (!inputValido) {
            System.out.println("Inserire un numero intero maggiore di 0: ");
            try {
                num = scanner.nextInt();
                if (num > 0) {
                    inputValido = !inputValido;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
        }
        scanner.close();
        long start = System.nanoTime();
        System.out.println(RecursiveFib(fib, num - 3));
        long end = System.nanoTime();
        System.out.println("Time: " + (end - start) + " milliseconds");
    }
}

// Scrivere una classe eseguibile IterFib.java il cui metodo main riceva un
// numero intero dalla riga di comando,
// oppure (nel caso in cui non vengano forniti argomenti sulla riga di comando)
// chieda all'utente un numero intero n
// visualizzi l'n-esimo numero di Fibonacci, calcolato usando un algoritmo
// iterativo

// Si consiglia di scrivere due metodi ausiliari statici, recursiveFib e
// iterativeFib,
// invocati da ciascun metodo main della rispettiva classe per realizzare il
// comportamento sopra indicato.
// Entrambi i metodi ricevono un parametro n di tipo int e (dopo aver verificato
// la pre-condizione che n non sia negativo)
// restituiscono un valore di tipo long che rappresenta l'n-esimo numero Fib( n
// ) nella sequenza di Fibonacci.

// Il metodo recursiveFib calcola il valore da restituire usando la ricorsione
// doppia, implementando direttamente la definizione della serie
// Il metodo iterativeFib deve calcolare il valore da restituire senza usare la
// ricorsione e senza usare strutture dati
// di memorizzazione (ossia senza array, ma usando soltanto variabili semplici).
// Nei metodi main invocare System.currentTimeMillis() prima e dopo la chiamata
// al metodo statico e riportare il tempo di esecuzione.
// Se i tempi non dovessero essere rilevabili in termini di millisecondi potete
// utilizzare il metodo System.nanoTime()

// Provare a lanciare i due programmi piu' volte (giusto per vedere che i tempi
// sono simili ma non necessariamente uguali per uno stesso algoritmo e uno
// stesso n, specie al crescere di n) su input crescente.

// Verificare la differenza nell'andamento dei tempi di esecuzione tra i due
// algoritmi.