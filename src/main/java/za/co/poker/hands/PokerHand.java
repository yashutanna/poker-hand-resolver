package za.co.poker.hands;

import lombok.Data;

import java.util.Comparator;
import java.util.List;

@Data
public abstract class PokerHand implements Hand {
    List<Card> cards;

    public void sort(){
        cards.sort(Comparator.comparing(Card::getValue));
    }
}
