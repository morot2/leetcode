package kotlin_sol.medium

/**
 * https://leetcode.com/problems/combination-sum-ii/
 */
class CombinationSum2 {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        var answer = arrayListOf(arrayListOf<Int>());

        if (candidates.isEmpty())
            return answer

        candidates.sort()

        var current = arrayListOf<Int>()
        backtracking(answer, candidates, target, current, 0)
        answer.remove(arrayListOf())
        return answer
    }

    private fun backtracking(answer: ArrayList<ArrayList<Int>>, candidates: IntArray, target: Int, current: ArrayList<Int>, start: Int) {
        if (target == 0) {
            if (!answer.contains(current))
                answer.add(ArrayList(current))
            return
        }
        if(target < 0)
            return

        for (i in start until candidates.size) {
            if(i > start && candidates[i] == candidates[i-1]) continue

            if (target - candidates[i] >= 0) {
                current.add(candidates[i])
                backtracking(answer, candidates, target - candidates[i], current, i+1)
                current.removeAt(current.size - 1)
            }
        }
    }
}

fun main() {
    val combinationSum2 = CombinationSum2()
    val answer = combinationSum2.combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8)

    println("$answer")
}