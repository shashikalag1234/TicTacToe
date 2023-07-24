package com.ttt.tdd;

import com.ttt.exceptions.TicTacToeException;

public class TicTacToe {

	private Character[][] board = { { '\0', '\0', '\0' }, { '\0', '\0', '\0' }, { '\0', '\0', '\0' } };
	private char lastPlayer = '\0';
	public static final String ERROR_MSG_OF_X_VALUE_IF_OUTSIDE_THE_BOARD = "X value is outside the board!";
	public static final String ERROR_MSG_OF_Y_VALUE_IF_OUTSIDE_THE_BOARD = "Y value is outside the board!";
	public static final String FFIELD_IS_OCCUPIED = "Field is occupied!";
	public static final String ALL_FIELDS_ARE_FILLEd_ITS_A_DRAW= "It is a draw";
	public static final String NO_WINNER= "It is a draw";




	public String play(int column, int row) {
		checkAxis(column, ERROR_MSG_OF_X_VALUE_IF_OUTSIDE_THE_BOARD);
		checkAxis(row, ERROR_MSG_OF_Y_VALUE_IF_OUTSIDE_THE_BOARD);
		lastPlayer = nextPlayer();
		setField(column, row, FFIELD_IS_OCCUPIED, lastPlayer);
		if (isWinner()) {
			return lastPlayer + " is the Winner";
		}
			else if (isDraw()) {
	            return ALL_FIELDS_ARE_FILLEd_ITS_A_DRAW;
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
