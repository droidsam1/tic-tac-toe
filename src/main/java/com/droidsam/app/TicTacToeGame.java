package com.droidsam.app;

import java.security.InvalidParameterException;

public class TicTacToeGame {

    final Player[][] squares;
    int marks = 0;
    private Player lasPlayer;

    public TicTacToeGame() {
        squares = new Player[3][3];
    }

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
        if (squares[x][y] != null) {
            throw new InvalidParameterException("Can not place over squares that has already been played");
        }

        lasPlayer = player;
        squares[x][y] = player;

        marks++;

    }
}
