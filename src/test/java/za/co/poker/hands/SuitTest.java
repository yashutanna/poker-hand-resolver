package za.co.poker.hands;

import org.junit.Assert;
import org.junit.Test;

public class SuitTest {
    @Test
    public void testSuits(){
        Assert.assertEquals(Suit.HEARTS, Suit.fromValue("H"));
        Assert.assertEquals(Suit.CLUBS, Suit.fromValue("C"));
        Assert.assertEquals(Suit.DIAMONDS, Suit.fromValue("D"));
        Assert.assertEquals(Suit.SPADES, Suit.fromValue("S"));
    }
}
