/*
CSE 17
Sam Sausville
sps222
Program Description: To create a binary tree of an expression and learn how to use stacks as well as create an RPN cacluator
to evalute the expression
Program #7
*/

public class Node {

    private String value;
    private Node left;
    private Node right;

    public Node(String v){
        value = v;
        left = null;
        right = null;
    }

    public Node (String v, Node l, Node r){
        value = v;
        left = l;
        right = r;
    }


    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public String getValue() {
        return value;
    }
}
