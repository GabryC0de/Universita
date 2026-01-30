// Cont Gabriele 2186454

import java.util.Scanner;

public class Cont2186454Ric{
	
	private static String vowels = "aeiou";
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Inserire una stringa: ");
		String line = scan.nextLine();
		
		System.out.print("Ordinate: ");
		System.out.println(orderedVowels(line));
		
		System.out.print("Invertite: ");
		System.out.println(reverseVowels(line));
	}
	
	public static String orderedVowels(String s){
		if(s.length() == 0){
			return "";
		}
		
		String currChar = s.substring(0, 1).toLowerCase();
		
		if(vowels.contains(currChar)){
			return s.substring(0, 1) + orderedVowels(s.substring(1, s.length()));
		} else {
			return "" + orderedVowels(s.substring(1, s.length()));
		}
	}
	
	public static String reverseVowels(String s){
		if(s.length() == 0){
			return "";
		}
				
		String checkChar = s.substring(s.length() - 1, s.length()).toLowerCase();
		
		if(vowels.contains(checkChar)){
			return s.substring(s.length() - 1, s.length()) + reverseVowels(s.substring(0, s.length() - 1));
		} else {
			return "" + reverseVowels(s.substring(0, s.length() - 1));
		}
		
	}
	
}