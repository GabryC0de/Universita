// nome e cognome del candidato, matricola, data, numero della postazione

import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.*;

public class TraduttoreTester {
    public static void main(String[] args) {
		
		Traduttore dizionario = new Traduttore();
		Traduttore dizionario2 = new Traduttore();
        
		try{
			FileReader reader = new FileReader(args[0]);
			Scanner scan = new Scanner(reader);
			
			while(scan.hasNext()){
				String line = scan.nextLine();
				
				String word = line.substring(0, line.indexOf(":")).trim();
				String[] values = line.substring(line.indexOf(":") + 1, line.length()).trim().split(" ");
				
				dizionario.insert(word, values);
			}
						
			Scanner scan2 = new Scanner(System.in);
			
			while(scan2.hasNext()){
				
				String in = scan2.nextLine();
				
				String inWord = in.substring(0, in.indexOf(":")).trim();
				String[] inValues = in.substring(in.indexOf(":") + 1, in.length()).trim().split(" ");
				
				dizionario2.insert(inWord, inValues);
			}
			
			FileWriter writer = new FileWriter(args[1]);
			PrintWriter printer = new PrintWriter(writer);
			
			dizionario.update(dizionario2);
			
			printer.println(dizionario.toString());
			
			printer.close();
			scan.close();
			scan2.close();
			
		} catch(IOException e){
			System.out.println(e);
		} catch(NoSuchElementException e){
			System.out.println(e);
		} catch(Exception e){
			System.out.println(e);
		}
		
    }
}

class Traduttore implements DictionaryUD {
    
	private WordPair[] dict;
	private int dictSize;
	private static final int DEFAULT_LEN = 5;
	
	public Traduttore(){
		dict = new WordPair[DEFAULT_LEN];
		dictSize = 0;
	}

	public boolean isEmpty(){
		return dictSize == 0;
	}
	
	public void makeEmpty(){
		dictSize = 0;
	}
	
	public void insert(Comparable key, Object value){
		
		if(key == null){
			throw new IllegalArgumentException("La chiave inserita non è valida");
		}
		
		String k = (String) key;
		String[] values = (String[]) value;
		
		int index = binarySearch(key);
		
		if(index >= 0){
			dict[index].translations = values;
		} else {
			
			if(dictSize == dict.length){
				dict = resize();
			}
			
			int insertPos = -(index + 1);
			
			for(int i = dictSize; i > insertPos; i--){
				dict[i] = dict[i - 1];
			}
			dict[insertPos] = new WordPair(k, values);
			dictSize++;
		}
	}
	
	public void remove(Comparable key){
		
		int index = binarySearch(key);
		if(index < 0){
			throw new DictionaryItemNotFoundException();
		}
		
		for(int i = index; i < dictSize - 1; i++){
			dict[i] = dict[i - 1];
		}
		dictSize--;
	}
	
	public Object find(Comparable key){
		int index = binarySearch(key);
		if(index < 0){
			throw new DictionaryItemNotFoundException();
		}
		
		return dict[index].translations;
	}
	
    public String toString() {
		
		String result = "";
		
		for(int i = 0; i < dictSize; i++){
			result += dict[i].toString() + "\n";
		}
		
		return result;
    }
	 
	public void update(DictionaryUD newDict){
		if(!(newDict instanceof Traduttore)){
			throw new IllegalArgumentException("Il nuovo dizionari non e' valido");
		}
		
		Traduttore newTranslator = (Traduttore) newDict;
		
		for(int i = 0; i < newTranslator.dictSize; i++){
			
			String key = newTranslator.dict[i].getWord();
			String[] values = newTranslator.dict[i].getTranslations();
			
			this.insert(key, values);
		}
	}	
	
	private WordPair[] resize(){
		WordPair[] newDict = new WordPair[dict.length * 2];
		System.arraycopy(dict, 0, newDict, 0, dict.length);
		return newDict;
	}

	private int binarySearch(Object key){
		
		String k = (String) key;
		int upper = dictSize - 1;
		int lower = 0;
		
		while(upper >= lower){
			int mid = (upper + lower) / 2;
			int cmp = dict[mid].word.compareTo(k);
			if(cmp > 0){
				upper = mid - 1;
			}else if(cmp < 0){
				lower = mid + 1;
			} else {
				return mid;
			}
		}
		return -(lower + 1);
	}
	
    // classe privata WordPair: non modificare!!
    private class WordPair {
        public WordPair(String word, String[] translations) {
            this.word = word;
            this.translations = translations;
        }

        public String getWord() {
            return word;
        }

        public String[] getTranslations() {
            return translations;
        }

        /*
         * Restituisce una stringa contenente
         * - la parola word
         * - un carattere di separazione ( : )
         * - gli elementi dell'array translations, separati da uno spazio
         */
        public String toString() {
            String retString = word + " :";
            for (int i = 0; i < translations.length; i++)
                retString += " " + translations[i];
            return retString;
        }

        // campi di esemplare
        private String word;
        private String[] translations;
    }
}

// non modificare!!
interface DictionaryUD {
    /*
     * verifica se il dizionario contiene almeno una coppia chiave/valore
     */
    boolean isEmpty();

    /*
     * svuota il dizionario
     */
    void makeEmpty();

    /*
     * Inserisce un elemento nel dizionario. L'inserimento va sempre a buon fine.
     * Se la chiave non esiste la coppia key/value viene aggiunta al dizionario;
     * se la chiave esiste gia' il valore ad essa associato viene sovrascritto
     * con il nuovo valore; se key e` null viene lanciata IllegalArgumentException
     */
    void insert(Comparable key, Object value);

    /*
     * Rimuove dal dizionario l'elemento specificato dalla chiave key
     * Se la chiave non esiste viene lanciata DictionaryItemNotFoundException
     */
    void remove(Comparable key);

    /*
     * Cerca nel dizionario l'elemento specificato dalla chiave key
     * La ricerca per chiave restituisce soltanto il valore ad essa associato
     * Se la chiave non esiste viene lanciata DictionaryItemNotFoundException
     */
    Object find(Comparable key);

    /*
     * Aggiorna il contenuto del dizionario (parametro implicito del metodo) con
     * il contenuto del dizionario newdict (parametro esplicito del metodo).
     * Piu' precisamente:
     * a) se newdict contiene una chiave key non presente nel dizionario, la
     * coppia corrispondente (key value) viene scritta nel dizionario
     * b) se newdict contiene una chiave key gia' presente nel dizionario, la
     * coppia (key value) presente nel dizionario viene sovrascritta da quella
     * di newdict
     */
    void update(DictionaryUD newdict);
}

class DictionaryItemNotFoundException extends RuntimeException {
}