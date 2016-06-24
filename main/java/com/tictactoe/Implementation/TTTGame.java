package com.tictactoe.Implementation;

import com.tictactoe.Interface.Board;
import com.tictactoe.Interface.Piece;
import com.tictactoe.Interface.TicTacToe;

public class TTTGame implements TicTacToe {
	
	Player playerX;
	Player playerO;
	Board tttBoard;
	int numTurnsLeft = 9;
	
	public TTTGame() {
		tttBoard = new TTTBoard();
		initializePlayers();
		initializeBoard();
	}

	public Board getBoard() {
		return tttBoard;
	}

	public boolean isValidMove(Board currentState, Board nextState) {
		// TODO Auto-generated method stub
		return false;
	}
	

	public boolean isWinningBoard(Board board) {
		
		Piece currentPiece;
		if (getCurrentPlayer().getName().equals("Player X")) {
			currentPiece = Piece.X;
		} else {
			currentPiece = Piece.O;
		}
		
		// 8 ways to win
		if (tttBoard.getPieceAt(0, 0).equals(currentPiece)
				&& tttBoard.getPieceAt(0, 1).equals(currentPiece) 
				&& tttBoard.getPieceAt(0, 2).equals(currentPiece))  {
			return true;
		} else if (tttBoard.getPieceAt(1, 0).equals(currentPiece) 
				&& tttBoard.getPieceAt(1, 1).equals(currentPiece) 
				&& tttBoard.getPieceAt(1, 2).equals(currentPiece)) {
				return true;
		} else if (tttBoard.getPieceAt(2, 0).equals(currentPiece) 
				&& tttBoard.getPieceAt(2, 1).equals(currentPiece) 
				&& tttBoard.getPieceAt(2, 2).equals(currentPiece)) {
				return true;
		} 
		else if (tttBoard.getPieceAt(0, 0).equals(currentPiece) 
				&& tttBoard.getPieceAt(1, 0).equals(currentPiece) 
				&& tttBoard.getPieceAt(2, 0).equals(currentPiece)) {
				return true;
		} else if (tttBoard.getPieceAt(0, 1).equals(currentPiece) 
				&& tttBoard.getPieceAt(1, 1).equals(currentPiece) 
				&& tttBoard.getPieceAt(2, 1).equals(currentPiece)) {
				return true;
		} else if (tttBoard.getPieceAt(0, 2).equals(currentPiece) 
				&& tttBoard.getPieceAt(1, 2).equals(currentPiece) 
				&& tttBoard.getPieceAt(2, 2).equals(currentPiece)) {
				return true;
		} 
		else if (tttBoard.getPieceAt(0, 0).equals(currentPiece) 
				&& tttBoard.getPieceAt(1, 1).equals(currentPiece) 
				&& tttBoard.getPieceAt(2, 2).equals(currentPiece)) {
				return true;
		} else if (tttBoard.getPieceAt(0, 2).equals(currentPiece) 
				&& tttBoard.getPieceAt(1, 1).equals(currentPiece) 
				&& tttBoard.getPieceAt(2, 0).equals(currentPiece)) {
				return true;
		}
		else {
			return false;
		}

	}
	
	/* Player helper functions */
	
	public Player getCurrentPlayer() {
		if (playerX.isTurn) {
			return playerX;
		} else {
			return playerO;
		}
	}

	public void switchPlayer() {
		if (getCurrentPlayer().getName().contains("Player X")) {
			playerX.setTurn(false);
			playerO.setTurn(true);
		} else {
			playerO.setTurn(false);
			playerX.setTurn(true);
		}	
	}
	
	/* Initialization helper functions */ 
	
	private void initializeBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tttBoard.place(Piece.OPEN, i, j);
			}
		}
	}

	public void initializePlayers() {
		playerX = new Player();
		playerO = new Player();
		playerX.setName("Player X");
		playerX.setPiece(Piece.X);
		playerO.setName("Player 0");
		playerO.setPiece(Piece.O);
	}
	
	/* Board helper functions */
	
	public void printBoard() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Piece currentPiece = tttBoard.getPieceAt(i, j);
				if (currentPiece.equals(Piece.X)) {
					buffer.append ("|	X	|");
				} else if (currentPiece.equals(Piece.O)) {
					buffer.append("|	O	|");
				} else {
					buffer.append("|		|");
				}
			}
			buffer.append("\r");
		}
		System.out.println(buffer.toString());
	}


	public boolean isValidMove(Board board,int inputX, int inputY) {
		
		if (inputX < 0 || inputX > 2 || inputY < 0 || inputX > 2) {
			System.out.println("Position is out of bounds. Try again.");
			return false;
		}
		
		if (!board.getPieceAt(inputX, inputY).equals(Piece.OPEN)) {
			System.out.println("There is already a piece at that position. Try again.");
			return false;
		}
		numTurnsLeft--;
		return true;
	}

	public boolean checkIfTie() {
		return numTurnsLeft == 0;
	}

	public void startNewGame() {
		tttBoard.clear();
		numTurnsLeft=0;
		
	}
}
