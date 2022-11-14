import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;

/**
 * Tests all methods relating to the View class.
 * Mainly tests toString(), which shows the board
 * as it is played
 */
public class MarbleSolitaireTextViewTest {

  EnglishSolitaireModel model1;
  EnglishSolitaireModel model2;
  EnglishSolitaireModel model25;
  EnglishSolitaireModel model3;
  EnglishSolitaireModel model4;
  String three;
  String five;
  MarbleSolitaireView view1;
  MarbleSolitaireView view2;
  MarbleSolitaireView view25;
  MarbleSolitaireView view3;
  MarbleSolitaireView view4;
  EuropeanSolitaireModel eModel1;
  EuropeanSolitaireModel eModel2;
  EuropeanSolitaireModel eModel25;
  EuropeanSolitaireModel eModel3;
  EuropeanSolitaireModel eModel4;
  String eThree;
  String eFive;
  MarbleSolitaireView eView1;
  MarbleSolitaireView eView2;
  MarbleSolitaireView eView25;
  MarbleSolitaireView eView3;
  MarbleSolitaireView eView4;

  @Before
  public void setup() {
    model1 = new EnglishSolitaireModel();
    model2 = new EnglishSolitaireModel(3);
    model25 = new EnglishSolitaireModel(5);
    model3 = new EnglishSolitaireModel(3,3);
    model4 = new EnglishSolitaireModel(3,3,3);
    three = ("    O O O\n" +
             "    O O O\n" +
             "O O O O O O O\n" +
             "O O O _ O O O\n" +
             "O O O O O O O\n" +
             "    O O O\n" +
             "    O O O");

    five = ("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O");
    view1 = new MarbleSolitaireTextView(model1);
    view2 = new MarbleSolitaireTextView(model2);
    view3 = new MarbleSolitaireTextView(model3);
    view4 = new MarbleSolitaireTextView(model4);
    view25 = new MarbleSolitaireTextView(model25);
    eModel1 = new EuropeanSolitaireModel();
    eModel2 = new EuropeanSolitaireModel(3);
    eModel25 = new EuropeanSolitaireModel(5);
    eModel3 = new EuropeanSolitaireModel(3,3);
    eModel4 = new EuropeanSolitaireModel(3,3,3);
    eThree = ("    O O O\n" +
              "  O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "   O O O O O\n" +
              "    O O O");

    eFive = ("        O O O O O\n" +
             "      O O O O O O O\n" +
             "    O O O O O O O O O\n" +
             "  O O O O O O O O O O O\n" +
             "O O O O O O O O O O O O O\n" +
             "O O O O O O O O O O O O O\n" +
             "O O O O O O _ O O O O O O\n" +
             "O O O O O O O O O O O O O\n" +
             "O O O O O O O O O O O O O\n" +
             "  O O O O O O O O O O O\n" +
             "    O O O O O O O O O\n" +
             "      O O O O O O O\n" +
             "        O O O O O");
    eView1 = new MarbleSolitaireTextView(eModel1);
    eView2 = new MarbleSolitaireTextView(eModel2);
    eView3 = new MarbleSolitaireTextView(eModel3);
    eView4 = new MarbleSolitaireTextView(eModel4);
    eView25 = new MarbleSolitaireTextView(eModel25);

  }

  @Test
  public void testToString() {
    assertEquals(three, view1.toString());
    assertEquals(three, view2.toString());
    assertEquals(three, view3.toString());
    assertEquals(three, view4.toString());
    assertEquals(five, view25.toString());
  }

  @Test
  public void testToStringGame() {
    assertEquals(three, view1.toString());
    model1.move(1, 3, 3, 3);
    assertEquals("    O O O\n" +
                          "    O _ O\n" +
                          "O O O _ O O O\n" +
                          "O O O O O O O\n" +
                          "O O O O O O O\n" +
                          "    O O O\n" +
                          "    O O O", view1.toString());
    model1.move(2, 1, 2, 3);
    assertEquals("    O O O\n" +
                          "    O _ O\n" +
                          "O _ _ O O O O\n" +
                          "O O O O O O O\n" +
                          "O O O O O O O\n" +
                          "    O O O\n" +
                          "    O O O", view1.toString());
    model1.move(0, 2, 2, 2);
    assertEquals("    _ O O\n" +
            "    _ _ O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", view1.toString());
    model1.move(3, 2, 1, 2);
    assertEquals("    _ O O\n" +
                          "    O _ O\n" +
                          "O _ _ O O O O\n" +
                          "O O _ O O O O\n" +
                          "O O O O O O O\n" +
                          "    O O O\n" +
                          "    O O O", view1.toString());
    model1.move(0, 4, 0, 2);
    assertEquals("    O _ _\n" +
                 "    O _ O\n" +
                 "O _ _ O O O O\n" +
                 "O O _ O O O O\n" +
                 "O O O O O O O\n" +
                 "    O O O\n" +
                 "    O O O", view1.toString());
    model1.move(0, 2, 2, 2);
    assertEquals("    _ _ _\n" +
                 "    _ _ O\n" +
                 "O _ O O O O O\n" +
                 "O O _ O O O O\n" +
                 "O O O O O O O\n" +
                 "    O O O\n" +
                 "    O O O", view1.toString());
    model1.move(5, 2, 3, 2);
    assertEquals("    _ _ _\n" +
                 "    _ _ O\n" +
                 "O _ O O O O O\n" +
                 "O O O O O O O\n" +
                 "O O _ O O O O\n" +
                 "    _ O O\n" +
                 "    O O O", view1.toString());
    model1.move(4, 0, 4, 2);
    assertEquals("    _ _ _\n" +
                 "    _ _ O\n" +
                 "O _ O O O O O\n" +
                 "O O O O O O O\n" +
                 "_ _ O O O O O\n" +
                 "    _ O O\n" +
                 "    O O O", view1.toString());
    model1.move(4, 3, 4, 1);
    assertEquals("    _ _ _\n" +
                 "    _ _ O\n" +
                 "O _ O O O O O\n" +
                 "O O O O O O O\n" +
                 "_ O _ _ O O O\n" +
                 "    _ O O\n" +
                 "    O O O", view1.toString());
    model1.move(2, 0, 4, 0);
    assertEquals("    _ _ _\n" +
                 "    _ _ O\n" +
                 "_ _ O O O O O\n" +
                 "_ O O O O O O\n" +
                 "O O _ _ O O O\n" +
                 "    _ O O\n" +
                 "    O O O", view1.toString());
    model1.move(4, 0, 4, 2);
    assertEquals("    _ _ _\n" +
                 "    _ _ O\n" +
                 "_ _ O O O O O\n" +
                 "_ O O O O O O\n" +
                 "_ _ O _ O O O\n" +
                 "    _ O O\n" +
                 "    O O O", view1.toString());
    model1.move(4, 5, 4, 3);
    assertEquals("    _ _ _\n" +
                 "    _ _ O\n" +
                 "_ _ O O O O O\n" +
                 "_ O O O O O O\n" +
                 "_ _ O O _ _ O\n" +
                 "    _ O O\n" +
                 "    O O O", view1.toString());
    model1.move(6, 4, 4, 4);
    assertEquals("    _ _ _\n" +
                 "    _ _ O\n" +
                 "_ _ O O O O O\n" +
                 "_ O O O O O O\n" +
                 "_ _ O O O _ O\n" +
                 "    _ O _\n" +
                 "    O O _", view1.toString());
    model1.move(3, 4, 5, 4);
    assertEquals("    _ _ _\n" +
                 "    _ _ O\n" +
                 "_ _ O O O O O\n" +
                 "_ O O O _ O O\n" +
                 "_ _ O O _ _ O\n" +
                 "    _ O O\n" +
                 "    O O _", view1.toString());
    model1.move(6, 2, 6, 4);
    assertEquals("    _ _ _\n" +
                 "    _ _ O\n" +
                 "_ _ O O O O O\n" +
                 "_ O O O _ O O\n" +
                 "_ _ O O _ _ O\n" +
                 "    _ O O\n" +
                 "    _ _ O", view1.toString());
    model1.move(6, 4, 4, 4);
    assertEquals("    _ _ _\n" +
                 "    _ _ O\n" +
                 "_ _ O O O O O\n" +
                 "_ O O O _ O O\n" +
                 "_ _ O O O _ O\n" +
                 "    _ O _\n" +
                 "    _ _ _", view1.toString());
    model1.move(1, 4, 3, 4);
    assertEquals("    _ _ _\n" +
                 "    _ _ _\n" +
                 "_ _ O O _ O O\n" +
                 "_ O O O O O O\n" +
                 "_ _ O O O _ O\n" +
                 "    _ O _\n" +
                 "    _ _ _", view1.toString());
    model1.move(2, 6, 2, 4);
    assertEquals("    _ _ _\n" +
                 "    _ _ _\n" +
                 "_ _ O O O _ _\n" +
                 "_ O O O O O O\n" +
                 "_ _ O O O _ O\n" +
                 "    _ O _\n" +
                 "    _ _ _", view1.toString());
    model1.move(2, 3, 2, 5);
    assertEquals("    _ _ _\n" +
                 "    _ _ _\n" +
                 "_ _ O _ _ O _\n" +
                 "_ O O O O O O\n" +
                 "_ _ O O O _ O\n" +
                 "    _ O _\n" +
                 "    _ _ _", view1.toString());
    model1.move(4, 6, 2, 6);
    assertEquals("    _ _ _\n" +
                 "    _ _ _\n" +
                 "_ _ O _ _ O O\n" +
                 "_ O O O O O _\n" +
                 "_ _ O O O _ _\n" +
                 "    _ O _\n" +
                 "    _ _ _", view1.toString());
    model1.move(2, 6, 2, 4);
    assertEquals("    _ _ _\n" +
                 "    _ _ _\n" +
                 "_ _ O _ O _ _\n" +
                 "_ O O O O O _\n" +
                 "_ _ O O O _ _\n" +
                 "    _ O _\n" +
                 "    _ _ _", view1.toString());
    model1.move(4, 3, 4, 1);
    assertEquals("    _ _ _\n" +
                 "    _ _ _\n" +
                 "_ _ O _ O _ _\n" +
                 "_ O O O O O _\n" +
                 "_ O _ _ O _ _\n" +
                 "    _ O _\n" +
                 "    _ _ _", view1.toString());
    model1.move(4, 1, 2, 1);
    assertEquals("    _ _ _\n" +
                 "    _ _ _\n" +
                 "_ O O _ O _ _\n" +
                 "_ _ O O O O _\n" +
                 "_ _ _ _ O _ _\n" +
                 "    _ O _\n" +
                 "    _ _ _", view1.toString());
    model1.move(2, 1, 2, 3);
    assertEquals("    _ _ _\n" +
                 "    _ _ _\n" +
                 "_ _ _ O O _ _\n" +
                 "_ _ O O O O _\n" +
                 "_ _ _ _ O _ _\n" +
                 "    _ O _\n" +
                 "    _ _ _", view1.toString());
    model1.move(2, 3, 2, 5);
    assertEquals("    _ _ _\n" +
                 "    _ _ _\n" +
                 "_ _ _ _ _ O _\n" +
                 "_ _ O O O O _\n" +
                 "_ _ _ _ O _ _\n" +
                 "    _ O _\n" +
                 "    _ _ _", view1.toString());
    model1.move(2, 5, 4, 5);
    assertEquals("    _ _ _\n" +
                 "    _ _ _\n" +
                 "_ _ _ _ _ _ _\n" +
                 "_ _ O O O _ _\n" +
                 "_ _ _ _ O O _\n" +
                 "    _ O _\n" +
                 "    _ _ _", view1.toString());
    model1.move(4, 5, 4, 3);
    assertEquals("    _ _ _\n" +
                 "    _ _ _\n" +
                 "_ _ _ _ _ _ _\n" +
                 "_ _ O O O _ _\n" +
                 "_ _ _ O _ _ _\n" +
                 "    _ O _\n" +
                 "    _ _ _", view1.toString());
    model1.move(3, 3, 3, 5);
    assertEquals("    _ _ _\n" +
                 "    _ _ _\n" +
                 "_ _ _ _ _ _ _\n" +
                 "_ _ O _ _ O _\n" +
                 "_ _ _ O _ _ _\n" +
                 "    _ O _\n" +
                 "    _ _ _", view1.toString());
    model1.move(5, 3, 3, 3);
    assertEquals("    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ O O _ O _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _", view1.toString());
    model1.move(3, 2, 3, 4);
    assertEquals("    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ O O _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _", view1.toString());
    model1.move(3, 5, 3, 3);
    assertEquals("    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _", view1.toString());
  }

  @Test
  public void testRenderBoard() throws IOException { // tests that it renders the board correctly
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    Appendable out = new StringBuilder();
    MarbleSolitaireView ftw = new MarbleSolitaireTextView(model, out);
    String start = "    O O O\n" +
                   "    O O O\n" +
                   "O O O O O O O\n" +
                   "O O O _ O O O\n" +
                   "O O O O O O O\n" +
                   "    O O O\n" +
                   "    O O O";
    ftw.renderBoard();
    assertEquals(start, out.toString());
  }

  @Test (expected = IOException.class)
  public void testRenderBoardException() throws IOException { // tests appendable exception
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    Appendable out = new FakeTestAppendable();
    MarbleSolitaireView ftw = new MarbleSolitaireTextView(model, out);
    ftw.renderBoard();
    assertEquals("", out.toString());
  }

  @Test
  public void testRenderMessage() throws IOException { // tests that it renders message correctly
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    Appendable out = new StringBuilder();
    MarbleSolitaireView ftw = new MarbleSolitaireTextView(model, out);
    String one = "one";
    String two = "two";
    ftw.renderMessage(one);
    assertEquals(one, out.toString());
    ftw.renderMessage(two);
    assertEquals(one + two, out.toString());
  }

  @Test (expected = IOException.class)
  public void testRenderMessageException() throws IOException { // tests appendable exception
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    Appendable out = new FakeTestAppendable();
    MarbleSolitaireView ftw = new MarbleSolitaireTextView(model, out);
    ftw.renderMessage("");
    assertEquals("", out.toString());
  }

  @Test
  public void testEuroToString() {
    assertEquals(eThree, eView1.toString());
    assertEquals(eThree, eView2.toString());
    assertEquals(eThree, eView3.toString());
    assertEquals(eThree, eView4.toString());
    assertEquals(eFive, eView25.toString());
  }
}