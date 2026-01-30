public class FixedArrayQueue implements Queue{

   protected Object[] v;
   protected int front;
   protected int back;
   final int INITIAL_SIZE = 10;
   
   public FixedArrayQueue(){
      v = new Object[INITIAL_SIZE];
      makeEmpty();
   }

   public void enqueue(Object obj){
   
      if(back == v.length){
         throw new FullQueueException();
      }
      v[back] = obj;
      back++;
   }
   
   public Object getFront(){
      if (isEmpty()){
         throw new EmptyQueueException();
      }
      return v[front];
   }
   
   public Object dequeue(){
      Object result = getFront();
      front++;
      return result;
   }

   public boolean isEmpty(){
      return front == back;
   }
   
   public void makeEmpty(){
      front = 0;
      back = 0;
   }
}

class EmptyQueueException extends RuntimeException{}
class FullQueueException extends RuntimeException{}
