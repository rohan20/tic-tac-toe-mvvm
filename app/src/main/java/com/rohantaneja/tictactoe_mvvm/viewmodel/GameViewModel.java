package com.rohantaneja.tictactoe_mvvm.viewmodel;

import com.rohantaneja.tictactoe_mvvm.model.Cell;
import com.rohantaneja.tictactoe_mvvm.model.Game;
import com.rohantaneja.tictactoe_mvvm.model.Player;

import java.util.Observable;

/**
 * Created by rohantaneja on 06/04/18.
 */

public class GameViewModel extends Observable {

    private static final String TAG = GameViewModel.class.getName();
    private Game game;

    public GameViewModel(String player1Name, String player2Name) {
        game = new Game();
        beginGame(new Player(player1Name, "X"), new Player(player2Name, "O"));
    }

    private void beginGame(Player player1, Player player2) {
        game.setPlayer1(player1);
        game.setPlayer2(player2);
        game.setCurrentPlayer(player1);
    }

    private void onClickedCellAt(int row, int column) {
        Cell[][] cell = game.getCells();
        cell[row][column] = new Cell(game.getCurrentPlayer());

        if (game.hasGameEnded()) {
            onGameHasEnded();
        }

        game.switchPlayer();
    }

    private void onGameHasEnded() {
        setChanged();
        notifyObservers(game.getWinner() == null ? "No winner" : game.getWinner().getName());
        game.resetGame();
    }
}
