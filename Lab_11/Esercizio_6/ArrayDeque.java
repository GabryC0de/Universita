public class ArrayDeque implements Deque {
    private Object[] array;
    private int front; // Indice del primo elemento
    private int back;  // Indice della prima cella libera dopo l'ultimo
    private int size;  // Numero di elementi presenti
    private static final int INITIAL_CAPACITY = 10;

    public ArrayDeque() {
        array = new Object[INITIAL_CAPACITY];
        front = back = size = 0;
    }

    // -- Metodi di Container --
    public boolean isEmpty() {
        return (size == 0);
    }

    public void makeEmpty() {
        front = back = size = 0;
    }
    
	// -- Metodi di Deque --
    public int size() { return size; }
	
	public void addFirst(Object element) {
        if (size == array.length) resize(); // Se pieno, raddoppia
        
        // Sposta front all'indietro in modo circolare
        front = (front - 1 + array.length) % array.length;
        array[front] = element;
        size++;
    }

    public void addLast(Object element) {
        if (size == array.length) resize();
        
        // Inserisci in back e poi sposta back in avanti
        array[back] = element;
        back = (back + 1) % array.length;
        size++;
    }

    public Object getFirst() throws EmptyDequeException {
        if (isEmpty()) throw new EmptyDequeException();
        return array[front];
    }

    public Object getLast() throws EmptyDequeException {
        if (isEmpty()) throw new EmptyDequeException();
        // L'ultimo elemento è in (back - 1)
        int lastIndex = (back - 1 + array.length) % array.length;
        return array[lastIndex];
    }

    public Object removeFirst() throws EmptyDequeException {
        Object temp = getFirst();
        array[front] = null; // Aiuta il Garbage Collector
        front = (front + 1) % array.length;
        size--;
        return temp;
    }

    public Object removeLast() throws EmptyDequeException {
        if (isEmpty()) throw new EmptyDequeException();
        back = (back - 1 + array.length) % array.length;
        Object temp = array[back];
        array[back] = null;
        size--;
        return temp;
    }
	
	// -- Richieste aggiuntive --
	public String toString() {
		String str = "[";
		
		// Partiamo dall'indice 'front'
		int current = front;
		
		// Cicliamo per il numero esatto di elementi presenti (size)
		for (int i = 0; i < size; i++) {
			str += array[current]; // Java chiama automaticamente il toString() dell'oggetto
			
			// Se non è l'ultimo elemento, aggiungiamo la virgola
			if (i < size - 1) {
				str += ", ";
			}
			
			// Ci spostiamo in avanti in modo circolare
			current = (current + 1) % array.length;
		}
		
		return str + "]";
	}
	
	// -- Metodi Helper --
	private void resize() {
        Object[] newArray = new Object[array.length * 2];
        for (int i = 0; i < size; i++) {
            // Copia gli elementi partendo da front
            newArray[i] = array[(front + i) % array.length];
        }
        array = newArray;
        front = 0;
        back = size;
    }
}