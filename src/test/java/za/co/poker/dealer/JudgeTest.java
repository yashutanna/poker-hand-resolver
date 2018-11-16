package za.co.poker.dealer;

import org.junit.Assert;
import org.junit.Test;
import za.co.poker.hands.Card;
import za.co.poker.hands.PokerHand;
import za.co.poker.hands.Suit;

import java.util.Arrays;
import java.util.HashMap;

public class JudgeTest {
    private Judge judge = new Judge();

    @Test
    public void testCardCount() throws Exception {
        PokerHand hand = new PokerHand();
        Card[] cards = new Card[]{new Card("3C"), new Card("3H"), new Card("2C"), new Card("AH"), new Card("KS")};
        hand.setCards(Arrays.asList(cards));

        HashMap<Integer, Integer> countedCards = judge.countCards(hand);
        Assert.assertEquals(1, countedCards.get(0).intValue());
        Assert.assertEquals(1, countedCards.get(2).intValue());
        Assert.assertEquals(2, countedCards.get(3).intValue());
        Assert.assertEquals(1, countedCards.get(13).intValue());
    }

    @Test
    public void testCardSuiteCount() throws Exception {
        PokerHand hand = new PokerHand();
        Card[] cards = new Card[]{new Card("3C"), new Card("3H"), new Card("2C"), new Card("AH"), new Card("KS")};
        hand.setCards(Arrays.asList(cards));

        HashMap<Suit, Integer> countedCards = judge.countSuits(hand);
        Assert.assertEquals(2, countedCards.get(Suit.CLUBS).intValue());
        Assert.assertEquals(2, countedCards.get(Suit.HEARTS).intValue());
        Assert.assertEquals(1, countedCards.get(Suit.SPADES).intValue());
    }

    @Test
    public void testPairHand() throws Exception {
        PokerHand hand = new PokerHand();
        Card[] cards = new Card[]{new Card("3C"), new Card("3H"), new Card("2C"), new Card("AH"), new Card("KS")};
        hand.setCards(Arrays.asList(cards));

        Assert.assertEquals(true, judge.has2cardsOfSameValue(hand));
    }

    @Test
    public void testTripsHand() throws Exception {
        PokerHand hand = new PokerHand();
        Card[] cards = new Card[]{new Card("3C"), new Card("3H"), new Card("3S"), new Card("AH"), new Card("KS")};
        hand.setCards(Arrays.asList(cards));

        Assert.assertEquals(true, judge.has3cardsOfSameValue(hand));
    }

    @Test
    public void testSameSuitedHand() throws Exception {
        PokerHand hand = new PokerHand();
        Card[] cards = new Card[]{new Card("3C"), new Card("5C"), new Card("7C"), new Card("AC"), new Card("KC")};
        hand.setCards(Arrays.asList(cards));

        Assert.assertEquals(true, judge.hasAllSameSuit(hand));
    }

    @Test
    public void testHandSequential() throws Exception {
        PokerHand hand = new PokerHand();
        Card[] cards = new Card[]{new Card("3C"), new Card("2C"), new Card("4C"), new Card("5C"), new Card("AH")};
        hand.setCards(Arrays.asList(cards));
        Assert.assertEquals(true, judge.hasSequentialCards(hand));
    }

    @Test
    public void testHandSequential2() throws Exception {
        PokerHand hand = new PokerHand();
        Card[] cards = new Card[]{new Card("AC"), new Card("KC"), new Card("QC"), new Card("JC"), new Card("10H")};
        hand.setCards(Arrays.asList(cards));
        Assert.assertEquals(true, judge.hasSequentialCards(hand));
    }

    @Test
    public void testHandSequential3() throws Exception {
        PokerHand hand = new PokerHand();
        Card[] cards = new Card[]{new Card("AC"), new Card("KC"), new Card("4C"), new Card("3C"), new Card("2H")};
        hand.setCards(Arrays.asList(cards));
        Assert.assertEquals(false, judge.hasSequentialCards(hand));
    }


    @Test
    public void testRoyalFlushHouse() throws Exception {
        PokerHand hand = new PokerHand();
        Card[] cards = new Card[]{new Card("AC"), new Card("KC"), new Card("QC"), new Card("JC"), new Card("10C")};
        hand.setCards(Arrays.asList(cards));

        Assert.assertEquals(true, judge.hasRoyalFlush(hand));
    }

    @Test
    public void testStraightFlush() throws Exception {
        PokerHand hand = new PokerHand();
        Card[] cards = new Card[]{new Card("AC"), new Card("2C"), new Card("3C"), new Card("4C"), new Card("5C")};
        hand.setCards(Arrays.asList(cards));

        Assert.assertEquals(true, judge.hasStraightFlush(hand));
    }

    @Test
    public void testFourOfAKind() throws Exception {
        PokerHand hand = new PokerHand();
        Card[] cards = new Card[]{new Card("3C"), new Card("3H"), new Card("3S"), new Card("3D"), new Card("2H")};
        hand.setCards(Arrays.asList(cards));

        Assert.assertEquals(true, judge.hasFourOfAkind(hand));
    }

    @Test
    public void testFullHouse() throws Exception {
        PokerHand hand = new PokerHand();
        Card[] cards = new Card[]{new Card("3C"), new Card("3H"), new Card("3S"), new Card("2C"), new Card("2H")};
        hand.setCards(Arrays.asList(cards));

        Assert.assertEquals(true, judge.hasFullHouse(hand));
    }

    @Test
    public void testFlush() throws Exception {
        PokerHand hand = new PokerHand();
        Card[] cards = new Card[]{new Card("KC"), new Card("2C"), new Card("3C"), new Card("4C"), new Card("5C")};
        hand.setCards(Arrays.asList(cards));

        Assert.assertEquals(true, judge.hasFlush(hand));
    }

    @Test
    public void testStraight() throws Exception {
        PokerHand hand = new PokerHand();
        Card[] cards = new Card[]{new Card("AH"), new Card("2C"), new Card("3C"), new Card("4C"), new Card("5C")};
        hand.setCards(Arrays.asList(cards));

        Assert.assertEquals(true, judge.hasStraight(hand));
    }

    @Test
    public void testThreeOfAKind() throws Exception {
        PokerHand hand = new PokerHand();
        Card[] cards = new Card[]{new Card("3C"), new Card("3H"), new Card("3S"), new Card("AC"), new Card("2H")};
        hand.setCards(Arrays.asList(cards));

        Assert.assertEquals(true, judge.hasThreeOfAKind(hand));
    }

    @Test
    public void testTwoPair() throws Exception {
        PokerHand hand = new PokerHand();
        Card[] cards = new Card[]{new Card("3C"), new Card("3H"), new Card("AS"), new Card("AC"), new Card("2H")};
        hand.setCards(Arrays.asList(cards));

        Assert.assertEquals(true, judge.hasTwoPair(hand));
    }

    @Test
    public void testOnePair() throws Exception {
        PokerHand hand = new PokerHand();
        Card[] cards = new Card[]{new Card("3C"), new Card("3H"), new Card("AS"), new Card("KC"), new Card("2H")};
        hand.setCards(Arrays.asList(cards));

        Assert.assertEquals(true, judge.hasOnePair(hand));
    }
}
