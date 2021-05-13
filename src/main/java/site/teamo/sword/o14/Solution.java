package site.teamo.sword.o14;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/13 19:41
 * @Description:
 */

/**
 * 剑指 Offer 14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 * <p>
 * 2 <= n <= 58
 */
public class Solution {
    public int cuttingRope(int n) {
        /**
         * dp记录每个长度的最优解
         */
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                /**
                 *  j即是将长度为i的绳子从第j处分割
                 *  Math.max(j*(i-j),j*dp[i-j]) 为了比较 j*(i-j)指的是分割一次后的乘积 和 j*dp[i-j]指
                 *  分割一次后，剩余部分继续分割后的最大乘积 取两者中大的一个
                 */
                dp[i] = Math.max(dp[i],
                        Math.max((i - j) * j, j * dp[i - j])
                );
            }
        }
        return dp[n];
    }
}
