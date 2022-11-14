import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * Contains all tests related to Triangle models.
 */
public class TriangleSolitaireModelTest {

  TriangleSolitaireModel model1;
  TriangleSolitaireModel model2;
  TriangleSolitaireModel model22;
  TriangleSolitaireModel model3;
  TriangleSolitaireModel model32;
  TriangleSolitaireModel model4;
  TriangleSolitaireModel model42;


  @Before
  public void setup() {
    model1 = new TriangleSolitaireModel();
    model2 = new TriangleSolitaireModel(5);
    model22 = new TriangleSolitaireModel(3);
    model3 = new TriangleSolitaireModel(0, 0);
    model32 = new TriangleSolitaireModel(2, 1);
    model4 = new TriangleSolitaireModel(5, 0, 0);
    model42 = new TriangleSolitaireModel(3, 2, 1);
  }

  @Test
  public void testConstructor1() { // tests default
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(2,2));
  }

  @Test
  public void testConstructor2() { // tests constructor that takes only size
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model2.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model2.getSlotAt(2,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model22.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model22.getSlotAt(2,2));

  }

  @Test
  public void testConstructor2Size() { // tests board size
    assertEquals(4, new TriangleSolitaireModel(4).getBoardSize());
    assertEquals(6, new TriangleSolitaireModel(6).getBoardSize());
  }

  @Test(expected = IllegalArgumentException.class) // tests negative board size
  public void testConstructor2Exception() {
    assertEquals(10, new TriangleSolitaireModel(-3).getBoardSize());
  }

  @Test
  public void testConstructor3() { // tests constructor that takes in two args
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model3.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model3.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model32.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model32.getSlotAt(2, 2));
    assertEquals(5, new TriangleSolitaireModel(0, 0).getBoardSize());
    assertEquals(5, new TriangleSolitaireModel(1,1).getBoardSize());
  }

  @Test(expected = IllegalArgumentException.class) // tests sRow too large
  public void testConstructor3Exception() {
    assertEquals(10, new TriangleSolitaireModel(7, 5).getBoardSize());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor3Exception2() { // tests sRow negative
    assertEquals(10, new TriangleSolitaireModel(-1, 1).getBoardSize());
  }

  @Test(expected = IllegalArgumentException.class) // tests sCol too large
  public void testConstructor3Exception3() {
    assertEquals(10, new TriangleSolitaireModel(4, 9).getBoardSize());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor3Exception4() { // tests sCol negative
    assertEquals(10, new TriangleSolitaireModel(1, -1).getBoardSize());
  }

  @Test
  public void testConstructor4() { // tests constructor with all args
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model4.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model4.getSlotAt(1,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model42.getSlotAt(2,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model42.getSlotAt(0,0));
  }

  @Test(expected = IllegalArgumentException.class) // tests size exception
  public void testConstructor4Exception() {
    assertEquals(10, new TriangleSolitaireModel(-1, 3, 3).getBoardSize());
  }

  @Test(expected = IllegalArgumentException.class) // tests sRow too large
  public void testConstructor4Exception2() {
    assertEquals(10, new TriangleSolitaireModel(5, 7, 4).getBoardSize());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor4Exception3() { // tests sRow negative
    assertEquals(10, new TriangleSolitaireModel(5,-1, 1).getBoardSize());
  }

  @Test(expected = IllegalArgumentException.class) // tests sCol too large
  public void testConstructor4Exception4() {
    assertEquals(10, new TriangleSolitaireModel(5,4, 9).getBoardSize());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor4Exception5() { // tests sCol negative
    assertEquals(10, new TriangleSolitaireModel(5,1, -1).getBoardSize());
  }

  @Test
  public void testGetBoardSize() {
    assertEquals(5, new TriangleSolitaireModel().getBoardSize());
    assertEquals(5, new TriangleSolitaireModel(5).getBoardSize());
    assertEquals(3, new TriangleSolitaireModel(3).getBoardSize());
    assertEquals(5, new TriangleSolitaireModel(3, 3).getBoardSize());
    assertEquals(5, new TriangleSolitaireModel(5, 3, 3).getBoardSize());
    assertEquals(3, new TriangleSolitaireModel(3, 2, 2).getBoardSize());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetSlotAtExceptionOffBoard() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(10, 10));
  }


  @Test
  public void testMove() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(2, 0));
    model1.move(2, 0, 0, 0); //up right move
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(0, 0));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(2, 2));
    model1.move(2, 2, 2, 0); // left move
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(2, 0));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(4, 4));
    model1.move(4, 4, 2, 2); // up left move
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(4, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(2, 2));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(4, 2));
    model1.move(4, 2, 4, 4); // right move
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(4, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(4, 4));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(1, 1));
    model1.move(1, 1, 3, 3); // down right move
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(3, 3));

    model1.move(3, 0, 1, 0); // just to get an open down left move
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(0, 0));
    model1.move(0, 0, 2, 0); // down left move
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(2, 0));

  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveMarbleBetween() {
    model1.move(2, 0, 0,0);
    model1.move(0, 0, 2,0); // No marble in between
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTooFarException() {
    model1.move(3, 0, 3, 3); //if from and to are not two apart
  }

  @Test
  public void testGetScore() {
    assertEquals(14, this.model1.getScore());
    model1.move(2, 0, 0, 0);
    assertEquals(13, this.model1.getScore());
    model1.move(2, 2, 2, 0);
    assertEquals(12, this.model1.getScore());
    model1.move(4, 4, 2, 2);
    assertEquals(11, this.model1.getScore());
    model1.move(4, 2, 4, 4);
    assertEquals(10, this.model1.getScore());
  }

  @Test
  public void testIsGameOver() {
    assertEquals(false, this.model1.isGameOver());
    model1.move(2, 0, 0, 0);
    model1.move(4, 0, 2, 0);
    assertEquals(false, this.model1.isGameOver());
    model1.move(4, 2, 4, 0);
    model1.move(4, 4, 4, 2);
    assertEquals(false, this.model1.isGameOver());
    model1.move(2, 2, 4, 4);
    model1.move(3, 1, 3, 3);
    assertEquals(false, this.model1.isGameOver());
    model1.move(2, 0, 2, 2);
    assertEquals(true, this.model1.isGameOver());
  }
}

