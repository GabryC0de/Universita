import java.util.Scanner;

public class Main {
    // Scrivi un programma in C che chieda all'utente di inserire 5 numeri interi e
    // li memorizzi in un array.
    // Il programma deve calcolare e stampare la somma di tutti gli elementi
    // dell'array.
    // Esempio di funzionamento:
    // Inserisci 5 numeri: 2 4 6 8 10
    // La somma degli elementi è: 30
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserire un numero: ");

        int num = scanner.nextInt();
        int sum = num;
        for (int i = 1; i < 5; i++) {
            System.out.println("Prossimo numero: ");
            sum = sum + scanner.nextInt();
        }

        System.out.println("La somma dei numeri immessi e': " + sum);

        scanner.close();
    }
}