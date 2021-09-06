package java_sol.easy;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;

        final int nullVal = -999;

        int lastOriginVal = nums[0];
        int numOfDuplicated = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nullVal && nums[i] == lastOriginVal){
                nums[i] = nullVal;
                numOfDuplicated++;
            } else {
                lastOriginVal = nums[i];
            }
        }

        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nullVal){
                for (int j = i + 1; j < nums.length; j++){
                    if(nums[j] != nullVal) {
                        swap(nums, i, j);
                        break;
                    }
                }
            }
        }

        return nums.length - numOfDuplicated;
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        removeDuplicates(new int[]{1,2});
    }
}
