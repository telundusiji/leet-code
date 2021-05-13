package site.teamo.sword.o12;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/13 09:52
 * @Description:
 */

/**
 * 剑指 Offer 12. 矩阵中的路径
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * board 和 word 仅由大小写英文字母组成
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (hasNext(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasNext(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        /**
         * 越界或者已经访问过均返回false
         */
        if (i < 0
                || i >= board.length
                || j < 0
                || j >= board[0].length
                || visited[i][j]) {
            return false;
        }
        /**
         * 当前位置字符与word中字符不匹配返回false
         */
        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        /**
         * 当前字符与word中字符匹配且是最后一个字符，返回true
         */
        if (index == word.length() - 1) {
            return true;
        }

        visited[i][j] = true;
        boolean result = false;
        result = hasNext(board, i - 1, j, word, index + 1, visited)
                || hasNext(board, i + 1, j, word, index + 1, visited)
                || hasNext(board, i, j - 1, word, index + 1, visited)
                || hasNext(board, i, j + 1, word, index + 1, visited);
        visited[i][j] = false;

        return result;
    }
}
