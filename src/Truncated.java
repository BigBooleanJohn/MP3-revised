
/*Truncated is a method that truncates a TextBlock onject. It was written By John Miller for mini-project 3:
*/
/*the class Truncated implements TextBlock's methods */
public class Truncated implements TextBlock {
    TextBlock child;
    TextLine[] TrunkBlock;
    int TrunkIndex;

    /* Truncated constructor */
    public Truncated(int _TrunkIndex, TextBlock TBInput) {
        this.child = TBInput;
        this.TrunkBlock = new TextLine[TBInput.height()];
        for (int i = 0; i < TBInput.height(); i++) {
            try {
                this.TrunkBlock[i] = new TextLine(TBInput.row(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.TrunkIndex = _TrunkIndex;
    }

    public String row(int i) throws Exception {
        if (i >= this.height()) {
            throw new Exception("Invalid row " + i);
        } else {
            return this.TrunkBlock[i].line;
        }
    }// row

    public int height() {
        return this.TrunkBlock.length;
    }// height

    /* the width will be the width of the widest bit of text */
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
     * truncator is a method that refers to a Truncated object, and based on the
     * truncateIndex field of the object, truncates the object to the appropriate
     * length if it is shorter, it will right justify.
     */
    public TextBlock truncator() {
        try {
            for (int i = 0; i < this.height(); i++) {
                if (this.row(i).length() > this.TrunkIndex) {
                    this.TrunkBlock[i] = new TextLine(this.row(i).substring(0, this.TrunkIndex));
                } else if (this.row(i).length() < this.TrunkIndex) {
                    this.TrunkBlock[i] = new TextLine(
                            this.row(i) + TBUtils.spaces(this.TrunkIndex - this.row(i).length()));
                }
            } // for
        } catch (Exception e) {
            e.printStackTrace();
        } // try/catch
        return this;// return the TruncatedBlock TextBlock implementation
    }

    /*
     * getChildren method for Truncated. This adds null, as centered cannot have
     * children
     */
    public TextBlock[] getChildren() {
        TextBlock[] arr = new TextBlock[1];
        arr[0] = this.child;
        return arr;
    }// getChildren
}// Truncated
