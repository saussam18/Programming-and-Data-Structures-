import java.util.Random;
/*
CSE 17
Sam Sausville
sps222
Program Description: Create a blackjack simulater that allows the player to play as
well as other players to play against with certain types of logic. Includes a dealer, 4 other players
and a human player that allows you to hit or miss
Program #4 

*/
public class Deck{
    private Card[] cards;
    private int nextCard;
    private Random rand;

    public Deck(){
        rand = new Random();
        cards = new Card[52];
        for(int i = 0; i < cards.length; i++){
            cards[i] = new Card(i);
        }
    }
    public void shuffle(){
        for(int i = 0; i < cards.length; i++){
            int index = rand.nextInt(52);
            Card c = cards[index];
            cards[index] = cards[i];
            cards[i] = c;
        }
        nextCard = 0;
    }
    public Card dealCard(){
        if(getCardsRemaining() > 0){
            return cards[nextCard++];
        }else{
            shuffle();
            nextCard = 0;
            return cards[nextCard++];
        }
    }
    public int getCardsRemaining(){
        return cards.length - nextCard;
    }
}