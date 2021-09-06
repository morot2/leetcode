package java_sol.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/permutations-ii/submissions/
 */
public class Permutation2 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> answer = new HashSet<>();

        if (nums == null) { return null; }
        if (nums.length == 1) {
            answer.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return answer.stream()
                         .collect(Collectors.toList());
        }

        Map<Integer, Integer> numsCount = getUniqueCountMap(nums);
        List current = new ArrayList<Integer>();

        dfs(numsCount, nums, current, answer);
        return answer.stream()
                     .collect(Collectors.toList());
    }

    private static Map<Integer, Integer> getUniqueCountMap(int[] nums) {
        Set<Integer> uniqueNums = Arrays.stream(nums)
                                        .boxed()
                                        .collect(Collectors.toSet());

        Map<Integer, Integer> numsCount = new HashMap();
        uniqueNums.forEach(uniqueNum -> numsCount.put(uniqueNum, 0));
        for (int num : nums)
            numsCount.replace(num, numsCount.get(num) + 1);
        return numsCount;
    }

    private static void dfs(Map<Integer, Integer> numsCount, final int[] nums, List<Integer> current, Set<List<Integer>> answer) {
        if (current.size() == nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if(numsCount.get(num) == 0) continue;

            current.add(num);
            numsCount.replace(num, numsCount.get(num)-1);
            dfs(numsCount, nums, current, answer);
            numsCount.replace(num, numsCount.get(num)+1);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Objects.requireNonNull(permuteUnique(new int[]{1, 1, 2}))
               .forEach(t ->
                     {
                         t.forEach(System.out::print);
                         System.out.println();
                     });
    }
}
