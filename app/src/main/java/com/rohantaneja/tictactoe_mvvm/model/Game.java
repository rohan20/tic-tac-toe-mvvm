package com.rohantaneja.tictactoe_mvvm.model;

/**
 * Created by rohantaneja on 05/04/18.
 */

public class Game {

    private static final int BOARD_SIZE = 3;

    private Cell[][] cells;

    private Player player1;
    private Player player2;

    private Player currentPlayer;
    private Player winner;

    public Game() {
        cells = new Cell[BOARD_SIZE][BOARD_SIZE];
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1 ? player2 : player1);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}
