public class ArrayMultiMap {
	public class Pair {
		Object key;
		Object value;

		public Pair(Object k, Object v) {
			this.key = k;
			this.value = v;
		}
	}

	private Pair[] pairs;
	private int pairsSize;
	private static final int INITIAL_CAPACITY = 10;

	public ArrayMultiMap() {
		pairs = new Pair[INITIAL_CAPACITY];
		pairsSize = 0;
	}

	// -- Metodi di container --
	public boolean isEmpty() {
		return pairsSize == 0;
	}

	public void makeEmpty() {
		pairsSize = 0;
	}

	// -- Metodi di MultiMap --
	public void insert(Object key, Object value) {
		if (pairsSize == pairs.length) {
			pairs = resize();
		}
		
		pairs[pairsSize] = new Pair(key, value);
		pairsSize++;
	}

	public Object remove(Object key) {
		if(findIndex(key) < 0){
			return null;
		}
		int index = findIndex(key);
		if (index >= 0) {
			Object oldValue = pairs[index].value;
			pairs[index] = pairs[pairsSize - 1];
			pairs[pairsSize - 1] = null;
			pairsSize--;
			return oldValue;
		}
		return null;

	}

	public Object find(Object key) {
		for (int i = 0; i < pairsSize; i++) {
			if (pairs[i].key.equals(key)) {
				return pairs[i].value;
			}
		}
		return null;
	}

	public Object[] findAll(Object key) {
    Object[] found = new Object[0];

    for (int i = 0; i < pairsSize; i++) {
        if (key.equals(pairs[i].key)) {
            
            Object[] newObject = new Object[found.length + 1];
            System.arraycopy(found, 0, newObject, 0, found.length);
            found = newObject;

            found[found.length - 1] = pairs[i].value;
        }
    }
    return found;
}

	public Object[] removeAll(Object key) {
    Object[] removed = new Object[0]; // Partiamo da 0

    for (int i = 0; i < pairsSize; i++) { // Ricorda: i < pairsSize
        if (pairs[i].key.equals(key)) {
            
            Object[] newObject = new Object[removed.length + 1];
            System.arraycopy(removed, 0, newObject, 0, removed.length);
            removed = newObject;

            removed[removed.length - 1] = pairs[i].value;

            pairs[i] = pairs[pairsSize - 1];
            pairs[pairsSize - 1] = null;
            pairsSize--;
            i--; 
        }
    }
    if(removed.length != 0){
        return removed;
    }
    return null;
}

	public Object[] keys() {
		Object[] keys = new Object[pairsSize];
		for (int i = 0; i < pairsSize; i++) {
			keys[i] = pairs[i].key;
		}
		return keys;
	}

	public int size(){
		return pairsSize;
	}
	// -- Metodi HELPER --

	public int findIndex(Object key) {
		for (int i = 0; i < pairsSize; i++) {
			if (key.equals(pairs[i].key)) {
				return i;
			}
		}
		return -1;
	}

	public Pair[] resize() {
		Pair[] newPair = new Pair[pairs.length * 2];
		System.arraycopy(pairs, 0, newPair, 0, pairs.length);
		return newPair;
	}
}