package cs3500.marblesolitaire.model.hw02;

/**
 * Represents a marble in a game of marble solitaire.
 */
public enum Marble {
  Empty("_"), Full("O"), Blank(" ");

  private final String disp;

  Marble(String disp) {
    this.disp = disp;
  }

  @Override
  public String toString() {
    return disp;
  }
}
