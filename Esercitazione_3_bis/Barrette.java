import java.util.Scanner;

// Le calorie necessarie per una donna sono:
// MB = 655 + (9.6* peso in Kg) + (1.8 * altezza in cm) - (4.7 * eta' in anni)

// Le calorie necessarie per un uomo sono:
// MB = 66 + (13.8* peso in Kg) + (5.0 * altezza in cm) - (6.8 * eta' in anni)

// Una barretta di cioccolato contiene circa 230 calorie. Scrivere un programma eseguibile che consenta all'utente di inserire il proprio peso, 
// la propria altezza e la propria eta'. Il programma dovra' stampare il numero di barrette che si dovrebbero consumare per mantenere il proprio peso
// sia che si tratti di un uomo che di una donna con i valori di peso, altezza ed eta' specificati.

public class Barrette{
	public static void main(String[] args){
		final int BAR_CAL = 230;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("L'utente e' uomo ('U') o donna ('D')? ");
		String genere = scanner.nextLine().toUpperCase().trim();
		
		System.out.print("Inserire il proprio peso: ");
		double weight = scanner.nextDouble();
		
		System.out.print("Inserire la propria altezza: ");
		double height = scanner.nextDouble();	
		
		System.out.print("Inserire la propria eta': ");
		double age = scanner.nextInt();	
		
		scanner.close();
		
		double woman_need = 655 + (9.6* weight) + (1.8 * height) - (4.7 * age);
		double man_need = 66 + (13.8* weight) + (5.0 * height) - (6.8 * age);
		
		if(genere.equals("U")){
			System.out.print("\nUn uomo dovrebbe mangiare: " + (int)(man_need / BAR_CAL));
		} else if(genere.equals("D")){
			System.out.print("Una donna dovrebbe mangiare: " + (int)(woman_need / BAR_CAL));
		}
	}
}