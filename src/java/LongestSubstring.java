package java;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if(s.equals("")) return 0;

        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<String> temp = new HashSet<>();

            for (int j = 0; j < s.length() - i; j++) {
                String substring = s.substring(i + j, i + j + 1);
                if(!temp.contains(substring)){
                    temp.add(substring);
                    if(temp.size() > maxLength)
                        maxLength = temp.size();
                } else {
                    break;
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
