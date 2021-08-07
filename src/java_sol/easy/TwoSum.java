package java_sol.easy;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public static void main(String[] args){
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length; j++) {
                if((i != j) && (nums[i] + nums[j]) == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{0,1};
    }
}
