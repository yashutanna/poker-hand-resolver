package za.co.poker.hands.types;

import lombok.Data;
import lombok.EqualsAndHashCode;
import za.co.poker.hands.PokerHand;

@EqualsAndHashCode(callSuper = true)
@Data
public class OnePairHand extends PokerHand {
    public OnePairHand(PokerHand hand) {
        super(hand);
    }

    public OnePairHand() {
        super();
    }

    public String print() {
        return "One Pair";
    }
}
