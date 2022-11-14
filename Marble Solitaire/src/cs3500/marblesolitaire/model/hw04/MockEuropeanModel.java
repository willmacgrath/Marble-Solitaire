package cs3500.marblesolitaire.model.hw04;

import java.util.Objects;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * A mock European Model that allows you to observe the ints passed to the move method.
 */
public class MockEuropeanModel implements MarbleSolitaireModel {

  final StringBuilder log;

  public MockEuropeanModel(StringBuilder log) {
    this.log = Objects.requireNonNull(log);
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    log.append(String.format("fromRow = %d, FromCol = %d, toRow = %d, toCol = %d",
            fromRow, fromCol, toRow, toCol));
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public int getBoardSize() {
    return 0;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    return null;
  }

  @Override
  public int getScore() {
    return 0;
  }
}
