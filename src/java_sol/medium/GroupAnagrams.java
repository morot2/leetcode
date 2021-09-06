package java_sol.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) { return new ArrayList<>(); }

        Map<String, Integer> map = new HashMap<>();
        List<List<String>> answer = new ArrayList<>();

        int mapNum = 0;
        for (int i = 0; i < strs.length; i++) {
            char[] strAsChar = strs[i].toCharArray();
            Arrays.sort(strAsChar);
            String key = new String(strAsChar);

            if(map.containsKey(key)){
                int mapNumber = map.get(key);
                List<String> item = answer.get(mapNumber);
                item.add(strs[i]);
                answer.set(mapNumber, item);
            } else {
                map.put(key, mapNum++);
                ArrayList<String> item = new ArrayList<>();
                item.add(strs[i]);
                answer.add(item);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        List<List<String>> answer = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
}
