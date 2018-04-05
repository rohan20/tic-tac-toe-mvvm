package com.rohantaneja.tictactoe_mvvm.model;

/**
 * Created by rohantaneja on 05/04/18.
 */

public class Player {

    private String name;
    private String value;

    public Player(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
