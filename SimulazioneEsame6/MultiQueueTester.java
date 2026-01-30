// nome e cognome del candidato, matricola, data, numero della postazione

import java.util.Scanner;
import java.io.*;

public class MultiQueueTester {
    public static void main(String[] args) {
        
		try {
			
			Scanner scan = new Scanner(System.in);
			
			int N = Integer.parseInt(args[0]);
			
			ArrayMultiQueue queues = new ArrayMultiQueue(N);
			
			boolean flag = false;
			
			while(scan.hasNextLine() && !flag){
				String line = scan.nextLine();
				if (line.isEmpty()) continue;

				char cmd = line.toUpperCase().charAt(0);
				
				switch(cmd){
					case 'A':
						String name = scan.nextLine(); // Solo A legge il nome
						queues.add(name);
						break;
					case 'R':
						int index = Integer.parseInt(scan.nextLine()); // Leggi l'indice pulito
						queues.remove(index);
						break;
					case 'P':
						System.out.println(queues.toString());
						break;
					case 'Q':
						flag = true;
						break;
				}
			}
			scan.close();
			
		} catch(EmptyQueueException e){
			
		}
	}
}

// -----------------------------------------------------------------------------

// Classe che implementa l'interfaccia Queue usando un array (array riempito
// solo in parte, oppure array riempito solo nella parte centrale, oppure
// array circolare), con o senza ridimensionamento. La classe sovrascrive
// il metodo toString
// ....... da completare ............

class ArrayQueue implements Queue {
    // metodi pubblici dell'interfaccia Queue ......da completare ......
    
	private Object[] queue;
	private int queueSize;
	
	private static final int DEFAULT_LEN = 5;
	
	public ArrayQueue(){
		queue = new Object[DEFAULT_LEN];
		queueSize = 0;
	}
	
	public void makeEmpty(){
		queueSize = 0;
	}
	
	public boolean isEmpty(){
		return queueSize == 0;
	}
	
	public int size(){
		return queueSize;
	}
	
	public void enqueue(Object obj){
		if(queueSize == queue.length) queue = resize();
		queue[queueSize] = obj;
		queueSize++;	
	}
	
	public Object dequeue() throws EmptyQueueException{
		if(queueSize == 0) throw new EmptyQueueException();
		
		Object oldObj = queue[0];
		
		for(int i = 0; i < queueSize - 1; i++){
			queue[i] = queue[i + 1];
		}
		queue[queueSize - 1] = null;
		queueSize--;
		return oldObj;
	}

    public Object getFront() throws EmptyQueueException{
		if(queueSize == 0) throw new EmptyQueueException();
		return queue[0];
	}
	
    public String toString() {
        String result = "";
		for(int i = 0; i < queueSize; i++){
			result += (String) queue[i] + "\n";
		}
		return result;
    }

    private Object[] resize(){
		Object[] newQueue = new Object[queue.length * 2];
		System.arraycopy(queue, 0, newQueue, 0, queue.length);
		return newQueue;
	}
	
	private int find(Object obj){
		for(int i = 0; i < queueSize; i++){
			if(queue[i] == obj) return i;
		}
		return -1;
	}
}

// -----------------------------------------------------------------------------

// Classe che implementa l'interfaccia MultiQueue usando un array di N code.
// La classe sovrascrive il metodo toString
// ....... da completare ............

class ArrayMultiQueue implements MultiQueue {
    // costruttore ......da completare ......
    // crea una multicoda vuota, costituita da una sequenza di N code vuote,
    // con N > 0
		
	private ArrayQueue[] multiQueue;
	
    public ArrayMultiQueue(int N) {
		multiQueue = new ArrayQueue[N];
		for (int i = 0; i < N; i++) {
			multiQueue[i] = new ArrayQueue(); // Crea la singola "scatola" (Coda)
		}
    }
	
	public boolean isEmpty() {
		for (int i = 0; i < multiQueue.length; i++) {
			if (!multiQueue[i].isEmpty()) return false;
		}
		return true;
	}

	public void makeEmpty() {
		for (int i = 0; i < multiQueue.length; i++) {
			multiQueue[i].makeEmpty(); // Svuota la coda, non distruggere l'oggetto!
		}
	}

	public Object remove(int i) throws EmptyQueueException {
		// La condizione corretta è 0 <= i < length
		if (i < 0 || i >= multiQueue.length) throw new IllegalArgumentException();
		return multiQueue[i].dequeue();
	}
	
	public void add(Object obj){
		int min = multiQueue[0].size();
		int targetIndex = 0;
		for(int i = 1; i < multiQueue.length; i++){
			if(multiQueue[i].size() <= min){
				min = multiQueue[i].size();
				targetIndex = i;
			}
		}
		multiQueue[targetIndex].enqueue(obj);		
	}

    public String toString() {
		String result = "";
		for (int i = 0; i < multiQueue.length; i++) {
			result += "Coda " + i + ": " + multiQueue[i].toString() + "\n";
		}
		return result;
	}
}

// -----------------------------------------------------------------------------

// NON MODIFICARE!
// Interfaccia che rappresenta il tipo di dati astratto coda
interface Queue { 
	// Restituisce true se la coda e` vuota. Restituisce false se la coda
    // contiene almeno un elemento
    boolean isEmpty();

    // Svuota la coda
    void makeEmpty();

    // Restituisce il numero di elementi presenti nella coda
    int size();

    // Inserisce l'oggetto obj nella coda
    void enqueue(Object obj);

    // Elimina dalla coda il primo oggetto, e lo restituisce.
    // Lancia EmptyQueueException se la coda e` vuota
    Object dequeue() throws EmptyQueueException;

    // Restituisce il primo oggetto della coda, senza estrarlo
    // Lancia EmptyQueueException se la coda e` vuota
    Object getFront() throws EmptyQueueException;
}

// -----------------------------------------------------------------------------

// NON MODIFICARE!
// Eccezione lanciata da dequeue e getFront quando la coda e` vuota

class EmptyQueueException extends RuntimeException {
}

// -----------------------------------------------------------------------------

// NON MODIFICARE!
// Interfaccia che rappresenta il tipo di dati astratto "multicoda".
// Una multicoda e` una sequenza di N code. Ciascuna delle N code e`
// identificata da un indice intero i, dove 0 <= i < N.
interface MultiQueue {
    // Restituisce true se la multicoda e` vuota, cioe` se tutte le N
    // code della multicoda sono vuote. Restituisce false se la multicoda
    // contiene almeno un elemento, cioe` se almeno una delle N code della
    // multicoda contiene almeno un elemento
    boolean isEmpty();

    // Svuota la multicoda, cioe` svuota tutte le N code della multicoda
    void makeEmpty();

    // Inserisce l'oggetto obj nella multicoda. Tra tutte le N code della
    // multicoda, l'oggetto viene accodato a quella che contiene il minor
    // numero di elementi. Nel caso in cui piu` code contengano un numero
    // di elementi pari al minimo, la scelta è indifferente
    void add(Object obj);

    // Disaccoda dalla i-esima coda il suo primo elemento e lo restituisce.
    // L'indice intero i specifica quale e` la coda da cui disaccodare il
    // primo elemento. Di conseguenza i deve essere tale che 0 <= i < N.
    // Lancia EmptyQueueException se la la i-esima coda e` vuota
    Object remove(int i) throws EmptyQueueException;
}
