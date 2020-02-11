/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//is this working
public class Card {
    private final CardSuit cardSuit;
    private final CardKind cardKind;

    public enum CardSuit {
        HEARTS,
        SPADES,
        CLUBS,
        DIAMONDS,
    }

    public enum CardKind {
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE
    }

    public Card(CardSuit suit, CardKind kind){
        cardSuit = suit;
        cardKind = kind;

    }

    public CardKind getCardKind() {
        return cardKind;
        

    }

    public CardSuit getCardSuit() {
        return cardSuit;
        
    }

    @Override
    public String toString(){
        CardKind kind = getCardKind();
        CardSuit suit = getCardSuit();
        String kindOf = null;
        String suitOf = null;

        if (kind ==CardKind.ACE){
            kindOf = "Ace";
        }
        else if (kind == CardKind.TWO){
            kindOf = "2";
        }
        else if (kind == CardKind.THREE){
            kindOf = "3";
        }
        else if (kind == CardKind.FOUR){
            kindOf = "4";
        }
        else if (kind == CardKind.FIVE){
            kindOf = "5";
        }
        else if (kind == CardKind.SIX){
            kindOf = "6";
        }
        else if (kind == CardKind.SEVEN){
            kindOf = "7";
        }
        else if (kind == CardKind.EIGHT){
            kindOf = "8";
        }
        else if (kind == CardKind.NINE){
            kindOf = "9";
        }
        else if (kind == CardKind.TEN){
            kindOf = "10";
        }
        else if (kind == CardKind.JACK){
            kindOf = "Jack";
        }
        else if (kind == CardKind.QUEEN){
            kindOf = "Queen";
        }
        else if (kind == CardKind.KING){
            kindOf = "King";
        }

        if (suit == CardSuit.HEARTS){
            suitOf = "Hearts";
        }
        else if (suit == CardSuit.SPADES){
            suitOf = "Spades";
        }
        else if (suit == CardSuit.CLUBS){
            suitOf = "Clubs";
        }
        else if (suit == CardSuit.DIAMONDS){
            suitOf = "Diamonds";
        }
        return kindOf + " of " + suitOf;



    }
/*
    public static void main(String[] args) {
        Card queen = new Card(CardSuit.HEARTS, CardKind.QUEEN);
        System.out.println(queen);
        //card.cardsuit.hearts

    }
*/
}

