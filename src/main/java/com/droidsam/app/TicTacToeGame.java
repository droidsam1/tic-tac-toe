package com.droidsam.app;

import java.security.InvalidParameterException;

public class TicTacToeGame {

    final Board board;
    private PlayerMark lasPlayer;

    public TicTacToeGame() {
        board = new Board();
    }

    public boolean isBoardEmpty() {
        return board.isEmpty();
    }

    public void place(PlayerMark player, int x, int y) {
        enforcePlayerMoveRules(player, x, y);

        lasPlayer = player;
        board.place(player, x, y);
    }

    private void enforcePlayerMoveRules(PlayerMark player, int x, int y) {
        playerXAlwaysStartTheGame(player);
        playersMustAlternate(player);
        playersCanNotKeepPlayingIfThereIsAWinner();
    }

    private void playersCanNotKeepPlayingIfThereIsAWinner() {
        if (thereIsAWinner()) {
            throw new IllegalStateException("Can not continue playing when a player has already won the game");
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

    public PlayerMark getWinner() {
        for (PlayerMark player : PlayerMark.values()) {
            if (board.getMarksPerRow(player) == 3 || board.getMarksPerColumn(player) == 3 || board.getMarksPerDiagonal(player) == 3) {
                return player;
            }
        }
        return PlayerMark.NONE;
    }

    private boolean thereIsAWinner() {
        return getWinner() != PlayerMark.NONE;
    }

    public boolean isADraw() {
        return board.isFull() && !thereIsAWinner();
    }
}
