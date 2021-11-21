package site.teamo.leetcode3.q13;

/**
 * @author haocongshun
 * @date 2021/11/16 19:43
 */

/**
 * 13. 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "III"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: s = "IV"
 * 输出: 4
 * 示例 3:
 * <p>
 * 输入: s = "IX"
 * 输出: 9
 * 示例 4:
 * <p>
 * 输入: s = "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: s = "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 15
 * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
 * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
 * <p>
 * * I             1
 * * V             5
 * * X             10
 * * L             50
 * * C             100
 * * D             500
 * * M             1000
 */
public class Solution {
    public int romanToInt(String s) {
        int result = 0;
        s = s + "_";
        for (int i = 0; i < s.length() - 1; i++) {
            char temp = s.charAt(i);
            if (temp == 'I') {
                if (s.charAt(i + 1) == 'V') {
                    result = result + 4;
                    i++;
                } else if (s.charAt(i + 1) == 'X') {
                    result = result + 9;
                    i++;
                } else {
                    result = result + 1;
                }
            } else if (temp == 'V') {
                result = result + 5;
            } else if (temp == 'X') {
                if (s.charAt(i + 1) == 'L') {
                    result = result + 40;
                    i++;
                } else if (s.charAt(i + 1) == 'C') {
                    result = result + 90;
                    i++;
                } else {
                    result = result + 10;
                }
            } else if (temp == 'L') {
                result = result + 50;
            } else if (temp == 'C') {
                if (s.charAt(i + 1) == 'D') {
                    result = result + 400;
                    i++;
                } else if (s.charAt(i + 1) == 'M') {
                    result = result + 900;
                    i++;
                } else {
                    result = result + 100;
                }
            } else if (temp == 'D') {
                result = result + 500;
            } else {
                result = result + 1000;
            }
        }
        return result;
    }

    public int romanToInt1(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int temp = getNumber(s.charAt(i));
            int tempNext = getNumber(s.charAt(i + 1));
            if (temp < tempNext) {
                result = result - temp;
            } else {
                result = result + temp;
            }
        }
        return result + getNumber(s.charAt(s.length() - 1));
    }

    private int getNumber(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
