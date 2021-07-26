package kotlin_sol.easy

/**
 * https://leetcode.com/problems/shuffle-the-array/
 */

class ShuffleTheArray {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        val answer = IntArray(n * 2)

        for (i in 0..n*2-1){
            if(i%2==0)
                answer[i] = nums[i/2]
            else
                answer[i] = nums[(i-1)/2 + n]
        }
        return answer
    }
}

fun main() {
    val sh = ShuffleTheArray()
    for(value in sh.shuffle(intArrayOf(2,5,1,3,4,7), 3))
        println(value.toString())
}
