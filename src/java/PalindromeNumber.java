package java;

import java.util.Stack;

public class PalindromeNumber {

    public static void main(String[] args){
        System.out.println(isPalindrome(1));
    }

    public static boolean isPalindrome(int x) {
        if(x < 0) return false;

        String strX = Integer.toString(x);

        for (int i = 0; i < strX.length() / 2; i++)
            if(strX.charAt(i) != strX.charAt(strX.length() -1 - i)) return false;

        return true;
    }
}
