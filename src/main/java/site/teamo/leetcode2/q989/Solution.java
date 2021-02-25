package site.teamo.leetcode2.q989;

/**
 * @author 爱做梦的锤子
 * @create 2021/1/22
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 989. 数组形式的整数加法
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * <p>
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 示例 2：
 * <p>
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 * <p>
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 * <p>
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 * <p>
 * <p>
 * 提示：
 * <p>l
 * <p>
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 */
public class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<>();
        for (int i = A.length - 1; i >= 0 || K > 0; i--, K = K / 10) {
            if (i >= 0) {
                result.add(0, A[i] + K % 10);
            } else {
                result.add(0, K % 10);
            }
        }

        for (int i = result.size() - 1; i > 0; i--) {
            result.set(i - 1, result.get(i - 1) + result.get(i) / 10);
            result.set(i, result.get(i) % 10);
        }

        if (result.get(0) > 9) {
            result.add(0, result.get(0) / 10);
            result.set(1, result.get(1) % 10);
        }

        return result;
    }

    public static void main(String[] args) {
        new Solution().addToArrayForm(new int[]{9, 9, 9}, 12);
    }
}
