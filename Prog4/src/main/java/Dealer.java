/*
CSE 17
Sam Sausville
sps222
Program Description: Create a blackjack simulater that allows the player to play as
well as other players to play against with certain types of logic. Includes a dealer, 4 other players
and a human player that allows you to hit or miss
Program #4 

*/
public class Dealer extends Player{


public Dealer(String s){
    super(s);
}
    @Override
    public String toString(){
        return hand.toString();
    }

@Override
public int nextAction(){
    if(handValue() >= 17){
        return STAY;
    }else{
        return HIT;
    }
}
}