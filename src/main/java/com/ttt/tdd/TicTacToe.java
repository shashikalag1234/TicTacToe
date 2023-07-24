package com.ttt.tdd;

import com.ttt.exceptions.TicTacToeException;

public class TicTacToe {

	private Character[][] board = { { '\0', '\0', '\0' }, { '\0', '\0', '\0' }, { '\0', '\0', '\0' } };
	private char lastPlayer = '\0';

	public String play(int column, int row) {
		checkAxis(column, "X value is outside the board!");
		checkAxis(row, "Y value is outside the board!");
		setField(column, row, "Field is occupied!");
		lastPlayer = nextPlayer();
		return checkWin();
	}

	private String checkWin() {
		String winner = "No winner";
		for (int index = 0; index < 3; index++) {
			if (board[0][index] == lastPlayer && board[1][index] == lastPlayer && board[2][index] == lastPlayer) {
				return lastPlayer + " is the Winner";
			}
		}
		return winner;
	}

	public char nextPlayer() {
		if (lastPlayer == 'X') {
			return 'O';
		}
		return 'X';

	}

	private void checkAxis(int axis, String message) {
		if (axis < 1 || axis > 3) {
			throw new TicTacToeException(message);
		}
	}

	private void setField(int column, int row, String msg) {
		if (board[column - 1][row - 1] != '\0') {
			throw new TicTacToeException(msg);
		} else {
			board[column - 1][row - 1] = lastPlayer;
		}

	}

}
