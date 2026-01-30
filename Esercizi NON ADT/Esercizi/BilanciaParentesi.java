public class BilanciaParentesi{
	
	private static String s = "()(()";
	
	public static void main(String[] args){
		System.out.println(balanceCheck(s));
	}
	
	private static boolean balanceCheck(String s){
		return check(s, 0);
	}
	
	private static boolean check(String s, int count){
		
		if(s.isEmpty()){
			return count == 0;
		}
		
		if(count < 0){
			return false;
		}
		
		if(s.charAt(0) == '(') count++;
		if(s.charAt(0) == ')') count--;
		
		return check(s.substring(1, s.length()), count);
	
	}
}