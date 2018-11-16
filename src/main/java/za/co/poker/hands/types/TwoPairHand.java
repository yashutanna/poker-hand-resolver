package za.co.poker.hands.types;

import lombok.Data;
import lombok.EqualsAndHashCode;
import za.co.poker.hands.PokerHand;

@EqualsAndHashCode(callSuper = true)
@Data
public class TwoPairHand extends PokerHand {
    public TwoPairHand(PokerHand hand) {
        super(hand);
    }

    public TwoPairHand() {
        super();
    }

    public String print() {
        return "Two Pair";
    }
}
