import java.util.Scanner;

// Esercizio 5: Prodotto scalare di due array
// Scrivi un programma in C che chieda all'utente di inserire due array di 5 numeri ciascuno. Il
// programma deve calcolare il prodotto scalare dei due array e stampare il risultato.
// Esempio di funzionamento:
// Inserisci il primo array (5 numeri): 1 2 3 4 5
// Inserisci il secondo array (5 numeri): 6 7 8 9 10
// Il prodotto scalare è: 130

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr1 = new int[5];
        int[] arr2 = new int[5];

        System.out.println("Inserire i numeri del primo insieme: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(i + 1 + ": ");
            arr1[i] = scanner.nextInt();
            System.out.println("");
        }

        System.out.println("Inserire i numeri del secondo insieme: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(i + 1 + ": ");
            arr2[i] = scanner.nextInt();
            System.out.println("");
        }
        float scalare = 0;
        for (int i = 0; i < arr1.length; i++) {
            scalare += arr1[i] * arr2[i];
        }
        System.out.println("Il prodotto scalare dei due insiemi e': " + scalare);
    }

}
