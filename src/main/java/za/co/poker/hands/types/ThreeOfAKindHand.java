package za.co.poker.hands.types;

import lombok.Data;
import lombok.EqualsAndHashCode;
import za.co.poker.hands.PokerHand;

@EqualsAndHashCode(callSuper = true)
@Data
public class ThreeOfAKindHand extends PokerHand {
    public ThreeOfAKindHand(PokerHand hand) {
        super(hand);
    }

    public ThreeOfAKindHand() {
        super();
    }

    public String print() {
        return "Three Of A Kind";
    }
}
