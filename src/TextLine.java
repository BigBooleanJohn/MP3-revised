
/**
 * One line of text.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of February 2019
 */
public class TextLine implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The contents of the line.
   */
  String line;
  TextBlock child;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new line with the specified contents. make the child null as a
   * TextLine can never have a child
   */
  public TextLine(String line) {
    this.child = null;
    this.line = line;
  } // TextLine(String)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   * 
   * @pre i == 0
   * @exception Exception if i != 0
   */
  public String row(int i) throws Exception {
    if (i != 0) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid
    return this.line;
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return 1;
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return this.line.length();
  } // width()

  /*
   * getChildren method for TextLine. This adds null, as TextLine cannot have
   * children
   */
  public TextBlock[] getChildren() {
    return null;
  }// getChildren
}
// class TextLine
