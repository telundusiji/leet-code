package site.teamo.leetcode3.q1404;

/**
 * @@author: 爱做梦的锤子
 * @date: 2021/11/8 20:12
 */

import java.util.Arrays;

/**
 * 1404. 将二进制表示减到 1 的步骤数
 * 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
 * <p>
 * 如果当前数字为偶数，则将其除以 2 。
 * <p>
 * 如果当前数字为奇数，则将其加上 1 。
 * <p>
 * 题目保证你总是可以按上述规则将测试用例变为 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1101"
 * 输出：6
 * 解释："1101" 表示十进制数 13 。
 * Step 1) 13 是奇数，加 1 得到 14
 * Step 2) 14 是偶数，除 2 得到 7
 * Step 3) 7  是奇数，加 1 得到 8
 * Step 4) 8  是偶数，除 2 得到 4
 * Step 5) 4  是偶数，除 2 得到 2
 * Step 6) 2  是偶数，除 2 得到 1
 * 示例 2：
 * <p>
 * 输入：s = "10"
 * 输出：1
 * 解释："10" 表示十进制数 2 。
 * Step 1) 2 是偶数，除 2 得到 1
 * 示例 3：
 * <p>
 * 输入：s = "1"
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s 由字符 '0' 或 '1' 组成。
 * s[0] == '1'
 */

public class Solution {
    public int numSteps(String s) {
        int result = 0;
        int carry = 0;
        int nextCarry = 0;
        for (int index = s.length()-1; index >= 0; index--) {
            if(index == 0 && carry==0){
                break;
            }
            result++;
            char current = s.charAt(index);
            if (current == '0' && carry == 0) {
                if (nextCarry == 1) {
                    carry = 1;
                    nextCarry = 0;
                }
                continue;
            } else if (current == '0' && carry == 1) {
                index++;
                nextCarry = 1;
                carry = 0;
            } else if (current == '1' && carry == 0) {
                index++;
                carry = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int i = new Solution().numSteps("101");
    }
}
