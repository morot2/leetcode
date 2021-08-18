package java_sol.easy;

/**
 * https://leetcode.com/problems/implement-strstr/
 */
public class ImplementStrStr {

    public static int strStr(String haystack, String needle) {
        if (needle.equals("")) { return 0; }

        int result = -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) == needle.charAt(j)) {
                    if(j == needle.length() - 1)
                        return i;
                } else {
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
    }
}
