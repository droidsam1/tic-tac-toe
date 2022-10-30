package com.droidsam.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTacToeGameTest {

    @Test
    public void shouldStartWithEmptyGrid() {
        assertTrue(new TicTacToeGame().isGridEmpty());
    }

    @Test
    public void shouldPlayerXStartTheGame() {
        var game = new TicTacToeGame();
        game.place('X', 1, 1);
        assertFalse(game.isGridEmpty());
    }

}
