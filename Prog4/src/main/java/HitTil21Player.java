/*
CSE 17
Sam Sausville
sps222
Program Description: Create a blackjack simulater that allows the player to play as
well as other players to play against with certain types of logic. Includes a dealer, 4 other players
and a human player that allows you to hit or miss
Program #4 

*/
public class HitTil21Player extends Player{
    public HitTil21Player (String s){
        super(s);
    }
    @Override
    public int nextAction(){
        if(hand.softValue() < 21 && hand.hardValue() < 21){
            return HIT;
        }else{
            return STAY;
        }
    }
}