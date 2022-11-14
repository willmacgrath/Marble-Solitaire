package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Contains methods related to the Controller.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  public MarbleSolitaireModel model;
  public MarbleSolitaireView view;
  public Readable in;

  /**
   * Controller constructor takes in the model, the view, and inputs, and uses these to play
   * the game.
   * @param model the type of board you want to play on
   * @param view makes the board visible to the user
   * @param in the inputs given by the use
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model,
                                       MarbleSolitaireView view, Readable in) {
    if (model == null || view == null || in == null) {
      throw new IllegalArgumentException("No Field can be null");
    }
    this.model = model;
    this.view = view;
    this.in = in;
  }

  @Override
  public void playGame() {
    boolean gameQuit = false;
    Scanner scan = new Scanner(in); // scan inputs
    while (!(model.isGameOver())) { // while game is not over
      try {
        this.view.renderBoard(); // render board
      } catch (IOException e) {
        throw new IllegalStateException("View could not be rendered");
      }
      try {
        this.view.renderMessage("\nScore: " + model.getScore() + "\n"); // render score
      } catch (IOException e) {
        throw new IllegalStateException("Message could not be rendered");
      }
      ArrayList<Integer> inputList = new ArrayList<>();
      while (inputList.size() < 4) {
        int b = 0;
        if (scan.hasNext()) { // why is causing it to infinitely loop
          String a = scan.next();
          try {
            b = Integer.parseInt(a);
            if (b > 0) {
              inputList.add(b);
            }
          } catch (NumberFormatException e) {
            if (a.equalsIgnoreCase("q")) {
              try {
                this.view.renderMessage("Game quit!\n"
                        + "State of game when quit:\n"
                        + this.view + "\n"
                        + "Score: " + model.getScore());
                gameQuit = true;
                break;
              } catch (IOException f) {
                throw new IllegalStateException("Message could not be rendered");
              }
            }
          }
        } else {
          throw new IllegalStateException();
        }
      }
      if (gameQuit) { // if game has been quit break, if not end game
        break;
      } try {
        this.model.move(inputList.get(0) - 1, inputList.get(1) - 1, // move
                inputList.get(2) - 1, inputList.get(3) - 1);
      } catch (IllegalArgumentException e) {
        try {
          this.view.renderMessage("Invalid Move. Play again.\n");
        } catch (IOException f) {
          throw new IllegalStateException("Message could not be rendered");
        }
      }
    }
    if (!(gameQuit)) {
      try { // Game over
        this.view.renderMessage("Game over!\n"
                + this.view + "\n"
                + "Score: " + model.getScore());
      } catch (IOException e) {
        throw new IllegalStateException("Message could not be rendered");
      }
    }
  }
}
