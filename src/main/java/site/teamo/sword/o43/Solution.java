package site.teamo.sword.o43;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/22 14:51
 * @Description:
 */

/**
 * 剑指 Offer 43. 1～n 整数中 1 出现的次数
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：6
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= n < 2^31
 */
public class Solution {
    public int countDigitOne(int n) {
        int result = 0;
        for (int i = 0; i <= n; i++) {
            result += computer(i);
        }
        return result;
    }

    private int computer(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c == '1') count++;
        }
        return count;
    }
}
