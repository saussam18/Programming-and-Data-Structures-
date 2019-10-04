/*
CSE 17
Sam Sausville
sps222
Program Description: To create a binary tree of an expression and learn how to use stacks as well as create an RPN cacluator
to evalute the expression
Program #7
*/

public class Prog7 {

    public static void main (String args[]){
        InFixToBinaryTreeConverter fp = new InFixToBinaryTreeConverter();
        fp.run("( ( 6 + 2 ) - 5 ) * 8 / 2");
        fp.run("3 + 5 * ( 2 + 4 ) ");
    }
}
