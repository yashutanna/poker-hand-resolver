package za.co.poker.hands;

import lombok.Data;

import java.util.Objects;

@Data
public class Card {
    int value;
    Suit suit;

    public Card(String cardValue) throws Exception {
        this.suit = Suit.fromValue(cardValue.substring(cardValue.length() - 1, cardValue.length()).toUpperCase());
        this.setValue(cardValue.substring(0, cardValue.length() - 1));
    }
    public Card() {
    }

    public void setValue(String valueString) throws Exception {
        try {
            this.value = Integer.parseInt(valueString);
        } catch (NumberFormatException e){
            switch (valueString){
                case "J" : {
                    this.value = 11;
                    break;
                }
                case "Q" : {
                    this.value = 12;
                    break;
                }
                case "K" : {
                    this.value = 13;
                    break;
                }
                case "A" : {
                    this.value = 0;
                    break;
                }
                default: {
                    throw new Exception("Invalid card value");
                }
            }
        }
    }
}
