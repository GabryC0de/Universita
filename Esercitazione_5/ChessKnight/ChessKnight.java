public class ChessKnight {
	// Inizializzazione delle varibili
	private String initialRow;
	private String initialCol;

	private String horseRow;
	private String horseCol;

	// private String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h"};
	// private String[] digits = {"1", "2", "3", "4", "5", "6", "7", "8"};

	String letters = "abcdefgh";
	String digits = "12345678";

	private String[][] chessBoard = new String[8][8];

	public ChessKnight(String initialSquare) {

		// Numero
		for (int row = 0; row < 8; row++) {
			// Lettera
			for (int col = 0; col < 8; col++) {
				chessBoard[row][col] = letters.substring(row, row + 1) + digits.substring(col, col + 1);
				System.out.print(chessBoard[row][col] + " ");
				if (col == 7) {
					System.out.println(" ");
				}
			}
		}

		if (!isChessValidSquare(initialSquare)) {
			System.out.println("La cella dichiarata non è valida!");
		} else {
			initialRow = initialSquare.substring(0, 1);
			initialCol = initialSquare.substring(1, 2);

			horseRow = initialRow;
			horseCol = initialCol;
		}

	}

	// Verifica se la casa specificata e' una casa valida della scacchiera,
	// ovvero se la stringa che la definisce e' di due caratteri di cui il primo
	// appartenente all'intervallo di caratteri [a, h],
	// il secondo all'intervallo di caratteri [1, 8].
	public boolean isChessValidSquare(String chessSquare) {

		if ((letters.contains(chessSquare.substring(0, 1).trim().toLowerCase()))
				&& (digits.contains(chessSquare.substring(1, 2).trim().toLowerCase())))
			return true;
		else
			return false;
	}

	// Verifica se la casa specificata e' una casa raggiungibile dalla posizione
	// attuale del Cavallo
	public boolean isKnightReachableSquare(String chessSquare) {
		int horsePositionRowIndex = 0;
		int horsePositionColIndex = 0;

		int chessSquareRowIndex = 0;
		int chessSquareColIndex = 0;

		// Lettera
		for (int col = 0; col < 8; col++) {
			// Numero
			for (int row = 0; row < 8; row++) {
				if (chessBoard[row][col] == (horseCol + horseRow)) {
					horsePositionColIndex = col;
					horsePositionRowIndex = row;
					break;
				}
			}
		}

		for (int col = 0; col < 8; col++) {
			// Numero
			for (int row = 0; row < 8; row++) {
				if (chessBoard[row][col] == chessSquare) {
					chessSquareRowIndex = col;
					chessSquareColIndex = row;
					break;
				}
			}
		}


		boolean columnExists = (((horsePositionColIndex + 2 <= 8) && (horsePositionColIndex + 2 >= 0)) && ((horsePositionColIndex - 2 <= 8) && (horsePositionColIndex - 2 >= 0)));
		boolean rowExists = (((horsePositionRowIndex + 2 <= 8) && (horsePositionRowIndex + 2 >= 0)) && ((horsePositionRowIndex - 2 <= 8) && (horsePositionRowIndex - 2 >= 0)));

		if(columnExists && rowExists){
			return true;
		} else {
			return false;
		}
	}

	// Se la casa specificata e' valida e raggiungibile, sposta il Cavallo nella
	// casa specificata
	public void moveToSquare(String newPosition) {
		if (isChessValidSquare(newPosition) && isKnightReachableSquare(newPosition)) {
			horseCol = newPosition.substring(0, 1);
			horseRow = newPosition.substring(1, 2);
		} else {
			System.out.println("La posizione specificata non è valida!");
		}

	}

	// descrizione testuale nella forma "Cavallo in cr" dove cr e' la posizione del
	// Cavallo nella scacchiera.
	public String knightToString() {
		if ((horseCol != null) && (horseRow != null)) {
			return ("Il cavaliere si trova in posizione: " + horseRow + horseCol);
		} else {
			return ("Il cavaliere non è stato inizializzato in una posizione valida");
		}
	}
}