public class ContaVocali{

   public static void main(String[] args){
      
      String s = "aeiouTGERJGNWwefjhweihfwA";
      System.out.println("Il numero di vocali di "+s+"e' "+contaV(s.toUpperCase()));
      
   
   }

   
   public static int contaV(String s){
   
      if(s==null) throw new IllegalArgumentException();
   
      //caso base
      if(s.length()==0){
         return 0;
      }
      // passo ricorsivo
      char c = s.charAt(0);
      if(c=='A'|| c=='E' || c=='I' || c=='O' || c=='U'){
         return 1+contaV(s.substring(1));
      }
      return contaV(s.substring(1));
   
   }

}