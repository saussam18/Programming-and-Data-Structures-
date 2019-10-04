/*
CSE 17
Sam Sausville
sps222
Program Description: Create a blackjack simulater that allows the player to play as
well as other players to play against with certain types of logic. Includes a dealer, 4 other players
and a human player that allows you to hit or miss
Program #4 

*/
public class Card{
//Variables
private int cardNumber;
private static String[] rankNames = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
private static String[] suitNames = {"S", "H", "C", "D"};

//Constants
public static final int SPADES = 0;
public static final int HEARTS = 1;
public static final int CLUBS = 2;
public static final int DIAMONDS = 3;
public static final int ACE = 0;
public static final int TWO = 1;
public static final int THREE = 2;
public static final int FOUR = 3;
public static final int FIVE = 4;
public static final int SIX = 5;
public static final int SEVEN = 6;
public static final int EIGHT = 7;
public static final int NINE = 8;
public static final int TEN = 9;
public static final int JACK = 10;
public static final int QUEEN = 11;
public static final int KING = 12; 

//Methods
public Card(int n){
    cardNumber = n;
}

public int getCardNumber() {
    return cardNumber;
}

public int getRank() {
    return cardNumber % 13;
}

public int getSuit() {
    return cardNumber / 13;
}
public String getSuitName(){
return suitNames[getSuit()];
}
public String getRankName(){
    return rankNames[getRank()];
}

@Override
public String toString(){
    return getRankName() + getSuitName();
}
@Override
public boolean equals(Object obj){
    if(obj instanceof Card){
        Card c = (Card) obj;
        if(c.getCardNumber() == cardNumber){
            return true;
        }else{
            return false;
        }
    }else{
        return false;
    }
}

}