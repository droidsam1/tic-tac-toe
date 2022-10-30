package com.droidsam.app;

import java.security.InvalidParameterException;

public class TicTacToeGame {

    int marks = 0;
    private Player lasPlayer;

    public boolean isBoardEmpty() {
        return marks == 0;
    }

    public void place(Player player, int x, int y) {
        if (marks == 0 && Player.X != player) {
            throw new InvalidParameterException("Player X always goes first");
        }
        if (player == lasPlayer) {
            throw new InvalidParameterException("Players alternate placing marks on the board");
        }
        lasPlayer = player;
        marks++;

    }
}
