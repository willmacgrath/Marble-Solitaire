package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * The main class runs the game in the console.
 */
public final class Main {
  /**
   * Uses a model, view, and a readable to run the game.
   *
   * @param args Arguments that help the game to run.
   */
  public static void main(String[] args) {

    if (args.length == 1) {
      switch (args[0]) {
        case "english":
          makeEnglish(3, 3, 3).playGame();
          break;
        case "european":
          makeEuropean(3, 3, 3).playGame();
          break;
        case "triangle":
          makeTriangle(5, 0, 0).playGame();
          break;
        default:break;
      }
    }
    if (args.length == 3) {
      switch (args[0]) {
        case "english":
          makeEnglish(Integer.parseInt(args[2]), 3, 3).playGame();
          break;
        case "european":
          makeEuropean(Integer.parseInt(args[2]), 3, 3).playGame();
          break;
        case "triangle":
          makeTriangle(Integer.parseInt(args[2]), 0, 0).playGame();
          break;
        default:break;
      }
    }
    if (args.length == 4) {
      switch (args[0]) {
        case "english":
          makeEnglish(3, Integer.parseInt(args[2]),
                  Integer.parseInt(args[3])).playGame();
          break;
        case "european":
          makeEuropean(3, Integer.parseInt(args[2]),
                  Integer.parseInt(args[3])).playGame();
          break;
        case "triangle":
          makeTriangle(3, Integer.parseInt(args[2]),
                  Integer.parseInt(args[3])).playGame();
          break;
        default:break;
      }
    }
    if (args.length == 6) {
      switch (args[0]) {
        case "english":
          makeEnglish(Integer.parseInt(args[0]), Integer.parseInt(args[2]),
                  Integer.parseInt(args[3])).playGame();
          break;
        case "european":
          makeEuropean(Integer.parseInt(args[0]), Integer.parseInt(args[2]),
                  Integer.parseInt(args[3])).playGame();
          break;
        case "triangle":
          makeTriangle(Integer.parseInt(args[0]), Integer.parseInt(args[2]),
                  Integer.parseInt(args[3])).playGame();
          break;
        default:break;
      }
    }
  }

  private static MarbleSolitaireController makeEnglish(int armThickness, int sRow, int sCol) {
    MarbleSolitaireModel a = new EnglishSolitaireModel();
    MarbleSolitaireView b = new MarbleSolitaireTextView(a);
    return new MarbleSolitaireControllerImpl(a, b,
            new InputStreamReader(System.in));
  }

  private static MarbleSolitaireController makeEuropean(int armThickness, int sRow, int sCol) {
    MarbleSolitaireModel a = new EuropeanSolitaireModel();
    MarbleSolitaireView b = new MarbleSolitaireTextView(a);
    return new MarbleSolitaireControllerImpl(a, b,
            new InputStreamReader(System.in));
  }

  private static MarbleSolitaireController makeTriangle(int armThickness, int sRow, int sCol) {
    TriangleSolitaireModel a = new TriangleSolitaireModel();
    MarbleSolitaireView b = new TriangleSolitaireTextView(a);
    return new MarbleSolitaireControllerImpl(a, b,
            new InputStreamReader(System.in));
  }
}