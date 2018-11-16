package za.co.poker.hands;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DealtPokerHand extends PokerHand {
    @Override
    public String print() {
        return "Undetermined poker hand";
    }
}
