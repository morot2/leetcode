package java_sol.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/4sum/
 */
public class FourSum {
    static List<List<Integer>> answer = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length == 0) { return answer; }

        Arrays.sort(nums);
        dfs(nums, target, 0);
        return answer;
    }

    private static void dfs(final int[] nums, final int target, int start) {
        if (temp.size() == 4) {
            if (temp.stream().reduce(Integer::sum).get() == target
                && !contain(answer, temp)) {
                answer.add(new ArrayList<>(temp));
            }
            return;
        }

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums, target, i + 1);
            temp.remove(Integer.valueOf(nums[i]));
        }
    }

    private static boolean contain(List<List<Integer>> answer, List<Integer> temp) {
        boolean contain = false;
        for (List<Integer> temps : answer) {
            contain = true;
            int index = 0;
            for (Integer val : temps) {
                if (!val.equals(temp.get(index))) {
                    contain = false;
                    break;
                }
                index++;
            }
            if(contain) return true;
        }

        return contain;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
    }
}
