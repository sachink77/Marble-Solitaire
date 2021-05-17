package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.Marble;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Represents an abstract model for marble solitaire game representations.
 */
public abstract class AbstractSolitaireModel implements MarbleSolitaireModel {

  public int armThickness;
  public int emptyX;
  public int emptyY;
  public Marble[][] board;

  /**
   * Move a single marble from a given position to another given position. A move is valid only if
   * the from and to positions are valid. Specific implementations may place additional constraints
   * on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   * @throws IllegalArgumentException if the move is not possible, the cell position is invalid, or
   *                                  the cell position is not a marble (updated to add more
   *                                  exception cases)
   */
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
  public boolean isGameOver() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (i < board.length - 1 && j < board[i].length - 1) {
          if (board[i][j] == Marble.Full
              && (board[i + 1][j] == Marble.Full && board[i + 2][j] == Marble.Empty
              || board[i][j + 1] == Marble.Full && board[i][j + 2] == Marble.Empty)) {
            return false;
          }
        }
        if (i > 1 && j > 1) {
          if (board[i][j] == Marble.Full
              && (board[i - 1][j] == Marble.Full && board[i - 2][j] == Marble.Empty
              || board[i][j - 1] == Marble.Full && board[i][j - 2] == Marble.Empty)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  @Override
  public String getGameState() {
    StringBuilder s = new StringBuilder();

    for (Marble[] row : board) {
      for (Marble m : row) {
        if (m != null) {
          s.append(m.toString() + " ");
        }
      }
      s.deleteCharAt(s.length() - 1);
      s.append("\n");
    }
    s.deleteCharAt(s.length() - 1);
    return s.toString();
  }

  @Override
  public int getScore() {
    int n = 0;
    for (Marble[] row : board) {
      for (Marble m : row) {
        if (m != null && m == Marble.Full) {
          n++;
        }
      }
    }
    return n;
  }
}
