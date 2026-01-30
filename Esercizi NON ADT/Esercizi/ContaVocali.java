public class ContaVocali{
	
	private static String s = "aoinoaioiawuyeb3q2897409q8wnbcb01324f8iundcuqwn0iNPASJUCBNERUR9YVWQBOWIECNQW";
	private static String vowels = "aeiou";
	private static int count = 0;
	
	public static void main(String[] args){
		
		s = s.toLowerCase();
		
		for(int i = 0; i < s.length(); i++){
			if(vowels.indexOf(s.charAt(i)) != -1) count++;
		}
		
		System.out.println("Iterativo: " + count);
		
		System.out.println("Ricorsivo: " + countVowels(s));
	}
	
	private static int countVowels(String s){
				
		if(s.length() < 1){
			return 0;
		}
		
		String sub = s.substring(0, 1).toLowerCase();
		
		int trovata = (vowels.indexOf(sub) != -1) ? 1 : 0;
				
		return trovata + countVowels(s.substring(1, s.length()));
	}
}