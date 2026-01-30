import java.util.Scanner;

public class Main {
    // Esercizio 2: Trova il massimo in un array
    // Scrivi un programma che chieda all'utente di inserire 10 numeri interi in un
    // array e poi trovi e stampi
    // il valore massimo tra gli elementi.
    // Esempio di funzionamento:
    // Inserisci 10 numeri: 5 7 2 9 4 11 3 8 6 1
    // Il massimo valore è: 11
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserire un numero intero: ");

        int[] numbers = new int[10];

        numbers[0] = scanner.nextInt();
        for (int i = 1; i < 10; i++) {
            System.out.println("Prossimo numero: ");
            numbers[i] = scanner.nextInt();
        }

        int max = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max)
                max = numbers[i];
        }

        System.out.println("Il massimo tra i numeri immessi e': " + max);

        scanner.close();
    }
}