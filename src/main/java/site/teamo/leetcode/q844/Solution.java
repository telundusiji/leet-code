package site.teamo.leetcode.q844;

/**
 * @author 爱做梦的锤子
 * @create 2020/12/4
 */

import java.util.Scanner;
import java.util.Stack;

/**
 * 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 */

public class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> SCache = scan(S);
        Stack<Character> TCache = scan(T);
        if (SCache.size() != TCache.size()) {
            return false;
        }
        while (!SCache.isEmpty()) {
            if (SCache.pop() != TCache.pop()) {
                return false;
            }
        }
        return true;
    }

    private Stack<Character> scan(String s) {
        Stack<Character> cache = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!cache.isEmpty()) {
                    cache.pop();
                }
                continue;
            }
            cache.push(s.charAt(i));
        }
        return cache;
    }

    public static void main(String[] args) {
        boolean b = new Solution().backspaceCompare("abcd", "bbcd");
        System.out.println(b);
    }
}
