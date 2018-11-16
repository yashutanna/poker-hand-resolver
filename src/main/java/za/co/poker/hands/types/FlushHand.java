package za.co.poker.hands.types;

import lombok.Data;
import lombok.EqualsAndHashCode;
import za.co.poker.hands.PokerHand;

@EqualsAndHashCode(callSuper = true)
@Data
public class FlushHand extends PokerHand {
    public FlushHand(PokerHand hand) {
        super(hand);
    }

    public FlushHand() {
        super();
    }

    public String print() {
        return "Flush";
    }
}
