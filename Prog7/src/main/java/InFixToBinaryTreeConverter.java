import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/*
CSE 17
Sam Sausville
sps222
Program Description: To create a binary tree of an expression and learn how to use stacks as well as create an RPN cacluator
to evalute the expression
Program #7
*/
public class InFixToBinaryTreeConverter {

    private LinkedList<String> inFix; //queue
    private ArrayList<String> stack; //stack
    private List<Node> bstack = new ArrayList<>(); //stack

    private String expression;

    public InFixToBinaryTreeConverter(){
        inFix = new LinkedList<>();
        stack =  new ArrayList<>();
        bstack = new ArrayList<>();
    }

    public void run (String s){
        expression = s;
        System.out.println(expression);
        String[] split = s.split("\\s+");
        createInFix(split);
        Node tree = createBinaryTree();
        System.out.println(inOrder(tree));
        System.out.println(preOrder(tree));
        String post = postOrder(tree);
        System.out.println(post);
        System.out.println(calculate(post));
    }

    private String calculate(String ex){
        stack.clear();
        String [] split = ex.split("\\s+");
        for(int i = 0; i < split.length; i++){
            if(!operatorCheck(split[i])){
                stack.add(split[i]);
            }else{
                int x = Integer.parseInt(stack.remove(stack.size()-1));
                int y = Integer.parseInt(stack.remove(stack.size()-1));
                if(split[i].equalsIgnoreCase("+")){
                    stack.add(String.valueOf(x+y));
                }else if(split[i].equalsIgnoreCase("-")){
                    stack.add(String.valueOf(y-x));
                }else if(split[i].equalsIgnoreCase("/")){
                    stack.add(String.valueOf(y/x));
                }else if(split[i].equalsIgnoreCase("*")){
                    stack.add(String.valueOf(x*y));
                }else{
                    System.out.println("Illegal expression");
                }
            }
        }
        return stack.remove(0);
    }
    private void createInFix(String[] split){
        for(int i = 0; i < split.length; i++){
            inFix.add(split[i]);
        }
    }

    private Node createBinaryTree(){
        stack.add(0, "(");
        inFix.add(")");
        while(!inFix.isEmpty()){
            String check = inFix.getFirst();
            inFix.removeFirst();
                Scanner scan = new Scanner(check);
                if(scan.hasNextInt()){
                    Node curr = new Node(check);
                    bstack.add(curr);
                }else if(check.equalsIgnoreCase("(")){
                    stack.add(check);
                }else if(operatorCheck(check)){
                    while(operatorCheck(stack.get(stack.size()-1)) && precedenceCheck(check, stack.get(stack.size()-1))){
                        Node r = bstack.remove(bstack.size() -1);
                        Node l = bstack.remove(bstack.size()-1);
                        Node curr = new Node(stack.remove(stack.size()-1), l, r);
                        bstack.add(curr);
                    }
                    stack.add(check);
                }else if(check.equalsIgnoreCase(")")){
                    while(!stack.get(stack.size()-1).equalsIgnoreCase("(")){
                        Node r = bstack.remove(bstack.size() -1);
                        Node l = bstack.remove(bstack.size()-1);
                        Node curr = new Node(stack.remove(stack.size()-1), l, r);
                        bstack.add(curr);
                    }
                    stack.remove(stack.size()-1);
                }else{
                    System.out.println("There a problem boyos");
                }
            }
            return bstack.remove(0);
        }

        private boolean operatorCheck(String check){
        if(check.equalsIgnoreCase("+") || check.equalsIgnoreCase("-") ||
                check.equalsIgnoreCase("/") || check.equalsIgnoreCase("*")){
            return true;
        }else{
            return false;
        }
        }
        private boolean precedenceCheck(String operation1, String operation2){
            if ((operation2.equalsIgnoreCase("*") || operation2.equalsIgnoreCase("/"))
                    && (operation1.equalsIgnoreCase("+") || operation1.equalsIgnoreCase("-"))){
                return false;
            }
            return true;
        }

        private String preOrder(Node start){
        String value = "";
        if(start == null){
            return "";
        }else{
            value = value + start.getValue() + " ";
            value = value + preOrder(start.getLeft());
            value = value + preOrder(start.getRight());
            return value;
            }
        }

        private String inOrder(Node start){
            String value = "";
            if(start == null){
                return "";
            }else{
                value = value + inOrder(start.getLeft());
                value = value + start.getValue() + " ";
                value = value + inOrder(start.getRight());
                return value;
            }
        }

    private String postOrder(Node start){
        String value = "";
        if(start == null){
            return "";
        }else{
            value = value + postOrder(start.getLeft());
            value = value + postOrder(start.getRight());
            value = value + start.getValue() + " ";

            return value;
        }
    }


}
