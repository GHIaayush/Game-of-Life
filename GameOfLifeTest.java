/**
 *
 *  Unit test for Game Of Life
 *
 *  Test methods use methods names as hints or the extra String 
 *  argument that appears when the assertion fails
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameOfLifeTest {


  @Test
  public void testFailedConstructorGetrows() {
    GameOfLife society = new GameOfLife(10, 16);
    assertEquals(10, society.numberOfRows());
    assertEquals(16, society.numberOfColumns());
  }

  @Test
  public void testFailedConstructorOrGrowcellatOrCellatWhenCellsShouldBeThere() {
    GameOfLife society = new GameOfLife(10, 16);
    society.growCellAt(0, 0);
    society.growCellAt(1, 1);
    society.growCellAt(2, 2);
    society.growCellAt(3, 3);
    society.growCellAt(4, 4);
    society.growCellAt(5, 5);
    society.growCellAt(6, 6);
    society.growCellAt(7, 7);
    society.growCellAt(8, 8);
    society.growCellAt(9, 9);

    for (int i = 0; i < 10; i++)
      assertTrue(society.cellAt(i, i));
  }

  @Test
  public void testFailedConstructorOrGrowcellatOrCellatForCellsThatShouldNotBeThere() {
    GameOfLife society = new GameOfLife(10, 16);
    society.growCellAt(0, 0);
    society.growCellAt(1, 1);
    society.growCellAt(2, 2);
    society.growCellAt(3, 3);
    society.growCellAt(4, 4);
    society.growCellAt(5, 5);
    society.growCellAt(6, 6);
    society.growCellAt(7, 7);
    society.growCellAt(8, 8);
    society.growCellAt(9, 9);
    for (int i = 0; i < 10; i++)
      assertFalse(society.cellAt(i, i + 1));
  }

  @Test
  public void testFailedGrowCellAtCorner() {
    GameOfLife society = new GameOfLife(7, 7);
    assertFalse(society.cellAt(5, 6));
    assertFalse(society.cellAt(6, 6));
    assertFalse(society.cellAt(0, 6));
    assertFalse(society.cellAt(5, 5));
    assertFalse(society.cellAt(6, 5));
    assertFalse(society.cellAt(0, 5));
    assertFalse(society.cellAt(5, 0));
    assertFalse(society.cellAt(6, 0));
    assertFalse(society.cellAt(0, 0));
    society.growCellAt(6, 6);
    assertTrue(society.cellAt(6, 6));
    assertFalse(society.cellAt(5, 6));
    assertFalse(society.cellAt(0, 6));
    assertFalse(society.cellAt(5, 5));
    assertFalse(society.cellAt(6, 5));
    assertFalse(society.cellAt(0, 5));
    assertFalse(society.cellAt(5, 0));
    assertFalse(society.cellAt(6, 0));
    assertFalse(society.cellAt(0, 0));
  }

  @Test
  public void testFailedToString() {
    GameOfLife society = new GameOfLife(2, 10);
    String expected0 = "..........\n..........\n";
    String expected1 = "..........\n..........";
    assertTrue(
        "Failed testing toString which should be like this with no cell grown..........NewLine..........NewLine",
        society.toString().equals(expected0)
            || society.toString().equals(expected1));
  }

  @Test
  public void testFailedToStringWithNoCells() {
    GameOfLife society = new GameOfLife(2, 10);
    society.growCellAt(0, 0);
    society.growCellAt(0, 4);
    society.growCellAt(0, 8);
    society.growCellAt(1, 2);
    society.growCellAt(1, 6);
    String expected1 = "O...O...O.\n..O...O...\n";
    String expected2 = "0...0...0.\n..0...0...\n";
    String expected3 = "O...O...O.\n..O...O...";
    String expected4 = "0...0...0.\n..0...0...";
    assertTrue(
        "Failed testing toString which should be like this with 5 cells grown: O...O...O.\n..O...O...\n",
        society.toString().equals(expected1)
            || society.toString().equals(expected2)
            || society.toString().equals(expected3)
            || society.toString().equals(expected4));

  }

  @Test
  public void testFailedNeighborCountToTheNorthNoWraparound() {
    GameOfLife g = new GameOfLife(8, 9);
    g.growCellAt(2, 2);
    g.growCellAt(2, 3);
    g.growCellAt(2, 4);
    assertEquals(0, g.neighborCount(1, 0));
    assertEquals(1, g.neighborCount(1, 1));
    assertEquals(2, g.neighborCount(1, 2));
    assertEquals(3, g.neighborCount(1, 3));
    assertEquals(2, g.neighborCount(1, 4));
    assertEquals(1, g.neighborCount(1, 5));
    assertEquals(0, g.neighborCount(1, 6));
  }

  @Test
  public void testFailedNeighborCountToTheSouthNoWraparound() {
    GameOfLife g = new GameOfLife(8, 9);
    g.growCellAt(2, 2);
    g.growCellAt(2, 3);
    g.growCellAt(2, 4);
    assertEquals(0, g.neighborCount(3, 0));
    assertEquals(1, g.neighborCount(3, 1));
    assertEquals(2, g.neighborCount(3, 2));
    assertEquals(3, g.neighborCount(3, 3));
    assertEquals(2, g.neighborCount(3, 4));
    assertEquals(1, g.neighborCount(3, 5));
    assertEquals(0, g.neighborCount(3, 6));
  }

  @Test
  public void testFailedNeighborCountToTheEastNoWraparound() {
    GameOfLife g = new GameOfLife(8, 9);
    g.growCellAt(2, 2);
    g.growCellAt(3, 2);
    g.growCellAt(4, 2);
    assertEquals(0, g.neighborCount(0, 3));
    assertEquals(1, g.neighborCount(1, 3));
    assertEquals(2, g.neighborCount(2, 3));
    assertEquals(3, g.neighborCount(3, 3));
    assertEquals(2, g.neighborCount(4, 3));
    assertEquals(1, g.neighborCount(5, 3));
    assertEquals(0, g.neighborCount(6, 3));
  }

  @Test
  public void testFailedNeighborCountToTheWestNoWraparound() {
    GameOfLife g = new GameOfLife(8, 9);
    g.growCellAt(2, 2);
    g.growCellAt(3, 2);
    g.growCellAt(4, 2);
    assertEquals(0, g.neighborCount(0, 1));
    assertEquals(1, g.neighborCount(1, 1));
    assertEquals(2, g.neighborCount(2, 1));
    assertEquals(3, g.neighborCount(3, 1));
    assertEquals(2, g.neighborCount(4, 1));
    assertEquals(1, g.neighborCount(5, 1));
    assertEquals(0, g.neighborCount(6, 1));
  }

  @Test
  public void testFailedNeighborCountWithWraparound() {
    GameOfLife g = new GameOfLife(8, 9);
    g.growCellAt(0, 0);
    g.growCellAt(0, 1);
    g.growCellAt(1, 0);
    g.growCellAt(1, 1);
    assertEquals(3, g.neighborCount(0, 0));

    g.growCellAt(0, 8);
    g.growCellAt(1, 8);
    g.growCellAt(7, 1);
    g.growCellAt(7, 0);
    g.growCellAt(7, 8);
    assertEquals(8, g.neighborCount(0, 0));
  }

  @Test
  public void testFailedNeighborcountWithWraparound() {
    GameOfLife society = new GameOfLife(10, 16);
    society.growCellAt(6, 6);
    society.growCellAt(6, 7);
    society.growCellAt(7, 6);
    society.growCellAt(5, 5);

    society.growCellAt(3, 0);
    society.growCellAt(3, 15);
    assertEquals(1, society.neighborCount(3, 15));
    assertEquals(1, society.neighborCount(3, 0));
    society.growCellAt(4, 0);
    society.growCellAt(4, 15);
    assertEquals(3, society.neighborCount(3, 15));
    assertEquals(3, society.neighborCount(3, 0));
    assertEquals(3, society.neighborCount(4, 15));
    assertEquals(3, society.neighborCount(4, 0));
    society.update();
    assertEquals(3, society.neighborCount(3, 15));
    assertEquals(3, society.neighborCount(3, 0));
    assertEquals(3, society.neighborCount(4, 15));
    assertEquals(3, society.neighborCount(4, 0));

    society.growCellAt(5, 0);
    society.update();
    assertTrue(society.cellAt(5, 15));
    assertTrue(society.cellAt(5, 15));
    assertTrue(society.cellAt(4, 1));
    assertFalse(society.cellAt(4, 15));
  }

  @Test
  public void testFailedNeighborcountWrapLowerLeftUpperRight() {
    GameOfLife society = new GameOfLife(10, 16);
    society.growCellAt(6, 6);
    society.growCellAt(6, 7);
    society.growCellAt(7, 6);
    society.growCellAt(5, 5);

    society.growCellAt(9, 1);
    society.growCellAt(8, 0);
    assertEquals(2, society.neighborCount(9, 0));
    society.growCellAt(0, 15);

    society.update();
    assertTrue(society.cellAt(9, 0));
    assertFalse(society.cellAt(9, 1));
    assertFalse(society.cellAt(8, 0));
    assertEquals(0, society.neighborCount(0, 9));
  }

  @Test
  public void testFailedNeighborcountWrapUpperLeftLowerRight() {
    GameOfLife society = new GameOfLife(10, 16);
    society.growCellAt(6, 6);
    society.growCellAt(6, 7);
    society.growCellAt(7, 6);
    society.growCellAt(5, 5);

    society.growCellAt(0, 1);
    society.growCellAt(1, 0);
    society.growCellAt(9, 15);
    assertEquals(2, society.neighborCount(0, 15));
  }

  @Test
  public void testFailedNeighborCountOnTopRow() {
    GameOfLife society = new GameOfLife(7, 7);
    society.growCellAt(0, 2);
    society.growCellAt(0, 3);
    society.growCellAt(0, 4);
    assertEquals(3, society.neighborCount(6, 3));
    assertEquals(1, society.neighborCount(6, 1));
    assertEquals(2, society.neighborCount(6, 2));
    assertEquals(0, society.neighborCount(6, 0));
  }

  @Test
  public void testFailedNeighborCountOnBottomRow() {
    GameOfLife society = new GameOfLife(7, 7);
    society.growCellAt(2, 6);
    society.growCellAt(3, 6);
    society.growCellAt(4, 6);
    assertEquals(3, society.neighborCount(3, 0));
    assertEquals(1, society.neighborCount(1, 0));
    assertEquals(2, society.neighborCount(2, 0));
    assertEquals(0, society.neighborCount(0, 0));
  }

  @Test
  public void testFailedNeighborCountInCorners() {
    GameOfLife society = new GameOfLife(7, 7);
    society.growCellAt(0, 0);
    society.growCellAt(1, 0);
    society.growCellAt(6, 0);
    assertEquals(3, society.neighborCount(0, 6));
    assertEquals(2, society.neighborCount(1, 6));
    assertEquals(2, society.neighborCount(0, 0));
    assertEquals(1, society.neighborCount(6, 0));
    assertEquals(2, society.neighborCount(6, 6));
    assertEquals(1, society.neighborCount(5, 6));
    assertEquals(0, society.neighborCount(4, 6));
  }

  @Test
  public void testFailedNeighborCountInCornersUpperLeftLowerRight() {
    GameOfLife society = new GameOfLife(7, 7);
    society.growCellAt(6, 5);
    society.growCellAt(6, 6);
    society.growCellAt(6, 0);
    assertEquals(3, society.neighborCount(5, 6));
    assertEquals(3, society.neighborCount(0, 6));
    assertEquals(2, society.neighborCount(5, 5));
    assertEquals(2, society.neighborCount(6, 6));
    assertEquals(1, society.neighborCount(6, 0));
    assertEquals(2, society.neighborCount(0, 0));
    assertEquals(1, society.neighborCount(0, 4));
    assertEquals(0, society.neighborCount(4, 6));
  }

  @Test
  public void testFailedNeighborCountWhenCellasAreInTheUpperRightCorner() {
    GameOfLife society = new GameOfLife(7, 7);
    society.growCellAt(0, 5);
    society.growCellAt(0, 6);
    society.growCellAt(0, 0);
    assertEquals(3, society.neighborCount(1, 6));
    assertEquals(3, society.neighborCount(6, 6));
    assertEquals(2, society.neighborCount(1, 5));
    assertEquals(2, society.neighborCount(0, 6));
    assertEquals(1, society.neighborCount(0, 0));
    assertEquals(2, society.neighborCount(6, 0));
    assertEquals(1, society.neighborCount(6, 4));
    assertEquals(0, society.neighborCount(2, 6));

    GameOfLife society2 = new GameOfLife(7, 7);
    society2.growCellAt(0, 6);
    society2.growCellAt(1, 6);
    society2.growCellAt(6, 6);
    assertEquals(3, society2.neighborCount(0, 0));
    assertEquals(2, society2.neighborCount(1, 0));
    assertEquals(2, society2.neighborCount(0, 6));
    assertEquals(1, society2.neighborCount(6, 6));
    assertEquals(2, society2.neighborCount(6, 0));
    assertEquals(1, society2.neighborCount(5, 0));
    assertEquals(0, society2.neighborCount(4, 0));
  }

  @Test
  public void testFailedUpdateNoCorners() {
    GameOfLife society = new GameOfLife(5, 6);
    society.growCellAt(1, 1);
    society.growCellAt(1, 2);
    society.growCellAt(1, 3);
    society.growCellAt(2, 2);
    society.growCellAt(2, 3);
    society.growCellAt(3, 2);

    society.update();
    // Verify two new cells have been "born" (had precisely 3 neighbors)
    assertTrue(society.cellAt(0, 2));
    assertTrue(society.cellAt(3, 3));

    // Verify three cells remained alive (had 2 or 3 neighbors)
    assertTrue(society.cellAt(1, 1));
    assertTrue(society.cellAt(1, 3));
    assertTrue(society.cellAt(3, 2));

    // Verify three cells have "died" (had 4 or more neighbors)
    assertFalse(society.cellAt(1, 2));
    assertFalse(society.cellAt(2, 2));
    assertFalse(society.cellAt(2, 3));
  }

  @Test
  public void testFailedUpdateEdgesAndCorners() {
    GameOfLife society = new GameOfLife(5, 9);
    society.growCellAt(0, 5);
    society.growCellAt(0, 8);
    society.growCellAt(1, 0);
    society.growCellAt(2, 0);
    society.growCellAt(2, 8);
    society.growCellAt(3, 0);
    society.growCellAt(3, 8);
    society.growCellAt(4, 6);
    society.growCellAt(4, 4);

    society.update();
    // Only assert the live cells after upDate
    assertTrue(society.cellAt(0, 5));
    assertTrue(society.cellAt(1, 0));
    assertTrue(society.cellAt(2, 1));
    assertTrue(society.cellAt(3, 0));
    assertTrue(society.cellAt(3, 7));
    assertTrue(society.cellAt(3, 8));
    assertTrue(society.cellAt(4, 0));
    assertTrue(society.cellAt(4, 5));
    assertTrue(society.cellAt(4, 7));
    assertTrue(society.cellAt(4, 8));
  }

  @Test
  public void testFailedEasyWrapAround() {
    GameOfLife society = new GameOfLife(10, 16);
    society.growCellAt(6, 6);
    society.growCellAt(6, 7);
    society.growCellAt(7, 6);
    society.growCellAt(5, 5);
    society.growCellAt(9, 2);
    society.growCellAt(9, 3);
    society.growCellAt(9, 4);
    society.update();
    assertTrue(society.cellAt(8, 3));
    assertTrue(society.cellAt(9, 3));
    assertTrue(society.cellAt(0, 3));
  }

  @Test
  public void testFailedEasyUpdate() {
    GameOfLife g = new GameOfLife(6, 6);
    g.growCellAt(2, 2);
    g.growCellAt(2, 3);
    g.growCellAt(2, 4);
    // ......
    // ......
    // ..OOO.
    // ......
    // ......
    // ......

    g.update();
    // ......
    // ...O..
    // ...O..
    // ...O..
    // ......
    // ......
    assertTrue(g.cellAt(1, 3));
    assertTrue(g.cellAt(2, 3));
    assertTrue(g.cellAt(3, 3));
    assertFalse(g.cellAt(2, 2));
    assertFalse(g.cellAt(2, 4));

    g.update();
    assertTrue(g.cellAt(2, 2));
    assertTrue(g.cellAt(2, 3));
    assertTrue(g.cellAt(2, 4));
    assertFalse(g.cellAt(1, 3));
    assertFalse(g.cellAt(3, 3));

    g.update();
    assertTrue(g.cellAt(1, 3));
    assertTrue(g.cellAt(2, 3));
    assertTrue(g.cellAt(3, 3));
    assertFalse(g.cellAt(2, 2));
    assertFalse(g.cellAt(2, 4));
  }

  @Test
  public void showAssignment() {
    GameOfLife society2 = new GameOfLife(5, 10);
    society2.growCellAt(1, 3);
    society2.growCellAt(2, 4);
    society2.growCellAt(2, 5);
    society2.growCellAt(3, 4);

    System.out.println(society2);
    society2.update();
    System.out.println(society2);

    // Assert all cells are alive that should be alive
    assertTrue(society2.cellAt(1, 4));
    assertTrue(society2.cellAt(2, 3));
    assertTrue(society2.cellAt(2, 4));
    assertTrue(society2.cellAt(2, 5));
    assertTrue(society2.cellAt(3, 4));
    assertTrue(society2.cellAt(3, 5));
  }

  @Test public void testUpdateEdgesAndCorners() {
    GameOfLife society = new GameOfLife(5, 9);
    society.growCellAt(0, 5);
    society.growCellAt(0, 8);
    society.growCellAt(1, 0);
    society.growCellAt(2, 0);
    society.growCellAt(2, 8);
    society.growCellAt(3, 0);
    society.growCellAt(3, 8);
    society.growCellAt(4, 6);
    society.growCellAt(4, 4);

    System.out.println(society);
    society.update();
    System.out.println(society);

  }


  
  @Test
  public void testFailedUpdate() {
    GameOfLife society2 = new GameOfLife(8, 12);
    society2.growCellAt(3, 5);
    society2.growCellAt(4, 6);
    society2.growCellAt(4, 7);
    society2.growCellAt(5, 6);
    // ............
    // ............
    // ............
    // .....O......
    // ......OO....
    // ......O.....
    // ............
    // ............

    society2.update();

    assertTrue(society2.cellAt(3, 6));
    assertTrue(society2.cellAt(4, 5));
    assertTrue(society2.cellAt(4, 6));
    assertTrue(society2.cellAt(4, 7));
    assertTrue(society2.cellAt(5, 6));
    assertTrue(society2.cellAt(5, 7));
  }

  /**
   * These tests check the GameOfLife class and assumes method headers are
   * correct. <br>
   * Created on: September 28, 2006<br>
   * Last Modified on: September 29, 2006
   * 
   * @author michaels
   * 
   */
  @Test
  public void testFailedUpdateAtLeftColumn() {
    GameOfLife society = new GameOfLife(7, 7);
    society.growCellAt(2, 0);
    society.growCellAt(3, 0);
    society.growCellAt(4, 0);
    society.update();
    assertTrue(society.cellAt(3, 6));
    assertTrue(society.cellAt(3, 0));
    assertTrue(society.cellAt(3, 1));
    assertFalse(society.cellAt(2, 0));
    assertFalse(society.cellAt(4, 0));
  }

  @Test
  public void testFailedUpdateWithCellsOnTopRow() {
    GameOfLife society = new GameOfLife(7, 7);
    society.growCellAt(0, 2);
    society.growCellAt(0, 3);
    society.growCellAt(0, 4);
    society.update();
    assertTrue(society.cellAt(6, 3));
    assertTrue(society.cellAt(0, 3));
    assertTrue(society.cellAt(1, 3));
    assertFalse(society.cellAt(0, 2));
    assertFalse(society.cellAt(0, 4));
  }

  @Test
  public void testFailedUpdateWithCellsAtRightColumn() {
    GameOfLife society = new GameOfLife(7, 7);
    society.growCellAt(2, 6);
    society.growCellAt(3, 6);
    society.growCellAt(4, 6);
    society.update();
    assertTrue(society.cellAt(3, 5));
    assertTrue(society.cellAt(3, 6));
    assertTrue(society.cellAt(3, 0));
    assertFalse(society.cellAt(2, 6));
    assertFalse(society.cellAt(4, 6));
  }

  @Test
  public void testFailedUpdateWithCellsOnBottomRow() {
    GameOfLife society = new GameOfLife(7, 7);
    society.growCellAt(6, 2);
    society.growCellAt(6, 3);
    society.growCellAt(6, 4);
    society.update();
    assertTrue(society.cellAt(5, 3));
    assertTrue(society.cellAt(6, 3));
    assertTrue(society.cellAt(0, 3));
    assertFalse(society.cellAt(6, 2));
    assertFalse(society.cellAt(6, 4));
  }

  @Test
  public void testFailedUpdateInTwoCorners() {
    GameOfLife society = new GameOfLife(7, 7);
    society.growCellAt(0, 0);
    society.growCellAt(1, 0);
    society.growCellAt(6, 0);
    society.update();
    assertTrue(society.cellAt(0, 1));
    assertTrue(society.cellAt(0, 0));
    assertTrue(society.cellAt(0, 6));
    assertFalse(society.cellAt(1, 0));
    assertFalse(society.cellAt(6, 0));
  }

  @Test
  public void testFailedUpdateInTwoCornersAgain() {
    GameOfLife society = new GameOfLife(7, 7);
    society.growCellAt(0, 0);
    society.growCellAt(0, 1);
    society.growCellAt(0, 6);
    society.update();
    assertTrue(society.cellAt(1, 0));
    assertTrue(society.cellAt(0, 0));
    assertTrue(society.cellAt(6, 0));
    assertFalse(society.cellAt(0, 1));
    assertFalse(society.cellAt(0, 6));
  }

  @Test
  public void testFailedUpdateWhenCellsAreInCorners() {
    GameOfLife society = new GameOfLife(7, 7);
    society.growCellAt(0, 0);
    society.growCellAt(5, 0);
    society.growCellAt(6, 0);
    society.update();
    assertTrue(society.cellAt(6, 1));
    assertTrue(society.cellAt(6, 6));
    assertTrue(society.cellAt(6, 0));
    assertFalse(society.cellAt(5, 0));
    assertFalse(society.cellAt(0, 0));
  }

  @Test
  public void testFailedUpdateWitCellsInCorners() {
    GameOfLife society = new GameOfLife(7, 7);
    society.growCellAt(0, 0);
    society.growCellAt(0, 5);
    society.growCellAt(0, 6);
    society.update();
    assertTrue(society.cellAt(1, 6));
    assertTrue(society.cellAt(6, 6));
    assertTrue(society.cellAt(0, 6));
    assertFalse(society.cellAt(0, 5));
    assertFalse(society.cellAt(0, 0));
  }

  private GameOfLife society;

  /**
   * Set up a game with 4 cells used by many test methods.
   */
  @Before
  public void setUp() {
    society = new GameOfLife(10, 16);
    society.growCellAt(6, 6);
    society.growCellAt(6, 7);
    society.growCellAt(7, 6);
    society.growCellAt(5, 5);
  }

  /**
   * A test.
   */
  @Test
  public void testFailedGetRowsAndColumns1() {
    society = new GameOfLife(10, 16);
    society.growCellAt(1, 2);
    society.growCellAt(2, 2);
    society.growCellAt(3, 2);
    society.growCellAt(5, 5);
    society.growCellAt(6, 6);
    society.growCellAt(6, 7);
    society.growCellAt(7, 6);
    assertEquals("Failed numberOfRows: ", 10, society.numberOfRows());
    assertEquals("Failed numberOfColumns: ", 16, society.numberOfColumns());
  }

  /**
   * A test.
   */
  @Test
  public void testFailedgetRowsAndColumns2() {
    assertEquals("Failed numberOfRows: ", 10, society.numberOfRows());
    assertEquals("Failed numberOfColumns: ", 16, society.numberOfColumns());
  }

  /**
   * A test.
   */
  @Test
  public void testFailedIsCellAt3() {
    assertTrue(society.cellAt(6, 6));
    assertTrue(society.cellAt(6, 7));
    assertTrue(society.cellAt(7, 6));
    assertTrue(society.cellAt(5, 5));

    // Also check a few cells to ensure there is no cell
    // No cells on colum 8
    for (int r = 0; r < society.numberOfRows(); r++) {
      assertFalse("Failed cellAt: ", society.cellAt(r, 8));
    }

    // No cells on row 1
    for (int c = 0; c < society.numberOfColumns(); c++) {
      assertFalse("Failed cellAt: ", society.cellAt(1, c));
    }

    // Check a couple more (not exhaustive)
    assertFalse("Failed cellAt: ", society.cellAt(5, 6));
    assertFalse("Failed cellAt: ", society.cellAt(6, 5));
  }

  /**
   * A test.
   */
  @Test
  public void testFailedNeighborCount4() {
    society.growCellAt(3, 10);
    society.growCellAt(3, 11);
    society.growCellAt(3, 12);
    society.growCellAt(4, 10);
    society.growCellAt(4, 12);
    society.growCellAt(5, 10);
    society.growCellAt(5, 11);
    society.growCellAt(5, 12);

    // System.out.println(society); should show this society with 12
    // cells
    // ................
    // ................
    // ................
    // ..........OOO...
    // ..........O.O...
    // .....O....OOO...
    // ......OO........
    // ......O.........
    // ................
    // ................

    assertEquals("Failed neighborCount: ", 0, society.neighborCount(5, 3));
    assertEquals("Failed neighborCount: ", 1, society.neighborCount(5, 4));
    assertEquals("Failed neighborCount: ", 1, society.neighborCount(5, 5));
    assertEquals("Failed neighborCount: ", 3, society.neighborCount(5, 6));
    assertEquals("Failed neighborCount: ", 3, society.neighborCount(6, 5));
    society.growCellAt(6, 4);
    assertEquals("Failed neighborCount: ", 4, society.neighborCount(6, 5));

    // Count the number of cells around a selected subset of possible
    assertEquals("Failed neighborCount: ", 0, society.neighborCount(3, 3));
    assertEquals("Failed neighborCount: ", 3, society.neighborCount(4, 9));
    assertEquals("Failed neighborCount: ", 4, society.neighborCount(4, 10));
    assertEquals("Failed neighborCount: ", 8, society.neighborCount(4, 11));
    assertEquals("Failed neighborCount: ", 4, society.neighborCount(4, 12));
    assertEquals("Failed neighborCount: ", 3, society.neighborCount(4, 13));

    assertEquals("Failed neighborCount: ", 1, society.neighborCount(5, 8));
    assertEquals("Failed neighborCount: ", 2, society.neighborCount(5, 9));
    assertEquals("Failed neighborCount: ", 2, society.neighborCount(5, 10));
    assertEquals("Failed neighborCount: ", 4, society.neighborCount(5, 11));
    assertEquals("Failed neighborCount: ", 2, society.neighborCount(5, 12));
    assertEquals("Failed neighborCount: ", 2, society.neighborCount(5, 13));
  }

  /**
   * A test.
   */
  @Test
  public void testFailedUpdate5() {
    // System.out.println(society); Initial should show this society
    // with 12
    // cells
    // ................
    // ................
    // ................
    // ................
    // ................
    // .....O..........
    // ......OO........
    // ......O.........
    // ................
    // ................
    society.update();
    assertFalse("Failed cellAt: ", society.cellAt(5, 5));
    assertTrue("Failed cellAt: ", society.cellAt(5, 6));
    assertTrue("Failed cellAt: ", society.cellAt(6, 6));
    assertTrue("Failed cellAt: ", society.cellAt(6, 6));
    assertTrue("Failed cellAt: ", society.cellAt(6, 7));
    assertTrue("Failed cellAt: ", society.cellAt(7, 6));
    assertTrue("Failed cellAt: ", society.cellAt(7, 7));

    // System.out.println(society); // Updated society should look like
    // this
    // ................
    // ................
    // ................
    // ................
    // ................
    // ......O.........
    // .....OOO........
    // ......OO........
    // ................
    // ................
  }

  /**
   * A test.
   */
  @Test
  public void testFailedEasyWrapAround6() {
    society.growCellAt(9, 2);
    society.growCellAt(9, 3);
    society.growCellAt(9, 4);
    society.update();
    assertTrue("Failed cellAt: ", society.cellAt(8, 3));
    assertTrue("Failed cellAt: ", society.cellAt(9, 3));
    assertTrue("Failed cellAt: ", society.cellAt(0, 3));
  }

  /**
   * A test.
   */
  @Test
  public void testFailedWrapLowerLeftUpperRight7() {
    society.growCellAt(9, 1);
    society.growCellAt(8, 0);
    assertEquals("Failed neighborCount with wraparound: ", 2, society
        .neighborCount(9, 0));
    society.growCellAt(0, 15);

    society.update();
    assertTrue("Failed cellAt: ", society.cellAt(9, 0));
    assertFalse("Failed cellAt: ", society.cellAt(9, 1));
    assertFalse("Failed cellAt: ", society.cellAt(8, 0));
    assertEquals("Failed neighborCount with wraparound: ", 0, society
        .neighborCount(0, 9));
  }

  /**
   * A test.
   */
  @Test
  public void testFailedWrapUpperLeftLowerRight8() {
    society.growCellAt(0, 1);
    society.growCellAt(1, 0);
    society.growCellAt(9, 15);
    assertEquals("Failed neighborCount with wraparound: ", 2, society
        .neighborCount(0, 15));

    society.update();
    assertTrue(society.cellAt(0, 0));
    assertFalse(society.cellAt(0, 1));
    assertFalse(society.cellAt(1, 0));
    assertEquals("Failed neighborCount with wraparound: ", 0, society
        .neighborCount(0, 0));
  }

  /**
   * A test.
   */
  @Test
  public void testFailedNeighborsWrapping9() {
    society = new GameOfLife(10, 16);
    society.growCellAt(3, 0);
    society.growCellAt(3, 15);
    assertEquals("Failed neighborCount with wraparound: ", 1, society
        .neighborCount(3, 15));
    assertEquals("Failed neighborCount with wraparound: ", 1, society
        .neighborCount(3, 0));
    assertEquals("Failed neighborCount with wraparound: ", 2, society
        .neighborCount(2, 0));
    assertEquals("Failed neighborCount with wraparound: ", 2, society
        .neighborCount(4, 0));
    assertEquals("Failed neighborCount with wraparound: ", 2, society
        .neighborCount(2, 15));
    assertEquals("Failed neighborCount with wraparound: ", 2, society
        .neighborCount(4, 15));
  }

  /**
   * A test.
   */
  @Test
  public void testFailedNeighborsWhenWrapping10() {
    society.growCellAt(3, 0);
    society.growCellAt(3, 15);
    assertEquals("Failed neighborCount with wraparound: ", 1, society
        .neighborCount(3, 15));
    assertEquals("Failed neighborCount with wraparound: ", 1, society
        .neighborCount(3, 0));
    society.growCellAt(4, 0);
    society.growCellAt(4, 15);
    assertEquals("Failed neighborCount with wraparound: ", 3, society
        .neighborCount(3, 15));
    assertEquals("Failed neighborCount with wraparound: ", 3, society
        .neighborCount(3, 0));
    assertEquals("Failed neighborCount with wraparound: ", 3, society
        .neighborCount(4, 15));
    assertEquals("Failed neighborCount with wraparound: ", 3, society
        .neighborCount(4, 0));
    society.update();
    assertEquals("Failed neighborCount with wraparound: ", 3, society
        .neighborCount(3, 15));
    assertEquals("Failed neighborCount with wraparound: ", 3, society
        .neighborCount(3, 0));
    assertEquals("Failed neighborCount with wraparound: ", 3, society
        .neighborCount(4, 15));
    assertEquals("Failed neighborCount with wraparound: ", 3, society
        .neighborCount(4, 0));

    society.growCellAt(5, 0);
    society.update();
    assertTrue("Failed cellAt after updating with wraparound: ", society
        .cellAt(5, 15));
    assertTrue("Failed cellAt after updating with wraparound: ", society
        .cellAt(5, 15));
    assertTrue("Failed cellAt after updating with wraparound: ", society
        .cellAt(4, 1));
    assertFalse("Failed cellAt after updating with wraparound: ", society
        .cellAt(4, 15));

  }

  /**
   * A test.
   */
  @Test
  public void testFailedNeighborsOnCorner11() {
    society = new GameOfLife(5, 9);
    society.growCellAt(0, 1);
    society.growCellAt(1, 0);
    society.growCellAt(1, 1);
    society.growCellAt(0, 8);
    society.growCellAt(1, 8);
    society.growCellAt(4, 0);
    society.growCellAt(4, 1);
    society.growCellAt(4, 8);
    assertEquals("Failed cellAt with wraparound: ", 8, society.neighborCount(0,
        0));
  }

  /**
   * A test.
   */
  @Test
  public void testFailedProject12() {
    society = new GameOfLife(5, 9);
    society.growCellAt(0, 5);
    society.growCellAt(0, 8);
    society.growCellAt(1, 0);
    society.growCellAt(2, 0);
    society.growCellAt(2, 8);
    society.growCellAt(3, 0);
    society.growCellAt(3, 8);
    society.growCellAt(4, 4);
    society.growCellAt(4, 6);
    assertEquals("Failed neighborCount with wraparound: ", 2, society
        .neighborCount(0, 5));
    assertEquals("Failed neighborCount with wraparound: ", 4, society
        .neighborCount(2, 8));
    assertEquals("Failed neighborCount with wraparound: ", 4, society
        .neighborCount(2, 0));
    assertEquals("Failed neighborCount with wraparound: ", 3, society
        .neighborCount(1, 0));
    assertEquals("Failed neighborCount with wraparound: ", 3, society
        .neighborCount(4, 8));
    assertEquals("Failed neighborCount with wraparound: ", 3, society
        .neighborCount(3, 8));
  }

  /**
   * A test.
   */
  @Test
  public void testFailedProject14() {
    society = new GameOfLife(7, 9);
    society.growCellAt(2, 8);
    society.growCellAt(3, 8);
    society.growCellAt(4, 8);
    assertEquals("Failed neighborCount with wraparound: ", 0, society
        .neighborCount(0, 0));
    assertEquals("Failed neighborCount with wraparound: ", 1, society
        .neighborCount(1, 0));
    assertEquals("Failed neighborCount with wraparound: ", 2, society
        .neighborCount(2, 0));
    assertEquals("Failed neighborCount with wraparound: ", 3, society
        .neighborCount(3, 0));
    assertEquals("Failed neighborCount with wraparound: ", 2, society
        .neighborCount(4, 0));
    assertEquals("Failed neighborCount with wraparound: ", 1, society
        .neighborCount(5, 0));
    assertEquals("Failed neighborCount with wraparound: ", 0, society
        .neighborCount(6, 0));
  }

  @Test
  public void testFailedProject15() {
    society = new GameOfLife(7, 9);
    society.growCellAt(0, 7);
    society.growCellAt(0, 8);
    society.growCellAt(1, 8);
    assertEquals("Failed neighborCount with wraparound: ", 2, society
        .neighborCount(0, 0));
    assertEquals("Failed neighborCount with wraparound: ", 2, society
        .neighborCount(1, 0));
    assertEquals("Failed neighborCount with wraparound: ", 1, society
        .neighborCount(2, 0));
  }

  @Test
  public void testFailedProject16() {
    society = new GameOfLife(7, 9);
    society.growCellAt(0, 0);
    society.growCellAt(0, 7);
    society.growCellAt(0, 8);
    society.growCellAt(1, 8);
    assertEquals("Failed neighborCount with wraparound: ", 3, society
        .neighborCount(6, 8));
    assertEquals("Failed neighborCount with wraparound: ", 2, society
        .neighborCount(6, 7));
    assertEquals("Failed neighborCount with wraparound: ", 2, society
        .neighborCount(0, 0));
    assertEquals("Failed neighborCount with wraparound: ", 3, society
        .neighborCount(1, 0));
    assertEquals("Failed neighborCount with wraparound: ", 3, society
        .neighborCount(1, 8));
  }

  @Test
  public void testFailedFailedWhenAMixOfAllMessagesAreSent() {
    GameOfLife gol = new GameOfLife(5, 7);
    gol.growCellAt(1, 2);
    gol.growCellAt(1, 4);
    gol.growCellAt(2, 2);
    gol.growCellAt(2, 3);
    gol.growCellAt(2, 4);

    // Go to the next time
    gol.update();

    // Check the four existing cells exist still
    assertTrue(gol.cellAt(1, 2));
    assertTrue(gol.cellAt(1, 4));
    assertTrue(gol.cellAt(2, 2));
    assertTrue(gol.cellAt(2, 4));

    // This cell died off
    assertFalse(gol.cellAt(2, 3));

    // This cell grew
    assertTrue(gol.cellAt(3, 3));

    // These cells should remain unaffected in the neighborhood
    assertFalse(gol.cellAt(1, 1));
    assertFalse(gol.cellAt(1, 3));
    assertFalse(gol.cellAt(1, 5));
    assertFalse(gol.cellAt(2, 1));
    assertFalse(gol.cellAt(2, 5));

    // first row
    assertFalse(gol.cellAt(0, 0));
    assertFalse(gol.cellAt(0, 1));
    assertFalse(gol.cellAt(0, 2));
    assertFalse(gol.cellAt(0, 3));
    assertFalse(gol.cellAt(0, 4));
    assertFalse(gol.cellAt(0, 5));

    assertFalse(gol.cellAt(4, 0));
    assertFalse(gol.cellAt(4, 1));
    assertFalse(gol.cellAt(4, 2));
    assertFalse(gol.cellAt(4, 3));
    assertFalse(gol.cellAt(4, 4));
    assertFalse(gol.cellAt(4, 5));

    assertFalse(gol.cellAt(1, 0));
    assertFalse(gol.cellAt(2, 0));
    assertFalse(gol.cellAt(3, 0));
    assertFalse(gol.cellAt(4, 0));

    assertFalse(gol.cellAt(1, 6));
    assertFalse(gol.cellAt(2, 6));
    assertFalse(gol.cellAt(3, 6));
    assertFalse(gol.cellAt(4, 6));
  }
}