/*

CSE 17
Sam Sausville
sps222
Program Description: Create Portmanteau words from a list and print out all of them in a ordered and specialized format
Program #8

 */

public class Triple{

    String currentWord;
    String prefixWord;
    String suffixWord;


    public Triple(String word, String pre, String post){
        currentWord = word;
        prefixWord = pre;
        suffixWord = post;
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public String toString(){
        return currentWord + " = " + prefixWord + " + " + suffixWord;
    }
}
