import java.util.Scanner;

public class InvertArrayOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = 3;

        int[] initialArr = new int[len];

        int count = 0;

        while (true) {
            System.out.println("Inserire un numero: ");
            String num = scanner.nextLine();
            if (!num.trim().toLowerCase().equals("q")) {
                if(count < initialArr.length){
                    initialArr[count] = Integer.parseInt(num);
                } else {
                    initialArr = ArrayUtil.resize(initialArr, initialArr.length + 1);
                    initialArr[count] = Integer.parseInt(num);             
                }
                count++;
            } else {
                System.out.println("Ciclo terminato...");
                break;
            }
        }
        scanner.close();

        for (int i = initialArr.length - 1; i >= 0; i--) {
            System.out.println(initialArr[i]);
        }

    }
}
