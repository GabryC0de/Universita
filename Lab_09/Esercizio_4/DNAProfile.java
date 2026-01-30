import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class DNAProfile {
    public static void main(String[] args) {
        // La prima posizione dell'array contiene l'intestazione del file "sospetti.txt"
        String[][] data = new String[2][2];
        // Contiene solo le STR dell'intestazione
        String[] str = new String[3];
        try {
            // Lettura del contenuto del file sospetti.txt
            FileReader reader = new FileReader(args[0]);
            Scanner scanner = new Scanner(reader);

            String intestation = scanner.nextLine();

            int start = 0;
            int lastIndexOf = 0;
            int end = 0;
            while (lastIndexOf != -1) {
                end = intestation.indexOf(" ", lastIndexOf);
                str[start] = intestation.substring(start, intestation.indexOf(" "));
            }

            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                start = s.indexOf(" ", lastIndexOf);
                data[start][0] = s.substring();
                lastIndexOf = start;

            }
            reader.close();
            scanner.close();
        } catch (IOException e) {
            System.out.println("Errore: " + e);
        }
    }

    public static String[] resize(String[] oldArray, int newLength) {
        String[] newArray = new String[newLength];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = oldArray[i];
            if (i == oldArray.length - 1) {
                break;
            }
        }
        return newArray;
    }
}
