/*
CSE 17
Sam Sausville
sps222
Program Description: Create a blackjack simulater that allows the player to play as
well as other players to play against with certain types of logic. Includes a dealer, 4 other players
and a human player that allows you to hit or miss
Program #4 

*/
public abstract class Player{
public static final int HIT = 1;
public static final int STAY = 0;

protected Hand hand = new Hand();
protected String name;

public Player(String s){
    name = s;
}

public void acceptCard(Card c){
    hand.acceptCard(c);
}
public int handValue(){
    int value = hand.softValue();
    if(value > 21){
        return hand.hardValue();
    }else{
        return hand.softValue();
    }
}
public abstract int nextAction();

@Override
public String toString(){
   return hand.toString();
}

public String getName() {
        return name;
}
}