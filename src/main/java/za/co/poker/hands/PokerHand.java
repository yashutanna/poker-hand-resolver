package za.co.poker.hands;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public abstract class PokerHand implements Hand {
    List<Card> cards = new LinkedList<>();

    public List<Integer> getCardValues(){
        return cards.stream()
                .map(Card::getValue)
                .collect(Collectors.toList());
    }

    public List<Suit> getCardSuits() {
        return cards.stream()
                .map(Card::getSuit)
                .collect(Collectors.toList());
    }

    public void setCards(List<Card> cards) throws Exception {
        Set<Card> unique = new HashSet<>(cards);
        if(unique.size() != 5){
            throw new Exception("invalid, non-unique cards specified");
        }
        cards.sort(Comparator.comparing(Card::getValue));
        this.cards = cards;
    }

    @Override
    public String print() {
        return "Undetermined poker hand";
    }
}
