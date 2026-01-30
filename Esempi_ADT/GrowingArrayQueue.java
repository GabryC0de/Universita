public class GrowingArrayQueue extends FixedArrayQueue{

 
   public void enqueue(Object obj){
   
      if(back == v.length){
         v = resize(v,2*v.length);
      }
      super.enqueue(obj);
   }
   
   
   public static Object[] resize(Object[] v, int newSize){
   
      Object[] newV = new Object[newSize];
      System.arraycopy(v,0,newV,0,v.length);
      return newV;
   }
}

