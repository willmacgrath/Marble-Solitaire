package cs3500.marblesolitaire.model.hw04;

/**
 * Contains all methods exclusive to TriangleSolitaireModels.
 */
public class TriangleSolitaireModel extends AbstractModel {

  /**
   * Default Constructor that always makes a board with a bottom size of 5 and an empty at the top.
   */
  public TriangleSolitaireModel() {
    this.rowEmpty = 0;
    this.colEmpty = 0;
    this.armThickness = 5;
    this.setBoard();
    this.score = this.getScore();
  }

  /**
   * This constructor takes in one parameter which is the
   * size of arms of the board with the empty in the center.
   *
   * @param size an int that describes the size of each arm
   */
  public TriangleSolitaireModel(int size) throws IllegalArgumentException {
    this.rowEmpty = 0;
    this.colEmpty = 0;
    if (size >= 0) {
      this.armThickness = size;
    } else {
      throw new IllegalArgumentException("Size cannot be negative");
    }
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
  public TriangleSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this.armThickness = 5;
    if (((sRow >= 0) && (sRow < armThickness)) && ((sCol >= 0) && (sCol < armThickness))) {
      this.rowEmpty = sRow;
      this.colEmpty = sCol;
    } else {
      throw new IllegalArgumentException("Not a valid empty space");
    }
    this.setBoard();
    this.score = getScore();
  }


  /**
   * This constructor takes in three parameters which
   * dictate its size and the empty spot.
   *
   * @param size n int that describes the size of each arm
   * @param sRow Row coordinate of the empty spot
   * @param sCol Column coordinate of the empty spot
   */
  public TriangleSolitaireModel(int size, int sRow, int sCol) throws IllegalArgumentException {
    if (size >= 0) {
      this.armThickness = size;
    } else {
      throw new IllegalArgumentException("Size cannot be negative");
    }
    if ((sRow >= 0) && (sCol >= 0)
            && (sRow < this.getBoardSize() && (sCol < this.getBoardSize()))) {
      this.rowEmpty = sRow;
      this.colEmpty = sCol;
    } else {
      throw new IllegalArgumentException("Empty Slot Location Not Valid");
    }
    this.setBoard();
    this.score = getScore();
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (this.isValidMove(fromRow, fromCol, toRow, toCol)) {
      this.board[fromRow][fromCol] = SlotState.Empty; // clear space you moved from
      this.board[toRow][toCol] = SlotState.Marble; // set space you move marble to
      if ((toCol < fromCol) && (toRow < fromRow)) {
        this.board[fromRow - 1][fromCol - 1] = SlotState.Empty; // up left
      }
      if ((toCol == fromCol) && (toRow > fromRow)) {
        this.board[fromRow + 1][fromCol] = SlotState.Empty; // down left
      }
      if ((toCol == fromCol) && (toRow < fromRow)) {
        this.board[fromRow - 1][fromCol] = SlotState.Empty; // up right
      }
      if ((toCol > fromCol) && (toRow > fromRow)) {
        this.board[fromRow + 1][fromCol + 1] = SlotState.Empty; // down right
      }
      if ((toCol > fromCol) && (toRow == fromRow)) {
        this.board[fromRow][fromCol + 1] = SlotState.Empty; // right
      }
      if ((toCol < fromCol) && (toRow == fromRow)) {
        this.board[fromRow][fromCol - 1] = SlotState.Empty; // left
      }
    } else {
      throw new IllegalArgumentException("Not a valid move");
    }
  }


  /**
   * Checks to see if the move is able to be performed.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @return true if valid, false if not
   */

  @Override
  public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    if (!(isValid(toRow, toCol))) { //if the to spot is a valid spot on board
      return false;
    }
    if (!(isValid(fromRow, fromCol))) { //if the from spot is a valid spot on board
      return false;
    } else if (this.board[fromRow][fromCol] != SlotState.Marble) { // if the from spot has a marble
      return false;
    } else if (this.board[toRow][toCol] != SlotState.Empty) { // if the to spot is empty
      return false;
    } else if (this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2]
            != SlotState.Marble) { // if there's a marble between
      return false;
    } else {
      return (((Math.abs(toRow - fromRow) == 2) //if they are two apart positive slope diagonal
              && (toCol == fromCol))
              || ((Math.abs(toRow - fromRow) == 2) //if they are two apart negative slope diagonal
              && ((Math.abs(toCol - fromCol) == 2)))
              || ((Math.abs(toCol - fromCol) == 2) // if they are 2 apart horizontal
              && (toRow == fromRow)));
    }
  }


  /**
   * Sets a board by filling out each slot with the appropriate SlotState.
   */
  public void setBoard() {
    this.board = new SlotState[this.getBoardSize()][this.getBoardSize()];
    setAllInvalid();
    for (int row = 0; row < getBoardSize(); row++) { // set marbles
      for (int col = 0; col <= row; col++) {
        this.board[row][col] = SlotState.Marble;
      }
    }
    if (this.board[rowEmpty][colEmpty] == SlotState.Marble) { // set empty slot
      this.board[rowEmpty][colEmpty] = SlotState.Empty;
    } else {
      throw new IllegalArgumentException("Not valid empty spot");
    }
  }

  /**
   * Helper method that sets the whole board to Invalid.
   */
  public void setAllInvalid() {
    for (int row = 0; row < this.getBoardSize(); row++) { // sets all to invalid
      for (int col = 0; col < this.getBoardSize(); col++) {
        this.board[row][col] = SlotState.Invalid;
      }
    }
  }

  @Override
  public int getBoardSize() {
    return armThickness;
  }

  /**
   * Checks to see if there are any more possible moves.
   *
   * @return true if the game is over, false if another move is possible
   */
  public boolean isGameOver() {
    for (int row = 0; row < this.getBoardSize(); row++) {
      for (int col = 0; col < this.getBoardSize(); col++) {
        if (this.board[row][col] == SlotState.Marble) {
          if (isValidMove(row, col, row + 2, col)) { // down left
            return false;
          }
          if (isValidMove(row, col, row - 2, col)) { // up right
            return false;
          }
          if (isValidMove(row, col, row, col - 2)) { // left
            return false;
          }
          if (isValidMove(row, col, row, col + 2)) { // right
            return false;
          }
          if (isValidMove(row, col, row - 2, col - 2)) { // up left
            return false;
          }
          if (isValidMove(row, col, row + 2, col + 2)) { // down right
            return false;
          }
        }
      }
    }
    return true;
  }
}


