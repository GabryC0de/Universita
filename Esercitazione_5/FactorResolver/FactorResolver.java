/*
Scrivere una classe eseguibile che invii a standard output la scomposizione in fattori primi del numero intero n > 1. Il numero n sia acquisito da standard input.

Esempi:

- se n = 24 viene inviata a standard output la stringa

24 = 2 * 2 * 2 * 3

- se n = 13 (numero primo) viene inviata a standard output la stringa

13 = 1 * 13

- se n = 1234567 viene inviata a standard output la stringa

1234567 = 1 * 127 * 9721

Scaricare il bytecode FactorResolver.class ed eseguire la classe.

Codificare una classe che si comporti allo stesso modo.
*/

import java.util.Scanner;

public class FactorResolver{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Inserire un numero intero da fattorizzare: ");
		int initialNumber = scanner.nextInt();
				
		scanner.close();
				
		int divider = 2;
		int number = initialNumber;
		int current_div_count = 0;
		
		boolean found = false;
		
		for(int i = 2; i < initialNumber; i++){
			if((initialNumber % i== 0) && (initialNumber != i)){
				found = true;
				break;
			}
		}
		
		if(!found){
			System.out.println("1 * " + initialNumber);
			return;
		}
		
		while(true){			
			// controllo se il numero è divisibile per l'attuale contatore
			if(number % divider == 0){
				// aumento il numero di volte per cui è divisibile
				current_div_count++;
				// divido il numero per il contatore
				number /= divider;								
			} else {
				// quando il numero non è più divisibile stampo quante volte è stato diviso e resetto il numero di volte per il prossimo contatore
				for(int i = 0; i < current_div_count; i++){
					System.out.print(divider + " * ");
				}
				
				current_div_count = 0;
				
				// aumento il divisore oer il ciclo dopo				
				divider++;

				// se il divisore è arrivato alla grandezza del numero originale vuol dire che ho raggiunto il mio obiettivo
				if(divider == initialNumber){
					break;
				}
			}
			
		}
		
	}
}