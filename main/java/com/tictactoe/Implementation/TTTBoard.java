package com.tictactoe.Implementation;

import java.util.Arrays;

import com.tictactoe.Interface.Board;
import com.tictactoe.Interface.Piece;

public class TTTBoard implements Board {
	
	Piece[][] TTTBoard = new Piece[3][3];

	public Piece getPieceAt(int x, int y) throws IndexOutOfBoundsException {
		return TTTBoard[x][y];
	}

	public void place(Piece piece, int x, int y)
			throws IndexOutOfBoundsException {
		
		if (x < 0 || x > 2 || y < 0 || y > 2) {
			throw new IndexOutOfBoundsException("Position is out-of-bounds!");
		}
		TTTBoard[x][y] = piece;
		
	}

	public void clear() {
		for (Piece[] row : TTTBoard) {
			Arrays.fill(row, Piece.OPEN);
		}
	}
	

}
