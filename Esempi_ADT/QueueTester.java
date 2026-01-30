import java.util.*;

public class QueueTester{

   public static void main(String[] args){
   
      FixedArrayQueue q = new FixedArrayQueue();
      GrowingArrayQueue q2 = new GrowingArrayQueue();
      FixedCircularArrayQueue q3 = new FixedCircularArrayQueue();
      GrowingCircularArrayQueue q4 = new GrowingCircularArrayQueue();
      
      
      Random rand = new Random();
      Scanner console = new Scanner(System.in);
      
      System.out.println("Numero di elementi da introdurre nella coda?");
      int n = console.nextInt();
      
      System.out.println("Inserisco "+n+" elementi nella coda a dimensione fissa");
      for(int i=0; i<n; i++){
         try{
            int elem = rand.nextInt(100);            
            q.enqueue(elem);
            System.out.print(elem+" ");
         }
         catch(FullQueueException e){
            System.out.println("\nCoda piena");
            break;
         }
      }
      System.out.println("\nEstraggo gli elementi dalla coda a dimensione fissa = 10");    
      while(!q.isEmpty()){
         System.out.print(q.dequeue()+" ");
      }   
      
      System.out.println("\n\nInserisco "+n+" elementi nella coda ridimensionabile");
      for(int i=0; i<n; i++){       
            int elem = rand.nextInt(100);            
            q2.enqueue(elem);
            System.out.print(elem+" ");
      }
      System.out.println("\n\nEstraggo gli elementi dalla coda ridimensionabile");    
      while(!q2.isEmpty()){
         System.out.print(q2.dequeue()+" ");
      }  
      
      System.out.println("\n\nInserisco "+n+" elementi nella coda fissa circolare");
      for(int i=0; i<n; i++){   
        try{
            int elem = rand.nextInt(100);            
            q3.enqueue(elem);
            System.out.print(elem+" ");
        }
        catch(FullQueueException e){
            System.out.println("\nCoda piena");
            break;
         }
      }
      System.out.println("\n\nEstraggo 5 elementi dalla coda fissa circolare");    
      int index = 0;
      
      while(!q3.isEmpty() && index<5){
         System.out.print(q3.dequeue()+" ");
         index++;
      }
      System.out.println("\n\nInserisco 5 elementi nella coda fissa circolare");
      for(int i=0; i<5; i++){       
            int elem = rand.nextInt(100);            
            q3.enqueue(elem);
            System.out.print(elem+" ");
      }
      
      System.out.println("\n\nEstraggo gli elementi dalla coda fissa circolare");    
      while(!q3.isEmpty()){
         System.out.print(q3.dequeue()+" ");
      }  
          
      
      
      System.out.println("\n\nInserisco 20 elementi nella coda fissa circolare");
      for(int i=0; i<20; i++){   
        try{
            int elem = rand.nextInt(100);            
            q3.enqueue(elem);
            System.out.print(elem+" ");
        }
        catch(FullQueueException e){
            System.out.println("\nCoda piena");
            break;
        }
      }
      
      System.out.println("\n\nInserisco 20 elementi nella coda ridimensionabile circolare");
      for(int i=0; i<20; i++){   
        try{
            int elem = rand.nextInt(100);            
            q4.enqueue(elem);
            System.out.print(elem+" ");
        }
        catch(FullQueueException e){
            System.out.println("\nCoda piena");
            break;
        }
      }
      System.out.println("\n\nEstraggo tutti gli elementi dalle code");    
      while(!q3.isEmpty()){
         System.out.print(q3.dequeue()+" ");
      }
      while(!q4.isEmpty()){
         System.out.print(q4.dequeue()+" ");
      } 
      System.out.println("\n\nInserisco 9 elementi nella coda fissa circolare");
      for(int i=0; i<9; i++){   
        try{
            int elem = rand.nextInt(100);            
            q3.enqueue(elem);
            System.out.print(elem+" ");
        }
        catch(FullQueueException e){
            System.out.println("\nCoda piena");
            break;
        }
      }
      
      System.out.println("\n\nInserisco 9 elementi nella coda ridimensionabile circolare");
      for(int i=0; i<9; i++){   
        try{
            int elem = rand.nextInt(100);            
            q4.enqueue(elem);
            System.out.print(elem+" ");
        }
        catch(FullQueueException e){
            System.out.println("\nCoda piena");
            break;
        }
      }
      
      System.out.println();
      console.close();
   
   }


}