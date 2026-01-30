public class DequeStack implements Stack {
    // La pila usa una Deque per memorizzare i dati
    private Deque q;

    public DequeStack() {
        // Inizializziamo usando l'implementazione che hai scritto tu
        q = new ArrayDeque();
    }

    public void push(Object obj) {
        q.addFirst(obj); // Inseriamo sempre in testa
    }

    public Object pop() {
        return q.removeFirst(); // Estraiamo sempre dalla testa (LIFO)
    }

    public Object top() {
        return q.getFirst(); // Guardiamo solo la testa
    }
	
	// -- Metodi di Container --

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public void makeEmpty() {
        q.makeEmpty();
    }
}