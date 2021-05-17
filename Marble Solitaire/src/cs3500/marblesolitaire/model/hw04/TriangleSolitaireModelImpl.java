package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.Marble;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Represents a single game of triangle solitaire.
 */
public class TriangleSolitaireModelImpl extends AbstractSolitaireModel implements
    MarbleSolitaireModel {

  /**
   * Constructs a default european solitaire game with an arm thickness of 3 and the empty slot at
   * the center.
   */
  public TriangleSolitaireModelImpl() {
    armThickness = 5;
    emptyX = 0;
    emptyY = 0;
    board = getBoard();
  }

  /**
   * Constructs a marble solitaire game with a given arm thickness and the empty slot at the
   * center.
   *
   * @param thickness arm thickness
   */
  public TriangleSolitaireModelImpl(int thickness) {
    if (thickness < 1) {
      throw new IllegalArgumentException();
    }

    armThickness = thickness;
    emptyX = 0;
    emptyY = 0;
    board = getBoard();
  }

  /**
   * Constructs a european solitaire game with an arm thickness of 3 and a given empty slot
   * position.
   *
   * @param sRow empty slot row
   * @param sCol empty slot column
   */
  public TriangleSolitaireModelImpl(int sRow, int sCol) {
    armThickness = 5;
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
   * Constructs a marble solitaire game with a given arm thickness and a given empty slot position.
   *
   * @param thickness arm thickness
   * @param sRow      empty slot row
   * @param sCol      empty slot column
   */
  public TriangleSolitaireModelImpl(int thickness, int sRow, int sCol) {
    if (thickness < 1) {
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
    board = new Marble[armThickness][armThickness];
    for (int i = 0; i < armThickness; i++) {
      for (int j = 0; j <= i; j++) {
        board[i][j] = Marble.Full;
      }
    }
    if (board[emptyX][emptyY] == Marble.Full) {
      board[emptyX][emptyY] = Marble.Empty;
    } else {
      throw new IllegalArgumentException();
    }
    return board;
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) {
    if (fromRow < 0 || fromCol < 0 || toRow < 0 || toCol < 0
        || fromRow > board.length - 1 || fromCol > board.length - 1 || toRow > board.length - 1
        || toCol > board.length - 1) {
      throw new IllegalArgumentException("Invalid cell position");
    } else if (board[fromRow][fromCol] != Marble.Full || board[toRow][toCol] != Marble.Empty) {
      throw new IllegalArgumentException("Invalid move: not a marble");
    } else {
      if (fromRow != toRow && fromCol != toCol) {
        throw new IllegalArgumentException("Invalid move");
      }
      if (fromRow == toRow && Math.abs(fromCol - toCol) != 2) {
        throw new IllegalArgumentException("Invalid move");
      }
      if (fromCol == toCol && Math.abs(fromRow - toRow) != 2) {
        throw new IllegalArgumentException("Invalid move");
      }
      board[fromRow][fromCol] = Marble.Empty;
      board[toRow][toCol] = Marble.Full;
      if (fromRow == toRow) {
        board[fromRow][(fromCol + toCol) / 2] = Marble.Empty;
      } else {
        board[(fromRow + toRow) / 2][fromCol] = Marble.Empty;
      }
    }
  }

  @Override
  public String getGameState() {
    String s = "";

    for (int i = 0; i < armThickness; i++) {
      for (int j = armThickness - 2; j >= i; j--) {
        s += " ";
      }
      for (int j = 0; j < armThickness; j++) {
        if (board[i][j] != null) {
          s += board[i][j].toString() + " ";
        }
      }
      s = s.substring(0, s.length() - 1);
      s += "\n";
    }
    s = s.substring(0, s.length() - 1);
    return s;
  }
}
