/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
*/

package card;
import java.util.ArrayList;
// test comment 2

/**
 *
 * @author jtass
 */
public class PokerHand {
    
    public enum HandType {
        HIGH_CARD,PAIR,THREE_OF_KIND,FOUR_OF_KIND,TWO_PAIR,
        FLUSH,FULL_HOUSE,STRAIGHT,STRAIGHT_FLUSH,ROYAL_FLUSH;
    }
    
    public static HandType classifyHand(Card[] hands) {
        int amtOfKind = 1;
        int sameSuit = 1;
        int isLessThan=0;
        int isOneLess = 0;
        int sum = 0;
        
        ArrayList<Card.CardKind> duplicates = new ArrayList<>();
        
        for(int i =0;i<hands.length-1;i++){

            // checks if  card ordinal is less than next card ordinal in array
            if ((hands[i].getCardKind().ordinal())< hands[i+1].getCardKind().ordinal()){
                isLessThan ++;
                sum+=hands[i].getCardKind().ordinal();
            }
            // checks if card ordinal is exactly one more than next card ordinal in array
            if ((hands[i].getCardKind().ordinal())+1== hands[i+1].getCardKind().ordinal()){
                isOneLess++;
            }
            // checks is if card suit is same suit as one after in array
            if ((hands[i].getCardSuit() == hands[i+1].getCardSuit())){
                sameSuit++;  
            }
            // checks if card suit kind shows up multiple times
            // Note: will still add to array if two different cards appear twice
            //This gets accounted for in the conditonal statments for returing the correct HandType
            if (hands[i].getCardKind() == hands[i+1].getCardKind()){
                amtOfKind++;
                if(duplicates.contains(hands[i].getCardKind())){
                    // do nothing
                }
                else{
                   duplicates.add(hands[i].getCardKind()); 
                }
            }
        }
        
        
        if (sum == 38 && sameSuit == 5){
            return HandType.ROYAL_FLUSH;
        }    
        else if (isOneLess == 4 && sameSuit==5){
            return HandType.STRAIGHT_FLUSH;
        }
        else if (isLessThan == 4 && sameSuit == 5){
            return HandType.FLUSH;
        }
        else if (isOneLess == 4 ){
            return HandType.STRAIGHT;
        }
        else if (amtOfKind == 4 && duplicates.size()== 1){
            return HandType.FOUR_OF_KIND;
        }
        else if (duplicates.size() == 2 && amtOfKind == 4){
            return HandType.FULL_HOUSE;
        }
        else if (duplicates.size() == 2 && amtOfKind == 3){
            return HandType.TWO_PAIR;
        }
        else if(duplicates.size() == 1 && amtOfKind == 2){
            return HandType.PAIR;
        }
        else if (amtOfKind == 3){
            return HandType.THREE_OF_KIND;
        }
        else {
            return HandType.HIGH_CARD;
        }

    }
        

    
    public static void main(String[] args) {
        // High Card
        Card aceOfHearts = new Card(Card.CardSuit.HEARTS,Card.CardKind.ACE);
        Card queenOfClubs= new Card(Card.CardSuit.CLUBS,Card.CardKind.QUEEN);
        Card sixOfHearts= new Card(Card.CardSuit.HEARTS,Card.CardKind.SIX);
        Card fourOfSpades = new Card(Card.CardSuit.SPADES,Card.CardKind.FOUR);
        Card twoOfDiamonds= new Card(Card.CardSuit.DIAMONDS,Card.CardKind.TWO);
        
        Card highCard[] = {twoOfDiamonds, fourOfSpades,sixOfHearts,queenOfClubs,aceOfHearts};

        // One Pair
        Card kingOfHearts = new Card(Card.CardSuit.HEARTS, Card.CardKind.KING);
        Card kingOfSpades = new Card(Card.CardSuit.SPADES, Card.CardKind.KING);
        Card nineOfDiamonds = new Card(Card.CardSuit.DIAMONDS, Card.CardKind.NINE);
        Card eightOfSpades= new Card(Card.CardSuit.SPADES, Card.CardKind.EIGHT);
        Card fourOfHearts = new Card(Card.CardSuit.HEARTS, Card.CardKind.FOUR);
        
        Card onePair[] = {fourOfHearts,eightOfSpades, nineOfDiamonds, kingOfHearts,kingOfSpades};
        
        // Two Pair
        Card jackOfSpades = new Card(Card.CardSuit.SPADES, Card.CardKind.JACK);
        Card jackOfHearts = new Card(Card.CardSuit.HEARTS, Card.CardKind.JACK);
        Card nineofSpades = new Card(Card.CardSuit.SPADES, Card.CardKind.NINE);
        Card fiveOfHearts = new Card(Card.CardSuit.HEARTS, Card.CardKind.FIVE);
        Card fiveOfClubs = new Card(Card.CardSuit.CLUBS, Card.CardKind.FIVE);
        
        Card twoPair [] = {fiveOfClubs,fiveOfHearts, nineOfDiamonds,nineofSpades,jackOfSpades};
        
        //Three Of A Kind
      
        Card queenOfHearts = new Card(Card.CardSuit.HEARTS, Card.CardKind.QUEEN);
        Card queenOfSpades = new Card(Card.CardSuit.SPADES, Card.CardKind.QUEEN);
        Card sevenOfHearts = new Card(Card.CardSuit.HEARTS, Card.CardKind.SEVEN);
        Card twoOfClubs = new Card(Card.CardSuit.CLUBS, Card.CardKind.TWO);
        
        Card threeOfKind[] = {twoOfClubs,sevenOfHearts, queenOfClubs,queenOfHearts,queenOfSpades};
        
        // Straight
        Card eightOfHearts = new Card(Card.CardSuit.HEARTS, Card.CardKind.EIGHT);
        Card sevenOfClubs= new Card(Card.CardSuit.CLUBS, Card.CardKind.SEVEN);
        Card sixOfDiamonds = new Card(Card.CardSuit.DIAMONDS, Card.CardKind.SIX);
        Card fiveOfSpades = new Card(Card.CardSuit.SPADES, Card.CardKind.FIVE);
    
        
        Card straight [] = {fourOfHearts, fiveOfSpades, sixOfDiamonds,sevenOfClubs, eightOfHearts};
        
        // Flush
        Card twoOfHearts = new Card(Card.CardSuit.HEARTS, Card.CardKind.TWO);
        
        Card flush[] = {twoOfHearts,fourOfHearts,sixOfHearts, eightOfHearts,kingOfHearts};
        
        
        // Full House
        Card aceOfSpades = new Card(Card.CardSuit.SPADES, Card.CardKind.ACE);
        Card aceOfDiamonds = new Card(Card.CardSuit.DIAMONDS, Card.CardKind.ACE);
        Card aceOfClubs = new Card(Card.CardSuit.CLUBS, Card.CardKind.ACE);
        Card fullHouse [] = {kingOfSpades, kingOfHearts, aceOfClubs, aceOfSpades, aceOfDiamonds};
        
        // Four of a Kind
        Card queenOfDiamonds = new Card(Card.CardSuit.DIAMONDS, Card.CardKind.QUEEN);
        
        
        Card fourOfKind [] = {fiveOfClubs, queenOfClubs, queenOfHearts, queenOfSpades, queenOfDiamonds};
        
        // Straight Flush
        Card tenOfClubs = new Card(Card.CardSuit.CLUBS, Card.CardKind.TEN);
        Card nineOfClubs = new Card(Card.CardSuit.CLUBS, Card.CardKind.NINE);
        Card eightOfClubs = new Card(Card.CardSuit.CLUBS, Card.CardKind.EIGHT);

        Card sixOfClubs = new Card(Card.CardSuit.CLUBS, Card.CardKind.SIX);
        
        Card straightFlush [] = {sixOfClubs,sevenOfClubs,eightOfClubs,nineOfClubs,tenOfClubs};
        
        // Royal Flush
       
        Card tenOfHearts = new Card(Card.CardSuit.HEARTS, Card.CardKind.TEN);
        
        Card royalFlush [] = {tenOfHearts, jackOfHearts, queenOfHearts, kingOfHearts, aceOfHearts};
        
  
       
        
       if (PokerHand.classifyHand(highCard) != HandType.HIGH_CARD){
           System.out.println("Wrong card hand! Shoud be highCard");
       }
       if (PokerHand.classifyHand(onePair) != HandType.PAIR){
           System.out.println("Wrong card hand! Should be pair");
       }
       if (PokerHand.classifyHand(twoPair) != HandType.TWO_PAIR){
           System.out.println("Wrong card hand! Should be twoPair");
       }
       if (PokerHand.classifyHand(threeOfKind) != HandType.THREE_OF_KIND){
           System.out.println("Wrong card hand! Should be threeOfKind");
       }
       if (PokerHand.classifyHand(straight) != HandType.STRAIGHT){
           System.out.println("Wrong card hand! Should be straight");
       }
       if (PokerHand.classifyHand(flush) != HandType.FLUSH){
           System.out.println("Wrong card hand! Should be flush");
       }
       if (PokerHand.classifyHand(fullHouse) != HandType.FULL_HOUSE){
           System.out.println("Wrong card hand! Should be fullHouse");
       }
       if (PokerHand.classifyHand(fourOfKind) != HandType.FOUR_OF_KIND){
           System.out.println("Wrong card hand! Should be fourOfKind");
       }
       if (PokerHand.classifyHand(straightFlush) != HandType.STRAIGHT_FLUSH){
           System.out.println("Wrong card hand! Should be straightFlush");
       }
       if (PokerHand.classifyHand(royalFlush) != HandType.ROYAL_FLUSH){
           System.out.println("Wrong card hand! Should be royalFlush");
       }
       

    }
    
}
