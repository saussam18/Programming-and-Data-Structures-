import java.util.*;


/*

CSE 17
Sam Sausville
sps222
Program Description: Create Portmanteau words from a list and print out all of them in a ordered and specialized format
Program #8

 */
public class Portmanteau {
    Set<String> words;
    Map<String, List<String>> P = new HashMap<>();
    Map<String, List<String>> S = new HashMap<>();
    Set<String> portWords = new HashSet<>();
    List<Triple> triples = new ArrayList<>();

    public Portmanteau(Set<String> word){
        words = word;
        for(String next: words){
            int lengthHalf = next.length()-2;
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < lengthHalf; i++){
                String pre = next.substring(0, lengthHalf - i - 1);
                if(pre.length() > 1){ //No single letter prefix
                    temp.add(pre);
                }
            }
            P.put(next, temp);
        }
        for(String next: words){
            int lengthHalf = next.length()/2;
            List<String> temp = new ArrayList<>();
            for(int i = lengthHalf; i < next.length(); i++){
                String pre = next.substring(i);
                if(pre.length() > 1){ //No single letter suffix
                    temp.add(pre);
                }
            }
            S.put(next, temp);
        }
        createTripleList();
    }

    public void createTripleList(){
        for(String next : words){
            List<String> pre = P.get(next);
            for(int i = 0; i < pre.size(); i++){
                String prefix = pre.get(i);
                for(String next2 : words){
                    List<String> post = S.get(next2);
                    for(int j = 0; j < post.size(); j++){
                        String suffix = post.get(j);
                        String yeet = prefix + suffix;
                        if(!portWords.contains(yeet)){ //This is to shorten the list tremondously by not allowing repeat portmanteau words
                            portWords.add(yeet);
                            Triple t = new Triple(yeet, next, next2);
                            triples.add(t);
                        }
                    }

                }
            }

        }
    }



    public void print(){
        if (triples.size() > 0) { //Sorts the list
            Collections.sort(triples, new Comparator<Triple>() {
                @Override
                public int compare(final Triple object1, final Triple object2) {
                    return object1.getCurrentWord().compareTo(object2.getCurrentWord());
                }
            });
        }        int  count = 0;
        for(Triple t: triples){
            count++;
            System.out.println(t.toString());
        }
        System.out.println("Number of Words: " + count);
    }
}
