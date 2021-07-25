package java.easy;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParenthesis {

    public static void main(String[] args) {
        System.out.println(isValid("{[])}"));
    }

    public static boolean isValid(String s) {
        Stack<String> stack = new Stack();
        String[] letters = s.split("");

        for (String letter : letters){
            if( letter.equals("(") || letter.equals("{") || letter.equals("[") ) {
                stack.push(letter);
                continue;
            } else {
                if(stack.isEmpty())
                  return false;
            }

            String top = stack.pop();
            if(top.equals("(") && letter.equals(")") ||
                top.equals("{") && letter.equals("}") ||
                top.equals("[") && letter.equals("]")){
                continue;
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
