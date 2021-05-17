package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.Marble;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Represents a single game of european solitaire.
 */
public class EuropeanSolitaireModelImpl extends AbstractSolitaireModel implements
    MarbleSolitaireModel {

  /**
   * Constructs a default european solitaire game with an arm thickness of 3 and the empty slot at
   * the center.
   */
  public EuropeanSolitaireModelImpl() {
    armThickness = 3;
    emptyX = 3;
    emptyY = 3;
    board = getBoard();
  }

  /**
   * Constructs a european solitaire game with an arm thickness of 3 and a given empty slot
   * position.
   *
   * @param sRow empty slot row
   * @param sCol empty slot column
   */
  public EuropeanSolitaireModelImpl(int sRow, int sCol) {
    armThickness = 3;
    emptyX = sRow;
    emptyY = sCol;
    board = getBoard();
  }

  /**
   * Constructs a marble solitaire game with a given arm thickness and the empty slot at the
   * center.
   *
   * @param thickness arm thickness
   */
  public EuropeanSolitaireModelImpl(int thickness) {
    if (thickness < 1 || thickness % 2 == 0) {
      throw new IllegalArgumentException();
    }

    armThickness = thickness;
    emptyX = (armThickness * 3 - 2) / 2;
    emptyY = (armThickness * 3 - 2) / 2;
    board = getBoard();
  }

  /**
   * Constructs a marble solitaire game with a given arm thickness and a given empty slot position.
   *
   * @param thickness arm thickness
   * @param sRow      empty slot row
   * @param sCol      empty slot column
   */
  public EuropeanSolitaireModelImpl(int thickness, int sRow, int sCol) {
    if (thickness < 1 || thickness % 2 == 0) {
      throw new IllegalArgumentException();
    }

    armThickness = thickness;
    emptyX = sRow;
    emptyY = sCol;
    try {
      board = getBoard();
    } catch (Exception e) {
      throw new IllegalArgumentException(
          "Invalid empty cell position (" + sRow + ", " + sCol + ")");
    }
  }

  /**
   * Builds an array representing the marble solitaire board, with the appropriate arm thickness and
   * empty slot position.
   *
   * @return an array representing the marble solitaire board
   */
  public Marble[][] getBoard() {
    board = new Marble[armThickness * 3 - 2][armThickness * 3 - 2];
    for (int i = 0; i < armThickness * 3 - 2; i++) {
      if (i < armThickness - 1) {
        for (int j = 0; j < armThickness - 1 - i; j++) {
          board[i][j] = Marble.Blank;
        }
        for (int j = armThickness - 1 - i; j < armThickness * 2 - 1 + i; j++) {
          board[i][j] = Marble.Full;
        }
      } else if (i > armThickness * 2 - 2) {
        for (int j = 0; j < i - armThickness * 2 + 2; j++) {
          board[i][j] = Marble.Blank;
        }
        for (int j = i - armThickness * 2 + 2; j < armThickness * 5 - 4 - i; j++) {
          board[i][j] = Marble.Full;
        }
      } else {
        for (int j = 0; j < armThickness * 3 - 2; j++) {
          board[i][j] = Marble.Full;
        }
      }
    }
    if (board[emptyX][emptyY] == Marble.Full) {
      board[emptyX][emptyY] = Marble.Empty;
    } else {
      throw new IllegalArgumentException();
    }
    return board;
  }
}
