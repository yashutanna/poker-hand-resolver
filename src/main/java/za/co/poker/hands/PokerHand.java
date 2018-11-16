package za.co.poker.hands;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public abstract class PokerHand implements Hand {
    List<Card> cards = new LinkedList<>();

    public void sort(){
        cards.sort(Comparator.comparing(Card::getValue));
    }

    public List<Integer> getCardValues(){
        return cards.stream()
                .map(Card::getValue)
                .collect(Collectors.toList());
    }

    public void setCards(List<Card> cards) throws Exception {
        Set<Card> unique = new HashSet<>(cards);
        if(unique.size() != 5){
            throw new Exception("invalid, non-unique cards specified");
        }
        this.cards = cards;
    }
}
