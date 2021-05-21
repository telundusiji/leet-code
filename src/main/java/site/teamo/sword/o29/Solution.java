package site.teamo.sword.o29;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/17 18:32
 * @Description:
 */

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 */
public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int[] result = new int[matrix.length * matrix[0].length];
        printHangHead(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, result, 0);
        return result;
    }

    /**
     * 打印上方行
     * @param matrix
     * @param hs 开始行
     * @param he 结束行
     * @param ls 开始列
     * @param le 结束列
     * @param result 最终存储结果
     * @param index 存储结果的数组索引
     */
    public void printHangHead(int[][] matrix, int hs, int he, int ls, int le, int[] result, int index) {
        if (isEnd(hs, he, ls, le)) return;
        for (int i = ls; i <= le; i++) {
            result[index++] = matrix[hs][i];
        }
        printLieRight(matrix, hs + 1, he, ls, le, result, index);
    }

    /**
     * 打印下方行
     * @param matrix
     * @param hs 开始行
     * @param he 结束行
     * @param ls 开始列
     * @param le 结束列
     * @param result 最终存储结果
     * @param index 存储结果的数组索引
     */
    public void printHangBottom(int[][] matrix, int hs, int he, int ls, int le, int[] result, int index) {
        if (isEnd(hs, he, ls, le)) return;
        for (int i = le; i >= ls; i--) {
            result[index++] = matrix[he][i];
        }
        printLieLeft(matrix, hs, he - 1, ls, le, result, index);
    }

    /**
     * 打印左侧列
     * @param matrix
     * @param hs 开始行
     * @param he 结束行
     * @param ls 开始列
     * @param le 结束列
     * @param result 最终存储结果
     * @param index 存储结果的数组索引
     */
    public void printLieLeft(int[][] matrix, int hs, int he, int ls, int le, int[] result, int index) {
        if (isEnd(hs, he, ls, le)) return;
        for (int i = he; i >= hs; i--) {
            result[index++] = matrix[i][ls];
        }
        printHangHead(matrix, hs, he, ls + 1, le, result, index);
    }

    /**
     * 打印右侧列
     * @param matrix
     * @param hs 开始行
     * @param he 结束行
     * @param ls 开始列
     * @param le 结束列
     * @param result 最终存储结果
     * @param index 存储结果的数组索引
     */
    public void printLieRight(int[][] matrix, int hs, int he, int ls, int le, int[] result, int index) {
        if (isEnd(hs, he, ls, le)) return;
        for (int i = hs; i <= he; i++) {
            result[index++] = matrix[i][le];
        }
        printHangBottom(matrix, hs, he, ls, le - 1, result, index);
    }

    /**
     * 判断是否结束
     * @param hs
     * @param he
     * @param ls
     * @param le
     * @return
     */
    private boolean isEnd(int hs, int he, int ls, int le) {
        if (hs > he || ls > le) {
            return true;
        }
        return false;
    }
}
