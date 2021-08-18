package kotlin_sol.medium

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
class FindElementPosition {
    fun searchRange(nums: IntArray, target: Int): IntArray {

        var result = intArrayOf(-1, -1)

        if(nums.size == 0)
            return result

        result[0] = binarySearch(nums, target, true)

        if(result[0] < 0 || result[0] > nums.size - 1 || result[0] == -1 || nums[result[0]] != target)
            result[0] = -1

        if(nums.size == 1 && result[0]!= -1){
            result[1] = result[0]
            return result
        }

        result[1] = binarySearch(nums, target, false) - 1

        if(result[1] > nums.size -1 || result[1] == -1 || nums[result[1]] != target)
            result[1] = -1

        return result
    }

    fun binarySearch(nums: IntArray, target: Int, isLeft: Boolean): Int {
        var left = 0
        var right = nums.size

        while (left < right) {
            val mid = (left + right) / 2
            if (nums[mid] > target || isLeft && nums[mid] == target)
                right = mid
            else
                left = mid + 1
        }

        return left
    }
}

fun main() {
    val fep = FindElementPosition()
    val searchRange = fep.searchRange(intArrayOf(2,2), 3)
    print(searchRange[0])
    print(searchRange[1])
}