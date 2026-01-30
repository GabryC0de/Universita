import java.util.Scanner;

// Esercizio 4: Ricerca di un numero in un array
// Scrivi un programma che permetta all'utente di inserire un array di 8 numeri interi. Il programma poi
// chiede un numero da cercare nell'array e informa l'utente se il numero è presente e in quale posizione.
// Esempio di funzionamento:
// Inserisci 8 numeri: 3 7 8 2 5 9 1 4
// Inserisci un numero da cercare: 5
// Numero trovato nella posizione: 4

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];

        System.out.println("Inserire un numero intero: ");
        numbers[0] = scanner.nextInt();

        for (int i = 1; i < 8; i++) {
            System.out.println("Inserire il prossimo numero: ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Inserire il numero da cercare: ");
        int ref = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == ref) {
                found = !found;
                System.out.println("Numero trovato in posizione " + (i + 1));
                break;
            }
        }
        if(!found){
            System.out.println("Il numero immesso non esiste");
        }

        scanner.close();
    }

}
