//uguale a PostalOffice solo che chiama la versione 2 dello sportello
//ovvero Sportello2

import java.util.*;

public class PostalOffice2{

   public static void main(String[] args){  
      Sportello2[] posta = new Sportello2[5];
      for(int i=0; i<5;i++){ 
         posta[i] = new Sportello2();
         System.out.println("Sportello "+(i+1)+" : "+posta[i]);
      } 
      Random rand = new Random(123);
      
      if(args.length != 1){
         System.out.println("Usage: java PostalOffice numeroDiMinuti");
         System.exit(1);
      }
      int n = Integer.parseInt(args[0]);
      
      for(int i=0; i<n; i++){        
         int durata = rand.nextInt(15)+1; 
         int index = minSizeQueue(posta); 
         System.out.println("Nuovo cliente con pratica "+durata+" minuti inserito in coda allo sportello "+(index+1));
         posta[index].enqueue(durata); 
         System.out.println("Situazione code dopo "+(i+1)+" minuti");
         for(int j=0; j<5; j++){
            if(!posta[j].isEmpty()){ 
               Object cliente = posta[j].dequeue();
            }   
            System.out.println("Sportello "+(j+1)+" : "+posta[j]);
         }     
      }   
   }

   public static int minSizeQueue(Sportello2[] p){
      int minIndex = 0;
      for(int i=1; i<p.length; i++){
         if(p[i].getSize()<p[minIndex].getSize()){
            minIndex = i;
         }
      }
      return minIndex;
   }  
}