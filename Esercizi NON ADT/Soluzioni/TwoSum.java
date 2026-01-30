import java.util.*;

public class TwoSum{

   public static void main(String args[]){
   
      int[] a = {-4,6,2,3,9,4,7,18,1,5,10,-9,-23,45,-11,23};
      //stampo l'array per controllo
      for(int i=0; i < a.length; i++){
         System.out.print(a[i]+" ");
      }
      
      
      // soluzione O(n^2)
      System.out.println("\n---------------------");
      System.out.println("Soluzione quadratica");
      
      // per ogni elemento dell'array
      for(int i=0; i<a.length; i++){       
         //cerco tra i successivi se c'e' l'opposto
         //in questo modo riporto le coppie solo una volta
         for(int j=i+1; j<a.length; j++){
           
            if(a[j]==-a[i]){
               System.out.println("Coppia a["+i+"]="+a[i]+" e a["+j+"]="+a[j]);              
            }       
         }
      }
      
         
      
      // soluzione nlogn
      System.out.println("---------------------");
      System.out.println("Soluzione nlogn");
      
      //ordino gli elementi con mergesort O(nlogn)
      mergesort(a); 
      //stampo l'array per controllo
      for(int i=0; i<a.length; i++){
         System.out.print(a[i]+" ");
      }
      System.out.println();
      
      // per ogni elemento O(n)
      for(int i=0; i<a.length; i++){ 
         //cerco l'opposto con ricerca binaria O(log n)
         int j = binSearch(a,-a[i]);
         //la prima condizione mi dice se ho trovato l'opposto
         //la seconda condizione mi permette di stampare le coppie una sola volta
         if(j!= -1 && i<j){
            System.out.println("Coppia a["+i+"]="+a[i]+" e a["+j+"]="+a[j]);                         
         }
      }
      
      System.out.println("---------------------");
      System.out.println("Soluzione nlogn alternativa");
      //ordino gli elementi con mergesort O(nlogn)
      mergesort(a); 
       
      int left = 0;
      int right = a.length-1;
      
      // ad ogni iterazione almeno uno dei due indici viene
      // modificato (left incrementato, right decrementato)
      // poiche' quando si "incrociano" termina l'esecuzione
      // il numero di iterazioni e' al piu' n
      while(left<right && a[left]<0 && a[right]>0){
      
         System.out.println("Confronto "+a[left]+" e "+a[right]);
         
         if(a[left]== -a[right]){
            System.out.println("Coppia a["+left+"]="+a[left]+" e a["+right+"]="+a[right]);                                 
            left++;
            right--;
         }
         else if(Math.abs(a[left])>a[right]){
            left++;
         } 
         else{
            right--;
         }
      }
      
   
      
     
      // soluzione tempo atteso n + spazio n
      System.out.println("---------------------");
      System.out.println("Soluzione tempo atteso n + spazio n");      
      
      //creo una hastable di dimensione m e inserisco gli elementi
      MyHashTable ht = new MyHashTable(a.length);
      for(int i=0; i<a.length;i++){
         ht.insert(a[i],i);
      }
      System.out.println(ht.toString());
      
      //per ogni elemento dell'array O(n)
      for(int i=0; i<a.length; i++){
         
         //cerco l'opposto: tempo atteso di ricerca O(1)
         Integer elem = (Integer)ht.find(-a[i]);
         //attenzione a come si controlla se l'elemento e' stato trovato
         //e al vincolo sugli indici per stampare una sola coppia
         if(elem!=null && elem.compareTo(i)>0){
            System.out.println("Coppia a["+i+"]="+a[i]+" e a["+elem+"]="+a[elem.intValue()]);                                
         }
      }
   
     
   }
   
   
   public static void mergesort(int[] a){  
      if(a == null){
         throw new IllegalArgumentException();
      }
      if(a.length<=1){
         return;
      }
      int m = a.length/2;     
      int[] left = new int[m];
      int[] right = new int[a.length-m];
      System.arraycopy(a,0,left,0,left.length);
      System.arraycopy(a,m,right,0,right.length);
      mergesort(left);
      mergesort(right);
      merge(a,left,right);     
   }

   public static void merge(int[] a, int[] b, int[] c){
      int ia=0, ib=0, ic=0;   
      while(ib<b.length && ic<c.length){     
         if(b[ib]<c[ic]){
            a[ia] = b[ib];
            ia++; ib++;
         }
         else{
            a[ia] = c[ic];
            ia++; ic++;
         }
      }      
      while(ib<b.length){
         a[ia] = b[ib];
         ia++; ib++;
      }     
      while(ic<c.length){
         a[ia] = c[ic];
         ia++; ic++;
      }
   } 
      
      public static int binSearch(int[] a, int target){    
         return binarySearch(a,target,0,a.length);
      }
            
      public static int binarySearch(int[] a, int target, int left, int right){    
         if(right<left){
            return -1;
         }
         int m = (left+right)/2;
         if(a[m]==target){
            return m;
         }
         if(a[m]<target){
            return binarySearch(a,target,m+1,right);
         }
         else{
            return binarySearch(a,target,left,m-1);
         }
      
      }
   
}