import java.io.*;
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
public class PronouncingDictionary{
    private Thesaurus thesaurus;
    private Map<String, List<String>> wordList = new HashMap<>();
    private Map<String, Boolean> isVowel = new HashMap<>();

    public PronouncingDictionary(String wordListFile, String phonemeFile, Thesaurus thesaurus) throws IOException {
        this.thesaurus = thesaurus;
        try{
            BufferedReader in = new BufferedReader(new FileReader(wordListFile));
            String line = "";
            while((line = in.readLine()) != null){
                if(line.contains(";;;")){
                    continue;
                }
                String [] words = line.split(" ");
                List<String> phonemeList = new ArrayList<>();
                for(int i = 1; i < words.length; i++){
                    String remove = words[i];
                    remove = remove.replaceAll("\\d","");
                    phonemeList.add(remove);
                }
                String lookupWord = words[0];
                lookupWord = lookupWord.replaceAll("\\d","");
                wordList.put(lookupWord, phonemeList);
            }
            in.close();
        } catch(FileNotFoundException ex) {
            System.out.println(ex);
        }

        try{
            BufferedReader buff = new BufferedReader(new FileReader(phonemeFile));
            String next = "";
            while((next = buff.readLine()) != null){
                String [] words = next.split("\\s");
                String first = words[0];
                String check = words[1];
                if(check.equalsIgnoreCase("Vowel")){
                    isVowel.put(first, true);
                }else{
                    isVowel.put(first, false);
                }
            }
            buff.close();
        }catch (FileNotFoundException ex){
            System.out.println(ex);
        }
        }

        private int rhymePhoneCount(String word1, String word2){
        word1 = word1.toUpperCase();
        word2 = word2.toUpperCase();
            int vowelCount = 0;
            if(!wordList.containsKey(word1) || !wordList.containsKey(word2)){
                return 0;
            }
            List<String> list1 = wordList.get(word1);
            List<String> list2 = wordList.get(word2);
            int smallSize = list1.size();
            if(list2.size() < smallSize){
                smallSize = list2.size();
            }
            for(int i = 1 ; i < smallSize; i++){
                String phone1 = list1.get(list1.size()-i);
                String phone2 = list2.get(list2.size()-i);
                if(phone1.equalsIgnoreCase(phone2)){
                    if(isVowel.get(phone1.toUpperCase())){
                        vowelCount++;
                    }
                }else{
                    return vowelCount;
                }
            }
            return vowelCount;
        }
        public List<String> findRhymingSynonyms(String rootWord, String rhymeWord, int degree) throws ThesaurusException {

        List<String> synonyms = thesaurus.getSynonyms(rootWord);
        List<String> matches = new ArrayList<>();

        for(int i = 0; i < synonyms.size(); i++){
            if(rhymePhoneCount(synonyms.get(i), rhymeWord) >= degree){
                matches.add(synonyms.get(i));
            }
        }
            return matches;
        }
}