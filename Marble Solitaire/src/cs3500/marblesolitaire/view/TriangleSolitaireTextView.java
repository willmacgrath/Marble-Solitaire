package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Class contains all methods that allow a user to see the triangle model.
 */
public class TriangleSolitaireTextView implements MarbleSolitaireView {

  public MarbleSolitaireModelState model;
  public Appendable out;

  /**
   * Constructor takes a model and uses it to show the user a visual representation.
   * @param model the type of model being visualized.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model) {
    if (model == null) {
      throw new IllegalArgumentException("Neither field can be null");
    }
    this.model = model;
    this.out = System.out;
  }

  /**
   * Constructor uses the model to create the board, and the out holds the outputs
   * after an action happens.
   * @param model the type of model being visualized.
   * @param out handles the output after an action is attempted
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model, Appendable out) {
    if ((model == null) || (out == null)) {
      throw new IllegalArgumentException("Neither field can be null");
    }
    this.out = out;
    this.model = model;
  }


  @Override
  public String toString() {
    StringBuilder gameBoard = new StringBuilder();
    for (int row = 0; row < this.model.getBoardSize(); row++) { // for every row
      for (int i = 0; i < model.getBoardSize() - 1 - row; i++) {
        gameBoard.append(" ");
      }
      for (int col = 0; col < this.model.getBoardSize(); col++) { // for every column
        switch (this.model.getSlotAt(row, col)) {
          case Empty:
            gameBoard.append("_");// in empty case append a _
            break;
          case Marble:
            gameBoard.append("O");//in empty case append a O
            break;
          case Invalid:
            gameBoard.append("");//in empty case append a space
            break;
          default: break;
        }


        // add space after every tile it's supposed to
        if (col < row) {
          gameBoard.append(" ");
        }
      }
      // add new line unless at bottom of board
      if (row != this.model.getBoardSize() - 1) {
        gameBoard.append("\n");
      }
    }
    return gameBoard.toString();
  }

  @Override
  public void renderBoard() throws IOException { // add IOException
    out.append(toString());
  }

  @Override
  public void renderMessage(String message) throws IOException { // add IOException
    out.append(message);
  }
}