package site.teamo.sword.o49;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/24 15:53
 * @Description:
 */

/**
 * 剑指 Offer 49. 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 */
public class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = min(dp[index1] * 2, dp[index2] * 3, dp[index3] * 5);
            if (dp[i] == dp[index1] * 2) index1++;
            if (dp[i] == dp[index2] * 3) index2++;
            if (dp[i] == dp[index3] * 2) index3++;
        }
        return dp[n - 1];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
