import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

/**
 * StudentManager: programma eseguibile che gestisce un elenco di studenti.
 *
 * Funzionalita`:
 * - Legge righe di input contenenti: nome voto_scritto voto_orale
 *   (termina quando viene inserita una riga vuota o EOF). Se viene passato
 *   un argomento in linea di comando, viene interpretato come nome file da
 *   cui leggere i dati.
 * - Poi entra in un ciclo di comandi:
 *   - Q : termina
 *   - S : chiede il nome dello studente e mostra la media aritmetica
 *         fra i due voti (scritto e orale) se lo studente esiste
 *   - comandi diversi: segnala errore
 *
 * Nota: per semplicita` il campo usato per cercare e` il "nome" (cognome
 * suggerito dall'esercizio — i dati di esempio hanno il nome prima).
 */
public class StudentManager {
    public static void main(String[] args) {
        // Usiamo un array semplice per memorizzare gli studenti (non ArrayList)
        Student[] students = new Student[10];
        int studentCount = 0;

        Scanner inputScanner = null;
        boolean readingFromStdin = (args.length == 0);
        try {
            if (readingFromStdin) {
                inputScanner = new Scanner(System.in);
                System.out.println("Inserire record studenti (nome scritto orale). Riga vuota per terminare.");
            } else {
                inputScanner = new Scanner(new File(args[0]));
                System.out.println("Lettura da file: " + args[0]);
            }

            // Lettura dei record: una riga per studente, campi separati da spazi
            while (true) {
                if (!inputScanner.hasNextLine()) break;
                String line = inputScanner.nextLine().trim();
                if (line.isEmpty()) break; // riga vuota termina l'inserimento

                String[] parts = line.split("\\s+");
                if (parts.length < 3) {
                    System.out.println("Riga non valida (attesi 3 campi): " + line);
                    continue;
                }

                String name = parts[0];
                try {
                    int written = Integer.parseInt(parts[1]);
                    int oral = Integer.parseInt(parts[2]);
                    // aggiungi l'oggetto Student nell'array, espandendo se necessario
                    Student st = new Student(name, written, oral);
                    if (studentCount >= students.length) {
                        // raddoppia la capacita`
                        Student[] tmp = new Student[students.length * 2];
                        System.arraycopy(students, 0, tmp, 0, students.length);
                        students = tmp;
                    }
                    students[studentCount++] = st;
                } catch (NumberFormatException nfe) {
                    System.out.println("Voti non validi nella riga: " + line);
                }
            }

            // Ciclo comandi: se l'input iniziale proveniva da stdin, riutilizziamo
            // lo stesso scanner per i comandi; altrimenti creiamo un nuovo scanner
            Scanner cmdScanner = readingFromStdin ? inputScanner : new Scanner(System.in);

            boolean running = true;
            while (running) {
                System.out.print("Inserire comando (Q per uscire, S per cerca): ");
                if (!cmdScanner.hasNextLine()) break;
                String cmd = cmdScanner.nextLine().trim();
                if (cmd.isEmpty()) continue;
                cmd = cmd.toUpperCase();

                switch (cmd) {
                    case "Q":
                        System.out.println("Terminazione programma.");
                        running = false;
                        break;
                    case "S":
                        System.out.print("Inserire nome dello studente da cercare: ");
                        if (!cmdScanner.hasNextLine()) break;
                        String query = cmdScanner.nextLine().trim();
                        if (query.isEmpty()) {
                            System.out.println("Nome vuoto.");
                            break;
                        }
                        Student found = findStudentByName(students, studentCount, query);
                        if (found != null) {
                            System.out.printf("Voto finale di %s = %.2f%n", found.getName(), found.getAverage());
                        } else {
                            System.out.println("Cognome errato o studente non presente.");
                        }
                        break;
                    default:
                        System.out.println("Comando errato. Usare Q o S.");
                }
            }

            if (!readingFromStdin) {
                cmdScanner.close();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File non trovato: " + e.getMessage());
        } finally {
            // Chiudiamo lo scanner iniziale solo se non leggeva da System.in
            if (inputScanner != null && !readingFromStdin) {
                inputScanner.close();
            }
        }
    }
    /** Cerca uno studente per nome (case-insensitive) nell'array fino a count */
    private static Student findStudentByName(Student[] students, int count, String name) {
        for (int i = 0; i < count; i++) {
            Student s = students[i];
            if (s != null && s.getName().equalsIgnoreCase(name)) return s;
        }
        return null;
    }
}
