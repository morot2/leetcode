package java_sol.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/permutations/
 */
public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        if (nums == null) { return null; }
        if (nums.length == 1) {
            answer.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return answer;
        }

        List current = new ArrayList<Integer>();
        dfs(nums, current, answer);
        return answer;
    }

    private static void dfs(final int[] nums, List<Integer> current, List<List<Integer>> answer) {
        if (current.size() == nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (current.contains(num)) { continue; }

            current.add(num);
            dfs(nums, current, answer);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        permute(new int[]{1, 2, 3})
            .forEach(t ->
                     {
                         t.forEach(System.out::print);
                         System.out.println();
                     });
    }
}
