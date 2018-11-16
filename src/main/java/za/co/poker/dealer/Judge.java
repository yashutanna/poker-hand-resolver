package za.co.poker.dealer;

import za.co.poker.hands.PokerHand;
import za.co.poker.hands.Suit;

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

    public HashMap<Suit, Integer> countSuits(PokerHand hand) {
        HashMap<Suit, Integer> cardCounts = new HashMap<>();

        HashSet<Suit> uniqueSuits = new HashSet<>(hand.getCardSuits());
        for (Suit suit : uniqueSuits) {
            cardCounts.put(suit, Collections.frequency(hand.getCardSuits(), suit));
        }
        return cardCounts;
    }

    public boolean has3cardsOfSameValue(PokerHand hand) {
        HashMap<Integer, Integer> countedCards = countCards(hand);
        return countedCards.keySet().stream().anyMatch(card -> countedCards.get(card) == 3);
    }

    public boolean has2cardsOfSameValue(PokerHand hand) {
        HashMap<Integer, Integer> countedCards = countCards(hand);
        return countedCards.keySet().stream().anyMatch(card -> countedCards.get(card) == 2);
    }

    private boolean has4cardsOfSameValue(PokerHand hand) {
        HashMap<Integer, Integer> countedCards = countCards(hand);
        return countedCards.keySet().stream().anyMatch(card -> countedCards.get(card) == 4);
    }

    public boolean hasAllSameSuit(PokerHand hand) {
        HashMap<Suit, Integer> countedSuits = countSuits(hand);
        return countedSuits.size() == 1;
    }

    public boolean hasSequentialCards(PokerHand hand) {
        if (has2cardsOfSameValue(hand) || has3cardsOfSameValue(hand) || has4cardsOfSameValue(hand)) {
            return false;
        }

        boolean hasAce = hand.getCardValues().contains(0);
        if (hasAce) {
            boolean secondCardIsNot2 = hand.getCardValues().get(1) != 2;
            boolean lastCardIsNotKing = hand.getCardValues().get(hand.getCardValues().size() - 1) != 13;
            if (secondCardIsNot2 && lastCardIsNotKing) {
                return false;
            }

            hand.getCardValues().subList(1, 4);
            Integer prev = null;
            int seq = 0;
            for (Integer i : hand.getCardValues()) {
                if (prev != null && prev + 1 == i)
                    seq = seq == 0 ? 2 : seq + 1;
                prev = i;
            }
            return seq >= 4;
        } else {
            Integer prev = null;
            int seq = 0;
            for (Integer i : hand.getCardValues()) {
                if (prev != null && prev + 1 == i)
                    seq = seq == 0 ? 2 : seq + 1;
                prev = i;
            }
            return seq >= 5;
        }
    }


    public boolean hasFullHouse(PokerHand hand) {
        return has3cardsOfSameValue(hand) && has2cardsOfSameValue(hand);
    }

    public boolean hasFourOfAkind(PokerHand hand) {
        return has4cardsOfSameValue(hand);
    }

    public boolean hasStraight(PokerHand hand) {
        return hasSequentialCards(hand) && !hasAllSameSuit(hand);
    }

    public boolean hasStraightFlush(PokerHand hand) {
        return hasSequentialCards(hand) && hasAllSameSuit(hand);
    }

    public boolean hasRoyalFlush(PokerHand hand) {
        boolean lastCardIsKing = hand.getCardValues().get(hand.getCardValues().size() - 1) == 13;

        return hasSequentialCards(hand) && hasAllSameSuit(hand) && lastCardIsKing;
    }

    public boolean hasThreeOfAKind(PokerHand hand) {
        return has3cardsOfSameValue(hand) && !has2cardsOfSameValue(hand);
    }

    public boolean hasOnePair(PokerHand hand) {
        return has2cardsOfSameValue(hand);
    }

//    public PokerHand assessHand(PokerHand hand){
//        if(hasRoyalFlush(hand)){
//            return (RoyalFlushHand) hand;
//        }
//        else if(has4cardsOfSameValue(hand)){
//            return (FourOfAKindHand) hand;
//        }
//    }


}