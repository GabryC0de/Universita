import java.util.*;

public class SortedSetTester{

   public static void main(String[] args){
   
      SortedSet sort = new ArraySortedSet();
      SortedSet sort2 = new ArraySortedSet();
      
      String[] s = {"ciao", "evviva", "fine", "corsi", "ciao", "esame"};
      String[] s2 = {"evviva", "esami", "fondamenti", "informatica", "analisi", "ciao"};
      
      for(int i=0; i<s.length; i++){
         System.out.println("Provo a inserire "+s[i]);
         sort.add(s[i]);
      }
      
      
      System.out.println("Provo a inserire un oggetto di una classe che non implementa Comparable");
      try{
         sort.add(new NonComparable());
      }
      catch(IllegalArgumentException e){
         System.out.println("Ho catturato l'eccezione!!");
      }
      
      
      System.out.println("Stampo il contenuto");
      Comparable[] elements = sort.toSortedArray();
      for(int i=0; i<elements.length; i++){
         System.out.println(elements[i]);
      }
      
      System.out.println("Popolo il secondo insieme");        
      for(int i=0; i<s2.length; i++){
         sort2.add(s2[i]);
      } 
      System.out.println("Stampo il contenuto");
      elements = sort2.toSortedArray();
      for(int i=0; i<elements.length; i++){
         System.out.println(elements[i]);
      }
      
      System.out.println("---------------------");
      System.out.println("Stampo l'unione");
      SortedSet unionSet = ArraySortedSet.union(sort,sort2);
      elements = unionSet.toSortedArray();
      for(int i=0; i<elements.length; i++){
         System.out.println(elements[i]);
      }
      
      System.out.println("---------------------");
      System.out.println("Stampo l'intersezione");
      SortedSet intSet = ArraySortedSet.intersection(sort,sort2);
      elements = intSet.toSortedArray();
      for(int i=0; i<elements.length; i++){
         System.out.println(elements[i]);
      }
      
      System.out.println("---------------------");
      System.out.println("Stampo la differenza");
      SortedSet diffSet = ArraySortedSet.subtract(sort,sort2);
      elements = diffSet.toSortedArray();
      for(int i=0; i<elements.length; i++){
         System.out.println(elements[i]);
      }
    
     
   }


}

class NonComparable{
   
}