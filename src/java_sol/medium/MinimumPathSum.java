package java_sol.medium;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] cost = new int[m][n];

        cost[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i>0 && j>0){
                    cost[i][j] = Math.min(cost[i-1][j], cost[i][j-1]) + grid[i][j];
                } else if(i == 0 && j>0){
                    cost[i][j] = cost[i][j-1] + grid[i][j];
                } else if(j == 0 && i>0){
                    cost[i][j] = cost[i-1][j] + grid[i][j];
                }
            }
        }

        return cost[m-1][n-1];
    }

    public static void main(String[] args){
        minPathSum(new int[][]{{1,2,3}, {4,5,6}});
    }
}
