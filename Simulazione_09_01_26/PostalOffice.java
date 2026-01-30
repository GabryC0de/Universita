import java.util.*;

public class PostalOffice{

   public static void main(String[] args){
   
      //inizializzo l'array
      Sportello[] posta = new Sportello[5];//questo non basta, tutti i riferimenti sono a null!
      for(int i=0; i<5;i++){ //devo creare ciascuno sportello!
         posta[i] = new Sportello();
         System.out.println("Sportello "+(i+1)+" : "+posta[i]);
      } 
      //dichiaro e inizializzo la variabile random come da consegna
      Random rand = new Random(123);
      
      //verifico che sia stato inserito un valore da riga di comando e lo leggo
      if(args.length != 1){
         System.out.println("Usage: java PostalOffice numeroDiMinuti");
         System.exit(1);
      }
      int n = Integer.parseInt(args[0]);
      
      for(int i=0; i<n; i++){        
         int durata = rand.nextInt(15)+1; //arriva il cliente
         int index = minSizeQueue(posta); //individuo la coda piu' corta
         System.out.println("Nuovo cliente con pratica "+durata+" minuti inserito in coda allo sportello "+(index+1));
         posta[index].enqueue(durata); //accodo il cliente
         //faccio passare un minuto decrementando il tempo in tutte le code
         System.out.println("Situazione code dopo "+(i+1)+" minuti");
         for(int j=0; j<5; j++){
            if(!posta[j].isEmpty()){ //altrimenti possibile lancio di eccezione
               Object cliente = posta[j].dequeue();
            }   
            System.out.println("Sportello "+(j+1)+" : "+posta[j]);
         }     
      }   
   }

   //ATTENZIONE: devo restituire l'indice dello sportello con size
   // piu' piccola, non il valore piu' piccolo di size!
   public static int minSizeQueue(Sportello[] p){
      int minIndex = 0;
      for(int i=1; i<p.length; i++){
         if(p[i].getSize()<p[minIndex].getSize()){
            minIndex = i;
         }
      }
      return minIndex;
   }  
}