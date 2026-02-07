package org.example.TicTacToeDesign;

public class DefaultWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWin(Board board, Symbol symbol) {
        int size = board.getSize();

        // Check rows
        for (int i = 0; i < size; i++) {
            boolean win = true;
            for (int j = 0; j < size; j++) {
                if (board.getCellSymbol(i, j) != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // Check columns
        for (int j = 0; j < size; j++) {
            boolean win = true;
            for (int i = 0; i < size; i++) {
                if (board.getCellSymbol(i, j) != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // Check diagonal
        boolean win = true;
        for (int i = 0; i < size; i++) {
            if (board.getCellSymbol(i, i) != symbol) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Check anti-diagonal
        win = true;
        for (int i = 0; i < size; i++) {
            if (board.getCellSymbol(i, size - i - 1) != symbol) {
                win = false;
                break;
            }
        }
        return win;
    }
}
