package com.droidsam.app;

import java.security.InvalidParameterException;

public class TicTacToeGame {

    int marks = 0;

    public boolean isGridEmpty() {
        return marks == 0;
    }

    public void place(Player player, int x, int y) {
        if (marks == 0 && Player.X != player) {
            throw new InvalidParameterException("Player X always goes first");
        }
        marks++;

    }
}
