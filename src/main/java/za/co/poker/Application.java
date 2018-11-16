package za.co.poker;

import za.co.poker.dealer.Judge;
import za.co.poker.hands.PokerHand;

public class Application {
    public static void main(String[] args) throws Exception {
        Judge judge = new Judge();
        PokerHand hand = judge.deal("3C,3H,3S,2C,2S");
        System.out.println(judge.assessHand(hand).print());
    }
}
