/*this is an implementation of a TextBlock for MP3, written by John Miller */
/*the class Truncated implements TextBlock's methods */
public class RightJustified implements TextBlock {
    TextBlock child;
    TextLine[] RightBlock;
    int RightIndex;

    /* Truncated constructor */
    public RightJustified(int intInput, TextBlock TBInput) {
        this.child = TBInput;
        this.RightIndex = intInput;
        this.RightBlock = new TextLine[TBInput.height()];
        for (int i = 0; i < TBInput.height(); i++) {
            try {
                this.RightBlock[i] = new TextLine(TBInput.row(i));
            } catch (Exception e) {
                e.printStackTrace();
            } // try/catch
        } // for
    }

    public String row(int i) throws Exception {
        if (i > this.height()) {
            throw new Exception("Invalid row " + i);
        } else {
            return this.RightBlock[i].line;// return the String at this row
        }
    }// row

    public int height() {
        return this.RightBlock.length;
    }// height

    public int width() {
        int maxLength = 0;
        for (int i = 0; i < this.height(); i++) {
            try {
                if (this.row(i).length() > maxLength) {
                    maxLength = this.row(i).length();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return maxLength;// return the width of the widest line as this is the block's width;
    }// width

    /*
     * RightJustifier is a method that refers to a RightJustified object, and based
     * on
     * the RightIndex field of the object, it will justify it to the right if the
     * string
     * is shorter than the RightIndex field of the object
     */
    public TextBlock RightJustifier() {
        try {
            for (int i = 0; i < this.height(); i++) {
                if (this.row(i).length() < this.RightIndex) {
                    String justifiedRight = TBUtils.spaces(this.RightIndex - this.row(i).length()) + this.row(i);
                    this.RightBlock[i] = new TextLine(justifiedRight);
                } else if (this.row(i).length() > this.RightIndex) {
                    String rightTruncated = this.row(i).substring(0, this.RightIndex);
                    this.RightBlock[i] = new TextLine(rightTruncated);
                } // if
            } // for
        } catch (Exception E) {
        }
        return this;
    }// RightJustifier

    /*
     * getChildren method for RightJustified.
     */
    public TextBlock[] getChildren() {
        TextBlock[] arr = new TextBlock[1];
        arr[0] = this.child;
        return arr;
    }// getChildren
}
