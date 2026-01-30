import java.util.Scanner;

public class PrintSelectedMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserire il numero del mese: ");
        String month = scanner.nextLine();

        String year = "1 Gennaio1 2 Febbraio2 3 Marzo3 4 Aprile4 5 Maggio5 6 Giugno6 7 Luglio7 8 Agosto8 9 Settembre9 10Ottobre10 11Novembre11 12Dicembre12";

        int begin = year.indexOf(month);
        int end = year.indexOf(month, begin + 1);

        System.out.println(year.substring(begin + 2, end));

        scanner.close();
    }
}
