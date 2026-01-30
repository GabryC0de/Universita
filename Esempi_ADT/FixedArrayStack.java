public class FixedArrayStack implements Stack{

   protected Object[] v;
   protected int vSize;
   protected final int INITIAL_SIZE = 10;
   
   public FixedArrayStack(){
      v = new Object[INITIAL_SIZE];
      makeEmpty();
   }

   public void push(Object obj){
   
      if(vSize == v.length){
         throw new FullStackException();
      }
      v[vSize] = obj;
      vSize++;
   }
   
   public Object top(){
      if (isEmpty()){
         throw new EmptyStackException();
      }
      return v[vSize-1];
   }
   
   public Object pop(){
      Object result = top();
      vSize--;
      return result;
   }

   public boolean isEmpty(){
      return vSize==0;
   }
   
   public void makeEmpty(){
      vSize = 0;
   }
   
   public String toString(){
      String s = "";
      for(int i=0; i<vSize; i++){
         s += v[i];
      }
      return s;
   }
}

class EmptyStackException extends RuntimeException{}
class FullStackException extends RuntimeException{}
