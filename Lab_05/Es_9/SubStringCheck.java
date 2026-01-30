import java.util.Scanner;

public class SubStringCheck{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Inserire la prima stringa: ");
		String s1 = scanner.nextLine();
		
		System.out.println("Inserire la stringa da controllare: ");
		String s2 = scanner.nextLine();
				
		scanner.close();
		
		final int LENGTH_1 = s1.length();
		final int LENGTH_2 = s2.length();
		boolean isSubstring = false;
		if(LENGTH_2 != 0){
			for(int i = 0; i < LENGTH_1; i ++){
				if(s2.charAt(0) == s1.charAt(i)){					
					if(i + LENGTH_2 > LENGTH_1){
						break;
					}
					
					for(int j = 1; j < LENGTH_2; j++){
						
						if(s2.charAt(j) == s1.charAt(j + i)){
							isSubstring = true;						
						} else {
							isSubstring = false;
						}
					}
				}
			}
			if(isSubstring){
				System.out.println("La seconda stringa è contenuta nella prima.");
			} else {
				System.out.println("La second stringa NON è contenuta nella prima.");
			}
		} else {
			System.out.println("La stringa 2 è vuota. Vale come sottostringa della prima.");
		}
	}
}