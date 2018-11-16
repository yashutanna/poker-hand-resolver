package za.co.poker.hands;

import java.util.List;

public interface Hand {
    String print();
    List<Integer> getCardValues();
}
