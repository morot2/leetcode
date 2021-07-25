package java.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;

        int result = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(target - sum);

                if(diff == 0){
                    return sum;
                }

                if(diff < min){
                    min = diff;
                    result = sum;
                }
                if(sum <= target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }


    public static void main(String[] args){
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }
}
