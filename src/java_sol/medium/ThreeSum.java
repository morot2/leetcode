package java_sol.medium;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new LinkedList<>();

        if (nums == null || nums.length == 0) { return answer; }

        Arrays.sort(nums);

        for (int left = 0; left < nums.length - 2; left++) {
            if(left > 0 && nums[left] == nums[left - 1]) continue;;

            int medium = left + 1;
            int right = nums.length - 1;

            while (medium < right) {
                int sum = nums[left] + nums[medium] + nums[right];

                if (sum == 0) {
                    answer.add(Arrays.asList(nums[left], nums[medium], nums[right]));
                    medium++;
                    right--;
                    while (nums[medium] == nums[medium - 1] && medium < right) { medium++; }
                    while (nums[right] == nums[right + 1] && medium < right) { right--; }
                } else if (sum > 0) {
                    right--;
                } else {
                    medium++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4});
    }
}
