package cs3500.marblesolitaire.model.hw04;

/**
 * This class contains all methods that are used by only the European Solitaire Model.
 */
public class EuropeanSolitaireModel extends AbstractModel {

  /**
   * Default Constructor, always makes a board with armThickness 3 and the hole in the middle.
   */
  public EuropeanSolitaireModel() {
    this.rowEmpty = 3;
    this.colEmpty = 3;
    this.armThickness = 3;
    this.setBoard();
    this.score = this.getScore();
  }

  /**
   * This constructor takes in one parameter which is the
   * size of arms of the board with the empty in the center.
   *
   * @param armThickness an int that describes the size of each arm
   */
  public EuropeanSolitaireModel(int armThickness) {
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
   * This constructor takes in two parameters which
   * are the coordinates for the starting empty spot.
   *
   * @param sRow Row coordinate of the empty spot
   * @param sCol Column coordinate of the empty spot
   */
  public EuropeanSolitaireModel(int sRow, int sCol) {
    this.armThickness = 3;
    if ((sRow >= 0) && (sRow < getBoardSize())) {
      this.rowEmpty = sRow;
    }
    if ((sCol >= 0) && (sCol < getBoardSize())) {
      this.colEmpty = sCol;
    }
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
  public EuropeanSolitaireModel(int armThickness, int sRow, int sCol) {
    if ((armThickness > 0) && (armThickness % 2 != 0)) {
      this.armThickness = armThickness;
    } else {
      throw new IllegalArgumentException("Arm Thickness must be odd and positive");
    }
    if ((sRow >= 0) && (sCol >= 0)
            && (sRow < this.getBoardSize()) && (sCol < this.getBoardSize())) {
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
    for (int row = 0; row < this.getBoardSize(); row++) { // sets all to invalid
      for (int col = 0; col < this.getBoardSize(); col++) {
        this.board[row][col] = SlotState.Invalid;
      }
    }
    for (int row = 0; row <= armThickness - 1; row++) { // sets top half
      for (int col = armThickness - 1 - row;
           col <= this.getBoardSize() - armThickness + row; col++) {
        this.board[row][col] = SlotState.Marble;
      }
    }
    for (int row = armThickness - 1; row <= getBoardSize() - armThickness ; row++) {
      for (int col = 0; col < this.getBoardSize(); col++) { // sets middle rows
        this.board[row][col] = SlotState.Marble;
      }
    }
    for (int row = getBoardSize() - armThickness + 1; row < this.getBoardSize(); row++) {
      for (int col = row + armThickness - getBoardSize();
           col < (getBoardSize() * 2) - row - armThickness; col++) { // sets bottom half
        if (row < getBoardSize()) {
          this.board[row][col] = SlotState.Marble;
        }
        else {
          break;
        }
      }
    }
    if (this.board[rowEmpty][colEmpty] == SlotState.Marble) {
      this.board[rowEmpty][colEmpty] = SlotState.Empty;
    } else {
      throw new IllegalArgumentException("Not valid empty spot");
    }
  }
}


