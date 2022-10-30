package com.droidsam.app;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Objects;

public class Board {

    final PlayerMark[][] squares;

    public Board() {
        squares = new PlayerMark[3][3];
    }

    public boolean isEmpty() {
        return Arrays.stream(squares).allMatch(row -> Arrays.stream(row).allMatch(Objects::isNull));
    }

    public void place(PlayerMark player, int x, int y) {
        squaresCanNotBePlayedAgain(x, y);
        squares[x][y] = player;
    }

    private void squaresCanNotBePlayedAgain(int x, int y) {
        if (squares[x][y] != null) {
            throw new InvalidParameterException("Can not place over squares that has already been played");
        }
    }
}
