import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
CSE 17
Sam Sausville
sps222
Program Description: Find rhyming words based on the thesaurus
Program #5
*/
public class Prog5 {

    public static void main(String[] args) throws IOException {
        if(args.length < 3){
            System.exit(0);
        }
        Thesaurus thesaurus = new Thesaurus("mthesaurEDIT.txt");
        PronouncingDictionary p = new PronouncingDictionary("cmudictEDIT.0.7a.txt", "cmudict.0.7a.phones.txt", thesaurus);
        String rootword = args[0];
        String rhymeWWord = args[1];
        int degree = Integer.parseInt(args[2]);
        List<String> rhymes = new ArrayList<>();
        try{
            rhymes = p.findRhymingSynonyms(rootword, rhymeWWord, degree);
        } catch (ThesaurusException e) {
            System.out.println(e);
            System.exit(0);
        }
        for(int i = 0; i < rhymes.size(); i++){
            System.out.println(rhymes.get(i));
        }
    }
}
