public class GrowingArrayStack extends FixedArrayStack {

   public void push(Object obj){
   
      if(vSize == v.length){
         v = resize(v,2*v.length);
      }
      super.push(obj);
   }
   
   public static Object[] resize(Object[] v, int newSize){
   
      Object[] newV = new Object[newSize];
      System.arraycopy(v,0,newV,0,v.length);
      return newV;
   }
}
