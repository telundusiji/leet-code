package site.teamo.sword.o38;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/21 14:58
 * @Description:
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * <p>
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= s 的长度 <= 8
 */
public class Solution {
    public String[] permutation(String s) {
        HashSet<String> result = new HashSet<>();
        boolean[] visited = new boolean[s.length()];
        handle(s, visited, result, new StringBuilder());
        return result.toArray(new String[0]);
    }

    private void handle(String s, boolean[] visited, HashSet<String> result, StringBuilder sb) {
        if (sb.length() == s.length()) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            sb.append(s.charAt(i));
            handle(s, visited, result, sb);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        String[] abcs = new Solution().permutation("abc");
        System.out.println(abcs);
    }

}
