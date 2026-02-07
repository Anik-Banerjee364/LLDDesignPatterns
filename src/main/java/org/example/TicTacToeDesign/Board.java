package org.example.TicTacToeDesign;

public class Board {

    private int size;
    private Cell[][] cells;

    public Board(int size) {
        this.size = size;
        this.cells = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell();
            }
        }
    }


    public boolean makeMove(int row, int col, Symbol symbol) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            throw new IllegalArgumentException("Invalid move: Out of bounds");
        }
        if (!cells[row][col].isEmpty()) {
            throw new IllegalArgumentException("Invalid move: Cell is already occupied");
        }
        cells[row][col].setSymbol(symbol);
        return true;
    }

    public Symbol getCellSymbol(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            throw new IllegalArgumentException("Invalid cell position: Out of bounds");
        }
        return cells[row][col].getSymbol();
    }

    public int getSize() {
        return size;
    }

    public void displayBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(cells[i][j].getSymbol() + " ");
            }
            System.out.println();
        }
    }
}
