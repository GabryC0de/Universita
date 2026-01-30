public class SortedArrayMultiMap implements MultiMap{
	public class Pair{
		
		Comparable key;
		Object value;
		
		public Pair(Comparable k, Object val){
			this.key = k;
			this.value = val;			
		}
	}
	
	private int pairsSize;
	private static final int DEFAULT_SIZE = 10;
	private Pair[] pairs;
	
	public SortedArrayMultiMap(){
		pairs = new Pair[DEFAULT_SIZE];
		pairsSize = 0;
	}
	
	// -- Metodi di Container --
	public boolean isEmpty(){
		return pairsSize == 0;
	}
	
	public void makeEmpty(){
		pairsSize = 0;
	}
	
	// -- Metodi di MultiMap --
	public void insert(Object key, Object value){
		if(key == null || value == null){
			throw new IllegalArgumentException("Uno dei due parametri inseriti non ha un valore valido!");
		}
        Comparable k = (Comparable) key;
        int index = binarySearch(k);

        // Se non esiste, index è: -(posizione_inserimento + 1)
		int insertPos = 0;
		if(index < 0){
			insertPos = -(index + 1);
		} else {
			insertPos = index;
		}

        // Gestione ridimensionamento array (se pieno)
        if (pairsSize == pairs.length) {
            pairs = resize();
        }

        // Shift a destra per fare spazio
        for (int i = pairsSize; i > insertPos; i--) {
            pairs[i] = pairs[i - 1];
        }

        pairs[insertPos] = new Pair(k, value);
        pairsSize++;
	}
	
	public Object remove(Object key){
		int pairIndex = binarySearch((Comparable) key);
		if(pairIndex < 0){
			return null;
		}
		Object oldPair = pairs[pairIndex].value; 
		for(int i = pairIndex; i < pairsSize - 1; i++){
			pairs[i] = pairs[i + 1];
		}
		pairsSize--;
		return oldPair;
	}
	
	public Object find(Object key){
		int index = binarySearch((Comparable) key);
		if(index >= 0){
			return pairs[binarySearch((Comparable) key)].value;
		}
		return null;
	}
	
	public Object[] findAll(Object key){
		Comparable k = (Comparable) key;
		Object[] founds = new Object[1];
		int foundSize = 0;
		for(int i = 0; i < pairs.length; i++){
			if(founds.length == foundSize){
				Object[] newFounds = new Object[founds.length + 1];
				System.arraycopy(founds, 0, newFounds, 0, founds.length);
				founds = newFounds;
			}
			if(pairs[i].key.compareTo(k) == 0){
				founds[foundSize] = pairs[i].value;
				foundSize++;
			}
		}
		return founds;
	}
	
	public Object[] removeAll(Object key){
		Object[] founds = new Object[1];
		int foundSize = 0;
		
		for(int i = 0; i < pairs.length; i++){
			if(founds.length == foundSize){
				Object[] newFounds = new Object[founds.length + 1];
				System.arraycopy(founds, 0, newFounds, 0, founds.length);
				founds = newFounds;
			}
			if(pairs[i].key.compareTo((Comparable) key) == 0){
				founds[foundSize] = pairs[i].value;
				foundSize++;
				for(int j = i; j < pairsSize - 1; j++){
					pairs[j] = pairs[j + 1];
				}
				pairsSize--;
				i--;
			}
		}
		return founds;			
	}
	
	public Object[] keys(){
		Object[] keys = new Object[pairsSize];
		for(int i = 0; i < pairsSize; i++){
			keys[i] = pairs[i].key;
		}
		return keys;
	}
	// -- Metodo richiesto dal tester --
	public int size(){
		return pairsSize;
	}
	
	// -- Metodi helper --
	private int binarySearch(Comparable key) {
        int low = 0;
        int high = pairsSize - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = pairs[mid].key.compareTo(key);

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
        Pair[] newPairs = new Pair[pairs.length + 1];
        System.arraycopy(pairs, 0, newPairs, 0, pairs.length);
        return newPairs;
    }
}
