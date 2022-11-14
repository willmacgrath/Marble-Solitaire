package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Abstracts methods that all models can use.
 */
public abstract class AbstractModel implements MarbleSolitaireModel {

  protected SlotState[][] board;
  protected int armThickness;
  protected int score;
  protected int rowEmpty;
  protected int colEmpty;


  /**
   * Allows marbles to be moved from one place to another and properly removing marbles.
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the move is not valid
   */
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (this.isValidMove(fromRow, fromCol, toRow, toCol)) {
      this.board[fromRow][fromCol] = SlotState.Empty; // space you moved from
      this.board[toRow][toCol] = SlotState.Marble; // space you move marble to
      if (toRow > fromRow) { // Marble you jump over
        this.board[fromRow + 1][fromCol] = SlotState.Empty; // down
      }
      if (toRow < fromRow) {
        this.board[fromRow - 1][fromCol] = SlotState.Empty; // up
      }
      if (toCol > fromCol) {
        this.board[fromRow][fromCol + 1] = SlotState.Empty; // right
      }
      if (toCol < fromCol) {
        this.board[fromRow][fromCol - 1] = SlotState.Empty; // left
      }
    } else {
      throw new IllegalArgumentException("Not a valid move");
    }
  }

  /**
   * Checks to see if there are any more possible moves.
   * @return true if the game is over, false if another move is possible
   */
  public boolean isGameOver() {
    for (int row = 0; row < this.getBoardSize(); row++) {
      for (int col = 0; col < this.getBoardSize(); col++) {
        if (this.board[row][col] == SlotState.Marble) {
          if (isValidMove(row, col, row - 2, col)) {
            return false;
          }
          if (isValidMove(row, col, row + 2, col)) {
            return false;
          }
          if (isValidMove(row, col, row, col - 2)) {
            return false;
          }
          if (isValidMove(row, col, row, col + 2)) {
            return false;
          }
        }
      }
    }
    return true;
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
  public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    if (!(isValid(toRow, toCol))) { //if the to spot is a valid spot on board
      return false;
    }
    else if (!(isValid(fromRow, fromCol))) { //if the from spot is a valid spot on board
      return false;
    } else if (this.board[fromRow][fromCol] != SlotState.Marble) { // if the from spot has a marble
      return false;
    } else if (this.board[toRow][toCol] != SlotState.Empty) { // if the to spot is empty
      return false;
    } else if (this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2]
            != SlotState.Marble) { // if there's a marble between
      return false;
    } else if (((Math.abs(toCol - fromCol) == 2)
            && (toRow == fromRow)) ||  //if they are two apart vertical
            ((Math.abs(toRow - fromRow) == 2)
                    && (toCol == fromCol))) { // 2 apart horizontal
      return true;
    }
    return false;
  }

  /**
   * Determines if the slot is at a valid placement in the board.
   *
   * @param sRow the Row of the spot we are checking
   * @param sCol the Column of the spot we are checking
   * @return true if valid, false if invalid
   **/
  public boolean isValid(int sRow, int sCol) { // not negative and not outside board
    return (((sRow >= 0) && (sRow < getBoardSize()))
            && ((sCol < getBoardSize()) && (sCol >= 0)));
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

  /**
   * Gets the SlotState at a specified location.
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return the SlotState type
   * @throws IllegalArgumentException if the slot is not on the board
   */
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (isValid(row, col)) {
      return this.board[row][col];
    } else {
      throw new IllegalArgumentException("Not valid board spot");
    }
  }

  /**
   * Gets the current score.
   * @return the current score as an int
   */
  public int getScore() {
    int scoreCount = 0;
    for (int row = 0; row < this.getBoardSize(); row++) {
      for (int col = 0; col < this.getBoardSize(); col++) {
        if (this.board[row][col] == SlotState.Marble) { // board is null lol
          scoreCount += 1;
        }
      }
    }
    return scoreCount;
  }

  /**
   * Gets the size of the board.
   * @return the board size
   */
  public int getBoardSize() {
    return (armThickness * 3) - 2;
  }
}
