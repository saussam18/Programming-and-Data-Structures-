/*
CSE 17
Sam Sausville
sps222
Program Description: Find rhyming words based on the thesaurus
Program #5
*/
public class ThesaurusException extends Exception{
    public ThesaurusException(String message){
        System.out.println(message + " was not found within the thesaurus");
    }
}