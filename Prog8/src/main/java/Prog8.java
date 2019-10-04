import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
/*

CSE 17
Sam Sausville
sps222
Program Description: Create Portmanteau words from a list and print out all of them in a ordered and specialized format
Program #8

 */


public class Prog8 {

    public static void main (String [] args){
        Set<String> words = new HashSet<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("1-1000.txt"));
            String line = "";
            while ((line = in.readLine()) != null) {
                String punuation = ".,#()\'-/;!?&%\":";
                if (line.contains(";;;") || line.contains(punuation) ) {
                    continue;
                }
                String [] word = line.split("\\s+");
                String yeet = word[0].toLowerCase();
                words.add(yeet);
            }
            Portmanteau p = new Portmanteau(words);
            p.print(); //Print doesnt fully print out everything in the ide but does in terminal so I assume it is fine
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
