// Soluzione che non utilizza una nuova variabile di esemplare

public class Sportello2 extends FixedCircularArrayQueue{

  public int getSize(){  
      //ATTENZIONE: essendo una coda circolare devo gestire entrambi i casi possibili
      //Math.abs(back-front) e' sbagliato, non considerare che back possa essere minore 
      //di front e' un errore
      int size;
      if(back>=front){
         size = back-front;
      }
      else{
         size = (v.length-front+back);
      }
      return size;
   }
   
   public Object dequeue(){
      // uso getFront perche' lancia l'eccezione EmptyQueue in caso la coda sia vuota
      int time = ((Integer)getFront()).intValue()-1; 
      if(time==0){ //il cliente in testa alla coda ha finito: lo tolgo
         Object obj = super.dequeue();
         return obj;
      }   
      v[front] = time; //aggiorno il primo elemento della coda
      return v[front]; //non era importante il valore restituito, non erano state date specifiche
   }
   
   public String toString(){
      return getSize() +" clienti "+super.toString();
   }
}