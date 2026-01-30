public class Sportello extends FixedCircularArrayQueue{

   // variabile di esemplare (nuova)
   int size;
   
   // costruttore: devo esplicitarlo perche' devo inizializzare size
   public Sportello(){
      super();
      size = 0;
   }
   
   public int getSize(){     
      return size;
   }

   // devo sovrascrivere enqueue per aggiornare size quando c'e' un inserimento
   public void enqueue(Object obj){     
      super.enqueue(obj); // non serve riscrivere tutto, basta chiamare enqueue della superclasse
      size++;
   }
   
   public Object dequeue(){
      // uso getFront perche' lancia l'eccezione EmptyQueue in caso la coda sia vuota
      int time = ((Integer)getFront())-1; 
      if(time==0){ //il cliente in testa alla coda ha finito: lo tolgo
         Object obj = super.dequeue();
         size--;
         return obj;
      }   
      v[front] = time; //aggiorno il primo elemento della coda
      return v[front]; //non era importante il valore restituito, non erano state date specifiche
   }
   
   public String toString(){
      return size +" clienti "+super.toString();
   }
}