package com.tictactoe.Implementation;

import java.util.Scanner;


import com.tictactoe.Interface.Board;
import com.tictactoe.Interface.Piece;

public class PlayTTT {
	
	static TTTGame tttGame;
	static Scanner scanner;
	static boolean computerMode;
	static boolean gameOver = false;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		initialize();
		
		if(computerMode) {
			playComputer();
		} else {
			play2player();
		}
	}
		
		
	
	public static void play2player() {
		while (!gameOver) {
			doHumanTurn();		
			tttGame.printBoard();			
			gameOver = isGameOver();
			endOrRestartGame();
		}		
	}
	
	
	public static void playComputer() {
		while (!gameOver) {

			Player currentPlayer = tttGame.getCurrentPlayer();
			if (currentPlayer.getName().equals("Player O")) {
				doComputerTurn();
			} else {
				doHumanTurn();
			}
			tttGame.printBoard();
			
			gameOver = isGameOver();
			endOrRestartGame();
		}		
		
	}
	
	private static void doHumanTurn() {
		boolean inputCorrect = false;
		int inputX = 0, inputY = 0;
		System.out.print(tttGame.getCurrentPlayer().getName() + "'s turn. Input format as [x,y] ");	
		while (!inputCorrect) {
			try {
				String input = scanner.nextLine();
				String[] tokens = input.split(",");
				inputX = Integer.parseInt(tokens[0]);
				inputY= Integer.parseInt(tokens[1]);
				if (tttGame.isValidMove(tttGame.getBoard(), inputX, inputY)) {
					tttGame.getBoard().place(tttGame.getCurrentPlayer().getPiece(), inputX, inputY);
					inputCorrect = true;
				}
			} catch (Exception e) {
				System.out.println("Bad position input. Format is [x,y]");
				continue;
			}
		}
	}
	
	private static void doComputerTurn() {
		System.out.println(tttGame.getCurrentPlayer().getName() + "'s turn.");	
		Board possibleMoves  = tttGame.getBoard();
	    outerloop:
		for (int i = 0; i < possibleMoves.getBoardHeight(); i++) {
			for (int j = 0; j < possibleMoves.getBoardWidth(); j++) {
				if (possibleMoves.getPieceAt(i, j).equals(Piece.OPEN)) {
					tttGame.getBoard().place(tttGame.getCurrentPlayer().getPiece(), i, j);
					break outerloop;
				}
			}
		}
	}
	
	private static void endOrRestartGame() {
		if (gameOver) {
			System.out.println("Would you like to play again? Y/N");
			String input = scanner.nextLine();
			if (input.toUpperCase().equals("Y")) {
				gameOver = false;
				tttGame.startNewGame();
			} else {
				scanner.close();
				System.out.println("Goodbye!");
				System.exit(0);
			}
		} else {
			tttGame.switchPlayer();
		}
	}
	

	private static void initialize() {
		System.out.println("Starting new Tic Tac Toe Game");
		boolean isInputValid = false;
		computerMode  = false;
		while (!isInputValid) {
			System.out.println("Would you like to play:S \r 1. 2-Player\r 2. Human vs. Computer");
			String input = scanner.nextLine();
			int answer = Integer.parseInt(input);
			if (answer == 1) {
				computerMode = false;
				isInputValid = true;
			} else if (answer == 2) {
				computerMode = true;
				isInputValid = true;
			} else {
				System.out.println("Please input valid answer.");
			}
		}
		
		tttGame = new TTTGame();
		tttGame.playerX.setTurn(true);	
	}

	private static boolean isGameOver() {
		// check if the game is over.
		if (tttGame.isWinningBoard(tttGame.getBoard())) {
			System.out.println(tttGame.getCurrentPlayer().getName() + " won!");
			return true;
		} else if (tttGame.checkIfTie()) {
			System.out.println("It's a tie!");
			return true;
		} else {
			return false;
		}
		
	}


}
