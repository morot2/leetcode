package kotlin_sol.easy

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
class ClimbingStairs {
    fun climbStairs(n: Int): Int {
        val mem = IntArray(n+2)
        mem[1] = 1
        mem[2] = 2

        return doClimb(n, mem)
    }

    private fun doClimb(n: Int, mem: IntArray): Int {
        if(mem[n] > 0)
            return mem[n]

        mem[n] = doClimb(n-1, mem) + doClimb(n-2, mem)
        return mem[n]
    }
}

fun main() {
    val cs = ClimbingStairs()
    print(cs.climbStairs(1))
}
