/*
CSE 17
Sam Sausville
sps222
Program Description: Create a data structure similar to a hashtable that instead uses links and nodes
Program #6


 */


public class Link <T> { //Not sure why we need a generic if we know its a char but whatever
    private T value;
    private Node next;
    private char yeet; //yeet is just the data value

    public Link(char yeet, Node node){
        this.yeet = yeet;
        this.next = node;
    }

    public char getYeet() {
        return yeet;
    }

    public Node getNext() {
        return next;
    }

}
