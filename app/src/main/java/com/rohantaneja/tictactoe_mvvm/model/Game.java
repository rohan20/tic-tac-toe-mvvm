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

    private boolean areCellsEqual(Cell... cells) {

        //check if 2D array is null or empty
        if (cells == null || cells.length == 0) {
            return false;
        }

        //check if each cell of the array is null or empty
        for (Cell cell : cells)
            if (cell == null || cell.getPlayer().getValue() == null || cell.getPlayer().getValue().length() == 0)
                return false;

        //compare the values in all three cells
        for (int i = 1; i < cells.length; i++) {

            //if any 2 values do not match => cells are not equal => return false
            if (!cells[0].getPlayer().getValue().equals(cells[i].getPlayer().getValue()))
                return false;
        }

        return true;
    }

    public boolean hasGameEnded() {
        if (hasThreeSameDiagonalCells() || hasThreeSameHorizontalCells() || hasThreeSameVerticalCells()) {
            winner = currentPlayer;
            return true;
        }

        if (isBoardFull()) {
            winner = null;
            return true;
        }

        return false;
    }

    private boolean isBoardFull() {
        for (Cell[] row : cells) {
            for (Cell cell : row)
                if (cell == null || cell.isEmpty())
                    return false;
        }

        return true;
    }

    public void resetGame() {
        player1 = null;
        player2 = null;
        currentPlayer = null;
        cells = null;
    }

    private boolean hasThreeSameHorizontalCells() {
        for (int i = 0; i < BOARD_SIZE; i++)
            if (areCellsEqual(cells[i][0], cells[i][1], cells[i][2]))
                return true;

        return false;
    }

    private boolean hasThreeSameVerticalCells() {
        for (int i = 0; i < BOARD_SIZE; i++)
            if (areCellsEqual(cells[0][i], cells[1][i], cells[2][i]))
                return true;

        return false;
    }

    private boolean hasThreeSameDiagonalCells() {
        return areCellsEqual(cells[0][0], cells[1][1], cells[2][2]) || areCellsEqual(cells[0][2], cells[1][1], cells[2][0]);
    }

    //getters
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

    //setters
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
