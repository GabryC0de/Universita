public class DequeStack implements Stack { // Immaginando tu abbia l'interfaccia Stack
    private Deque deque; // La tua ArrayDeque usata come campo

    public DequeStack() {
        deque = new ArrayDeque();
    }

    public void push(Object element) {
        deque.addFirst(element);
    }

    public Object pop() {
        try {
            return deque.removeFirst();
        } catch (EmptyDequeException e) {
            throw new EmptyStackException(); // Converti l'eccezione
        }
    }

    public Object top() {
        try {
            return deque.getFirst();
        } catch (EmptyDequeException e) {
            throw new EmptyStackException();
        }
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }
}