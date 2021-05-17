package cs3500.marblesolitaire;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Runs a Marble Solitaire game on the console.
 */
public final class MarbleSolitaire {

  /**
   * Runs a Marble Solitaire game on the console.
   */
  public static void main(String[] args) {
    String s = Arrays.toString(args);
    if (s.contains("english")) {
      if (s.contains("size") && s.contains("hole")) {
        new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
            .playGame(new MarbleSolitaireModelImpl(s.charAt(s.indexOf("size") + 6) - '0',
                s.charAt(s.indexOf("hole") + 6) - '0', s.charAt(s.indexOf("hole") + 8) - '0'));
      } else if (s.contains("size")) {
        new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
            .playGame(new MarbleSolitaireModelImpl(s.charAt(s.indexOf("size") + 6) - '0'));
      } else if (s.contains("hole")) {
        new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
            .playGame(new MarbleSolitaireModelImpl(s.charAt(s.indexOf("hole") + 6) - '0',
                s.charAt(s.indexOf("hole") + 8) - '0'));
      } else {
        new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
            .playGame(new MarbleSolitaireModelImpl());
      }
    } else if (s.contains("european")) {
      if (s.contains("size") && s.contains("hole")) {
        new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
            .playGame(new EuropeanSolitaireModelImpl(s.charAt(s.indexOf("size") + 6) - '0',
                s.charAt(s.indexOf("hole") + 6) - '0', s.charAt(s.indexOf("hole") + 8) - '0'));
      } else if (s.contains("size")) {
        new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
            .playGame(new EuropeanSolitaireModelImpl(s.charAt(s.indexOf("size") + 6) - '0'));
      } else if (s.contains("hole")) {
        new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
            .playGame(new EuropeanSolitaireModelImpl(s.charAt(s.indexOf("hole") + 6) - '0',
                s.charAt(s.indexOf("hole") + 8) - '0'));
      } else {
        new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
            .playGame(new EuropeanSolitaireModelImpl());
      }
    } else if (s.contains("triangular")) {
      if (s.contains("size") && s.contains("hole")) {
        new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
            .playGame(new TriangleSolitaireModelImpl(s.charAt(s.indexOf("size") + 6) - '0',
                s.charAt(s.indexOf("hole") + 6) - '0', s.charAt(s.indexOf("hole") + 8) - '0'));
      } else if (s.contains("size")) {
        new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
            .playGame(new TriangleSolitaireModelImpl(s.charAt(s.indexOf("size") + 6) - '0'));
      } else if (s.contains("hole")) {
        new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
            .playGame(new TriangleSolitaireModelImpl(s.charAt(s.indexOf("hole") + 6) - '0',
                s.charAt(s.indexOf("hole") + 8) - '0'));
      } else {
        new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
            .playGame(new TriangleSolitaireModelImpl());
      }
    }
  }
}
