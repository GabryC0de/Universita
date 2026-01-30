public class ArrayMap implements Map{  
   // realizziamo con array non ordinato
   private Pair[] p;
   private int pSize;
   private static final int CAPACITY = 1;
   
   public ArrayMap()
	{	p = new Pair[CAPACITY];
	   makeEmpty();
	}
	
	public void makeEmpty(){ 
	   pSize = 0; 
	}  
	public boolean isEmpty(){ 
	   return (pSize == 0);
	}
	public int size(){	
	   return pSize;
	}
	
	public Object[] keys(){
		Object[] keys = new Object[pSize];
		for(int i=0; i< pSize; i++){
			keys[i] = p[i].getKey();
		}	
		return keys;
	}

	public Object put(Object key, Object value){  
		if (key == null || value == null){
         throw new IllegalArgumentException();
      }
		// elimino eventuale Pair esistente con stessa chiave
		Object old = remove(key);
		// se necessario ridimensiono
		if (pSize == p.length){ 
		   p = resize(p, 2*pSize);
		}   
      // inserisco nuova coppia in fondo e inc. pSize
		p[pSize++] = new Pair(key, value);
		return old;
	}
	
	public Object remove(Object key)
   {  for (int i = 0; i < pSize; i++)
      {  if (p[i].getKey().equals(key))
         {  Object obj = p[i].getValue();
				p[i] = p[pSize-1];
				pSize--; 
				return obj; 
			}
		}
      return null; // non c’e’
	}

   public Object get(Object key)
   {  for (int i = 0; i < pSize; i++)
         if (p[i].getKey().equals(key))
            return p[i].getValue();
      return null; // non c’e’
	}
	
	protected Pair[] resize(Pair[] oldv, int newsize){
         Pair[] newV = new Pair[newsize];
         System.arraycopy(oldv,0,newV,0,oldv.length);
         return newV;
   }
	
	private class Pair{ // interna alla classe ArrayMap  
      private Object key;
      private Object value;
      
      public Pair(Object k, Object v){  
         setKey(k); 
         setValue(v); 
      }
   
      public Object getKey(){  
         return key;
      }
      public Object getValue(){  
         return value;
      }
      public void setKey(Object k){  
         key = k;
      }
      public void setValue(Object v){
         value = v;
      }
      
      
   }


}
