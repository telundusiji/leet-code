package site.teamo.sword.o20;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/15 20:19
 * @Description:
 */

/**
 * 剑指 Offer 20. 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * <p>
 * 数值（按顺序）可以分成以下几个部分：
 * <p>
 * 若干空格
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 若干空格
 * 小数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分数值列举如下：
 * <p>
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * 部分非数值列举如下：
 * <p>
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "0"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "e"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：s = "."
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：s = "    .1  "
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 20
 * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。
 */
public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s == null || s.length() <= 0) {
            return false;
        }
        boolean isNumber = false;
        boolean hasE = false;
        boolean hasPoint = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isNum(c)) {
                isNumber = true;
            } else if (c == 'e' || c == 'E') {
                /**
                 * 之前出现过e则返回false
                 */
                if (hasE) {
                    return false;
                }
                /**
                 * e出现在第一位和最后一位返回false
                 */
                if (i == 0 || i == s.length() - 1) {
                    return false;
                }
                if (!isNum(s.charAt(i - 1)) && s.charAt(i - 1) != '.') {
                    return false;
                }
                hasE = true;
            } else if (c == '+' || c == '-') {
                if (i == s.length() - 1) {
                    return false;
                }
                /**
                 * +-符号出现在开头，进行下次循环
                 */
                if (i == 0) continue;
                /**
                 * +-符号不在开头，且前一位是e，进行下次循环
                 */
                if (s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E') continue;
                /**
                 * +-不是以上情况则，返回false
                 */
                return false;
            } else if (c == '.') {
                if (hasPoint || hasE) {
                    return false;
                }
                if (s.length() == 1) {
                    return false;
                }
                /**
                 * 点在最后一位，并且在e后面，返回false
                 */
                if (i == s.length() - 1 && (hasE || !isNum(s.charAt(i - 1)))) {
                    return false;
                }
                /**
                 * 点的下一个不是数字返回false
                 */
                if (i + 1 < s.length()) {
                    if (!isNum(s.charAt(i + 1)) && s.charAt(i + 1) != 'e' && s.charAt(i + 1) != 'E') {
                        return false;
                    }
                }
                if (i == 1 && s.charAt(i - 1) != '+' && s.charAt(i - 1) != '-' && !isNum(s.charAt(i - 1))) {
                    return false;
                }
                if (i > 1) {

                    if (!isNum(s.charAt(i - 1))) {
                        return false;
                    }
                }
                hasPoint = true;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        boolean number = new Solution().isNumber(".e1");
        System.out.println(number);
    }
}
