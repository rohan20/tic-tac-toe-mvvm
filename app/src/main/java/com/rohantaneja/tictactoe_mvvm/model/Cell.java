package com.rohantaneja.tictactoe_mvvm.model;

import com.rohantaneja.tictactoe_mvvm.util.StringUtil;

/**
 * Created by rohantaneja on 05/04/18.
 */

public class Cell {

    private Player player;

    public Cell(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isEmpty() {
        return player == null || StringUtil.isNullOrEmpty(player.getValue());
    }
}
