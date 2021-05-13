package site.teamo.sword.o13;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/13 10:26
 * @Description:
 */

import java.util.Comparator;
import java.util.function.Function;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */
public class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return count(0, 0, k, visited);
    }

    private int count(int i, int j, int k, boolean[][] visited) {
        if (i < 0 || i >= visited.length || j < 0 || j >= visited[0].length || visited[i][j] || compute(i, j, k)) {
            return 0;
        }

        visited[i][j] = true;
        return count(i + 1, j, k, visited)
                + count(i - 1, j, k, visited)
                + count(i, j + 1, k, visited)
                + count(i, j - 1, k, visited)
                + 1;
    }

    private boolean compute(int x, int y, int k) {
        return x / 10 + x % 10 + y / 10 + y % 10 > k;
    }
}
