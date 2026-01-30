public class BilanciaParentesi{

   public static void main(String[] args){
      
      String[] s = { "",
                     "()()()()",
                     "((((()))))",
                     "(()(()()))",
                     "()())()",
                     "(((()))))",
                     "(()(()())",
                     "())()(())"};
   
      System.out.println("Verifica bilanciamento con la pila");
      for(int i=0; i<s.length; i++){
         if(bilanciaStack(s[i]))
            System.out.println("La stringa "+s[i]+" e' bilanciata");
         else
            System.out.println("La stringa "+s[i]+" non e' bilanciata");
      }
      
      System.out.println("Verifica bilanciamento con metodo ricorsivo");
      for(int i=0; i<s.length; i++){
         if(bilancia(s[i],0))
            System.out.println("La stringa "+s[i]+" e' bilanciata");
         else
            System.out.println("La stringa "+s[i]+" non e' bilanciata");
      }
           
   }

   
   public static boolean bilancia(String s, int open){
   
      // caso base
      if(s.equals("")){
         if(open==0){
            return true;
         }
         else{
            return false;
         }
      }
      if(open<0){ // in qualsiasi istante se ho piu' parentesi chiuse non va bene
         return false;
      }
      // chiamata ricorsiva al sottoproblema
      if(s.charAt(0) == '('){
         return bilancia(s.substring(1),open+1);
      }
      else{
         return bilancia(s.substring(1),open-1);
      }
      
   }

   
   public static boolean bilanciaStack(String s){
      GrowingArrayStack stack = new GrowingArrayStack();
      
      
      for(int i=0; i<s.length(); i++){
         try{
            // inserisco le parentesi aperte
            if(s.charAt(i)=='('){
               stack.push('(');
            }
            else{ // se trovo una parentesi chiusa tolgo la parentesi aperta in cima
                  // allo stack in quanto sono accoppiate
               stack.pop();
            }
         }
         catch(EmptyStackException e){
            // l'eccezione viene lanciata se trovo una parentesi chiusa
            // senza averne aperta una corrispondente
            return false;
         }
      }
   
      // se ho esaminato tutta la stringa significa che non
      // ho mai trovato piu' parentesi chiuse che aperte
      // se la pila a questo punto e' vuota vuol dire che le
      // parentesi sono effettivamente bilanciate.
      if(stack.isEmpty()){
         return true;
      }
      else{
         return false;
      }
      
   }

}