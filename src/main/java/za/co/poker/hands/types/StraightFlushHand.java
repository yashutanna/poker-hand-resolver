package za.co.poker.hands.types;

import lombok.Data;
import lombok.EqualsAndHashCode;
import za.co.poker.hands.PokerHand;

@EqualsAndHashCode(callSuper = true)
@Data
public class StraightFlushHand extends PokerHand {
    public StraightFlushHand(PokerHand hand) {
        super(hand);
    }

    public StraightFlushHand() {
        super();
    }

    public String print() {
        return "Straight Flush";
    }
}
