package org.example.TicTacToeDesign;

public interface WinningStrategy {
    boolean checkWin(Board board, Symbol symbol);
}
