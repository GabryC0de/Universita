public class FixedCircularArrayQueue extends FixedArrayQueue{
 

   public void enqueue(Object obj){
   
      if(increment(back) == front){
         throw new FullQueueException();
      }
      v[back] = obj;
      back = increment(back);
      
   }
   
      
   public Object dequeue(){
      Object result = getFront();
      front = increment(front);
      return result;
   }

   
   protected int increment(int index){
      return (index+1)%v.length;
   }
   
}
