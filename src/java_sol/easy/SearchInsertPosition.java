package java_sol.easy;

/**
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        if(target < nums[0])
            return 0;

        if(target > nums[nums.length - 1])
            return nums.length;

        return binarySearch(0, nums.length - 1, nums, target);
    }

    public static int binarySearch(int left, int right, int[] nums, int target){
        int mid = (left + right) / 2;

        if(left == right -1){
            if(target == nums[left])
                return left;
            else
                return right;
        }

        if(nums[mid] == target){
            return mid;
        } else if(nums[mid] > target){
            return binarySearch(left, mid, nums, target);
        } else {
            return binarySearch(mid, right, nums, target);
        }
    }

    public static void main(String[] args){
        System.out.println(searchInsert(new int[]{1,3}, 3));
    }
}
