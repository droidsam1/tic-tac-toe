package com.droidsam.app;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeGameTest {

    @Test
    public void shouldStartWithEmptyGrid() {
        assertTrue(new TicTacToeGame().isGridEmpty());
    }

    @Test
    public void shouldPlayerXStartTheGame() {
        var game = new TicTacToeGame();
        game.place(Player.X, 1, 1);
        assertFalse(game.isGridEmpty());
    }

    @Test
    public void shouldPlayerXAlwaysStartTheGameBeEnforced() {
        var game = new TicTacToeGame();
        assertThrows(InvalidParameterException.class, () -> game.place(Player.O, 1, 1));
    }

}
