import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;
import static org.junit.Assert.assertEquals;

/**
 * Tests all methods relating to the View class.
 * Mainly tests toString(), which shows the board
 * as it is played
 */
public class TriangleSolitaireTextViewTest {

  TriangleSolitaireModel model1;
  TriangleSolitaireModel model2;
  TriangleSolitaireModel model23;
  TriangleSolitaireModel model3;
  TriangleSolitaireModel model4;
  String three;
  String five;
  TriangleSolitaireTextView view1;
  TriangleSolitaireTextView view2;
  TriangleSolitaireTextView view23;
  TriangleSolitaireTextView view3;
  TriangleSolitaireTextView view4;



  @Before
  public void setup() {
    model1 = new TriangleSolitaireModel();
    model2 = new TriangleSolitaireModel(5);
    model23 = new TriangleSolitaireModel(3);
    model3 = new TriangleSolitaireModel(0,0);
    model4 = new TriangleSolitaireModel(5,0,0);
    three = ("  _\n" +
            " O O\n" +
            "O O O");

    five = ("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O");
    view1 = new TriangleSolitaireTextView(model1);
    view2 = new TriangleSolitaireTextView(model2);
    view3 = new TriangleSolitaireTextView(model3);
    view4 = new TriangleSolitaireTextView(model4);
    view23 = new TriangleSolitaireTextView(model23);
  }

  @Test
  public void testToString() {
    assertEquals(five, view1.toString());
    assertEquals(five, view2.toString());
    assertEquals(five, view3.toString());
    assertEquals(five, view4.toString());
    assertEquals(three, view23.toString());
  }

  @Test
  public void testRenderBoard() throws IOException { // tests that it renders the board correctly
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    Appendable out = new StringBuilder();
    MarbleSolitaireView ftw = new TriangleSolitaireTextView(model, out);
    String start = "    _\n" +
                   "   O O\n" +
                   "  O O O\n" +
                   " O O O O\n" +
                   "O O O O O";
    ftw.renderBoard();
    assertEquals(start, out.toString());
  }

  @Test (expected = IOException.class)
  public void testRenderBoardException() throws IOException { // tests appendable exception
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    Appendable out = new FakeTestAppendable();
    MarbleSolitaireView ftw = new TriangleSolitaireTextView(model, out);
    ftw.renderBoard();
    assertEquals("", out.toString());
  }

  @Test
  public void testRenderMessage() throws IOException { // tests that it renders message correctly
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    Appendable out = new StringBuilder();
    MarbleSolitaireView ftw = new TriangleSolitaireTextView(model, out);
    String one = "one";
    String two = "two";
    ftw.renderMessage(one);
    assertEquals(one, out.toString());
    ftw.renderMessage(two);
    assertEquals(one + two, out.toString());
  }

  @Test (expected = IOException.class)
  public void testRenderMessageException() throws IOException { // tests appendable exception
    TriangleSolitaireModel model = new TriangleSolitaireModel();
    Appendable out = new FakeTestAppendable();
    MarbleSolitaireView ftw = new TriangleSolitaireTextView(model, out);
    ftw.renderMessage("");
    assertEquals("", out.toString());
  }
}