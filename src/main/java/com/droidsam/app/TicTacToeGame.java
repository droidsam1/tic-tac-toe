package com.droidsam.app;

import java.security.InvalidParameterException;

public class TicTacToeGame {

    final Board board;
    private PlayerMark lasPlayer;

    public TicTacToeGame() {
        board = new Board();
    }

    public boolean isBoardEmpty() {
        return board.isBoardEmpty();
    }

    public void place(PlayerMark player, int x, int y) {
        enforcePlayerMoveRules(player, x, y);

        lasPlayer = player;
        board.place(player, x, y);
    }

    private void enforcePlayerMoveRules(PlayerMark player, int x, int y) {
        playerXAlwaysStartTheGame(player);
        playersMustAlternate(player);
    }

    private void playersMustAlternate(PlayerMark player) {
        if (player == lasPlayer) {
            throw new InvalidParameterException("Players alternate placing marks on the board");
        }
    }

    private void playerXAlwaysStartTheGame(PlayerMark player) {
        if (isBoardEmpty() && PlayerMark.X != player) {
            throw new InvalidParameterException("Player X always goes first");
        }
    }
}
