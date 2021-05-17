import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.Marble;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;
import org.junit.Test;

/**
 * Test cases for the marble solitaire model. Verifying that game state is properly managed, and all
 * game actions are properly validated.
 */
public class MarbleSolitaireModelImplTest {

  MarbleSolitaireModelImpl s1;
  MarbleSolitaireModelImpl s2;
  MarbleSolitaireModelImpl s3;
  MarbleSolitaireModelImpl s4;
  MarbleSolitaireModelImpl s2i;
  MarbleSolitaireModelImpl s3i;
  MarbleSolitaireModelImpl s4i;

  EuropeanSolitaireModelImpl e1;
  EuropeanSolitaireModelImpl e2;
  EuropeanSolitaireModelImpl e3;
  EuropeanSolitaireModelImpl e4;
  EuropeanSolitaireModelImpl e2i;
  EuropeanSolitaireModelImpl e3i;
  EuropeanSolitaireModelImpl e4i;

  TriangleSolitaireModelImpl t1;
  TriangleSolitaireModelImpl t2;
  TriangleSolitaireModelImpl t3;
  TriangleSolitaireModelImpl t4;
  TriangleSolitaireModelImpl t2i;
  TriangleSolitaireModelImpl t3i;
  TriangleSolitaireModelImpl t4i;

  /**
   * Constructs all valid solitaire model examples.
   */
  private void construct() {
    s1 = new MarbleSolitaireModelImpl();
    s2 = new MarbleSolitaireModelImpl(2, 2);
    s3 = new MarbleSolitaireModelImpl(5);
    s4 = new MarbleSolitaireModelImpl(3, 4, 4);

    e1 = new EuropeanSolitaireModelImpl();
    e2 = new EuropeanSolitaireModelImpl(2, 2);
    e3 = new EuropeanSolitaireModelImpl(5);
    e4 = new EuropeanSolitaireModelImpl(3, 4, 4);

    t1 = new TriangleSolitaireModelImpl();
    t2 = new TriangleSolitaireModelImpl(2, 2);
    t3 = new TriangleSolitaireModelImpl(7);
    t4 = new TriangleSolitaireModelImpl(5, 4, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstruct() {
    s1 = new MarbleSolitaireModelImpl();
    s2 = new MarbleSolitaireModelImpl(2, 2);
    s3 = new MarbleSolitaireModelImpl(5);
    s4 = new MarbleSolitaireModelImpl(3, 4, 4);
    s2i = new MarbleSolitaireModelImpl(0, 0);
    s3i = new MarbleSolitaireModelImpl(-5);
    s4i = new MarbleSolitaireModelImpl(-3, -4, -5);

    e1 = new EuropeanSolitaireModelImpl();
    e2 = new EuropeanSolitaireModelImpl(2, 2);
    e3 = new EuropeanSolitaireModelImpl(5);
    e4 = new EuropeanSolitaireModelImpl(3, 4, 4);
    e2i = new EuropeanSolitaireModelImpl(0, 0);
    e3i = new EuropeanSolitaireModelImpl(-5);
    e4i = new EuropeanSolitaireModelImpl(-3, -4, -5);

    t1 = new TriangleSolitaireModelImpl();
    t2 = new TriangleSolitaireModelImpl(2, 2);
    t3 = new TriangleSolitaireModelImpl(7);
    t4 = new TriangleSolitaireModelImpl(5, 4, 4);
    t2i = new TriangleSolitaireModelImpl(0, 0);
    t3i = new TriangleSolitaireModelImpl(-7);
    t4i = new TriangleSolitaireModelImpl(-5, -4, -5);
  }


  @Test
  public void testGetBoard() {
    this.construct();
    assertEquals(s1.getBoard()[0][2], Marble.Full);
    assertEquals(e1.getBoard()[0][2], Marble.Full);
    assertEquals(t1.getBoard()[2][2], Marble.Full);
  }

  @Test
  public void testGetGameState() {
    this.construct();
    assertEquals(s1.getGameState(), "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O");
    assertEquals(s2.getGameState(), "    O O O\n"
        + "    O O O\n"
        + "O O _ O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O");
    assertEquals(s3.getGameState(), "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O _ O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O");
    assertEquals(s4.getGameState(), "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ O O\n"
        + "    O O O\n"
        + "    O O O");

    assertEquals(e1.getGameState(), "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O");
    assertEquals(e2.getGameState(), "    O O O\n"
        + "  O O O O O\n"
        + "O O _ O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O");
    assertEquals(e3.getGameState(), "        O O O O O\n"
        + "      O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O _ O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "      O O O O O O O\n"
        + "        O O O O O");
    assertEquals(e4.getGameState(), "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ O O\n"
        + "  O O O O O\n"
        + "    O O O");

    assertEquals(t1.getGameState(), "    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O");
    assertEquals(t2.getGameState(), "    O\n"
        + "   O O\n"
        + "  O O _\n"
        + " O O O O\n"
        + "O O O O O");
    assertEquals(t3.getGameState(), "      _\n"
        + "     O O\n"
        + "    O O O\n"
        + "   O O O O\n"
        + "  O O O O O\n"
        + " O O O O O O\n"
        + "O O O O O O O");
    assertEquals(t4.getGameState(), "    O\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O _");
  }

  @Test
  public void testMove() {
    this.construct();
    s1.move(1, 3, 3, 3);
    assertEquals(s1.getGameState(), "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O");
    s2.move(2, 0, 2, 2);
    assertEquals(s2.getGameState(), "    O O O\n"
        + "    O O O\n"
        + "_ _ O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O");
    s3.move(8, 6, 6, 6);
    assertEquals(s3.getGameState(), "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O _ O O O O O O\n"
        + "O O O O O O _ O O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O");
    s4.move(4, 6, 4, 4);
    assertEquals(s4.getGameState(), "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O _ _\n"
        + "    O O O\n"
        + "    O O O");

    e1.move(1, 3, 3, 3);
    assertEquals(e1.getGameState(), "    O O O\n"
        + "  O O _ O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O");
    e2.move(2, 0, 2, 2);
    assertEquals(e2.getGameState(), "    O O O\n"
        + "  O O O O O\n"
        + "_ _ O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O");
    e3.move(8, 6, 6, 6);
    assertEquals(e3.getGameState(), "        O O O O O\n"
        + "      O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O _ O O O O O O\n"
        + "O O O O O O _ O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "      O O O O O O O\n"
        + "        O O O O O");
    e4.move(4, 6, 4, 4);
    assertEquals(e4.getGameState(), "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O");

    t1.move(2, 0, 0, 0);
    assertEquals(t1.getGameState(), "    O\n"
        + "   _ O\n"
        + "  _ O O\n"
        + " O O O O\n"
        + "O O O O O");
    t2.move(2, 0, 2, 2);
    assertEquals(t2.getGameState(), "    O\n"
        + "   O O\n"
        + "  _ _ O\n"
        + " O O O O\n"
        + "O O O O O");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalMoves() {
    this.construct();
    s1.move(-1, -3, 3, 3);
    s1.move(1, 3, -3, -3);
    s1.move(3, 3, 5, 3);
    s1.move(2, 2, 4, 2);
    s1.move(3, 2, 3, 4);
    s1.move(1, 3, 5, 3);
    s1.move(1, 3, 3, 1);

    e1.move(-1, -3, 3, 3);
    e1.move(1, 3, -3, -3);
    e1.move(3, 3, 5, 3);
    e1.move(2, 2, 4, 2);
    e1.move(3, 2, 3, 4);
    e1.move(1, 3, 5, 3);
    e1.move(1, 3, 3, 1);

    t1.move(-1, -3, 3, 3);
    t1.move(1, 3, -3, -3);
    t1.move(3, 3, 5, 3);
    t1.move(2, 2, 4, 2);
    t1.move(3, 2, 3, 4);
    t1.move(1, 3, 5, 3);
    t1.move(1, 3, 3, 1);
  }

  @Test
  public void testIsGameOver() {
    this.construct();
    assertEquals(s1.isGameOver(), false);
    assertEquals(s2.isGameOver(), false);
    assertEquals(s3.isGameOver(), false);
    assertEquals(s4.isGameOver(), false);
  }

  @Test
  public void testGetScore() {
    this.construct();
    assertEquals(s1.getScore(), 32);
    assertEquals(s2.getScore(), 32);
    assertEquals(s3.getScore(), 104);
    assertEquals(s4.getScore(), 32);
    s1.move(1, 3, 3, 3);
    s2.move(2, 0, 2, 2);
    s3.move(8, 6, 6, 6);
    s4.move(4, 6, 4, 4);
    assertEquals(s1.getScore(), 31);
    assertEquals(s2.getScore(), 31);
    assertEquals(s3.getScore(), 103);
    assertEquals(s4.getScore(), 31);
  }
}
