package za.co.poker.hands.types;

import lombok.Data;
import lombok.EqualsAndHashCode;
import za.co.poker.hands.PokerHand;

@EqualsAndHashCode(callSuper = true)
@Data
public class StraightHand extends PokerHand {
    public StraightHand(PokerHand hand) {
        super(hand);
    }

    public StraightHand() {
        super();
    }

    public String print() {
        return "Straight";
    }
}
