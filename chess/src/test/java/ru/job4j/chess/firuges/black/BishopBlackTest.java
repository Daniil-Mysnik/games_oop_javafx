package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.assertEquals;

public class BishopBlackTest {
    @Test
    public void testPosition() {
        Figure figure = new BishopBlack(Cell.A1);
        assertEquals(Cell.A1, figure.position());
    }

    @Test
    public void testCopy() {
        Figure figure = new BishopBlack(Cell.C3);
        Figure copiedFigure = figure.copy(Cell.A4);
        assertEquals(Cell.A4, copiedFigure.position());
    }

    @Test
    public void testWay() throws ImpossibleMoveException {
        Figure figure = new BishopBlack(Cell.C1);
        Cell[] expected = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] actual = figure.way(figure.position(), Cell.G5);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void testWrongWay() throws ImpossibleMoveException {
        Figure figure = new BishopBlack(Cell.C1);
        Cell[] actual = figure.way(figure.position(), Cell.E7);
    }
}