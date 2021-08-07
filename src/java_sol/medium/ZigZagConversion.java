package java_sol.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigZagConversion {
    public static void main(String[] args){
        System.out.println(convert("AB", 1));
    }

    public static String convert(String s, int numRows) {
        List<LinkedList<String>> lists = new ArrayList<>();

        int idx = 0;
        int direction = 1;
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i + 1);

            if(lists.size() < numRows)
                lists.add(new LinkedList<>());

            LinkedList<String> toPut = lists.get(idx);
            toPut.add(str);

            if( (direction == 1 && idx == numRows - 1) || ( direction ==-1 && idx == 0 ))
                direction *= -1;

            if( idx + direction >= 0 && idx + direction < numRows)
                idx += direction;
        }


        String result = "";
        for(LinkedList linkedList : lists){
            for (int i = 0; i < linkedList.size(); i++) {
                result += linkedList.get(i);
            }
        }

        return result;
    }
}
