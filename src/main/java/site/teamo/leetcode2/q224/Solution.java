package site.teamo.leetcode2.q224;

/**
 * @author 爱做梦的锤子
 * @create 2021/3/10 16:15
 */

import java.util.Stack;

/**
 * 224. 基本计算器
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 */

public class Solution {
    Stack<Character> operator = new Stack<>();
    Stack<Integer> number = new Stack<>();

    //(1+(4+5+2)-3)+(6+8)
    public int calculate(String s) {
        operator.clear();
        number.clear();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == '(') {
                operator.push(c);
            } else if (c == ')') {
                operator.pop();
                if (!operator.isEmpty()) {
                    Character op = operator.pop();
                    Integer num2 = number.pop();
                    Integer num1 = number.pop();
                    if (op == '+') {
                        number.push(num1 + num2);
                    } else {
                        number.push(num1 - num2);
                    }
                }
            } else if (c == '+') {
                operator.push(c);
            } else if (c == '-') {
                if (number.isEmpty()) {
                    number.push(0);
                }
                operator.push(c);
            } else if (c >= '0' && c <= '9') {
                StringBuilder sb = new StringBuilder();
                char temp = c;
                while (temp >= '0' && temp <= '9') {
                    sb.append(temp);
                    i++;
                    if (i >= s.length()) {
                        break;
                    }
                    temp = s.charAt(i);
                }
                i--;
                int num2 = Integer.valueOf(sb.toString());
                if (!operator.isEmpty() && operator.peek() != '(') {
                    Character op = operator.pop();
                    Integer num1 = number.pop();
                    if (op == '+') {
                        number.push(num1 + num2);
                    } else {
                        number.push(num1 - num2);
                    }
                } else {
                    number.push(num2);
                }
            }

        }
        return number.pop();
    }

    public static void main(String[] args) {
//        new Solution().calculate("(11+2+(41+5+2)-3)+(6+8)");
        new Solution().calculate(" -2-1 + 2 ");
    }
}
