public class SortedArraySortedMap implements Map {
    // Classe interna per gestire l'associazione Chiave-Valore
    private class Pair {
        Comparable key;
        Object value;

        Pair(Comparable k, Object v) {
            key = k;
            value = v;
        }
    }

    private Pair[] v;
    private int vSize;
    private static final int DEFAULT_CAPACITY = 10;

    public SortedArraySortedMap() {
        v = new Pair[DEFAULT_CAPACITY];
        vSize = 0;
    }

    // --- Metodi dell'interfaccia Container ---

    public boolean isEmpty() {
        return vSize == 0;
    }

    public void makeEmpty() {
        vSize = 0;
    }

    public int size() {
        return vSize;
    }

    // --- Metodi dell'interfaccia Map ---

    public Object get(Object key) {
        int index = binarySearch((Comparable) key);
        if (index >= 0) {
            return v[index].value;
        }
        return null;
    }

    public Object put(Object key, Object value) {
        Comparable k = (Comparable) key;
        int index = binarySearch(k);

        // Se la chiave esiste già, sovrascrivo il valore
        if (index >= 0) {
            Object oldValues = v[index].value;
            v[index].value = value;
            return oldValues;
        }

        // Se non esiste, index è: -(posizione_inserimento + 1)
        int insertPos = -(index + 1);

        // Gestione ridimensionamento array (se pieno)
        if (vSize == v.length) {
            v = resize();
        }

        // Shift a destra per fare spazio
        for (int i = vSize; i > insertPos; i--) {
            v[i] = v[i - 1];
        }

        v[insertPos] = new Pair(k, value);
        vSize++;
        return null;
    }

    public Object remove(Object key) {
        int index = binarySearch((Comparable) key);
        if (index < 0)
            return null;

        Object oldValue = v[index].value;

        // Shift a sinistra per chiudere il buco
        for (int i = index; i < vSize - 1; i++) {
            v[i] = v[i + 1];
        }

        vSize--;
        return oldValue;
    }

    public Object[] keys() {
        Object[] keys = new Object[vSize];
        for (int i = 0; i < vSize; i++) {
            keys[i] = v[i].key;
        }
        return keys;
    }

    // Metodo richiesto dal tester fornito
    public Comparable[] sortedKeys() {
        Comparable[] keys = new Comparable[vSize];
        for (int i = 0; i < vSize; i++) {
            keys[i] = v[i].key;
        }
        return keys;
    }

    // --- Metodi Helper (Privati) ---

    // Ricerca binaria: restituisce l'indice se trovato,
    // altrimenti restituisce (-(posizione_inserimento) - 1)
    private int binarySearch(Comparable key) {
        int low = 0;
        int high = vSize - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = v[mid].key.compareTo(key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // Chiave trovata
        }
        return -(low + 1); // Chiave non trovata
    }

    private Pair[] resize() {
        Pair[] newV = new Pair[v.length * 2];
        System.arraycopy(v, 0, newV, 0, v.length);
        return newV;
    }
}