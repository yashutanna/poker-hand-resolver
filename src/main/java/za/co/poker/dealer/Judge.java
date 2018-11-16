package za.co.poker.dealer;

import za.co.poker.hands.PokerHand;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Judge {
    public HashMap<Integer, Integer> countCards(PokerHand hand){
        HashMap<Integer, Integer> cardCounts = new HashMap<>();

        HashSet<Integer> uniqueCards = new HashSet<>(hand.getCardValues());
        for (Integer card : uniqueCards) {
            cardCounts.put(card, Collections.frequency(hand.getCardValues(), card));
        }
        return cardCounts;
    }
}
