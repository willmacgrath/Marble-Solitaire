package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This class contains the operations to be performed on View objects.
 * Its primary toString method allows users to see the board
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {

  public MarbleSolitaireModelState model;
  public Appendable out;

  /**
   * Constructor takes a model and uses it to show the user a visual representation.
   *
   * @param model the type of model being visualized.
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState model) {
    if (model == null) {
      throw new IllegalArgumentException("Neither field can be null");
    }
    this.model = model;
    this.out = System.out;
  }

  /**
   * Constructor uses the model to create the board, and the out holds the outputs
   * after an action happens.
   *
   * @param model the type of model being visualized.
   * @param out   handles the output after an action is attempted
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState model, Appendable out) {
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
      for (int col = 0; col < this.model.getBoardSize(); col++) { // for every column
        switch (this.model.getSlotAt(row, col)) {
          case Empty:
            gameBoard.append("_");// in empty case append a _
            break;
          case Marble:
            gameBoard.append("O");//in empty case append a O
            break;
          case Invalid:
            gameBoard.append(" ");//in empty case append a space
            break;
          default:
            break;
        }
        // don't fill in corners *note check before adding the space to end of tile
        if (col > this.model.getBoardSize() / 2
                && col != this.model.getBoardSize() - 1
                && this.model.getSlotAt(row, col + 1)
                == MarbleSolitaireModelState.SlotState.Invalid) {
          break;
        }
        // add space after every tile
        if (col != this.model.getBoardSize() - 1) {
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