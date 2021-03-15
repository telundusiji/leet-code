package site.teamo.leetcode2.q54;

/**
 * @author 爱做梦的锤子
 * @create 2021/3/15 15:39
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int xs = 0;
        int xe = matrix[0].length;
        int ys = 0;
        int ye = matrix.length;
        List<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);
        while (xe > xs && ye > ys) {
            result.addAll(handle(xs, xe, ys, ye).stream().map(xy -> matrix[xy.x][xy.y]).collect(Collectors.toList()));
            xs++;
            ys++;
            xe--;
            ye--;
        }
        return result;
    }

    /**
     * 00 01 02 03
     * 10 11 12 13
     * 20 21 22 23
     * <p>
     * 0,3,0,4 = 3*4-(3-2)*(4-2)=12-1*2=10
     *
     * 1,2,3,4,8,12,11,10,9,5,6,7
     */
    private List<XY> handle(int xs, int xe, int ys, int ye) {
        List<XY> xy = new ArrayList<>((xe - xs) * (ye - ys));
        int x = xs;
        int y = ys;
        if (xe - xs == 1) {
            for (; y < ye; y++) {
                xy.add(new XY(x, y));
            }
            return xy;
        }
        if (ye - ys == 1) {
            for (; x < xe; x++) {
                xy.add(new XY(x, y));
            }
            return xy;
        }
        while (true) {
            if (x == xs && y == ys + 1) {
                xy.add(new XY(x, y));
                break;
            }
            if (y == ys && x != xe - 1) {
                xy.add(new XY(x, y));
                x++;
            } else if (x == xe - 1 && y != ye - 1) {
                xy.add(new XY(x, y));
                y++;
            } else if (y == ye - 1 && x != xs) {
                xy.add(new XY(x, y));
                x--;
            } else if (x == xs && y != xs) {
                xy.add(new XY(x, y));
                y--;
            }
        }
        return xy;
    }

    private class XY {
        int x;
        int y;

        public XY(int x, int y) {
            this.x = y;
            this.y = x;
        }
    }


    public static void main(String[] args) {

        new Solution().handle(0, 2, 0, 3);
        new Solution().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});

    }

    /**
     * 00 01
     * 10 11
     * 20 21
     **/
}
