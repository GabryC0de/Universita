public class PizzaMap extends FixedArrayMap{
	
	public Object put(Object key, Object value){
	
		if(!(key instanceof String) || !(value instanceof Double)) throw new IllegalArgumentException("Uno dei valori inseriti non è valido.");
		
		if(this.pSize == p.length) {
			p = resize();
			throw new FullMapException();
		}
		
		Object oldObj = remove(key);
		
		p[pSize++] =  new Pair(key, value);
			
		return oldObj;
	}
	
	public string printMenu(){
		
	}
	
	private Pair[] resize(){
		Pair[] newP = new Pair[p.length * 2];
		System.arraycopy(p, 0, newP, 0, p.length);
		return newP;
	}	
	
	private Pair[] mergeSort(){
		
		
		mergeSort(arr1);
		mergeSort(arr2);
		
		merge(arr1, arr2);
	}
	
	private Pair[] merge(){}
}