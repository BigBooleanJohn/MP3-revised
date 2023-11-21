
/*This vertically flips a TextBlock; that is, it flips row by row. Written by john Miller*/
public class VerticallyFlipped implements TextBlock {
    TextBlock child;
    TextLine[] FlipBox;

    /* Truncated constructor */
    public VerticallyFlipped(TextBlock TBInput) {
        this.child = TBInput;
        this.FlipBox = new TextLine[TBInput.height()];
        for (int i = 0; i < TBInput.height(); i++) {
            try {
                this.FlipBox[i] = new TextLine(TBInput.row(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String row(int i) throws Exception {
        if (i > this.height()) {
            throw new Exception("Invalid row " + i);
        } else {
            return this.FlipBox[i].line;
        }
    }// row

    public int height() {
        return this.FlipBox.length;
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
     * VerticalFlipper is a method that takes a VerticallyFlipped
     * object and flips the rows in the text field so that theyre vertically flipped
     */
    public TextBlock VerticalFlipper() {
        int min = 0;
        int max = this.height() - 1;
        while (min <= max) {
            TextLine temp = this.FlipBox[min];
            this.FlipBox[min] = this.FlipBox[max];
            this.FlipBox[max] = temp;
            min++;
            max--;
        }
        return this;
    }

    /*
     * getChildren method for centered. This adds null, as centered cannot have
     * children
     */
    public TextBlock[] getChildren() {
        TextBlock[] arr = new TextBlock[1];
        arr[0] = this.child;
        return arr;
    }// getChildren
}// class VerticallyFlipped
