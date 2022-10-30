package com.droidsam.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeGameTest {

    private TicTacToeGame game;

    @BeforeEach
    public void setup() {
        game = new TicTacToeGame();
    }

    @Test
    public void shouldStartWithEmptyGrid() {
        assertTrue(game.isGridEmpty());
    }

    @Test
    public void shouldPlayerXStartTheGame() {
        game.place(Player.X, 1, 1);
        assertFalse(game.isGridEmpty());
    }

    @Test
    public void shouldPlayerXAlwaysStartTheGameBeEnforced() {
        assertThrows(InvalidParameterException.class, () -> game.place(Player.O, 1, 1));
    }

    @Test
    public void shouldPlayersAlternatePlacingMarksOnTheBoard() {
        game.place(Player.X, 1, 1);
        game.place(Player.O, 1, 2);
        assertFalse(game.isGridEmpty());
    }

    @Test
    public void shouldPlayersAlternatePlacingMarksOnTheBoardBeEnforced() {
        game.place(Player.X, 1, 1);
        assertThrows(InvalidParameterException.class, () -> game.place(Player.X, 1, 2));
    }

}
