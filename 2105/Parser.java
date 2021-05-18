import java.util.*;
import java.util.Scanner;

import java.util.Stack;


// Write your code here. DO NOT use an access modifier in your class declaration.
class Parser{
    static String isBalanced(String s)
    {
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(Character c : s.toCharArray()){
            stack.add(c);
        }
        //() -> a / {} -> b

        while(!stack.isEmpty()){
            Character c = stack.pop();
            if(!stack2.isEmpty() && isPair(stack2.peek(), c)){
                stack2.pop();
                continue;
            }else{
                stack2.add(c);
            }

        }
        if(stack2.isEmpty()){
            return "true";
        }else{
            return "false";
        }
    }
    static boolean isPair(Character c1, Character c2){
        if(c2=='(' && c1==')') {
            return true;
        }
        if(c2=='{' && c1=='}') {
            return true;
        }
        return false;
    }

}
class Solution {

    public static void main(String[] args) {
        Parser parser = new Parser();

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            System.out.println(parser.isBalanced(in.next()));
        }

        in.close();
    }
}
