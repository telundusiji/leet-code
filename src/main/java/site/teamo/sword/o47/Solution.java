package site.teamo.sword.o47;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/22 16:36
 * @Description:
 */

/**
 * 剑指 Offer 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 */
public class Solution {
    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        dp[0][0] = 0;
        for (int h = 1; h < dp.length; h++) {
            for (int l = 1; l < dp[0].length; l++) {
                dp[h][l] = Math.max(dp[h][l - 1], dp[h - 1][l]) + grid[h - 1][l - 1];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
