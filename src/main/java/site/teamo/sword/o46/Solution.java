package site.teamo.sword.o46;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/22 15:57
 * @Description:
 */

import java.util.HashSet;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= num < 231
 */
public class Solution {
    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        int[] dp = new int[numStr.length()];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < numStr.length(); i++) {
            Integer r = Integer.valueOf(numStr.charAt(i - 2) + "" + numStr.charAt(i - 1));
            if (r >= 10 && r <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[dp.length - 1];
    }


    public static void main(String[] args) {
        int i = new Solution().translateNum(12258);
        System.out.println(i);
    }
}
