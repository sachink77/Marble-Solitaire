package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModel;

/**
 * Represents a single game of marble solitaire.
 */
public class MarbleSolitaireModelImpl extends AbstractSolitaireModel implements
    MarbleSolitaireModel {

  /**
   * Constructs a default marble solitaire game with an arm thickness of 3 and the empty slot at the
   * center.
   */
  public MarbleSolitaireModelImpl() {
    armThickness = 3;
    emptyX = 3;
    emptyY = 3;
    board = getBoard();
  }

  /**
   * Constructs a marble solitaire game with an arm thickness of 3 and a given empty slot position.
   *
   * @param sRow empty slot row
   * @param sCol empty slot column
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    if (sRow < 1 || sRow > 4) {
      if (sCol > 1 || sCol < 4 || sRow < 0 || sRow > 6) {
        throw new IllegalArgumentException(
            "Invalid empty cell position (" + sRow + ", " + sCol + ")");
      }
    }

    if (sCol < 1 || sCol > 4) {
      if (sRow < 1 || sRow > 4 || sCol < 0 || sCol > 6) {
        throw new IllegalArgumentException(
            "Invalid empty cell position (" + sRow + ", " + sCol + ")");
      }
    }

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
  public MarbleSolitaireModelImpl(int thickness) {
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
  public MarbleSolitaireModelImpl(int thickness, int sRow, int sCol) {
    if (thickness < 1 || thickness % 2 == 0) {
      throw new IllegalArgumentException();
    }

    if (sRow < thickness - 1 || sRow > thickness * 2 - 2) {
      if (sCol < thickness - 1 || sCol > thickness * 2 - 2 || sRow < 0
          || sRow > thickness * 3 - 3) {
        throw new IllegalArgumentException(
            "Invalid empty cell position (" + sRow + ", " + sCol + ")");
      }
    }

    if (sCol < thickness - 1 || sCol > thickness * 2 - 2) {
      if (sRow < thickness - 1 || sRow > thickness * 2 - 2 || sCol < 0
          || sCol > thickness * 3 - 3) {
        throw new IllegalArgumentException(
            "Invalid empty cell position (" + sRow + ", " + sCol + ")");
      }
    }

    armThickness = thickness;
    emptyX = sRow;
    emptyY = sCol;
    board = getBoard();
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
      if (i < armThickness - 1 || i > armThickness * 2 - 2) {
        for (int j = 0; j < armThickness - 1; j++) {
          board[i][j] = Marble.Blank;
        }
        for (int j = armThickness - 1; j < armThickness * 2 - 1; j++) {
          board[i][j] = Marble.Full;
        }
      } else {
        for (int j = 0; j < armThickness * 3 - 2; j++) {
          board[i][j] = Marble.Full;
        }
      }
    }
    board[emptyX][emptyY] = Marble.Empty;
    return board;
  }
}
