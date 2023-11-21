import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*this is a program that tests cases and edge cases for them different classes in the project. Writted by John Miller*/
public class TextBlockTests {

    /*
     * test1: this tests the truncated method on one line that is empty. this will
     * expand for spaces to the right
     */
    @Test
    public void test1_TruncateEmptyTest() {
        Truncated tBlock = new Truncated(5, new TextLine(""));
        tBlock.truncator();

        TextBlock myPrediction = new TextLine("     ");
        try {
            assertEquals(tBlock.row(0), myPrediction.row(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* test1: this tests the truncated method on one line */
    @Test
    public void test2_TruncateNormalTest() {
        Truncated tBlock = new Truncated(5, new TextLine("bababababnono"));
        tBlock.truncator();

        TextBlock myPrediction = new TextLine("babab");
        try {
            assertEquals(tBlock.row(0), myPrediction.row(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * test: this tests the truncated method on a line shorter than the given length
     * parameter. It will expand to have spaces on the right
     */
    @Test
    public void test3_TruncateLongTest() {
        Truncated tBlock = new Truncated(10, new TextLine("babab"));
        tBlock.truncator();

        TextBlock myPrediction = new TextLine("babab     ");
        try {
            assertEquals(tBlock.row(0), myPrediction.row(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * test: this test test the centered java file and a centered
     * object with only one line
     */
    @Test
    public void test4_CenteredTest() {
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
     * test: this test test the centered java file and a centered
     * object with only one line and param of 0. it will truncate it to be ""
     */
    @Test
    public void test5_Centered0Test() {
        Centered Cblock = new Centered(0, new TextLine("Test"));
        Cblock.CenteredJustifier();
        TextBlock myPrediction = new TextLine("");
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
    public void test6_RightAlignedTest() {
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
     * this tests rightAligned method on TextBlock's of one line
     */
    @Test
    public void test7_RightAlignedEmptyTest() {
        RightJustified tBlock = new RightJustified(10, new TextLine(""));
        tBlock.RightJustifier();
        TextBlock myPrediction = new TextLine("          ");
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
    public void test8_HorizFlipTest() {
        HorizontallyFlipped HBlock = new HorizontallyFlipped(new TextLine("TestLine"));
        HBlock.HorizFlipper();
        TextBlock myPrediction = new TextLine("eniLtseT");
        try {
            assertEquals(HBlock.row(0), myPrediction.row(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * this program tests the horizontal flip method TextBlock's of one empty
     * 
     */
    @Test
    public void test9_HorizFlipEmptyTest() {
        HorizontallyFlipped HBlock = new HorizontallyFlipped(new TextLine(""));
        HBlock.HorizFlipper();
        TextBlock myPrediction = new TextLine("");
        try {
            assertEquals(HBlock.row(0), myPrediction.row(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* this tests the verticallyFlipped method */

    @Test
    public void test10_VertFlipEmptyTest() {
        VerticallyFlipped VBlock = new VerticallyFlipped(new VComposition(new TextLine(""), new TextLine("")));
        VBlock.VerticalFlipper();
        TextBlock myPrediction = new VerticallyFlipped(new VComposition(new TextLine(""), new TextLine("")));
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
    public void test11_VertHorizFlipTest() {
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

    /*
     * this tests rightAligned method on a TextBlock made of other TextBlocks
     */
    @Test
    public void test12_RightAlignedOnTextBlock() {
        HorizontallyFlipped HF = new HorizontallyFlipped(new TextLine("John"));
        HF.HorizFlipper();
        Centered tBlock = new Centered(6, HF);
        tBlock.CenteredJustifier();
        TextBlock myPrediction = new TextLine(" nhoJ ");
        try {
            assertEquals(tBlock.row(0), myPrediction.row(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * this tests rightAligned method on a TextBlock made of other TextBlocks
     */
    @Test
    public void test13_RightAlignedOnTextBlock() {
        HorizontallyFlipped HF = new HorizontallyFlipped(new TextLine("John"));
        HF.HorizFlipper();
        Centered tBlock = new Centered(6, HF);
        tBlock.CenteredJustifier();
        TextBlock myPrediction = new TextLine(" nhoJ ");
        try {
            assertEquals(tBlock.row(0), myPrediction.row(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * this is testing my TBU.eqv method, which checks if two things are constructed
     * in the same way. This should return true as they are both TextLine's
     */
    @Test
    public void test14_eqvTest() {
        TBUtils TBU = new TBUtils();
        try {
            assertEquals(TBU.eqv(new TextLine("nana"), new TextLine("bolone")), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * this is testing my TBU.eqv method, which checks if two things contain the
     * same contents. This should return true as they are both TextLine's
     */
    @Test
    public void test145_equalTest() {
        TBUtils TBU = new TBUtils();
        try {
            assertEquals(TBU.equal(new TextLine("nanana"), new TextLine("nanana")), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * this is testing my TBU.eqv method, which checks if two things have the same
     * memory location
     */
    @Test
    public void test16_eqTest() {
        TBUtils TBU = new TBUtils();
        TextLine t = new TextLine("brooo");
        TextLine p = t;
        try {
            assertEquals(TBU.eq(t, p), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
