public class MyHashTable implements HashTable{

   private LinkedList[] table;
   private int DEFAULT_SIZE = 100;
   
   public MyHashTable(){
      table = new LinkedList[DEFAULT_SIZE];
      makeEmpty();
   }

   public MyHashTable(int size){
      table = new LinkedList[size];
      makeEmpty();
   }

   public void makeEmpty(){
      for(int i=0; i<table.length; i++){
         table[i] = new LinkedList();      
      } 
   }
   
   public boolean isEmpty(){
      for(int i=0; i<table.length; i++){
         if(!table[i].isEmpty()){
            return false;
         }      
      } 
      return true;
   }
   
   
   public void insert(Object key, Object value){
   
      int hash = key.hashCode()%table.length;
      if (hash<0){ 
         hash = -hash;
      }
      table[hash].addFirst(new Pair(key,value));     
   }
   
   public void remove(Object key){
      int hash = key.hashCode()%table.length;
      if (hash<0){ 
         hash = -hash;
      }
      ListIterator iter = table[hash].getIterator();
     
      while(iter.hasNext()){
         Pair coppia = (Pair)iter.next();
         if(coppia.getKey().equals(key)){
            Object elem = coppia.getValue();
            iter.remove();
            return;
         }
      }
      return; 
   
   }
   
   
   public Object find(Object key){
   
      int hash = key.hashCode()%table.length;
      if (hash<0){ 
         hash = -hash;
      }
      ListIterator iter = table[hash].getIterator();
      while(iter.hasNext()){
         Pair coppia = (Pair)iter.next();
         if(coppia.getKey().equals(key)){
            return coppia.getValue();
         }
      }
      return null;
      
   }

   public String toString(){
   
      String s ="";
      for(int i=0; i<table.length; i++){
         s+= i+": ";
         ListIterator iter = table[i].getIterator();
         while(iter.hasNext()){
            Pair coppia = (Pair)iter.next();
            s += coppia.toString();
         }
         s+="\n";
      }
      return s;
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
      
      public String toString(){
         return "("+key+","+value+")";
      }
         
   }
   
}