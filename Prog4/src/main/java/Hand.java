import java.util.ArrayList;
/*
CSE 17
Sam Sausville
sps222
Program Description: Create a blackjack simulater that allows the player to play as
well as other players to play against with certain types of logic. Includes a dealer, 4 other players
and a human player that allows you to hit or miss
Program #4 

*/
public class Hand{
    private ArrayList<Card> cards = new ArrayList<>();
    

    public Hand(){

    }

    @Override
    public String toString(){
        String s = "";
        for(int i = 0; i < cards.size(); i++){
            s = s + cards.get(i).toString();
            s = s + " ";
        }
        return s;
    }
    public int hardValue(){
        int value = 0;
        for(int i = 0; i < cards.size(); i++){
            Card c = cards.get(i);
            int n = c.getRank() + 1;
            if(n > 10){
                n = 10;
            }
            value += n;
        }
        return value;
    }
    public int softValue(){
        int value = 0;
        for(int i = 0; i < cards.size(); i++){
            Card c = cards.get(i);
            int n = c.getRank() + 1;
            if(n == 1){
                n = 11;
            }else if(n > 10){
                n = 10;
            }
            value += n;
        }
        return value;
    }
    public void acceptCard(Card c){
        if(c != null){
            cards.add(c);
        }else{
            System.out.println("Error: Card cannot be null");
            throw new IllegalArgumentException();
        }
    }
}