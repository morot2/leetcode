package java.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 */
public class MaxConsecutiveOne3 {
    public static int longestOnes(int[] nums, int k) {
        int max = 0;

        Deque<Integer> q = new LinkedList<>();

        int flipCount = k;
        for(int n : nums){
            if(n == 1){
                q.addLast(1);
                max = Math.max(q.size(), max);
            } else {
                if(flipCount > 0){
                    q.addLast(0);
                    max = Math.max(q.size(), max);
                    flipCount--;
                } else {
                    while(!q.isEmpty()){
                        int first = q.pollFirst();

                        if(first == 0){
                            q.addLast(0);
                            max = Math.max(q.size(), max);
                            break;
                        }
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args){
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
