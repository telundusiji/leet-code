package site.teamo.leetcode.q1544;

/**
 * @author 爱做梦的锤子
 * @create 2020/12/4
 */

import java.util.Stack;

/**
 * 1544. 整理字符串
 * 给你一个由大小写英文字母组成的字符串 s 。
 * <p>
 * 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i+1]，其中 0<= i <= s.length-2 ，要满足如下条件:
 * <p>
 * 若 s[i] 是小写字符，则 s[i+1] 不可以是相同的大写字符。
 * 若 s[i] 是大写字符，则 s[i+1] 不可以是相同的小写字符。
 * 请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
 * <p>
 * 请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
 * <p>
 * 注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leEeetcode"
 * 输出："leetcode"
 * 解释：无论你第一次选的是 i = 1 还是 i = 2，都会使 "leEeetcode" 缩减为 "leetcode" 。
 * 示例 2：
 * <p>
 * 输入：s = "abBAcC"
 * 输出：""
 * 解释：存在多种不同情况，但所有的情况都会导致相同的结果。例如：
 * "abBAcC" --> "aAcC" --> "cC" --> ""
 * "abBAcC" --> "abBA" --> "aA" --> ""
 * 示例 3：
 * <p>
 * 输入：s = "s"
 * 输出："s"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 只包含小写和大写英文字母
 */

public class Solution {
    public String makeGood(String s) {
        char[] chars = new char[s.length()];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char ci = s.charAt(i);
            if (i == s.length() - 1) {
                chars[index] = ci;
                index++;
                continue;
            }
            char ci1 = s.charAt(i + 1);
            if ('a' <= ci && ci <= 'z' && 'A' <= ci1 && ci1 <= 'Z' && ci - 32 == ci1) {
                i++;
                continue;
            }

            if ('A' <= ci && ci <= 'Z' && 'a' <= ci1 && ci1 <= 'z' && ci + 32 == ci1) {
                i++;
                continue;
            }
            chars[index] = ci;
            index++;
        }
        return new String(chars).trim();
    }

    public static void main(String[] args) {
        String leEeetcode = new Solution().makeGood("abBAcC");
        System.out.println(leEeetcode);
    }
}
