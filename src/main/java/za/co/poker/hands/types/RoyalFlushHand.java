package za.co.poker.hands.types;

import lombok.Data;
import lombok.EqualsAndHashCode;
import za.co.poker.hands.PokerHand;

@EqualsAndHashCode(callSuper = true)
@Data
public class RoyalFlushHand extends PokerHand {
    public RoyalFlushHand(PokerHand hand) {
        super(hand);
    }

    public RoyalFlushHand() {
        super();
    }

    public String print() {
        return "Royal Flush";
    }
}
