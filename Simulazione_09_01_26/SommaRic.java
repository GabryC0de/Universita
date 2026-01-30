// Cinzia Pizzi 123456
import java.util.*;

public class SommaRic{
	
	public static void main(String[] args){
	
		// leggere stringa input	
		// invocare il metodo per fare sommma dei numeri		
		// stampare il risultato
	
		String s;
		Scanner console = new Scanner(System.in);
		System.out.println("Inserire una stringa");
		s = console.nextLine();		
		
		System.out.println(sommaNumeriRic2(s));
		
		console.close();
	
	}
		
	public static int sommaNumeriRic(String s){
	
		// verifica pre-condizioni
		if(s==null){
			throw new IllegalArgumentException();
		}
		
		// caso base
		if(s.length()==0){ // if (s.equals("")){
			return 0;
		}
		
		// primo carattere della stringa
		char c = s.charAt(0);
		
		// se e' un numero lo sommo e invoco il metodo sulla
		// parte restante della stringa. NB: essendo un carattere
		// il suo valore e' quello del codice ASCII. Devo sottrarre
		// il valore del carattere '0' (che e' 48) per ottenere
		// il valore numerico da 0 a 9.
		if(c>='0' && c<='9'){
			return (c-'0')+sommaNumeriRic(s.substring(1));
		}
		else{
			return sommaNumeriRic(s.substring(1));
		}
	
	}
	
	
	// Soluzione alternativa che estrae il primo carattere come
	// stringa e poi usa i metodi di conversione tra stringhe e 
	// interi
	public static int sommaNumeriRic2(String s){
	
		if(s==null){
			throw new IllegalArgumentException();
		}
		
		// caso base
		if(s.length()==0){ // if (s.equals("")){
			return 0;
		}
		
		String c = s.substring(0,1);
		
		try{
			int value = Integer.parseInt(c);
			return value + sommaNumeriRic2(s.substring(1));
			
		}	
		catch(NumberFormatException e){
			return sommaNumeriRic2(s.substring(1));
		}
		
	}
	
	
	
	
	
}