import java.io.IOException;

/**
 * Used to test the IOExceptions in the render methods in the view.
 */
public class FakeTestAppendable implements Appendable {

  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException("YUHYUHYUHYUHYUHYUHYUHYUH");
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException("YUH YUH YUH YUH");
  }

  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException("YUH");
  }
}
