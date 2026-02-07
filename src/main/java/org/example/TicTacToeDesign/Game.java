package org.example.TicTacToeDesign;

import java.util.Scanner;

public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private WinningStrategy winningStrategy;
    private int moves;

    public Game(int size, WinningStrategy winningStrategy, Player player1, Player player2) {
        this.board = new Board(size);
        this.player1 = player1;
        this.player2 = player2;
        this.winningStrategy = winningStrategy;
        moves = 0;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        Player currentPlayer = player1;
        while (true) {

            board.displayBoard();
            System.out.println(currentPlayer.getName() + "'s turn. Enter row and column:");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (board.makeMove(row, col, currentPlayer.getSymbol())) {
                moves++;
                if (winningStrategy.checkWin(board, currentPlayer.getSymbol())) {
                    System.out.println(currentPlayer.getName() + " wins!");
                    break;
                } else if (moves == board.getSize() * board.getSize()) {
                    System.out.println("It's a draw!");
                    break;
                }
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        sc.close();
    }
}
