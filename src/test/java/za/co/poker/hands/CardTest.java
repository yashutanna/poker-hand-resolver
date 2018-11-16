package za.co.poker.hands;

import org.junit.Assert;
import org.junit.Test;

public class CardTest {
    @Test
    public void testCardValues() throws Exception {
        Card card = new Card();
        card.setValue("A");
        Assert.assertEquals(0, card.getValue());
        card.setValue("K");
        Assert.assertEquals(13, card.getValue());
        card.setValue("Q");
        Assert.assertEquals(12, card.getValue());
        card.setValue("J");
        Assert.assertEquals(11, card.getValue());


        card.setValue("10");
        Assert.assertEquals(10, card.getValue());
    }
}
