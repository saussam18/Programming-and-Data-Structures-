import java.util.List;
/*
CSE 17
Sam Sausville
sps222
Program Description: Create a data structure similar to a hashtable that instead uses links and nodes
Program #6


 */



public class Node <T> {
    private T value;
    private List<Link> list;
    private int wordCount;

    public Node(T value, List<Link> list){
        wordCount = 1;
        this.value = value;
        this.list = list;
    }
    public Node(List<Link> list){
        this.list = list;
    }

    public void addToList(Link link){
        list.add(link);
    }

    public Link containsLink(char c){ //Want to return null if it doesnt contain
        for(int i = 0; i < list.size(); i++){
            Link curr = list.get(i);
            char d = curr.getYeet();
            if(c == d){
                return curr;
            }
        }
        return null;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public int getWordCount() {
        return wordCount;
    }
    public void addWordCount(){
        wordCount++;
    }
    public void minusWordCount(){
        wordCount--;
    }
    public void linkRemove(Link link){
        list.remove(link);
    }
}
