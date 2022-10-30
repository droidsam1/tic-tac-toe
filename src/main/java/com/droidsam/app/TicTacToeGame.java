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
        enforcePlayerMoveRules(player, x, y);

        lasPlayer = player;
        squares[x][y] = player;

        marks++;
    }

    private void enforcePlayerMoveRules(Player player, int x, int y) {
        playerXAlwaysStartTheGame(player);
        playersMustAlternate(player);
        squaresCanNotPlayedAgain(x, y);
    }

    private void squaresCanNotPlayedAgain(int x, int y) {
        if (squares[x][y] != null) {
            throw new InvalidParameterException("Can not place over squares that has already been played");
        }
    }

    private void playersMustAlternate(Player player) {
        if (player == lasPlayer) {
            throw new InvalidParameterException("Players alternate placing marks on the board");
        }
    }

    private void playerXAlwaysStartTheGame(Player player) {
        if (marks == 0 && Player.X != player) {
            throw new InvalidParameterException("Player X always goes first");
        }
    }
}
