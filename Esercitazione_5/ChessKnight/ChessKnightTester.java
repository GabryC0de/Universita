public class ChessKnightTester{
	public static void main(String[] args){
		ChessKnight knight = new ChessKnight("a8");
		System.out.println(knight.knightToString());

		String square = "g6";
		knight.isChessValidSquare(square);
		knight.isKnightReachableSquare(square);
		knight.moveToSquare(square);
		System.out.println(knight.knightToString());
	}
}