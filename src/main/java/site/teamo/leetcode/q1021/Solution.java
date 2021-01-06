package site.teamo.leetcode.q1021;

/**
 * @author 爱做梦的锤子
 * @create 2020/12/4
 */

import java.util.Stack;

/**
 * 1021. 删除最外层的括号
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * <p>
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * <p>
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * <p>
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * 示例 2：
 * <p>
 * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * 示例 3：
 * <p>
 * 输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 * <p>
 * <p>
 * 提示：
 * <p>
 * S.length <= 10000
 * S[i] 为 "(" 或 ")"
 * S 是一个有效括号字符串
 */

public class Solution {

    public String removeOuterParentheses(String S) {
        Stack<Character> cache = new Stack<>();
        StringBuilder result = new StringBuilder();
        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == ')') {
                cache.pop();
                if (cache.isEmpty()) {
                    result.append(S.substring(start + 1, i));
                    start = i + 1;
                }
                continue;
            }
            cache.push(S.charAt(i));
        }
        return result.toString();
    }

    public String removeOuterParentheses2(String S) {
        int counter = 0;
        StringBuilder result = new StringBuilder();
        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == ')') {
                counter--;
                if (counter == 0) {
                    result.append(S.substring(start + 1, i));
                    start = i + 1;
                }
            } else {
                counter++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = new Solution().removeOuterParentheses("(()())");
        System.out.println(s);
    }
}
