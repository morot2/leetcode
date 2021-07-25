package java.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/integer-to-roman/
 */
//TODO : 다시 풀어보기
public class IntegerToRoman {

    public static void main(String[] args){
        System.out.println(intToRoman(660));
    }

    public static String intToRoman(int num) {
        String answer = "";

        Map romanMap = getRomanMap();
        List<Integer> parsedNum = parseNum(num);

        for (int i = 0; i < parsedNum.size(); i++) {
            int n = parsedNum.get(i);
            int headOfN = Integer.parseInt(Integer.toString(n).substring(0, 1));
            int digitOfN = Integer.toString(n).length();

            if(romanMap.containsKey(n)){
                answer += romanMap.get(n);
            } else if(headOfN == 4 || headOfN == 9){
                int head = 1;
                int base = 5;

                if(headOfN == 9) base = 1;

                for (int j = 0; j < digitOfN; j++) {
                    base *= 10;
                    head *= 10;
                }


                head /= 10;
                if(headOfN == 4) base /= 10;

                answer += romanMap.get(head);
                answer += romanMap.get(base);
            } else {
                int base = 1;
                for (int j = 0; j < digitOfN - 1; j++) {
                    base *= 10;
                }

                if(headOfN > 5) {
                    answer += romanMap.get(5 * base);
                    headOfN -= 5;
                }


                for (int j = 0; j < headOfN; j++) {
                    answer += romanMap.get(base);
                }
            }
        }
        return answer;
    }

    private static List<Integer> parseNum(int num) {
        List parsedNum = new ArrayList<>();

        final int divider = 10;
        int digit = 1;

        int length = Integer.toString(num).length();
        for (int i = 0; i < length; i++) {
            int parsed = (num % divider) * digit;
            if(parsed != 0)
                parsedNum.add( (num % divider) * digit );
            num /= divider;
            digit *= 10;
        }

        Collections.reverse(parsedNum);
        return parsedNum;
    }

    private static Map<Integer, String> getRomanMap() {
        Map<Integer, String> roman = new HashMap();

        roman.put(1, "I");
        roman.put(5, "V");
        roman.put(10, "X");
        roman.put(50, "L");
        roman.put(100, "C");
        roman.put(500, "D");
        roman.put(1000, "M");

        return roman;
    }
}
