import java.util.ArrayList;

public class ReversedAndFlipped implements TextBlock {
    TextLine[] RFBox;

    /* Truncated constructor */
    public ReversedAndFlipped(TextBlock TBInput) {
        this.RFBox = new TextLine[TBInput.height()];
        for (int i = 0; i < this.height(); i++) {
            try {
                this.RFBox[i] = new TextLine(TBInput.row(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String row(int i) throws Exception {
        if (i > this.height()) {
            throw new Exception("Invalid row " + i);
        } else {
            return this.RFBox[i].line;
        }
    }// row

    public int height() {
        return this.RFBox.length;
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
     * BothFlipper is a method that takes a ReversedAndFlipped
     * object and flips the rows in the text field so that theyre vertically
     * flipped,
     * and flips the rows as well
     */
    public TextBlock BothFlipper() {
        int min = 0;
        int max = this.height() - 1;
        while (min <= max) {
            try {
                StringBuilder minimum = new StringBuilder(this.row(min));// get the string of the row
                minimum.reverse();// flip the string
                StringBuilder maximum = new StringBuilder(this.row(max));
                maximum.reverse();
                this.RFBox[min] = new TextLine(maximum.toString());
                this.RFBox[max] = new TextLine(minimum.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            min++;
            max--;
        }
        return this;
    }

    /*
     * getChildren method for centered. This adds null, as ReversedAndFlipped cannot
     * have
     * children
     */
    public ArrayList<TextBlock> getChildren() {
        ArrayList<TextBlock> returnArr = new ArrayList<>();
        returnArr.add(this);
        return returnArr;
    }
}
