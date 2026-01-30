public interface Queue extends Container{

   void enqueue(Object obj);
   Object getFront();
   Object dequeue();

}