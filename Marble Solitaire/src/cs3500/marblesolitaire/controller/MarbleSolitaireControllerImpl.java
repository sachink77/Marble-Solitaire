package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import java.io.IOException;
import java.util.Scanner;

/**
 * Implements the controller for marble solitaire.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private Readable in;
  private Appendable out;

  /**
   * Constructs a controller for marble solitaire.
   *
   * @param rd the inputted string
   * @param ap the outputted string
   * @throws IllegalArgumentException when either argument is null
   */
  public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) throws IllegalArgumentException {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("null argument");
    }

    in = rd;
    out = ap;
  }

  @Override
  public void playGame(MarbleSolitaireModel model) {
    try {
      if (model == null) {
        throw new IllegalArgumentException("Empty model");
      }
      while (!(model.isGameOver())) {
        int fromRow = 0;
        int fromCol = 0;
        int toRow = 0;
        int toCol = 0;

        out.append(model.getGameState()).append("\n");
        out.append("Score: " + model.getScore()).append("\n");

        Scanner scan = new Scanner(in);
        while (scan.hasNext()) {
          String s = scan.next();
          try {
            if (Integer.parseInt(s) > 0) {
              if (fromRow == 0) {
                fromRow = Integer.parseInt(s);
              } else if (fromCol == 0) {
                fromCol = Integer.parseInt(s);
              } else if (toRow == 0) {
                toRow = Integer.parseInt(s);
              } else {
                toCol = Integer.parseInt(s);
                break;
              }
            } else {
              out.append("Invalid value").append("\n");
            }
          } catch (NumberFormatException e) {
            if (s.equals("q") || s.equals("Q")) {
              out.append("Game quit!\nState of game when quit:").append("\n");
              out.append(model.getGameState()).append("\n");
              out.append("Score: " + model.getScore()).append("\n");
              return;
            } else {
              out.append("Invalid value").append("\n");
            }
          }
        }
        try {
          model.move(fromRow - 1, fromCol - 1, toRow - 1, toCol - 1);
        } catch (IllegalArgumentException e) {
          out.append(
              "Invalid move. Play again. The given moves were illegal.")
              .append("\n");
        }
      }
      out.append("Game over!").append("\n");
      out.append(model.getGameState()).append("\n");
      out.append("Score: " + model.getScore()).append("\n");

    } catch (IOException e) {
      throw new IllegalStateException("Failed append");
    }
  }
}

