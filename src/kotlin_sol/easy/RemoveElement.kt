package kotlin_sol.easy

/**
 * https://leetcode.com/problems/remove-element/
 */
class RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var targetCount = 0
        for (i in nums.indices) {
            if (nums[i] == `val`) {
                nums[i] = -1
                targetCount++
            }
        }

        for (i in nums.indices) {
            if (nums[i] == -1) {
                for (j in i until nums.size) {
                    if (nums[j] != -1) {
                        swap(nums, i, j)
                        break
                    }
                }
            }
        }

        return nums.size - targetCount
    }

    fun swap(nums: IntArray, i: Int, j: Int) {
        var temp: Int

        temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}

fun main() {
    val re = RemoveElement()
    val answer = re.removeElement(intArrayOf(10, 1, 2, 7, 6, 1, 5), 7)

    println("$answer")
}