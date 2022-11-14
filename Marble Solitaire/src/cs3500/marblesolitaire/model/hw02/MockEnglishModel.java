package cs3500.marblesolitaire.model.hw02;

import java.util.Objects;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * This mock allows you to observe the values passed to the move method.
 */
public class MockEnglishModel implements MarbleSolitaireModel {
  final StringBuilder log;

  public MockEnglishModel(StringBuilder log) {
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
