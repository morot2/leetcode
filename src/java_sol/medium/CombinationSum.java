package java_sol.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
    static List<List<Integer>> answer = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) { return answer; }
        backtracking(candidates, 0, target, new ArrayList<>());
        return answer;
    }

    private static void backtracking(final int[] candidates, int start, int target, List<Integer> current) {
        if (target == 0) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                current.add(candidates[i]);
                backtracking(candidates, i, target - candidates[i], current);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        combinationSum(new int[]{2, 3, 5}, 8)
            .stream()
            .forEach(t ->
                     {
                         t.stream().forEach(System.out::print);
                         System.out.println();
                     });
    }
}
