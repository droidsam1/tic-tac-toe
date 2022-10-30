package com.droidsam.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTacToeGameTest {

    @Test
    public void shouldStartWithEmptyGrid() {
        assertTrue(new TicTacToeGame().isGridEmpty());
    }

}
