package za.co.poker.hands.types;

import lombok.Data;
import lombok.EqualsAndHashCode;
import za.co.poker.hands.PokerHand;

@EqualsAndHashCode(callSuper = true)
@Data
public class FourOfAKindHand extends PokerHand {
    public FourOfAKindHand(PokerHand hand) {
        super(hand);
    }

    public FourOfAKindHand() {
        super();
    }

    public String print() {
        return "Four Of A Kind";
    }
}
