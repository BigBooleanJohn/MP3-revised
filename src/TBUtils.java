
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
      return false;// if the two blocks do not have the same amount of rows, they will be unequal
    } else {
      int height = t1.height();// both heights will be the same, so this will be the height variable
      for (int i = 0; i < height; i++) {
        try {
          if (t1.row(i).compareTo(t2.row(i)) != 0) {
            return false; // if the strings in both rows do not match, return false
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      return true;// if the previous condition was not met, the strings are equal, return true
    }
  }

  /*
   * I wrote this function because in the textblocks, Strings have many
   * space characters in them that make them longer than expected. this method
   * returns the string that is made up of solely made up of alphabetic chars
   */
  public static String newString(String s) {
    String[] parsedArr = s.split(" ");
    return parsedArr[0];
  }

  /*
   * checking equivalency by construction method
   * 
   * @pre: t1 and t2 are valid TextBlocks
   * 
   * @Post: returns a boolean
   */
  public boolean eqv(TextBlock t1, TextBlock t2) {
    if (t1.getClass().getName().equals(t2.getClass().getName())) {
      System.out.printf("The classes match!\n");
      if (t1.getClass().getName().equals("TextLine") || t1.getClass().getName().equals("Centered")
          || t1.getClass().getName().equals("VerticallyFlipped") || t1.getClass().getName().equals("Truncated")
          || t1.getClass().getName().equals("HorizontallyFlipped")
          || t1.getClass().getName().equals("ReversedAndFlipped")) {
        System.out.printf("The classes are the last blocks!\n");
        return true;
      } else if (t1.getClass().getName().equals("BoxedBlock")) {
        BoxedBlock b1 = (BoxedBlock) t1;
        BoxedBlock b2 = (BoxedBlock) t2;
        eqv(b1.contents, b2.contents);
      } else if (t1.getClass().getName().equals("VComposition")) {
        VComposition V1 = (VComposition) t1;
        VComposition V2 = (VComposition) t2;
        eqv(V1.top, V2.top);
        eqv(V1.bottom, V2.bottom);
      } else if (t1.getClass().getName().equals("HComposition")) {
        HComposition H1 = (HComposition) t1;
        HComposition H2 = (HComposition) t2;
        eqv(H1.left, H2.left);
        eqv(H1.right, H2.right);
      }
    }
    return false;
  }

  /*
   * checking equivalency by memory
   * 
   * @pre: t1 and t2 are valid TextBlocks
   * 
   * @Post: returns a boolean
   */
  public boolean eq(TextBlock t1, TextBlock t2) {
    return t1 == t2;
  }
}
// class TBUtils
