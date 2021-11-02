package site.teamo.leetcode3.q9;

/**
 * @author haocongshun
 * @date 2021/11/2 20:13
 */

import java.util.LinkedList;
import java.util.List;

/**
 * 9. 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 * <p>
 * 输入：x = -101
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 */
public class Solution {
    public boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        for (int i = 0, j = num.length() - 1; i < j; i++, j--) {
            if (num.charAt(i) != num.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> nums = new LinkedList<>();
        while (x > 0) {
            nums.add(x % 10);
            x = x / 10;
        }
        for (int i = 0, j = nums.size() - 1; i < j; i++, j--) {
            if (nums.get(i) != nums.get(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        }
        int oldNum = x;
        int newNum = 0;
        while (oldNum > 0) {
            newNum = newNum * 10 + oldNum % 10;
            oldNum = oldNum / 10;
        }
        return (x ^ newNum) == 0;
    }

    public static void main(String[] args) {
        new Solution().isPalindrome3(121);
    }
}
