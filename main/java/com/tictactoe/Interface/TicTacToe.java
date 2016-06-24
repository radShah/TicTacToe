package com.tictactoe.Interface;

/**
 * A "game" of tic-tac-toe, provides current state, validation and win detection.
 */
public interface TicTacToe {

  /**
   * Get the {@link Board} encapsulating the current state of the tic-tac-toe game.
   * @return The {@link Board} with current game state.
   */
  Board getBoard();

  /**
   * Determine if the change of state is valid.
   *
   * @param currentState The {@link Board} representing the current state of the tic-tac-toe game.
   * @param nextState The @{link Board} representing the potential next state of the tic-tac-toe-game.
   * @return True if and only if the state change is valid, false otherwise.
   */
  boolean isValidMove(Board currentState, Board nextState);

  /**
   * Determine if the {@link Board} contains a winning position.
   *
   * @param board The {@link Board} encapsulating the state of the tic-tac-toe game.
   * @return True if and only if the {@link Board} contains a winning position, false otherwise.
   */
  boolean isWinningBoard(Board board);

}
