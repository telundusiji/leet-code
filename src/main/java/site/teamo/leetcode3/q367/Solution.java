package site.teamo.leetcode3.q367;

/**
 * @author haocongshun
 * @date 2021/11/4 19:59
 */

/**
 * 367. 有效的完全平方数
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * <p>
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 16
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：num = 14
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 2^31 - 1
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int temp = num % 10;
        if (temp == 0
                || temp == 1
                || temp == 4
                || temp == 9
                || temp == 6
                || temp == 5) {
            int half = num / 2;
            for (int i = 1; i <= half; i++) {
                if (num % i == 0) {
                    if (num / i == i) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isPerfectSquare2(int num) {
        int temp = 1;
        while (true) {
            num = num - temp;
            if (num == 0) {
                return true;
            } else if (num < 0) {
                return false;
            }
            temp = temp + 2;
        }
    }

    public boolean isPerfectSquare3(int num) {
        int min = 1;
        int max = num;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int temp = num / mid;
            if (temp < mid) {
                max = mid - 1;
            } else if (temp > mid) {
                min = mid + 1;
            } else {
                if (num%mid == 0) return true;
                min = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Solution().isPerfectSquare3(2147483647);
    }
}
