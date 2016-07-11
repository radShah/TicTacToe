package com.tictactoe.Interface;


/**
 * An interface for a standard 3x3 tic-tac-toe board.
 */
public interface Board {
	
	
	int height = 3;
	int width = 3;
	
	int getBoardHeight();
	int getBoardWidth();

  /**
   * Get the {@link Piece} at the given position on the board.
   *
   * @param x The horizontal index.
   * @param y The vertical index.
   * @return The @{Piece} at the given position.
   * @throws IndexOutOfBoundsException
   */
  Piece getPieceAt(int x, int y) throws IndexOutOfBoundsException;

  /**
   * Place the specified {@link Piece} at the given position.
   *
   * @param piece The type of {@link Piece} piece to place.
   * @param x The horizontal index.
   * @param y The vertical index.
   * @throws IndexOutOfBoundsException
   */
  void place(Piece piece, int x, int y) throws IndexOutOfBoundsException;

  /**
   * Clear all pieces from the board such that all positions are open.
   */
  void clear();

}
