public class GrowingCircularArrayQueue extends FixedCircularArrayQueue{

 
   public void enqueue(Object obj){
   
      if(increment(back) == front){
         v = resize(v,2*v.length);
         if (back < front)
         {  System.arraycopy(v, 0, v, v.length/2, back);
            back += v.length/2;
         }

      }
      super.enqueue(obj);
   }
   
   
   public static Object[] resize(Object[] v, int newSize){
   
      Object[] newV = new Object[newSize];
      System.arraycopy(v,0,newV,0,v.length);
      return newV;
   }
}

