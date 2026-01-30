// nome e cognome del candidato, matricola, data, numero della postazione

import java.util.Scanner;

public class AgendaTester {
    public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	
	Agenda agenda = new Agenda();
	
	boolean flag = false;
	
	while(scan.hasNext() && !flag){
		String line = scan.nextLine();
		
		char cmd = line.charAt(0);
		String data = scan.nextLine();
		
		char priorityCh = data.charAt(0);
		int priority = Integer.parseInt(priorityCh);
		String memo = data.substring(data.indexOf(" ") + 1, data.length()).trim();
		
		switch(cmd){
			case 'I':				
				agenda.insert(priority, memo);
				break;
			case 'R':
				agenda.remove(priority);
				break;
			case 'L':
				agenda.getMax();
				break;
			case 'Q':
				flag = true;
				break;
		}
		System.out.println(agenda.toString());
	}
	
	scan.close();
    }
}

class Agenda implements PriorityQueue {
    // costruttori e metodi pubblici ......da completare ......

	private int size;
	private Impegno[] impegni;
	private static final int DEFAULT_LEN = 5;

	public Agenda(){
		this.impegni = new Impegno[DEFAULT_LEN];
		this.size = 0;
	}

    public String toString() {
		String result = "";
		for(int i = 0; i < size; i++){
			result += impegni[i].toString() + "\n";
		}
		return result;
    }

	public void makeEmpty(){
		size = 0;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public void insert(int key, Object value){
		if(!(key >= 0 && key <= 3)){
			throw new IllegalArgumentException("Range di priorità non valido!");
		}

		if(size == impegni.length){
			impegni = resize();
		}

		impegni[size] = new Impegno(key, value);
		size++;
	}

	public Object removeMin() throws EmptyQueueException(){
		if(size == 0) throw new EmptyQueueException();
		
		int minPos = findMin();
		Object min = impegni[minPos].memo;
		
		for(int i = minPos; i < size; i++){
			impegni[i] = impegni[i + 1];
		}
		
		return min;
	}

	public Object getMin() throws EmptyQueueException(){
		if(size == 0) throw new EmptyQueueException();
		
		return impegni[findMin()].memo;
	}

	public Object getMax() throws EmptyQueueException(){
		if(size == 0) throw new EmptyQueueException();
		for(int i = 0; i < size; i++){
			if(impegni[i].priority == 0){
				return impegni[i].memo;
			}
		}
	}

	public Object removeMax() throws EmptyQueueException(){
		if(size == 0) throw new EmptyQueueException();
		
		int index = 0;
		
		for(int i = 0; i < size; i++){
			if(impegni[i].priority == 0){
				index = i;
			}
		}
		Object value = impegni[index].memo;
		for(int i = index; i < size; i++){
			impegni[i] = impegni[i + 1];
		}
		
		return value;
	}

	private Impegno[] resize(){
		Impegno[] newEvents = new Impegno[impegni.lenght * 2];
		System.arraycopy(impegni, 0, newEvents, 0, impegni.length);
		return newEvents;
	}

	private int findMin(int key){
		int min = impegni[0].priority;
		int minIndex = 0;
		for(int i = 1; i < size; i++){
			if(impegni[i].priority < min){
				min = impegni[i].priority;
				minIndex = i;
			}
		}
		return minIndex;
	}

    /*
     * classe privata Impegno: rappresenta gli elementi della classe Agenda ed
     * e` costituita da coppie "chiave valore" in cui il campo chiave e` di
     * tipo int e rappresenta la priorita` dell'impegno, e il campo valore e`
     * una stringa contenente un promemoria dell'impegno. Si considerano 4
     * livelli di priorita`, numerati da 0 a 3. Conseguentemente il campo
     * chiave puo` assumere valori solo in questo intervallo, dove il valore 0
     * significa "massima priorita`" e il valore 3 significa "minima priorita`"
     */
	// non modificare!!
    private class Impegno {
        public Impegno(int priority, String memo) {
            if (priority > 3 || priority < 0)
                throw new IllegalArgumentException();
            this.priority = priority;
            this.memo = memo;
        }

        // metodi (pubblici) di accesso
        public int getPriority() {
            return priority;
        }

        public Object getMemo() {
            return memo;
        }

        // metodo toString sovrascritto
        public String toString() {
            return priority + " " + memo;
        }

        // campi di esemplare (privati) della classe Impegno
        private int priority; // priorita` dell'impegno (da 0 a 3)
        private String memo; // promemoria dell'impegno
    }
}

/*
 * Interfaccia PriorityQueue (non modificare!!).
 * - Questo tipo di dato astratto definisce un contenitore di coppie
 * "chiave valore", dove il campo chiave e` un numero in formato int che
 * specifica il livello di priorita` della coppia mentre il campo valore
 * rappresenta il dato della coppia.
 * - Si assume che date due chiavi k1 e k2 tali che k1 < k2, allora k1 ha
 * priorita` piu` alta di k2.
 * - Naturalmente possono essere presenti nel contenitore coppie diverse con
 * chiavi uguali, cioe` con uguale priorita`
 */

 // non modificare!!
interface PriorityQueue {
  /*
   * svuota la coda di priorita`
   */
    void makeEmpty();

    /*
     * restituisce true se la coda e' vuota, false altrimenti
     */
    boolean isEmpty();

    /*
     * Metodo di inserimento
     * Inserisce la coppia "chiave valore" nella coda di priorita`. Notare che
     * la coda di priorita` puo` contenere piu` coppie con la stessa chiave.
     * Questo perche` il campo chiave non serve ad identificare univocamente
     * un elemento (come nel caso di un dizionario), ma serve invece a definire
     * la priorita` di un elemento. E` ovvio che piu` elementi possono avere
     * la stessa priorita`.
     */
    void insert(int key, Object value);

    /*
     * Metodo di rimozione
     * Rimuove dalla coda la coppia con chiave minima, e restituisce un
     * riferimento al suo campo value. Se sono presenti piu` coppie con chiave
     * minima, effettua la rimozione di una qualsiasi delle coppie con chiave
     * minima (ad es. la prima coppia con chiave minima che e` stata trovata)
     * Lancia EmptyQueueException se la coda di priorita` e` vuota
     */
    Object removeMin() throws EmptyQueueException;

    /*
     * Metodo di ispezione
     * Restituisce un riferimento al campo value della coppia con chiave minima
     * (ma *non* rimuove la coppia dalla coda). Se sono presenti piu` coppie
     * con chiave minima, restituisce il campo value di una qualsiasi delle
     * coppie con chiave minima (ad esempio la prima coppia con chiave minima
     * che e` stata trovata). Lancia EmptyQueueException se la coda e` vuota
     */
    Object getMin() throws EmptyQueueException;
}

/*
 * Eccezione lanciata dai metodi removeMin e getMin di PriorityQueue quando
 * la coda di priorita` e` vuota
 */
class EmptyQueueException extends RuntimeException {
}
