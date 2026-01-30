import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Interruttore toggle_1 = new Interruttore();
        Interruttore toggle_2 = new Interruttore();

        while (true) {

            System.out.print("Quale interruttore su vuole operare? (1, 2 o 0 per uscire): ");
            int toggle = scanner.nextInt();

            if (toggle == 1) {
                toggle_1.changeStatus();
                System.out.println("Interruttore 1: " + toggle_1.getStatusInterruttore());
                System.out.println("Lampadina: " + toggle_1.printStatus());
            } else if (toggle == 2) {
                toggle_2.changeStatus();
                System.out.println("Interruttore 2: " + toggle_2.getStatusInterruttore());
                System.out.println("Lampadina: " + toggle_2.printStatus());
            } else if (toggle == 0) {
                System.out.println("Programma terminato...");
                break;
            }
        }

        scanner.close();
    }

}
