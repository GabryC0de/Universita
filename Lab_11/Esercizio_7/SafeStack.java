public class SafeStack implements Stack {
    private int top;
    private Object[] arr; // Manteniamo Object[] per compatibilità con l'interfaccia
    private final int INITIAL_CAPACITY = 10;

    public SafeStack() {
        arr = new Object[INITIAL_CAPACITY];
        top = -1;
    }

    // -- Metodi di Container --
    public void makeEmpty() {
        // È buona norma pulire i riferimenti per il Garbage Collector
        for (int i = 0; i <= top; i++) arr[i] = null;
        top = -1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    // -- Metodi di Stack --
    // Nota: restituiamo Object per rispettare l'interfaccia Stack
    public Object pop() {
        check();
        Object val = arr[top];
        arr[top] = null; // Libera la memoria
        top--;
        return val;
    }

    public Object top() {
        check();
        return arr[top];
    }

    public void push(Object str) {
        if (!(str instanceof String)) {
            throw new IllegalArgumentException("La pila accetta solo stringhe!");
        }
        
        if (top + 1 == arr.length) {
            resize(); // Chiamata al metodo helper
        }
        arr[++top] = str;
    }

    // -- Metodi Helper --
    private void resize() {
        // Raddoppiamo la capacità per efficienza
        Object[] newArr = new Object[arr.length * 2];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr; // Assegnazione corretta tra tipi uguali
    }

    private void check() {
        if (isEmpty())
            throw new EmptyStackException();
    }
}