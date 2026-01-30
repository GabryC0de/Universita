// "In crittografia, il cifrario di Cesare è uno dei più antichi algoritmi crittografici di cui si abbia traccia storica. 
// È un cifrario a sostituzione monoalfabetica, in cui ogni lettera del testo in chiaro è sostituita, nel testo cifrato, 
// dalla lettera che si trova un certo numero di posizioni dopo nell'alfabeto. 
// Questi tipi di cifrari sono detti anche cifrari a sostituzione o cifrari a scorrimento a causa del loro modo di operare: 
// la sostituzione avviene lettera per lettera, scorrendo il testo dall'inizio alla fine."

// cifrario di Cesare

// Esempio di cifratura con spostamento di  a destra di 3 posizioni: La A diventa una D, la B una E, e cosi’ via…

// Testo in chiaro : X Y Z A B C D E F G H I J K L M N O P Q R S T U V W
// Testo cifrato   : A B C D E F G H I J K L M N O P Q R S T U V W X Y Z

// Esempio di conversione
// FONDAMENTI DI INFORMATICA
// IRQGDPHQWL GL LQIRUPDWLFDù

// Progettare due programmi eseguibili EncodeCeasar.java e DecodeCeasar.java che codifichino e decodifichino un messaggio.

// Il programma EncodeCeasar dovra' leggere in ingresso una stringa, trasformarla tutta in lettere maiuscole (per semplicita') 
// e leggere un numero intero compreso tra 1 e 25. Il programma dovra' stampare in output la stringa codificata secondo il cifrario di Cesare
// (dovranno essere convertite solo le lettere e si assume che il cifrario sia ciclico, ovvero se devo codificare la lettera Z con scorrimento 
// 4 il risultato sara' la lettera D.

// Il programma DecodeCeasar dovra' leggere in ingresso una stringa codificata con il Cifrario di Cesare
// e un numero che indichi lo scorrimento e stampare in uscita il messaggio originale.

import java.util.Scanner;

public class EncodeCeasar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        System.out.println("Immettere un testo per la codifica: ");
        String message = scanner.nextLine().toUpperCase();

        System.out.println("Inserire la chiave di codifica(num tra 1 e 25): ");
        int key = scanner.nextInt();

        scanner.close();        
		
        System.out.println("Encoded: ");
		
		String letter = "";
		int indexOf = 0;
		
        for (int i = 0; i < message.length(); i++) {
			letter = message.substring(i, i + 1);
			indexOf = alphabet.indexOf(letter, i);
			if(message.substring(i, i + 1) == " "){
				System.out.print(" ");
				continue;			
			}	
			if((indexOf + key) > 26){			
				System.out.print(alphabet.substring((indexOf + key - 26), (indexOf + key - 25)));							
			} else {
				System.out.print(alphabet.substring((indexOf + key), (indexOf + key + 1)));
			}
        }
    }
}