// - Riceva dall'input standard due nomi di file di testo, uno in lettura e uno in scrittura
// - Apra in lettura il primo file e ne legga il contenuto
// - Crei e apra in scrittura il secondo file
// - Copi nel secondo file il contenuto del primo, opportunamente modificato in modo che tutte le parole abbiano la prima lettera maiuscola e le seguenti minuscole
// Provare il programma usando il file vispateresa.txt come file di input e creando (ad esempio) il file vispateresa2.txt in output.
// Approfondimento: modificare il programma in modo che riconosca come due parole distinte anche quelle separate da un apostrofo. Ad esempio, se il file in lettura contiene le parole 

// LA vispA teresa AVEA tra l'erBETTa
// al termine dell'esecuzione il secondo file dovra` contenere il testo

// La Vispa Teresa Avea Tra L'Erbetta
// Suggerimento importante: studiare la documentazione di Scanner, e verificare che usando opportuni metodi è possibile usare un insieme di caratteri delimitatori diverso da quello di default.

import java.util.InputMismatchException;
import java.util.Scanner;

public class CapsCopier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "";
        do {
            try {
                String line = scanner.nextLine();
                text += line.toLowerCase();
            } catch (InputMismatchException e) {
                System.out.println("Input non valido!");
            }
        } while (scanner.hasNext());

        scanner.close();
        text = text.substring(0, 1).toUpperCase() + text.substring(1, text.length());
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ' || text.charAt(i) == '\'') {
                text = text.substring(0, i + 1) + text.substring(i + 1, i + 2).toUpperCase()
                        + text.substring(i + 2, text.length());
            }
        }
        System.out.println(text);
    }

}
