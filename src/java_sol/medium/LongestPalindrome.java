package java_sol.medium;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if(isPalindrome(s)) return s;

        String maxStr = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);

                if(isPalindrome(substring) && substring.length() > maxStr.length())
                    maxStr = substring;
            }
        }

        return maxStr;
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++)
            if(s.charAt(i) != s.charAt(s.length() -1 - i)) return false;

        return true;
    }

    public static void main(String[] args){
        System.out.println(longestPalindrome("abb"));
    }

}
