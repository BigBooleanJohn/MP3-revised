import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*this is a program that tests cases and edge cases for them different classes in the project. Writted by John Miller*/
public class TextBlockTests {

    /* test1: this tests the truncated method on one line */
    @Test
    public void test1_TruncateTest() {
        Truncated tBlock = new Truncated(5, new TextLine("TestLine"));
        tBlock.truncator();

        TextBlock myPrediction = new TextLine("TestL");
        try {
            assertEquals(tBlock.row(0), myPrediction.row(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * test2: this test test the centered java file and a centered
     * object with only one line
     */
    @Test
    public void test2_CenteredTest() {
        Centered Cblock = new Centered(10, new TextLine("Test"));
        Cblock.CenteredJustifier();
        TextBlock myPrediction = new TextLine("   Test   ");
        try {
            assertEquals(Cblock.row(0), myPrediction.row(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * this tests rightAligned method on TextBlock's of one line
     */
    @Test
    public void test3_RightAlignedTest() {
        RightJustified tBlock = new RightJustified(10, new TextLine("TestLine"));
        tBlock.RightJustifier();
        TextBlock myPrediction = new TextLine("  TestLine");
        try {
            assertEquals(tBlock.row(0), myPrediction.row(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * this program tests the horizontal flip method TextBlock's of one line
     * 
     */
    @Test
    public void test4_HorizFlipTest() {
        HorizontallyFlipped HBlock = new HorizontallyFlipped(new TextLine("TestLine"));
        HBlock.HorizFlipper();
        TextBlock myPrediction = new TextLine("eniLtseT");
        try {
            assertEquals(HBlock.row(0), myPrediction.row(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* this tests the verticallyFlipped method */

    @Test
    public void test5_VertFlipTest() {
        VerticallyFlipped VBlock = new VerticallyFlipped(new VComposition(new TextLine("Foo"), new TextLine("Bar")));
        VBlock.VerticalFlipper();
        TextBlock myPrediction = new VerticallyFlipped(new VComposition(new TextLine("Bar"), new TextLine("Foo")));
        try {
            assertEquals(VBlock.row(0), myPrediction.row(0));
            assertEquals(VBlock.row(1), myPrediction.row(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * This tests my personal textBlock implementation; which flips bot vertically
     * and horizontally
     */
    @Test
    public void test6_VertHorizFlipTest() {
        ReversedAndFlipped RFBlock = new ReversedAndFlipped(new VComposition(new TextLine("Foo"), new TextLine("Bar")));
        RFBlock.BothFlipper();
        TextBlock myPrediction = new VerticallyFlipped(new VComposition(new TextLine("raB"), new TextLine("ooF")));
        try {
            assertEquals(RFBlock.row(0), myPrediction.row(0));
            assertEquals(RFBlock.row(1), myPrediction.row(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
