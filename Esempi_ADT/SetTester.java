import java.util.*;

public class SetTester{

   public static void main(String[] args){
   
      Set sort = new ArraySet();
      Set sort2 = new ArraySet();
      
      String[] s = {"ciao", "evviva", "fine", "corsi", "ciao", "esame"};
      String[] s2 = {"evviva", "esami", "fondamenti", "informatica", "analisi", "ciao"};
      
      for(int i=0; i<s.length; i++){
         System.out.println("Provo a inserire "+s[i]);
         sort.add(s[i]);
      }
      
      
      System.out.println("Stampo il contenuto");
      Object[] elements = sort.toArray();
      for(int i=0; i<elements.length; i++){
         System.out.println(elements[i]);
      }
      
      System.out.println("Popolo il secondo insieme");        
      for(int i=0; i<s2.length; i++){
         sort2.add(s2[i]);
      } 
      System.out.println("Stampo il contenuto");
      elements = sort2.toArray();
      for(int i=0; i<elements.length; i++){
         System.out.println(elements[i]);
      }
      
      System.out.println("---------------------");
      System.out.println("Stampo l'unione");
      Set unionSet = ArraySet.union(sort,sort2);
      elements = unionSet.toArray();
      for(int i=0; i<elements.length; i++){
         System.out.println(elements[i]);
      }
      
      System.out.println("---------------------");
      System.out.println("Stampo l'intersezione");
      Set intSet = ArraySet.intersection(sort,sort2);
      elements = intSet.toArray();
      for(int i=0; i<elements.length; i++){
         System.out.println(elements[i]);
      }
      
      System.out.println("---------------------");
      System.out.println("Stampo la differenza");
      Set diffSet = ArraySet.subtract(sort,sort2);
      elements = diffSet.toArray();
      for(int i=0; i<elements.length; i++){
         System.out.println(elements[i]);
      }
    
     
   }


}

class NonComparable{
   
}