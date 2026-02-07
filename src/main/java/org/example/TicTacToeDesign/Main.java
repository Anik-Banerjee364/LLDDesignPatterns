package org.example.TicTacToeDesign;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Anik", Symbol.X);
        Player player2 = new Player("Samit", Symbol.O);

        WinningStrategy winningStrategy = new DefaultWinningStrategy();

        Game game = new Game(3, winningStrategy, player1, player2);
        game.start();
    }
}
