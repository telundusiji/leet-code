package site.teamo.leetcode2.q331;

/**
 * @author 爱做梦的锤子
 * @create 2021/3/12 16:39
 */

/**
 * 331. 验证二叉树的前序序列化
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 * <p>
 * _9_
 * /   \
 * 3     2
 * / \   / \
 * 4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 * <p>
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 * <p>
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 * <p>
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "1,#"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: "9,#,#,1"
 * 输出: false
 */

public class Solution {
    public boolean isValidSerialization(String preorder) {
        int nullNumber = 0;
        for (int i = preorder.length() - 1; i >= 0; i--) {
            char c = preorder.charAt(i);
            if (c == ',') {
                continue;
            } else if (c == '#') {
                nullNumber++;
            } else {
                while ((i - 1) >= 0 && preorder.charAt(i - 1) >= '0' && preorder.charAt(i - 1) <= '9') {
                    i--;
                }
                if (nullNumber < 2) {
                    return false;
                } else {
                    nullNumber--;
                }
            }
        }
        return nullNumber == 1;
    }

    public static void main(String[] args) {
        new Solution().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }
}
