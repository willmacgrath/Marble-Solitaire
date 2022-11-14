package cs3500.marblesolitaire.controller;

/**
 * Controller allows users to send inputs to rest of program.
 */
public interface MarbleSolitaireController {

  /**
   * Plays the game in the console.
   * @throws IllegalStateException When the game is not functioning as it's supposed to.
   */
  public void playGame() throws IllegalStateException;

}
