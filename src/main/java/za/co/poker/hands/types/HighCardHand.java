package za.co.poker.hands.types;

import lombok.Data;
import lombok.EqualsAndHashCode;
import za.co.poker.hands.PokerHand;

@EqualsAndHashCode(callSuper = true)
@Data
public class HighCardHand extends PokerHand {
    public HighCardHand(PokerHand hand) {
        super(hand);
    }

    public HighCardHand() {
        super();
    }

    public String print() {
        return "High Card";
    }
}
