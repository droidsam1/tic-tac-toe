package com.droidsam.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.security.InvalidParameterException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeGameTest {

    private TicTacToeGame game;

    private static Stream<Arguments> invalidCoordinates() {
        return Stream.of(Arguments.of(-1, 1), Arguments.of(3, 1), Arguments.of(1, -1), Arguments.of(1, 3));
    }

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
    public void shouldPlayersCanNotPlaceOverSquaresAlreadyBeenPlayed() {
        game.place(PlayerMark.X, 1, 1);
        assertThrows(InvalidParameterException.class, () -> game.place(PlayerMark.O, 1, 1));
    }

    @Test
    public void shouldOnlyPlayersCanWinWhenPutsAtLeastThreeMarks() {
        game.place(PlayerMark.X, 0, 0);
        game.place(PlayerMark.O, 1, 1);
        game.place(PlayerMark.X, 0, 1);
        game.place(PlayerMark.O, 1, 2);
        assertEquals(PlayerMark.NONE, game.getWinner());
    }

    @Test
    public void shouldPlayerXWithThreeMarksInARowWinsTheGame() {
        game.place(PlayerMark.X, 0, 0);
        game.place(PlayerMark.O, 1, 1);
        game.place(PlayerMark.X, 0, 1);
        game.place(PlayerMark.O, 1, 2);
        game.place(PlayerMark.X, 0, 2);
        assertEquals(PlayerMark.X, game.getWinner());
    }

    @Test
    public void shouldPlayerOWithThreeMarksInARowWinsTheGame() {
        game.place(PlayerMark.X, 1, 1);
        game.place(PlayerMark.O, 0, 0);
        game.place(PlayerMark.X, 1, 2);
        game.place(PlayerMark.O, 0, 1);
        game.place(PlayerMark.X, 2, 2);
        game.place(PlayerMark.O, 0, 2);
        assertEquals(PlayerMark.O,game.getWinner());
    }

    @Test
    public void shouldPlayerXWithThreeMarksInAColumnWinsTheGame() {
        game.place(PlayerMark.X, 0, 1);
        game.place(PlayerMark.O, 0, 0);
        game.place(PlayerMark.X, 1, 1);
        game.place(PlayerMark.O, 0, 2);
        game.place(PlayerMark.X, 2, 1);
        assertEquals(PlayerMark.X, game.getWinner());
    }

    @Test
    public void shouldPlayerOWithThreeMarksInAColumnWinsTheGame() {
        game.place(PlayerMark.X, 0, 2);
        game.place(PlayerMark.O, 0, 1);
        game.place(PlayerMark.X, 2, 2);
        game.place(PlayerMark.O, 1, 1);
        game.place(PlayerMark.X, 1, 0);
        game.place(PlayerMark.O, 2, 1);
        assertEquals(PlayerMark.O, game.getWinner());
    }

    @Test
    public void shouldPlayerWithThreeMarksInADiagonalWinsTheGame() {
        game.place(PlayerMark.X, 0, 0);
        game.place(PlayerMark.O, 0, 1);
        game.place(PlayerMark.X, 1, 1);
        game.place(PlayerMark.O, 0, 2);
        game.place(PlayerMark.X, 2, 2);
        assertEquals(PlayerMark.X, game.getWinner());
    }

    @ParameterizedTest
    @MethodSource("invalidCoordinates")
    public void shouldPlayerPlaceMarksWithinTheLimitsOfTheBoard(int x, int y) {
        assertThrows(IndexOutOfBoundsException.class, () -> game.place(PlayerMark.X, x, y));
    }

}
