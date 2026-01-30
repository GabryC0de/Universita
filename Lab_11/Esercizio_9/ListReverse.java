import java.util.Scanner;

public class ListReverse{
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		String line = "";
		boolean flag = false;
		int num = 0;
		
		while(!flag){
			try{
				System.out.println("Inserire un numero intero: ");
				num = scan.nextInt();
				flag = true;
			} catch(Exception e){
				scan.nextLine();
				System.out.println(e);
			}
		}		
		scan.close();
		
		LinkedList list = new LinkedList();
		
		for(int i = 0; i < num; i++){
			list.addLast(i);
		}
		
		ListIterator it = list.getIterator();
		printReverse(it);
		
	}
	
	public static void printReverse(ListIterator i){
		if(!i.hasNext()){
			return;
		}
		
		Object element = i.next();
		
		printReverse(i);
		
		System.out.println(element);
	}
}