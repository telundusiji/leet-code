package site.teamo.sword.o50;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/22 17:14
 * @Description:
 */

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例:
 * <p>
 * s = "abaccdeff"
 * 返回 "b"
 * <p>
 * s = ""
 * 返回 " "
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 50000
 */
public class Solution {
    public char firstUniqChar(String s) {
        int[] flag = new int['z' - 'a' + 1];
        for (int i = 0; i < s.length(); i++) {
            flag[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (flag[i] == 1) return s.charAt(i);
        }
        return ' ';
    }

    public static void main(String[] args) {
        new Solution().firstUniqChar("leetcode");
    }
}
