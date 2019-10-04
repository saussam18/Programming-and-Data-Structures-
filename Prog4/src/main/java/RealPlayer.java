import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
CSE 17
Sam Sausville
sps222
Program Description: Create a blackjack simulater that allows the player to play as
well as other players to play against with certain types of logic. Includes a dealer, 4 other players
and a human player that allows you to hit or miss
Program #4 

*/
public class RealPlayer extends Player {

private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

public RealPlayer(String name) {
    super(name);
}  
 public int nextAction() {
    for(;;){
        try {
            System.out.println("Enter h to hit, s to stay: ");
            String answer = in.readLine();
                if (answer.equals("h")) {
                    return Player.HIT;
                } else if (answer.equals("s")) {
                    return Player.STAY;
                }
        } catch (IOException ex) {
    System.out.println(ex.getMessage());
    System.exit(-1);
        }
    }  
 }
}