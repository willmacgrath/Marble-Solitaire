import org.junit.Test;
import java.io.StringReader;
import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MockEnglishModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import static org.junit.Assert.assertEquals;

/**
 * Tests related to MarbleSolitaireController.
 */
public class MarbleSolitaireControllerImplTest {

  @Test (expected = IllegalArgumentException.class) // tests that it throws when model is null
  public void testControllerConstructorModelException() {
    MarbleSolitaireModel model = null;
    MarbleSolitaireView view = new MarbleSolitaireTextView(model);
    Readable in = new StringReader("");
    assertEquals(new MarbleSolitaireControllerImpl(model, view, in),
            new MarbleSolitaireControllerImpl(model, view, in));
  }

  @Test (expected = IllegalArgumentException.class) // tests that it throws when view is null
  public void testControllerConstructorViewException() {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = null;
    Readable in = new StringReader("");
    assertEquals(new MarbleSolitaireControllerImpl(model, view, in),
            new MarbleSolitaireControllerImpl(model, view, in));
  }

  @Test (expected = IllegalArgumentException.class) // tests that it throws when Readable is null
  public void testControllerConstructorInException() {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model);
    Readable in = null;
    assertEquals(new MarbleSolitaireControllerImpl(model, view, in),
            new MarbleSolitaireControllerImpl(model, view, in));
  }

  @Test
  public void testPlayGameQuit1() { // tests quit in first position
    Readable testIn = new StringReader("q 4 4 4");
    StringBuilder output = new StringBuilder();
    MarbleSolitaireModel gameModel = new EnglishSolitaireModel();
    MarbleSolitaireView gameView = new MarbleSolitaireTextView(gameModel, output);
    MarbleSolitaireController gameController =
            new MarbleSolitaireControllerImpl(gameModel, gameView, testIn);
    String quit = "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32";
    gameController.playGame();
    assertEquals(quit, output.toString());
  }

  @Test
  public void testPlayGameQuit2() { // tests quit in second position
    Readable testIn = new StringReader("4 q 4 4");
    StringBuilder output = new StringBuilder();
    MarbleSolitaireModel gameModel = new EnglishSolitaireModel();
    MarbleSolitaireView gameView = new MarbleSolitaireTextView(gameModel, output);
    MarbleSolitaireController gameController =
            new MarbleSolitaireControllerImpl(gameModel, gameView, testIn);
    String quit = "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32";
    gameController.playGame();
    assertEquals(quit, output.toString());
  }

  @Test
  public void testPlayGameQuit3() { // tests quit in third position
    Readable testIn = new StringReader("4 4 q 4");
    StringBuilder output = new StringBuilder();
    MarbleSolitaireModel gameModel = new EnglishSolitaireModel();
    MarbleSolitaireView gameView = new MarbleSolitaireTextView(gameModel, output);
    MarbleSolitaireController gameController =
            new MarbleSolitaireControllerImpl(gameModel, gameView, testIn);
    String quit = "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32";
    gameController.playGame();
    assertEquals(quit, output.toString());
  }

  @Test
  public void testPlayGameQuit4() { // tests quit in fourth position
    Readable testIn = new StringReader("4 4 4 q");
    StringBuilder output = new StringBuilder();
    MarbleSolitaireModel gameModel = new EnglishSolitaireModel();
    MarbleSolitaireView gameView = new MarbleSolitaireTextView(gameModel, output);
    MarbleSolitaireController gameController =
            new MarbleSolitaireControllerImpl(gameModel, gameView, testIn);
    String quit = "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32";
    gameController.playGame();
    assertEquals(quit, output.toString());
  }

  @Test
  public void testMoveInputs() { // uses mock to test move inputs
    Readable testIn = new StringReader("4 2 4 4 q");
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel moveInputs = new MockEnglishModel(log);
    MarbleSolitaireView gameView = new MarbleSolitaireTextView(moveInputs);
    MarbleSolitaireController gameController =
            new MarbleSolitaireControllerImpl(moveInputs, gameView, testIn);
    gameController.playGame();
    assertEquals("fromRow = 3, FromCol = 1, toRow = 3, toCol = 3", log.toString());
  }

  @Test
  public void testMoveInputWithInvalids() { // uses mock to test move inputs with invalids
    Readable testIn = new StringReader("4 -1 2 a 4 x 4 q");
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel moveInputs = new MockEnglishModel(log);
    MarbleSolitaireView gameView = new MarbleSolitaireTextView(moveInputs);
    MarbleSolitaireController gameController =
            new MarbleSolitaireControllerImpl(moveInputs, gameView, testIn);
    gameController.playGame();
    assertEquals("fromRow = 3, FromCol = 1, toRow = 3, toCol = 3", log.toString());
  }

  @Test
  public void testPlayGameMoveQuit() {  // move then quit
    Readable testIn = new StringReader("4 2 4 4 q");
    StringBuilder output = new StringBuilder();
    MarbleSolitaireModel gameModel = new EnglishSolitaireModel();
    MarbleSolitaireView gameView = new MarbleSolitaireTextView(gameModel, output);
    MarbleSolitaireController gameController =
            new MarbleSolitaireControllerImpl(gameModel, gameView, testIn);
    String moveQuit = "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31";
    gameController.playGame();
    assertEquals(moveQuit, output.toString());
  }

  @Test
  public void testPlayGameInvalidQuit() {  // invalid move then quit
    Readable testIn = new StringReader("3 2 4 4 q");
    StringBuilder output = new StringBuilder();
    MarbleSolitaireModel gameModel = new EnglishSolitaireModel();
    MarbleSolitaireView gameView = new MarbleSolitaireTextView(gameModel, output);
    MarbleSolitaireController gameController =
            new MarbleSolitaireControllerImpl(gameModel, gameView, testIn);
    gameController.playGame();
    String invalidOver = "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid Move. Play again.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32";
    assertEquals(invalidOver, output.toString());
  }

  @Test
  public void testPlayGameInvalidMoveQuit() {  // invalid move then valid move then quit
    Readable testIn = new StringReader("3 2 4 4 6 4 4 4 q");
    StringBuilder output = new StringBuilder();
    MarbleSolitaireModel gameModel = new EnglishSolitaireModel();
    MarbleSolitaireView gameView = new MarbleSolitaireTextView(gameModel, output);
    MarbleSolitaireController gameController =
            new MarbleSolitaireControllerImpl(gameModel, gameView, testIn);
    gameController.playGame();
    String invalidMoveOver = "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid Move. Play again.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31";
    assertEquals(invalidMoveOver, output.toString());
  }

  @Test
  public void testPlayGameMoveInvalidQuit() {  // invalid move then valid move then quit
    Readable testIn = new StringReader("6 4 4 4 3 2 4 4 q");
    StringBuilder output = new StringBuilder();
    MarbleSolitaireModel gameModel = new EnglishSolitaireModel();
    MarbleSolitaireView gameView = new MarbleSolitaireTextView(gameModel, output);
    MarbleSolitaireController gameController =
            new MarbleSolitaireControllerImpl(gameModel, gameView, testIn);
    gameController.playGame();
    String moveInvalidQuit = "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Invalid Move. Play again.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31";
    assertEquals(moveInvalidQuit, output.toString());
  }

  @Test
  public void testCompleteGameLoss() { // Losing a game
    Readable testIn = new StringReader("6\n4 4 4 3 4 5 4 1 4 3 4 4 2 4 4 4 5 4 3 4 7 4 5");
    StringBuilder output = new StringBuilder();
    MarbleSolitaireModel gameModel = new EnglishSolitaireModel();
    MarbleSolitaireView gameView = new MarbleSolitaireTextView(gameModel, output);
    MarbleSolitaireController gameController =
            new MarbleSolitaireControllerImpl(gameModel, gameView, testIn);
    String loseGame = "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O _ O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ _ O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "Game over!\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ O _ _\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 26";
    gameController.playGame();
    assertEquals(loseGame, output.toString());
  }

  @Test
  public void testCompleteGameWin() { // Winning a game
    Readable testIn = new StringReader("2 4 4 4 3 2 3 4 1 3 3 3 4 3 2 3 1 5 1 3 1 3 3 3 6 3" +
            " 4 3 5 1 5 3 5 4 5 2 3 1 5 1 5 1 5 3 5 6 5 4 7 5 5 5 4 5 6 5 7 3 7 5 7 5 5 5 2 5 4 " +
            "5 3 7 3 5 3 4 3 6 5 7 3 7 3 7 3 5 5 4 5 2 5 2 3 2 3 2 3 4 3 4 3 6 3 6 5 6 5 6 5 4 " +
            "4 4 4 6 6 4 4 4 4 3 4 5 4 6 4 4");
    StringBuilder output = new StringBuilder();
    MarbleSolitaireModel gameModel = new EnglishSolitaireModel();
    MarbleSolitaireView gameView = new MarbleSolitaireTextView(gameModel, output);
    MarbleSolitaireController gameController =
            new MarbleSolitaireControllerImpl(gameModel, gameView, testIn);
    String win = "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    _ O O\n" +
            "    _ _ O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "    _ O O\n" +
            "    O _ O\n" +
            "O _ _ O O O O\n" +
            "O O _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "    O _ _\n" +
            "    O _ O\n" +
            "O _ _ O O O O\n" +
            "O O _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "O _ O O O O O\n" +
            "O O _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 26\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "O O _ O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 25\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "_ _ O O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 24\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "_ O _ _ O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 23\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ O O O O O\n" +
            "_ O O O O O O\n" +
            "O O _ _ O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 22\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ O O O O O\n" +
            "_ O O O O O O\n" +
            "_ _ O _ O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 21\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ O O O O O\n" +
            "_ O O O O O O\n" +
            "_ _ O O _ _ O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 20\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ O O O O O\n" +
            "_ O O O O O O\n" +
            "_ _ O O O _ O\n" +
            "    _ O _\n" +
            "    O O _\n" +
            "Score: 19\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ O O O O O\n" +
            "_ O O O _ O O\n" +
            "_ _ O O _ _ O\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "Score: 18\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ O O O O O\n" +
            "_ O O O _ O O\n" +
            "_ _ O O _ _ O\n" +
            "    _ O O\n" +
            "    _ _ O\n" +
            "Score: 17\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ O O O O O\n" +
            "_ O O O _ O O\n" +
            "_ _ O O O _ O\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 16\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ O O _ O O\n" +
            "_ O O O O O O\n" +
            "_ _ O O O _ O\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 15\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ O O O _ _\n" +
            "_ O O O O O O\n" +
            "_ _ O O O _ O\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 14\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ O _ _ O _\n" +
            "_ O O O O O O\n" +
            "_ _ O O O _ O\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 13\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ O _ _ O O\n" +
            "_ O O O O O _\n" +
            "_ _ O O O _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 12\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ O _ O _ _\n" +
            "_ O O O O O _\n" +
            "_ _ O O O _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 11\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ O _ O _ _\n" +
            "_ O O O O O _\n" +
            "_ O _ _ O _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 10\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ O O _ O _ _\n" +
            "_ _ O O O O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 9\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ O O _ _\n" +
            "_ _ O O O O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 8\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ O _\n" +
            "_ _ O O O O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 7\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ O O O _ _\n" +
            "_ _ _ _ O O _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 6\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ O O O _ _\n" +
            "_ _ _ O _ _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 5\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ O _ _ O _\n" +
            "_ _ _ O _ _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 4\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ O O _ O _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 3\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ O O _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 2\n" +
            "Game over!\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 1";
    gameController.playGame();
    assertEquals(win, output.toString());
  }
}