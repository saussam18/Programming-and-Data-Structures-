import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
CSE 17
Sam Sausville
sps222
Program Description: Find rhyming words based on the thesaurus
Program #5
*/
public class Thesaurus{
    private Map<String, List<String>> synonyms = new HashMap<>();

    public Thesaurus(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
            String line = "";
            while((line = in.readLine()) != null){
                String [] words = line.split(",");
                String lookupWord = words[0];
                List<String> synonymList = new ArrayList<>();
                for(int i = 1; i < words.length; i++){
                    synonymList.add(words[i]);
                }
                synonyms.put(lookupWord, synonymList);
            }
    }
    public List<String> getSynonyms(String lookupWord) throws ThesaurusException{
        if(synonyms.get(lookupWord) != null){
            return synonyms.get(lookupWord);
        }else{
            throw new ThesaurusException(lookupWord);
        }
    }
/* just used for debuging purposes
    public void printList(String yeet){
        List<String> list = synonyms.get(yeet);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }*/
}