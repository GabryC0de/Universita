public class SquareTester {
    public static void main(String[] args) {
        int[] coords = { 0, 0 };
        Square square = new Square(coords, 10);
        System.out.println(square.getArea());
        square.setSize(12);
        System.out.println(square.getArea());
        square.setSize(13, 13);
        System.out.println(square.getArea());
    }
}