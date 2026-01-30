public class ArrayTable100 implements Table{
	
	private int count;
	private Object[] tab = new Object[100];
	
	// -- Metodi di Container --
	public boolean isEmpty(){
		return count == 0;
	}
	
	public void makeEmpty(){
		count = 0;
		for(int i = 0; i < tab.length; i++){
			tab[i] = null;
		}
	}
	
	// -- Metodi di Table --
	public void insert(int key, Object value){
		check(key);
		if(tab[key] == null){	
			count++;
		}
		tab[key] = value;
	}
	
	public void remove(int key){
		check(key);
		if(tab[key] != null){
			tab[key] =  null;
			count--;
		}
	}
	public Object find(int key){
		check(key);
		return tab[key];
	}
	
	// -- Metodi Helper --
	public void check(int key){
		if(key < 0 || key > tab.length){
			throw new InvalidPositionTableException();
		}
	}
}