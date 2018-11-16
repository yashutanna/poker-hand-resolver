package za.co.poker.dealer;

import org.junit.Assert;
import org.junit.Test;
import za.co.poker.hands.Card;
import za.co.poker.hands.OnePairHand;
import za.co.poker.hands.PokerHand;

import java.util.Arrays;
import java.util.HashMap;

public class JudgeTest {
    Judge judge = new Judge();

    @Test
    public void testCardCount() throws Exception {
        PokerHand hand = new OnePairHand();
        Card[] cards = new Card[]{new Card("3C"), new Card("3H"), new Card("2C"), new Card("AH"), new Card("KS")};
        hand.setCards(Arrays.asList(cards));

        HashMap<Integer, Integer> countedCards = judge.countCards(hand);
        Assert.assertEquals(1, countedCards.get(0).intValue());
        Assert.assertEquals(1, countedCards.get(2).intValue());
        Assert.assertEquals(2, countedCards.get(3).intValue());
        Assert.assertEquals(1, countedCards.get(13).intValue());
    }
}
