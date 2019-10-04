import java.util.LinkedList;

/*
CSE 17
Sam Sausville
sps222
Program Description: Create a data structure similar to a hashtable that instead uses links and nodes
Program #6


 */


public class Bashtable<T> {
    private Node start;

    public Bashtable(){
        this.start =  new Node<T>(new LinkedList<>());
    }

    public void put (String key, T value){
        Node curr = start;
        for(int i = 0; i < key.length() - 1; i++){
            char c = key.charAt(i);
            curr.addWordCount();
            if(curr.containsLink(c) != null){
                curr.addWordCount();
                Link now = curr.containsLink(c);
                curr = now.getNext();
            }else{
                Node next = new Node<T>(new LinkedList<>());
                Link<T> other = new Link<T>(c, next);
                curr.addToList(other);
                curr = next;
            }
        }
        curr.addWordCount();
        char d = key.charAt(key.length()-1);
        if(curr.containsLink(d) != null){
            Link l = curr.containsLink(d);
            curr = l.getNext();
            curr.setValue(value);
        }else{
            Node<T> next = new Node<>(value, new LinkedList<>());
            Link<T> other = new Link<T>(d, next);
            curr.addToList(other);
        }
    }
    public T get(String key){
        Node curr = start;
        for(int i = 0; i < key.length() -1; i++){
            char c = key.charAt(i);
            Link l = curr.containsLink(c);
            if(l != null){
                curr = l.getNext();
            }else{
                return null;
            }
        }
        char d = key.charAt(key.length()-1);
        if(curr.containsLink(d) != null){
            Link l = curr.containsLink(d);
            curr = l.getNext();
            if(curr.getValue() != null){
                return (T) curr.getValue();
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    //Method for extra credit, should work fully but had to change the get and put methods just super slightly
    //Only added like 1 or 2 lines of code
    public void remove(String key){
        if(get(key) != null){
            Node curr = start;
            for(int i = 0; i < key.length() - 1; i++) {
                char c = key.charAt(i);
                Link l = curr.containsLink(c);
                if(l != null){
                    Node next = l.getNext();
                    char d = key.charAt(i + 1);
                    Link check = next.containsLink(d);
                    if(check != null){
                        next.minusWordCount();
                        if(next.getWordCount() <= 0){
                            next.linkRemove(check);
                        }else{
                            curr = next;
                        }
                    }else{
                        break;
                    }
                }else{
                    break;
                }
            }
            System.out.println("Word Removed");
        }else{
            System.out.println("Error: Word does not exist");
        }
    }
}
