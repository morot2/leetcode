package java_sol.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums)
            set.add(num);

        int min = 1;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if(!set.contains(i)) {
                min = i;
                break;
            }
        }

        return min;
    }

    public static void main(String[] args){
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
    }
}
