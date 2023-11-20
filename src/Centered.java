import java.util.ArrayList;

/*the class Centered implements TextBlock's methods */
public class Centered implements TextBlock {
    TextLine[] CenteredBlock;
    int CenteredIndex;

    /* Truncated constructor */
    public Centered(int intInput, TextBlock TBInput) {
        this.CenteredIndex = intInput;
        this.CenteredBlock = new TextLine[TBInput.height()];
        for (int i = 0; i < TBInput.height(); i++) {
            try {
                this.CenteredBlock[i] = new TextLine(TBInput.row(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String row(int i) throws Exception {
        if (i > this.height()) {
            throw new Exception("Invalid row " + i);
        } else {
            return this.CenteredBlock[i].line;// return the String at this row
        }
    }// row

    public int height() {
        return this.CenteredBlock.length;
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
    public TextBlock CenteredJustifier() {
        try {
            for (int i = 0; i < this.height(); i++) {
                if (this.row(i).length() < this.CenteredIndex) {// if the index to be right-justified at is greater than
                                                                // the width of the current
                    String justifiedRight = TBUtils.spaces((this.CenteredIndex - this.row(i).length()) / 2)
                            + this.row(i) + TBUtils.spaces((this.CenteredIndex - this.row(i).length()) / 2);
                    this.CenteredBlock[i] = new TextLine(justifiedRight);
                }
            }
        } catch (Exception E) {
        }
        return this;
    }

    /*
     * getChildren method for centered. This adds null, as centered cannot have
     * children
     */
    public ArrayList<TextBlock> getChildren() {
        ArrayList<TextBlock> returnArr = new ArrayList<>();
        returnArr.add(this);
        return returnArr;
    }
}
