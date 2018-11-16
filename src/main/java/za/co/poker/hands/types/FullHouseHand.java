package za.co.poker.hands.types;

import lombok.Data;
import lombok.EqualsAndHashCode;
import za.co.poker.hands.PokerHand;

@EqualsAndHashCode(callSuper = true)
@Data
public class FullHouseHand extends PokerHand {
    public FullHouseHand(PokerHand hand) {
        super(hand);
    }

    public FullHouseHand() {
        super();
    }

    public String print() {
        return "Full House";
    }
}
