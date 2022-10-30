package com.droidsam.app;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Objects;

public class Board {

    private final PlayerMark[][] squares;

    public Board() {
        squares = new PlayerMark[3][3];
    }

    public boolean isEmpty() {
        return Arrays.stream(squares).allMatch(row -> Arrays.stream(row).allMatch(Objects::isNull));
    }

    public void place(PlayerMark player, int x, int y) {
        squaresCanNotBePlayedAgain(x, y);
        placeMark(player, x, y);
    }

    private void placeMark(PlayerMark player, int x, int y) {
        try {
            squares[x][y] = player;
        } catch (IndexOutOfBoundsException ex) {
            throw new IndexOutOfBoundsException("Can not place marks outside board limits. Valid range goes from 0 to 2");
        }
    }

    private void squaresCanNotBePlayedAgain(int x, int y) {
        if (squares[x][y] != null) {
            throw new InvalidParameterException("Can not place over squares that has already been played");
        }
    }

    public long getMarksPerColumRow(PlayerMark player) {
        int result = 0;
        for (int i = 0; i < squares[0].length; i++) {
            int count = 0;
            for (int x = 0; x < squares[i].length; x++) {
                if (squares[i][x] == player) {
                    count++;
                }
            }
            if (count > result) {
                result = count;
            }
        }
        return result;
    }
}
