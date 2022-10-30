package com.droidsam.app;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Objects;

public class TicTacToeGame {

    final PlayerMark[][] squares;
    final Board board;
    private PlayerMark lasPlayer;

    public TicTacToeGame() {
        squares = new PlayerMark[3][3];
        board = new Board();
    }

    public boolean isBoardEmpty() {
        return board.isBoardEmpty();
    }

    public void place(PlayerMark player, int x, int y) {
        enforcePlayerMoveRules(player, x, y);

        lasPlayer = player;
        squares[x][y] = player;
        board.place(player, x, y);
    }

    private void enforcePlayerMoveRules(PlayerMark player, int x, int y) {
        playerXAlwaysStartTheGame(player);
        playersMustAlternate(player);
        squaresCanNotPlayedAgain(x, y);
    }

    private void squaresCanNotPlayedAgain(int x, int y) {
        if (squares[x][y] != null) {
            throw new InvalidParameterException("Can not place over squares that has already been played");
        }
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
