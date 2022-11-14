import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * Tests all methods related to the Model European Solitaire class.
 */
public class EuropeanSolitaireModelTest {

  EuropeanSolitaireModel model1;
  EuropeanSolitaireModel model2;
  EuropeanSolitaireModel model22;
  EuropeanSolitaireModel model3;
  EuropeanSolitaireModel model32;
  EuropeanSolitaireModel model4;
  EuropeanSolitaireModel model42;

  @Before
  public void setup() {
    model1 = new EuropeanSolitaireModel();
    model2 = new EuropeanSolitaireModel(3);
    model22 = new EuropeanSolitaireModel(5);
    model3 = new EuropeanSolitaireModel(3, 3);
    model32 = new EuropeanSolitaireModel(6, 4);
    model4 = new EuropeanSolitaireModel(3, 3, 3);
    model42 = new EuropeanSolitaireModel(5, 3, 8);
  }

  @Test
  public void testConstructor1() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(0,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model1.getSlotAt(0 ,0));
  }

  @Test
  public void testConstructor2() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model2.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model2.getSlotAt(0,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model2.getSlotAt(0 ,0));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor2Exception() {
    assertEquals(10, new EuropeanSolitaireModel(4).getBoardSize());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor2Exception2() {
    assertEquals(10, new EuropeanSolitaireModel(6).getBoardSize());
  }

  @Test
  public void testConstructor3() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model3.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model3.getSlotAt(0,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model3.getSlotAt(0 ,0));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor3Exception() {
    assertEquals(10, new EuropeanSolitaireModel(7, 5).getBoardSize());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor3Exception2() {
    assertEquals(10, new EuropeanSolitaireModel(-1, -5).getBoardSize());
  }

  @Test
  public void testConstructor4() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model4.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model4.getSlotAt(0,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model4.getSlotAt(0 ,0));
  }

  @Test(expected = IllegalArgumentException.class) // sRow negative
  public void testConstructor4Exception() {
    assertEquals(10, new EuropeanSolitaireModel(3, -1, 3).getBoardSize());
  }

  @Test(expected = IllegalArgumentException.class) // sCol negative
  public void testConstructor4Exception2() {
    assertEquals(10, new EuropeanSolitaireModel(3, 3, -3).getBoardSize());
  }

  @Test(expected = IllegalArgumentException.class) // armThickness not odd
  public void testConstructor4Exception3() {
    assertEquals(10, new EuropeanSolitaireModel(6, 3, 3).getBoardSize());
  }

  @Test(expected = IllegalArgumentException.class) // armThickness negative
  public void testConstructor4Exception4() {
    assertEquals(10, new EuropeanSolitaireModel(-5, 3, 3).getBoardSize());
  }

  @Test
  public void testGetBoardSize() {
    assertEquals(7, new EuropeanSolitaireModel().getBoardSize());
    assertEquals(7, new EuropeanSolitaireModel(3).getBoardSize());
    assertEquals(7, new EuropeanSolitaireModel(3, 3).getBoardSize());
    assertEquals(7, new EuropeanSolitaireModel(3, 3, 3).getBoardSize());
    assertEquals(13, new EuropeanSolitaireModel(5).getBoardSize());
  }


  @Test
  public void testGetSlotAt() {
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(3, 2));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetSlotAtExceptionOffBoard() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(10, 10));
  }


  @Test
  public void testMove() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(1, 3));
    model1.move(1, 3, 3, 3);//down move
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(1, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(3, 3));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(4, 3));
    model1.move(4, 3, 2, 3); //up move
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(2, 3));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(3, 1));
    model1.move(3, 1, 3, 3); //right move
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(3, 3));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(6, 3));
    model1.move(6, 3, 4, 3); //left move
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(6, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(5, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(4, 3));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveMarbleToNoExist() {
    model1.move(2, 1, 10, 10);//if to position doesn't exist
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveMarbleFromNoExist() {
    model1.move(10, 10, 3, 3);//if from position doesn't exist
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveMarbleBetween() {
    model1.move(2, 1, 3, 3);//If there is no marble between them
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNoFromMarbleException() {
    model1.move(3, 1, 3, 3); // moves to make scenario possible
    model1.move(1, 2, 3, 2);
    model1.move(3, 3, 3, 1);
    model1.move(3, 4, 5, 4); //if from does not have a marble
  }


  @Test(expected = IllegalArgumentException.class)
  public void testToNotEmptyException() {
    model1.move(3, 1, 5, 1);//if to isn't empty
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNoBetweenException() {
    model1.move(3, 1, 3, 3);
    model1.move(3, 0, 3, 2);//If there is no marble between them
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTooFarException() {
    model1.move(3, 0, 3, 3);// if from and to are not two apart
  }

  @Test
  public void testGetScore() {
    assertEquals(36, this.model1.getScore());
    model1.move(1, 3, 3, 3);
    assertEquals(35, this.model1.getScore());
    model1.move(4, 3, 2, 3);
    assertEquals(34, this.model1.getScore());
    model1.move(3, 1, 3, 3);
    assertEquals(33, this.model1.getScore());
    model1.move(6, 3, 4, 3);
    assertEquals(32, this.model1.getScore());
  }

  @Test
  public void testIsGameOver() {
    model1.setBoard();
    assertEquals(false, this.model1.isGameOver());
    model1.move(1, 3, 3, 3);
    model1.move(2, 1, 2, 3);
    model1.move(0, 2, 2, 2);
    assertEquals(false, this.model1.isGameOver());
    model1.move(3, 2, 1, 2);
    model1.move(0, 4, 0, 2);
    model1.move(0, 2, 2, 2);
    assertEquals(false, this.model1.isGameOver());
    model1.move(5, 2, 3, 2);
    model1.move(4, 0, 4, 2);
    model1.move(4, 3, 4, 1);
    model1.move(2, 0, 4, 0);
    model1.move(4, 0, 4, 2);
    model1.move(4, 5, 4, 3);
    assertEquals(false, this.model1.isGameOver());
    model1.move(6, 4, 4, 4);
    model1.move(3, 4, 5, 4);
    model1.move(6, 2, 6, 4);
    model1.move(6, 4, 4, 4);
    model1.move(1, 4, 3, 4);
    model1.move(2, 6, 2, 4);
    assertEquals(false, this.model1.isGameOver());
    model1.move(2, 3, 2, 5);
    model1.move(4, 6, 2, 6);
    model1.move(2, 6, 2, 4);
    model1.move(4, 3, 4, 1);
    model1.move(4, 1, 2, 1);
    model1.move(2, 1, 2, 3);
    model1.move(2, 3, 2, 5);
    model1.move(2, 5, 4, 5);
    model1.move(4, 5, 4, 3);
    model1.move(3, 3, 3, 5);
    model1.move(5, 3, 3, 3);
    model1.move(3, 2, 3, 4);
    model1.move(3, 5, 3, 3);
    assertEquals(true, this.model1.isGameOver());
  }
}



























