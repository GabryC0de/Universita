// Progettare il programma TwoNumbers che chieda all'utente di inserire due numeri reali e ne visualizzi (senza usare la classe Math):

//     •    la somma
//     •    il prodotto
//     •    il valore medio
//     •    il valore massimo
//     •    il valore minimo
//     •    il valore assoluto della differenza

import java.util.Scanner;

public class TwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("inserire il primo numero reale: ");
        float num_1 = scanner.nextFloat();
        System.out.println("inserire il secondo numero reale: ");
        float num_2 = scanner.nextFloat();

        scanner.close();

        System.out.println("somma:      " + (num_1 + num_2));
        System.out.println("prodotto:   " + (num_1 * num_2));
        System.out.println("media:      " + ((num_1 + num_2) / 2));

        System.out.print("Massimo:    ");
        if (num_1 > num_2) {
            System.out.println(num_1);
            System.out.println("Minimo:    " + num_2);
        } else {
            System.out.println(num_2);
            System.out.println("Minimo:    " + num_1);
        }

        System.out.print("Differenza assoluta: ");
        if ((num_1 - num_2) < 0) {
            System.out.println(-(num_1 - num_2));
        } else {
            System.out.println(num_1 - num_2);
        }
    }
}
