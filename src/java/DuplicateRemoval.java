package java;

import java.util.Stack;

public class DuplicateRemoval {
    public static String removeDuplicates(String s) {
        Stack<String> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.push(s.substring(i,i+1));
            } else {
                String top = stack.pop();
                String next = s.substring(i, i + 1);
                if (!top.equals(next)) {
                    stack.push(top);
                    stack.push(next);
                }
            }
        }

        s = "";
        while(!stack.isEmpty())
            s = stack.pop() + s;

        return s;
    }

    public static void main(String[] args){
        System.out.println(removeDuplicates("abbaca"));
    }
}
