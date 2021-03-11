package site.teamo.leetcode2.q227;

/**
 * @author 爱做梦的锤子
 * @create 2021/3/11 15:27
 */

import java.util.Stack;

/**
 * 227. 基本计算器 II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 整数除法仅保留整数部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 * <p>
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 */

public class Solution {
    Stack<Character> operator = new Stack<>();
    Stack<Integer> number = new Stack<>();

    public int calculate(String s) {
        operator.clear();
        number.clear();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }

            if (c == '+' || c == '-' || c == '*' || c == '/') {
                ca(Integer.valueOf(sb.toString()), sb);
            }

            if (c == '+') {
                operator.push(c);
            } else if (c == '-') {
                if (number.isEmpty()) {
                    number.push(0);
                }
                operator.push(c);
            } else if (c == '*') {
                operator.push(c);
            } else if (c == '/') {
                operator.push(c);
            } else {
                if (c >= '0' && c <= '9') {
                    sb.append(c);
                }
            }

        }
        if (sb.length() > 0) {
            ca(Integer.valueOf(sb.toString()), sb);
        }
        if (number.size() > 1) {
            for (int i = 0; i < operator.size(); i++) {
                Character op = operator.get(i);
                Integer num1 = number.remove(0);
                Integer num2 = number.remove(0);
                if (op == '+') {
                    number.add(0, num1 + num2);
                } else {
                    number.add(0, num1 - num2);
                }
            }
        }
        return number.get(0);
    }

    private void ca(int num2, StringBuilder sb) {
        if (number.isEmpty()) {
            number.push(num2);
        } else {
            if (operator.peek() == '*' || operator.peek() == '/') {
                Character op = operator.pop();
                Integer num1 = number.pop();
                if (op == '*') {
                    number.push(num1 * num2);
                } else {
                    number.push(num1 / num2);
                }
            } else {
                number.push(num2);
            }
        }
        sb.delete(0, sb.length());
    }

    public static void main(String[] args) {
        new Solution().calculate("3+2*2");
    }
}
