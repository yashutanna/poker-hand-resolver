package za.co.poker.hands;

import org.junit.Assert;
import org.junit.Test;
import za.co.poker.hands.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HandTest {

    @Test
    public void HighCard(){
        Hand hand = new HighCardHand();
        String handType = hand.print();
        Assert.assertEquals("High Card", handType);
    }
    @Test
    public void OnePair(){
        Hand hand = new OnePairHand();
        String handType = hand.print();
        Assert.assertEquals("One Pair", handType);
    }
    @Test
    public void TwoPair(){
        Hand hand = new TwoPairHand();
        String handType = hand.print();
        Assert.assertEquals("Two Pair", handType);
    }
    @Test
    public void ThreeOfAKind(){
        Hand hand = new ThreeOfAKindHand();
        String handType = hand.print();
        Assert.assertEquals("Three Of A Kind", handType);
    }
    @Test
    public void Straight(){
        Hand hand = new StraightHand();
        String handType = hand.print();
        Assert.assertEquals("Straight", handType);
    }
    @Test
    public void Flush(){
        Hand hand = new FlushHand();
        String handType = hand.print();
        Assert.assertEquals("Flush", handType);
    }
    @Test
    public void StraightFlush(){
        Hand hand = new StraightFlushHand();
        String handType = hand.print();
        Assert.assertEquals("Straight Flush", handType);
    }
    @Test
    public void FullHouse(){
        Hand hand = new FullHouseHand();
        String handType = hand.print();
        Assert.assertEquals("Full House", handType);
    }
    @Test
    public void FourOfAKind(){
        Hand hand = new FourOfAKindHand();
        String handType = hand.print();
        Assert.assertEquals("Four Of A Kind", handType);
    }
    @Test
    public void RoyalFlush(){
        Hand hand = new RoyalFlushHand();
        String handType = hand.print();
        Assert.assertEquals("Royal Flush", handType);
    }

    @Test
    public void testSortedHand() throws Exception {
        PokerHand hand = new OnePairHand();
        Card[] cards = new Card[]{new Card("3C"), new Card("3H"), new Card("2C"), new Card("AH"), new Card("KS")};
        hand.setCards(Arrays.asList(cards));
        hand.sort();

        List<Integer> sortedHand =
                hand.getCards().stream()
                        .map(Card::getValue)
                        .collect(Collectors.toList());
        Assert.assertEquals(Arrays.asList(new Integer[]{0,2,3,3,13}).toString(), sortedHand.toString());
    }
}
