import java.util.Scanner;

public class Main {
    // Esercizio 3: Conta numeri pari e dispari in un array
    // Scrivi un programma che prenda in input un array di 10 numeri interi inseriti
    // dall'utente e poi conti e
    // stampi quanti di questi numeri sono pari e quanti sono dispari.
    // Esempio di funzionamento:
    // Inserisci 10 numeri: 2 3 4 5 6 7 8 9 10 11
    // Numeri pari: 5
    // Numeri dispari: 5
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserire un numero intero: ");

        int[] numbers = new int[10];

        numbers[0] = scanner.nextInt();
        for (int i = 1; i < 10; i++) {
            System.out.println("Prossimo numero: ");
            numbers[i] = scanner.nextInt();
        }

        int fair = 0;
        int odd = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0)
                fair++;
            else
                odd++;
        }

        System.out.println("I numeri pari immessi sono: " + fair);
        System.out.println("I numeri dispari immessi sono: " + odd);

        scanner.close();
    }
}