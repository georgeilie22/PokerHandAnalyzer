import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestHandAnalyzer {
    public HandAnalyzer handAnalyzer;

    @BeforeSuite
    public void beforeSuit() {
        handAnalyzer = new HandAnalyzer();
        System.out.println("Score 0 = flush\n" +
                "Score 1 = straight\nScore 1 = straight\n" +
                "Score 2 = four of a kind\n" +
                "Score 3 = full house\n" +
                "Score 4 = three of a kind\n" +
                "Score 5 = two pairs\n" +
                "Score 6 = one pair\n" +
                "Score 100 = no combo\n" +
                "_______________________");
    }

    @Test
    public void checkFlush() {
        ArrayList<Card> flushHand = new ArrayList<>();
        flushHand.add(new Card(2, "Hearts"));
        flushHand.add(new Card(5, "Hearts"));
        flushHand.add(new Card(10, "Hearts"));
        flushHand.add(new Card(3, "Hearts"));
        flushHand.add(new Card(8, "Hearts"));

        handAnalyzer.setHand(flushHand);
        System.out.println("Score is: " + handAnalyzer.getScore());
        Assert.assertEquals(handAnalyzer.getScore(), 0);
    }

    @Test
    public void checkStraight() {
        ArrayList<Card> straightHand = new ArrayList<>();
        straightHand.add(new Card(10, "Hearts"));
        straightHand.add(new Card(11, "Diamonds"));
        straightHand.add(new Card(12, "Hearts"));
        straightHand.add(new Card(13, "Diamonds"));
        straightHand.add(new Card(14, "Hearts"));

        handAnalyzer.setHand(straightHand);
        System.out.println("Score is: " + handAnalyzer.getScore());
        Assert.assertEquals(handAnalyzer.getScore(), 1);
    }

    @Test
    public void checkFourOfAKind() {
        ArrayList<Card> fourOfAKindHand = new ArrayList<>();
        fourOfAKindHand.add(new Card(10, "Hearts"));
        fourOfAKindHand.add(new Card(10, "Diamonds"));
        fourOfAKindHand.add(new Card(10, "Hearts"));
        fourOfAKindHand.add(new Card(10, "Diamonds"));
        fourOfAKindHand.add(new Card(14, "Hearts"));

        handAnalyzer.setHand(fourOfAKindHand);
        System.out.println("Score is: " + handAnalyzer.getScore());
        Assert.assertEquals(handAnalyzer.getScore(), 2);
    }

    @Test
    public void checkFullHouse() {
        ArrayList<Card> fullHouseHand = new ArrayList<>();
        fullHouseHand.add(new Card(5, "Hearts"));
        fullHouseHand.add(new Card(10, "Diamonds"));
        fullHouseHand.add(new Card(10, "Hearts"));
        fullHouseHand.add(new Card(10, "Diamonds"));
        fullHouseHand.add(new Card(5, "Hearts"));

        handAnalyzer.setHand(fullHouseHand);
        System.out.println("Score is: " + handAnalyzer.getScore());
        Assert.assertEquals(handAnalyzer.getScore(), 3);
    }

    @Test
    public void checkThreePairs() {
        ArrayList<Card> threeOfAKindHand = new ArrayList<>();
        threeOfAKindHand.add(new Card(5, "Hearts"));
        threeOfAKindHand.add(new Card(5, "Diamonds"));
        threeOfAKindHand.add(new Card(2, "Hearts"));
        threeOfAKindHand.add(new Card(10, "Diamonds"));
        threeOfAKindHand.add(new Card(5, "Hearts"));

        handAnalyzer.setHand(threeOfAKindHand);
        System.out.println("Score is: " + handAnalyzer.getScore());
        Assert.assertEquals(handAnalyzer.getScore(), 4);
    }

    @Test
    public void checkTwoPairs() {
        ArrayList<Card> twoPairsHand = new ArrayList<>();
        twoPairsHand.add(new Card(10, "Hearts"));
        twoPairsHand.add(new Card(5, "Diamonds"));
        twoPairsHand.add(new Card(11, "Hearts"));
        twoPairsHand.add(new Card(10, "Diamonds"));
        twoPairsHand.add(new Card(5, "Hearts"));

        handAnalyzer.setHand(twoPairsHand);
        System.out.println("Score is: " + handAnalyzer.getScore());
        Assert.assertEquals(handAnalyzer.getScore(), 5);
    }

    @Test
    public void checkOnePair() {
        ArrayList<Card> onePairHand = new ArrayList<>();
        onePairHand.add(new Card(2, "Hearth"));
        onePairHand.add(new Card(8, "Diamonds"));
        onePairHand.add(new Card(10, "Hearth"));
        onePairHand.add(new Card(10, "Diamonds"));
        onePairHand.add(new Card(5, "Hearth"));

        handAnalyzer.setHand(onePairHand);
        System.out.println("Score is: " + handAnalyzer.getScore());
        Assert.assertEquals(handAnalyzer.getScore(), 6);
    }

    @Test
    public void checkNoCombo() {
        ArrayList<Card> noCombo = new ArrayList<>();
        noCombo.add(new Card(2, "Hearth"));
        noCombo.add(new Card(8, "Diamonds"));
        noCombo.add(new Card(9, "Hearth"));
        noCombo.add(new Card(10, "Diamonds"));
        noCombo.add(new Card(5, "Hearth"));

        handAnalyzer.setHand(noCombo);
        System.out.println("Score is: " + handAnalyzer.getScore());
        Assert.assertEquals(handAnalyzer.getScore(), 100);
    }

}


