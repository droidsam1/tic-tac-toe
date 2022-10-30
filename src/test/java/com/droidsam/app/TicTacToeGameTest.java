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
    public void shouldStartWithEmptyBoard() {
        assertTrue(game.isBoardEmpty());
    }

    @Test
    public void shouldPlayerXStartTheGame() {
        game.place(PlayerMark.X, 1, 1);
        assertFalse(game.isBoardEmpty());
    }

    @Test
    public void shouldPlayerXAlwaysStartTheGameBeEnforced() {
        assertThrows(InvalidParameterException.class, () -> game.place(PlayerMark.O, 1, 1));
    }

    @Test
    public void shouldPlayersAlternatePlacingMarksOnTheBoard() {
        game.place(PlayerMark.X, 1, 1);
        game.place(PlayerMark.O, 1, 2);
        assertFalse(game.isBoardEmpty());
    }

    @Test
    public void shouldPlayersAlternatePlacingMarksOnTheBoardBeEnforced() {
        game.place(PlayerMark.X, 1, 1);
        assertThrows(InvalidParameterException.class, () -> game.place(PlayerMark.X, 1, 2));
    }

    @Test
    public void shouldPlayersCanNotPlaceOverSquaresAlreadyBeenPlayed(){
        game.place(PlayerMark.X, 1, 1);
        assertThrows(InvalidParameterException.class, () -> game.place(PlayerMark.O, 1, 1));
    }

}
