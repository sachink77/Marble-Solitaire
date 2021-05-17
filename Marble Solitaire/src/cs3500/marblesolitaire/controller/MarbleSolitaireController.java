package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Represents a Controller for Marble Solitaire: handle user moves by executing them using the
 * model; convey move outcomes to the user in some form.
 */
public interface MarbleSolitaireController {

  /**
   * Execute a single game of marble solitaire given a Model. When the game is over, the playGame
   * method ends.
   *
   * @param model a non-null marble solitaire Model
   * @throws IllegalArgumentException when the model is null
   * @throws IllegalStateException    when the controller can't receive inputs or outputs
   */
  void playGame(MarbleSolitaireModel model);
}
