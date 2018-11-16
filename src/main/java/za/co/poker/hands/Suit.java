package za.co.poker.hands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public enum Suit {
    HEARTS("H"),
    CLUBS("C"),
    SPADES("S"),
    DIAMONDS("D");

    String description;
    static HashMap<String, Suit> lookup = new LinkedHashMap<>();
    static {
        Arrays.stream(Suit.values())
                .forEach(s -> lookup.put(s.description, s));
    }

    Suit(String description){
        this.description = description;
    }

    public static Suit fromValue(String s) {
        return lookup.get(s);
    }
}
