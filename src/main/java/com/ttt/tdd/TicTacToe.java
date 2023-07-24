package com.ttt.tdd;

import com.ttt.exceptions.TicTacToeException;

public class TicTacToe {

	private Character[][] board = { { '\0', '\0', '\0' }, { '\0', '\0', '\0' }, { '\0', '\0', '\0' } };
	private char lastPlayer = '\0';

	public String play(int column, int row) {
		checkAxis(column, "X value is outside the board!");
		checkAxis(row, "Y value is outside the board!");
		lastPlayer = nextPlayer();
		setField(column, row, "Field is occupied!", lastPlayer);
		if (isWinner()) {
			return lastPlayer + " is the Winner";
		}
			else if (isDraw()) {
	            return "It is a draw";
	        } 
			else{
				return "No winner";
			}
		}
	

	private boolean isWinner() {
		for (int i = 0; i < 3; i++) {
			if (board[0][i] == lastPlayer && board[1][i] == lastPlayer && board[2][i] == lastPlayer
					|| board[i][0] == lastPlayer && board[i][1] == lastPlayer && board[i][2] == lastPlayer) {
				return true;
			} else if (board[0][0] == lastPlayer && board[1][1] == lastPlayer && board[2][2] == lastPlayer
					|| board[2][0] == lastPlayer && board[1][1] == lastPlayer && board[0][2] == lastPlayer)
				return true;

		}
		return false;
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

	private void setField(int column, int row, String msg, char lastPlayer) {
		if (board[column - 1][row - 1] != '\0') {
			throw new TicTacToeException(msg);
		} else {
			board[column - 1][row - 1] = lastPlayer;
		}

	}
	
	private boolean isDraw() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (board[x][y] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

}
