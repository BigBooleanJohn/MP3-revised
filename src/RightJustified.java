import java.util.ArrayList;

/*the class Truncated implements TextBlock's methods */
public class RightJustified implements TextBlock {
    TextLine[] RightBlock;
    int RightIndex;

    /* Truncated constructor */
    public RightJustified(int intInput, TextBlock TBInput) {
        this.RightIndex = intInput;
        this.RightBlock = new TextLine[TBInput.height()];
        for (int i = 0; i < TBInput.height(); i++) {
            try {
                this.RightBlock[i] = new TextLine(TBInput.row(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
    }// width// width

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
                if (this.row(i).length() < this.RightIndex) {// if the index to be right-justified at is greater than
                                                             // the width of the current
                    String justifiedRight = TBUtils.spaces(this.RightIndex - this.row(i).length()) + this.row(i);
                    this.RightBlock[i] = new TextLine(justifiedRight);
                }
            }
        } catch (Exception E) {
        }
        return this;
    }

    /*
     * getChildren method for RightJustified. This adds null, as RightJustified
     * cannot
     * have children
     */
    public ArrayList<TextBlock> getChildren() {
        ArrayList<TextBlock> returnArr = new ArrayList<>();
        returnArr.add(this);
        return returnArr;
    }

}
