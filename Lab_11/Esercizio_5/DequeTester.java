import java.util.Scanner;

public class DequeTester {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		ArrayDeque uno = new ArrayDeque();
		ArrayDeque due = new ArrayDeque();
		ArrayDeque tre = new ArrayDeque();
		
		for(int i = 0; i < 10; i++){
			System.out.println("Inserire un numero intero: ");
			uno.addLast(scanner.nextInt());
		}
		System.out.println("Coda uno: ");
		scanner.close();
		System.out.println(uno.toString());
		
		for(int i = 0; i < uno.size() + due.size(); i++){
			due.addFirst(uno.removeLast());
		}
		System.out.println("Dalla uno alla due: ");
		System.out.println(uno.toString());
		System.out.println(due.toString());
		
		for(int i = 0; i < due.size() + tre.size(); i++){
			tre.addLast(due.removeFirst());
		}
		
		System.out.println("Dalla due alla tre: ");
		System.out.println(due.toString());
		System.out.println(tre.toString());
		
		for(int i = 0; i < 10; i++){
			tre.removeLast();
		}
		System.out.println("Tutto vuoto: ");
		System.out.println(uno.toString());
		System.out.println(due.toString());
		System.out.println(tre.toString());	
	}
}

//crei tre esemplari della classe ArrayDeque di nome uno, due e tre
//legga dall'ingresso standard una sequenza di numeri interi (uno per riga) e li inserisca alla fine della coda uno (con addLast)
//svuoti la coda uno dalla fine (con removeLast) trasferendone il contenuto all'inizio della coda due (con addFirst)
//svuoti la coda due dall'inizio (con removeFirst) inserendo i dati alla fine della coda tre
//svuoti infine la coda tre dall'inizio scrivendo i dati sull'uscita standard, uno per riga.