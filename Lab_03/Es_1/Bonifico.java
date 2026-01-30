public class Bonifico {

    public static void main(String[] args) {
        BankAccount conto_1 = new BankAccount();
        BankAccount conto_2 = new BankAccount();

        conto_1.deposit(1000);
        conto_2.deposit(100);

        System.out.println(conto_1.getBalance());
        System.out.println(conto_2.getBalance());

        conto_1.withdraw(400);
        conto_2.deposit(400);

        System.out.println(conto_1.getBalance());
        System.out.println(conto_2.getBalance());
    }
}
