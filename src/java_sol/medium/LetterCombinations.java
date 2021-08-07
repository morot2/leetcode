package java_sol.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {
    public static void main(String[] args){
        List<String> answer = letterCombinations("2");
        for(String str : answer){
            System.out.println(str);
        }
    }
    public static List<String> letterCombinations(String digits) {
        Map<String, String> dial = new HashMap<>();
        dial.put("2", "abc");
        dial.put("3", "def");
        dial.put("4", "ghi");
        dial.put("5", "jkl");
        dial.put("6", "mno");
        dial.put("7", "pqrs");
        dial.put("8", "tuv");
        dial.put("9", "wxyz");

        ArrayList answer = new ArrayList<>();

        if(digits.length() == 0)
            return Collections.emptyList();

        if(digits.length() == 1){
            String a = dial.get(digits);
            for (int i = 0; i < a.length(); i++)
                answer.add(a.substring(i,i+1));
            return answer;
        }

        if(digits.length() == 2){
            String a = dial.get(digits.substring(0,1));
            String b = dial.get(digits.substring(1,2));

            for (int i = 0; i < a.length(); i++) {
                for (int j = 0; j < b.length(); j++) {
                    answer.add(a.substring(i,i+1) + b.substring(j,j+1));
                }
            }

            return answer;
        }

        if(digits.length() == 3){
            String a = dial.get(digits.substring(0,1));
            String b = dial.get(digits.substring(1,2));
            String c = dial.get(digits.substring(2,3));

            for (int i = 0; i < a.length(); i++) {
                for (int j = 0; j < b.length(); j++) {
                    for (int k = 0; k < c.length(); k++) {
                        answer.add(a.substring(i,i+1) + b.substring(j,j+1) + c.substring(k,k+1));
                    }
                }
            }

            return answer;
        }

        if(digits.length() == 4){
            String a = dial.get(digits.substring(0,1));
            String b = dial.get(digits.substring(1,2));
            String c = dial.get(digits.substring(2,3));
            String d = dial.get(digits.substring(3,4));

            for (int i = 0; i < a.length(); i++) {
                for (int j = 0; j < b.length(); j++) {
                    for (int k = 0; k < c.length(); k++) {
                        for (int l = 0; l < d.length(); l++) {
                            answer.add(a.substring(i,i+1) + b.substring(j,j+1) + c.substring(k,k+1) + d.substring(l,l+1));
                        }
                    }
                }
            }

            return answer;
        }

        return answer;
    }
}
