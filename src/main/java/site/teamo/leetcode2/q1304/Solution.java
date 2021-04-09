package site.teamo.leetcode2.q1304;

/**
 * 1304. 和为零的N个唯一整数
 * 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：[-7,-1,1,3,4]
 * 解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：[-1,0,1]
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 */
public class Solution {
    public int[] sumZero(int n) {
        int last = 0;
        int[] result = new int[n];
        for (int i = 1; i < n; i++) {
            result[i - 1] = -i;
            last = last - i;
        }
        result[n - 1] = -last;
        return result;
    }
}
