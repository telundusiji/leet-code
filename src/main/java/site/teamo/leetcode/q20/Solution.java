package site.teamo.leetcode.q20;

/**
 * @author 爱做梦的锤子
 * @create 2020/12/4
 */

import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */

public class Solution {
    public boolean isValid(String s) {
        if (s == null || "".equals(s.trim())) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> cache = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                cache.push(c);
            } else {
                if (cache.isEmpty()) {
                    return false;
                }
                Character pop = cache.pop();
                if (c == ')' && pop != '(') {
                    return false;
                }
                if (c == ']' && pop != '[') {
                    return false;
                }
                if (c == '}' && pop != '{') {
                    return false;
                }
            }
        }
        return cache.isEmpty();
    }

    public static void main(String[] args) {
        boolean valid = new Solution().isValid("([])}");
        System.out.println(valid);
    }
}
