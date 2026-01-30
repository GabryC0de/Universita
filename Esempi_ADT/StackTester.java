import java.util.*;

public class StackTester{

   public static void main(String[] args){
   
      FixedArrayStack s = new FixedArrayStack();
      GrowingArrayStack s2 = new GrowingArrayStack();
      Random rand = new Random();
      Scanner console = new Scanner(System.in);
      
      System.out.println("Numero di elementi da introdurre nella pila?");
      int n = console.nextInt();
      
      System.out.println("Inserisco "+n+" elementi nella pila a dimensione fissa");
      for(int i=0; i<n; i++){
         try{
            s.push(rand.nextInt(100));
            System.out.print(s.top()+" ");
         }
         catch(FullStackException e){
            System.out.println("\nPila piena");
            break;
         }
      }
      System.out.println("\nEstraggo gli elementi dalla pila a dimensione fissa = 10");    
      while(!s.isEmpty()){
         System.out.print(s.pop()+" ");
      }   
      
      System.out.println("\n\nInserisco "+n+" elementi nella pila ridimensionabile");
      for(int i=0; i<n; i++){       
            s2.push(rand.nextInt(100)); 
            System.out.print(s2.top()+" ");
      }
      System.out.println("\n\nEstraggo gli elementi dalla pila ridimensionabile");    
      while(!s2.isEmpty()){
         System.out.print(s2.pop()+" ");
      }  
      System.out.println();
      console.close();
   
   }


}