package za.co.poker.dealer;

import za.co.poker.hands.Card;
import za.co.poker.hands.PokerHand;
import za.co.poker.hands.Suit;
import za.co.poker.hands.types.*;

import java.util.*;
import java.util.stream.Collectors;

public class Judge {
    public PokerHand deal(String cardsString) throws Exception {
        String[] cardTokens = cardsString.split(",");
        PokerHand PokerHand = new PokerHand();
        List<Card> cards = Arrays.stream(cardTokens).map(card -> {
            try {
                return new Card(card);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
        PokerHand.setCards(cards);
        return PokerHand;
    }

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

    public boolean hasFlush(PokerHand hand) {
        return hasAllSameSuit(hand);
    }

    public boolean hasStraightFlush(PokerHand hand) {
        return hasSequentialCards(hand) && hasAllSameSuit(hand);
    }

    public boolean hasRoyalFlush(PokerHand hand) {
        boolean lastCardIsKing = hand.getCardValues().get(hand.getCardValues().size() - 1) == 13;
        return hasSequentialCards(hand) && hasAllSameSuit(hand) && lastCardIsKing;
    }

    public boolean hasThreeOfAKind(PokerHand hand) {
        return has3cardsOfSameValue(hand);
    }

    public boolean hasTwoPair(PokerHand hand) {
        HashMap<Integer, Integer> countedCards = countCards(hand);
        return countedCards.values().stream().filter(count -> count == 2).count() == 2;
    }
    public boolean hasOnePair(PokerHand hand) {
        return has2cardsOfSameValue(hand);
    }

    public PokerHand assessHand(PokerHand hand) {
        if (hasRoyalFlush(hand)) {
            return new RoyalFlushHand(hand);
        } else if (hasStraightFlush(hand)) {
            return new StraightFlushHand(hand);
        } else if (has4cardsOfSameValue(hand)) {
            return new FourOfAKindHand(hand);
        } else if (hasFullHouse(hand)) {
            return new FullHouseHand(hand);
        } else if (hasFlush(hand)) {
            return new FlushHand(hand);
        } else if (hasStraight(hand)) {
            return new StraightHand(hand);
        } else if (hasThreeOfAKind(hand)) {
            return new ThreeOfAKindHand(hand);
        } else if (hasTwoPair(hand)) {
            return new TwoPairHand(hand);
        } else if (hasOnePair(hand)) {
            return new OnePairHand(hand);
        } else {
            return new HighCardHand(hand);
        }
    }


}