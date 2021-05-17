import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import java.io.Reader;
import java.io.StringReader;
import org.junit.Test;

/**
 * Test cases for the marble solitaire model controller. Verifying that game state is properly
 * managed, and all game actions are properly validated.
 */
public class MarbleSolitaireControllerImplTest {

  Reader validIn = new StringReader("2 4 4 4");
  Reader validIn2 = new StringReader("2\n4\n4\n4");
  Reader invalidIn = new StringReader("1 2 3 4");
  Reader invalidIn2 = new StringReader("1\n2\n3\n4");
  Reader q = new StringReader("q");
  Reader upperQ = new StringReader("Q");
  Reader nonsense = new StringReader("nonsense");
  Reader n1 = null;
  StringBuilder out = new StringBuilder();
  StringBuilder out2 = new StringBuilder();
  StringBuilder out3 = new StringBuilder();
  StringBuilder out4 = new StringBuilder();
  StringBuilder out5 = new StringBuilder();
  StringBuilder out6 = new StringBuilder();
  StringBuilder out7 = new StringBuilder();
  StringBuilder n2 = null;
  MarbleSolitaireModelImpl m = new MarbleSolitaireModelImpl();
  MarbleSolitaireControllerImpl c = new MarbleSolitaireControllerImpl(validIn, out);
  MarbleSolitaireControllerImpl c2 = new MarbleSolitaireControllerImpl(invalidIn, out2);
  MarbleSolitaireControllerImpl c3 = new MarbleSolitaireControllerImpl(q, out3);
  MarbleSolitaireControllerImpl c4 = new MarbleSolitaireControllerImpl(upperQ, out4);
  MarbleSolitaireControllerImpl c5 = new MarbleSolitaireControllerImpl(nonsense, out5);
  MarbleSolitaireControllerImpl c6 = new MarbleSolitaireControllerImpl(n1, n2);
  MarbleSolitaireControllerImpl c7 = new MarbleSolitaireControllerImpl(validIn2, out6);
  MarbleSolitaireControllerImpl c8 = new MarbleSolitaireControllerImpl(validIn2, out7);

  @Test(expected = IllegalArgumentException.class)
  public void testPlayGame() {
    c.playGame(m);
    c2.playGame(m);
    c3.playGame(m);
    c4.playGame(m);
    c5.playGame(m);
    c6.playGame(m);
    c7.playGame(m);

    assertEquals(out.toString(), "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n");
    assertEquals(out2.toString(), "Invalid move. Play again. The given moves were illegal.\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n");
    assertEquals(out3.toString(), "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n");
    assertEquals(out4.toString(), "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n");
    assertEquals(out5.toString(), "Invalid value\n");
    assertEquals(out6.toString(), "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n");
    assertEquals(out7.toString(), "Invalid move. Play again. The given moves were illegal.\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n");
    assertEquals(n2.toString(), "");
  }
}
