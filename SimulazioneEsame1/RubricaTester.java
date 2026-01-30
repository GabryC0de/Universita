// nome e cognome del candidato, matricola, data, numero della postazione

import java.util.Scanner;
import java.io.*;

public class RubricaTester {
    public static void main(String[] args) {
        // ....... da completare ............\\
		
		Rubrica rubrica1 = new Rubrica();
		Rubrica rubrica2 = new Rubrica();
			
		try{
			FileReader read = new FileReader(args[0]);
			
			Scanner scanner = new Scanner(read);
			
			while(scanner.hasNext()){
				String line = scanner.nextLine();
				
				if(line.trim().equals("")){
					continue;
				}
				
				String name = line.substring(0, line.indexOf(":")).trim();				
				String phoneStr = line.substring(line.indexOf(":") + 1, line.length()).trim();
				long phone = Long.parseLong(phoneStr);
				
				System.out.print(name + " : ");
				System.out.println(phone);
				
				rubrica1.insert((Comparable) name, phone);
			}
			read.close();
			scanner.close();
		}catch(IOException e){
			System.out.println("Il nome del file inserito non corrisponde a nessun file.");
		}
		
		
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNext()){
			
			String name = scanner.nextLine().trim();
			if(name.trim().equals("Q")){
				break;
			}
			
			try{
				if(name.equals("")){
					continue;
				}
				
				System.out.println(name);
				
				rubrica2.insert((Comparable)name, rubrica1.find((Comparable)name));
				rubrica1.remove((Comparable)name);
			} catch (MapItemNotFoundException e) {
				System.out.println("Il nome '" + name + "' non e' presente in rubrica.");
			}
		}
		
		scanner.close();
		
		try {    
			FileWriter writer = new FileWriter(args[1]);
			PrintWriter printer = new PrintWriter(writer);
			
			printer.print(rubrica2.toString());
			
			System.out.println("Salvataggio su file completato.");
			
			printer.close();

		} catch(IOException e) {
			System.out.println("Errore nella scrittura del file!");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Manca il nome del file di output negli argomenti!");
		}
    }
}

class Rubrica implements Map {
    
    // classe privata Pair: non modificare!!
    private class Pair {
        public Pair(String aName, long aPhone) {
            name = aName;
            phone = aPhone;
        }

        public String getName() {
            return name;
        }

        public long getPhone() {
            return phone;
        }

        /*
         * Restituisce una stringa contenente
         * - la nome, "name"
         * - un carattere di separazione ( : )
         * - il numero telefonico, "phone"
         */
        public String toString() {
            return name + " : " + phone;
        }

        // campi di esemplare
        private String name;
        private long phone;
    }
	
	// campi di esemplare di Rubrica ..... da completare ......

	private Pair[] pairs;
	private int pairsSize;
	private static final int DEFAULT_LENGTH = 5;
	
	public Rubrica(){
		pairs = new Pair[DEFAULT_LENGTH];
		pairsSize = 0;
	}
	
	// metodi di Rubrica ......da completare ......

    public String toString() {
		String s = "";
		for(int i = 0; i < pairsSize; i++){
			// Usa il toString() della classe Pair che hai già scritto
			s = s + pairs[i].toString() + "\n"; // Aggiunge a capo
		}
		return s;
	}
	
	public boolean isEmpty(){
		return (pairsSize == 0);
	}
	
	public void makeEmpty(){
		pairsSize = 0;
	}
	
	public void insert(Comparable key, Object value){
		if(key == null){
			throw new IllegalArgumentException("Parametro key non valido!");
		}
		if(pairsSize == pairs.length){
			pairs = resize();
		}
		
		int index = binarySearch(key);

		if (index < 0) {
			int insertPos = -(index + 1);
			
			for (int i = pairsSize; i > insertPos; i--) {
				pairs[i] = pairs[i - 1];
			}
			
			pairs[insertPos] = new Pair((String) key, (long) value);
			pairsSize++;
		} else {

			pairs[index] = new Pair((String)key, (long)value); 
		
		}
	}


	public void remove(Comparable key){
		int index = binarySearch(key);
		if(index >= 0){
			for(int i = index; i < pairsSize - 1; i++){
				pairs[i] = pairs[i + 1];
			}
			pairsSize--;
		} else {
			throw new MapItemNotFoundException();
		}
	}
	
	public Object find(Comparable key){
		int index = binarySearch(key);
		if(index >= 0){
			return (pairs[index].phone);
		} else {
			throw new MapItemNotFoundException(); 
		}
	}
	
	private int binarySearch(Object key){
		String k = (String) key;
		int high = pairsSize - 1;
		int low = 0;
				
		while(low <= high){
			int mid = (low + high) / 2;
			int cmp = pairs[mid].name.compareTo(k);
			if(cmp > 0){
				high = mid - 1;
			} else if(cmp < 0){
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -(low + 1);
	}
	
	private Pair[] resize(){
		Pair[] newPairs = new Pair[pairs.length * 2];
		System.arraycopy(pairs, 0, newPairs, 0, pairs.length);
		return newPairs;
	}
}

interface Map {
    /*
     * verifica se la mappa contiene almeno una coppia chiave/valore
     */
    boolean isEmpty();

    /*
     * Map
     * svuota la mappa
     */
    void makeEmpty();

    /*
     * Inserisce un elemento nella mappa. L'inserimento va sempre a buon fine.
     * Se la chiave non esiste la coppia key/value viene aggiunta alla mappa;
     * se la chiave esiste gia' il valore ad essa associato viene sovrascritto
     * con il nuovo valore; se key e` null viene lanciata IllegalArgumentException
     */
    void insert(Comparable key, Object value);

    /*
     * Rimuove dalla mappa l'elemento specificato dalla chiave key
     * Se la chiave non esiste viene lanciata MapItemNotFoundException
     */
    void remove(Comparable key);

    /*
     * Cerca nella mappa l'elemento specificato dalla chiave key
     * La ricerca per chiave restituisce soltanto il valore ad essa associato
     * Se la chiave non esiste viene lanciata MapItemNotFoundException
     */
    Object find(Comparable key);
}

class MapItemNotFoundException extends RuntimeException {
}