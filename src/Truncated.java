import java.util.ArrayList;

/*Truncated is a method that truncates a TextBlock onject. It was written By John Miller for mini-project 3:
*/

/*TODO: determine how to make Truncated be an implmementation of
 * TextBlock WITH MANY LEVELS OF TRUNKBLOCKS! for 11/18
 */
/*the class Truncated implements TextBlock's methods */
public class Truncated implements TextBlock {
    TextLine[] TrunkBlock;
    int TrunkIndex;

    /* Truncated constructor */
    public Truncated(int _TrunkIndex, TextBlock TBInput) {
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
     * length
     * if it is shorter, it will center the object. it will left-justify slightly.
     */
    public TextBlock truncator() {
        try {
            for (int i = 0; i < this.height(); i++) {
                if (this.row(i).length() > this.TrunkIndex) {
                    this.TrunkBlock[i] = new TextLine(this.row(i).substring(0, this.TrunkIndex));// truncate the line
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;// return the TruncatedBlock TextBlock implementation
    }

    /*
     * getChildren method for Truncated. This adds null, as centered cannot have
     * children
     */
    public ArrayList<TextBlock> getChildren() {
        ArrayList<TextBlock> returnArr = new ArrayList<>();
        returnArr.add(this);
        return returnArr;
    }
}
