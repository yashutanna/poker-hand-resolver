package za.co.poker;

import za.co.poker.dealer.Judge;
import za.co.poker.hands.PokerHand;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> hands = Arrays.asList(
            "3C,3H,3S,2C,2S",
            "3C,3H,3S,3D,2S"
        );

        Judge judge = new Judge();
        hands.forEach(hand -> {
            System.out.println("assessing hand: " + hand);
            PokerHand pokerHand = null;
            try {
                pokerHand = judge.deal(hand);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(judge.assessHand(pokerHand).print());
            System.out.println();
        });
    }
}
