import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class LinkedListTester{
	public static void main(String[] args){
		
		LinkedList data = new LinkedList();
		Random random = new Random();
		Scanner scan = new Scanner(System.in);
		
		int rnd = (int) (random.nextDouble() * 101);
		
		int num = 0;
		boolean flag = false;
		while(!flag){
			try{
				System.out.println("Inserire un numero intero: ");
				num = scan.nextInt();
				flag = true;
			}catch(InputMismatchException e){
				System.out.println("Valore inserito non valido, riprovare!");
				scan.nextLine();
			}		
		}
		
		for(int i = 0; i < num; i++){
			int insNum = (int)(random.nextDouble() * 101);
			
			if(i == 0 || i % 2 == 0)
				data.addFirst(insNum);
			else 
				data.addLast(insNum);
			
			System.out.print("Numero: ");
			System.out.println(insNum);
			System.out.print("Lista: \t");
			System.out.println(data.toString());
		}
		
		
		boolean flag2 = false;
		int thousandNum = 0;

		while (!flag2) {
			try {
				System.out.println("Dopo quale valore si desidera inserire il numero \"1000\"?");
				thousandNum = scan.nextInt();
				
				// CREO L'ITERATORE QUI DENTRO: così ogni tentativo riparte da capo
				ListIterator it = data.getIterator();
				boolean found = false; 

				while (it.hasNext()) {
					// Cast a Integer perché la lista restituisce Object
					if (it.next().equals(thousandNum)) {
						it.add(1000);
						flag2 = true;
						found = true;
						break; // Esci dal while interno se lo hai trovato
					}
				}

				if (!found) {
					System.out.println("Valore non esistente!");
					// Non serve lanciare l'eccezione se vuoi solo mostrare un messaggio e riprovare
				}

			} catch (InputMismatchException e) {
				System.out.println("Valore inserito non valido, riprovare!");
				scan.nextLine(); // Pulisci il buffer dello scanner
			}
		}
		
		System.out.print("Lista post 1000: \t");
		System.out.println(data.toString());
		
		
		boolean flag3 = false;
		int rmvNum = 0;

		while (!flag3) {
			try {
				System.out.println("Quale valore si desidera eliminare?");
				rmvNum = scan.nextInt();
				
				// CREO L'ITERATORE QUI DENTRO: così ogni tentativo riparte da capo
				ListIterator it = data.getIterator();
				boolean found = false; 

				while (it.hasNext()) {
					// Cast a Integer perché la lista restituisce Object
					if (it.next().equals(rmvNum)) {
						it.remove();
						flag3 = true;
						found = true;
						break; // Esci dal while interno se lo hai trovato
					}
				}

				if (!found) {
					System.out.println("Valore non esistente!");
					// Non serve lanciare l'eccezione se vuoi solo mostrare un messaggio e riprovare
				}

			} catch (InputMismatchException e) {
				System.out.println("Valore inserito non valido, riprovare!");
				scan.nextLine(); // Pulisci il buffer dello scanner
			}
		}
		
		System.out.print("Lista post remove: \t");
		System.out.println(data.toString());
		
		System.out.print("Lista dopo remove first: \t");
		data.removeFirst();
		System.out.println(data.toString());
		System.out.print("Lista dopo remove last: \t");
		data.removeLast();
		System.out.println(data.toString());
	}
}