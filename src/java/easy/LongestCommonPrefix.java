package java.easy;

import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        String answer = "";

        final int min = Stream.of(strs)
                              .reduce((a, b) -> a.length() < b.length() ? a : b)
                              .get()
                              .length();

        outer : for (int i = 0; i < min; i++) {
            String commonString = strs[0].substring(i, i+1);
            for (int j = 0; j < strs.length; j++) {
                if(commonString.equals(strs[j].substring(i, i+1))){
                    if(j == strs.length - 1)
                        answer += commonString;
                } else {
                    break outer;
                }
            }
        }

        return answer;
    }

}
