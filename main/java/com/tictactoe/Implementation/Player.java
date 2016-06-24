package com.tictactoe.Implementation;

import com.tictactoe.Interface.Piece;


public class Player {
	boolean isTurn;
	String name;
	Piece piece;
	
	public boolean isTurn() {
		return isTurn;
	}
	public void setTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Piece getPiece() {
		return piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}

}
