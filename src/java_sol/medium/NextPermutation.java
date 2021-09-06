package java_sol.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {
    final static int NO_VALID = -1;

    public static void nextPermutation(int[] nums) {
        int baseIndexI = NO_VALID;
        int baseIndexJ = NO_VALID;
        for(int i = nums.length - 1; i >= 1; i--) {
            int j = i - 1;
            while(j >= 0){
                if(nums[i] > nums[j]) {
                    if(j > baseIndexJ){
                        baseIndexI = i;
                        baseIndexJ = j;
                    }

                    if( i == baseIndexI && j > baseIndexJ){
                        baseIndexI = i;
                        baseIndexJ = j;
                    }
                }
                j--;
            }
        }
        if(baseIndexJ != NO_VALID) {
            swap(nums, baseIndexI, baseIndexJ);
        }

        if(baseIndexJ != NO_VALID && baseIndexJ + 1 < nums.length - 1){
            for (int i = baseIndexJ + 1; i < nums.length - 1; i++) {
                for (int j  = i + 1; j < nums.length; j++) {
                    if(nums[i] > nums[j]){
                        swap(nums, i, j);
                    }
                }
            }
        }

        if(baseIndexJ == NO_VALID)
            Arrays.sort(nums);
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        nextPermutation(new int[]{3,2,1});
    }
}
