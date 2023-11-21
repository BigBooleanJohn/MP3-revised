
import java.io.PrintWriter;

/**
 * This class provides Utilities for TextBlocks.
 * 
 * @author Samuel A. Rebelsky, John Miller
 * @version 1.3 of September 2014
 */
public class TBUtils {
  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  /**
   * A really big sequence of dashes. This sequence may grow as the program
   * operates.
   */
  static String lotsOfDashes = "--";

  /**
   * A really big sequence of spaces. This sequence may grow as the program
   * operates.
   */
  static String lotsOfSpaces = "  ";

  // +----------------+----------------------------------------------------
  // | Static Methods |
  // +----------------+

  /**
   * Build a sequence of dashes of a specified length.
   */
  static String dashes(int len) {
    // Note: This strategy probably represents an overkill in
    // attempts at efficiency.
    // Make sure the collection of dashes is big enough
    while (lotsOfDashes.length() < len) {
      lotsOfDashes = lotsOfDashes.concat(lotsOfDashes);
    } // while
    // Extract an appropriate length substring
    return lotsOfDashes.substring(0, len);
  } // dashes(int)

  /**
   * Print a TextBlock to the specified destination.
   */
  public static void print(PrintWriter pen, TextBlock block) {
    for (int i = 0; i < block.height(); i++) {
      // Even though we only call block.row with a valid i,
      // we need to put the call in a try/catch block.
      try {
        pen.println(block.row(i));
      } catch (Exception e) {
        pen.println();
      } // catch (Exception)
    } // for
  } // print(PrintWriter, TextBlock)

  /**
   * Build a sequence of spaces of a specified length.
   */
  static String spaces(int len) {
    // As with dashes, this is probably overkill.
    // Make sure the collection of dashes is big enough
    while (lotsOfSpaces.length() < len) {
      lotsOfSpaces = lotsOfSpaces.concat(lotsOfSpaces);
    } // while
    // Extract an appropriate length substring
    return lotsOfSpaces.substring(0, len);
  } // spaces(int)

  /*
   * checking equivalency by contents
   * 
   * @pre: t1 and t2 are valid TextBlocks
   * 
   * @Post: returns a boolean
   */
  public boolean equal(TextBlock t1, TextBlock t2) {
    if (t1.height() != t2.height()) {
      return false;
    } else {
      int height = t1.height();
      for (int i = 0; i < height; i++) {
        try {
          if (t1.row(i).compareTo(t2.row(i)) != 0) {
            return false;
          }
        } catch (Exception e) {
          e.printStackTrace();
        } // try/catch
      } // for
      return true;// if the previous condition was not met, the strings are equal, return true
    }
  }// equal

  /*
   * checking equivalency by construction method
   * 
   * @pre: t1 and t2 are valid TextBlocks
   * 
   * @Post: returns a boolean
   */
  public boolean eqv(TextBlock t1, TextBlock t2) {
    if (t1.getClass().equals(t2.getClass())) {
      if (t1.getClass().getName().equals("TextLine")) {
        return true;
      } else if (t1.getClass().getName().equals("Centered")
          || t1.getClass().getName().equals("HorizontallyFlipped")
          || t1.getClass().getName().equals("ReversedAndFlipped")
          || t1.getClass().getName().equals("RightJustified")
          || t1.getClass().getName().equals("Truncated")
          || t1.getClass().getName().equals("VerticallyFlipped")
          || t1.getClass().getName().equals("BoxedBlock")) {
        return eqv(t1.getChildren()[0], t2.getChildren()[0]);
      } else if (t1.getClass().getName().equals("HComposition") || t1.getClass().getName().equals("VComposition")) {
        return (eqv(t1.getChildren()[0], t2.getChildren()[0])
            && eqv(t1.getChildren()[1], t2.getChildren()[1]));
      }
    }
    return false;
  }// eqv

  /*
   * checking equivalency by memory
   * 
   * @pre: t1 and t2 are valid TextBlocks
   * 
   * @Post: returns a boolean
   */
  public boolean eq(TextBlock t1, TextBlock t2) {
    return t1 == t2;
  }// eq
}
// class TBUtils
