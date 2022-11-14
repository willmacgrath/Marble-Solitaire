package cs3500.marblesolitaire.model.hw02;


import cs3500.marblesolitaire.model.hw04.AbstractModel;

/**
 * This class represents the English Solitaire Model,
 * which will print the game in a cross pattern.
 */
public class EnglishSolitaireModel extends AbstractModel {

  /**
   * This constructor takes in no parameters, so
   * the game will always be created with
   * an armThickness of 3 and an empty center.
   */
  public EnglishSolitaireModel() {
    this.rowEmpty = 3;
    this.colEmpty = 3;
    this.armThickness = 3;
    this.setBoard();
    this.score = this.getScore();
  }

  /**
   * This constructor takes in two parameters which
   * are the coordinates for the starting empty spot.
   *
   * @param sRow Row coordinate of the empty spot
   * @param sCol Column coordinate of the empty spot
   */
  public EnglishSolitaireModel(int sRow, int sCol) { // fixed this constructor to check for max
    this.armThickness = 3;
    if ((sRow >= 0) && (sRow < getBoardSize())
            && (sCol >= 0) && (sCol < getBoardSize())) {
      this.rowEmpty = sRow;
      this.colEmpty = sCol;
    } else {
      throw new IllegalArgumentException("Invalid Empty spot");
    }
    this.setBoard();
    this.score = getScore();
  }

  /**
   * This constructor takes in one parameter which is the
   * size of arms of the board with the empty in the center.
   *
   * @param armThickness an int that describes the size of each arm
   */
  public EnglishSolitaireModel(int armThickness) {
    if ((armThickness > 0) && (armThickness % 2 != 0)) {
      this.armThickness = armThickness;
    } else {
      throw new IllegalArgumentException("Arm Thickness must be odd and positive");
    }
    this.rowEmpty = (getBoardSize() - 1) / 2;
    this.colEmpty = (getBoardSize() - 1) / 2;
    this.setBoard();
    this.score = getScore();
  }

  /**
   * This constructor takes in three parameters which
   * dictate its size and the empty spot.
   *
   * @param armThickness n int that describes the size of each arm
   * @param sRow         Row coordinate of the empty spot
   * @param sCol         Column coordinate of the empty spot
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol) {
    if ((armThickness > 0) && (armThickness % 2 != 0)) {
      this.armThickness = armThickness;
    } else {
      throw new IllegalArgumentException("Arm Thickness must be odd and positive");
    }
    if ((sRow >= 0) && (sCol >= 0) // fixed this constructor to check for max
            && (sRow < this.getBoardSize() && (sCol < this.getBoardSize()))) {
      this.rowEmpty = sRow;
      this.colEmpty = sCol;
    } else {
      throw new IllegalArgumentException("Empty Slot Location Not Valid");
    }
    this.setBoard();
    this.score = getScore();
  }

  /**
   * Sets a board by filling out each slot with the appropriate SlotState.
   */
  public void setBoard() {
    this.board = new SlotState[this.getBoardSize()][this.getBoardSize()];
    setAllInvalid();
    for (int row = 0; row < this.getBoardSize(); row++) {
      for (int col = armThickness - 1; col <= this.getBoardSize() - armThickness; col++) {
        this.board[row][col] = SlotState.Marble;
      }
    }
    for (int row = armThickness - 1; row <= this.getBoardSize() - armThickness; row++) {
      for (int col = 0; col < this.getBoardSize(); col++) {
        this.board[row][col] = SlotState.Marble;
      }
    }
    if (this.board[rowEmpty][colEmpty] == SlotState.Marble) {
      this.board[rowEmpty][colEmpty] = SlotState.Empty;
    } else {
      throw new IllegalArgumentException("Not valid empty spot");
    }
  }
}

