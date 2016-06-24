package com.tictactoe.Implementation;

import java.util.Scanner;

public class PlayTTT {
	
	static TTTGame tttGame;

	public static void main(String[] args) {
		
		initialize();
		
		Scanner scanner = new Scanner(System.in);
		
		boolean gameOver = false;
		
		while (!gameOver) {
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
			
			tttGame.printBoard();
			
			gameOver = isGameOver();
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
	}
	

	private static void initialize() {
		System.out.println("Starting new Tic Tac Toe Game");
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
