package za.co.poker.hands;

import lombok.Data;

@Data
public class Card {
    int value;
    Suit suit;

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
