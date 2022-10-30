package com.droidsam.app;

public class TicTacToeGame {

    int marks = 0;

    public boolean isGridEmpty() {
        return marks == 0;
    }

    public void place(char player, int x, int y) {
        marks++;

    }
}
