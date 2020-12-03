package site.teamo.leetcode.q977;

/**
 * @author 爱做梦的锤子
 * @create 2020/12/1
 */

/**
 * 977. 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 */
public class Solution {

    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        for (int i = 0, j = A.length - 1, k = A.length - 1; i <= j; k--) {
            int i2 = A[i] * A[i];
            int j2 = A[j] * A[j];
            if (i2 < j2) {
                result[k] = j2;
                j--;
            } else {
                result[k] = i2;
                i++;
            }
        }
        int leetcode = 0;
        return result;
    }

    public static void main(String[] args) {
        int[] A = new int[]{-7,-3,2,3,11};
        int[] ints = new Solution().sortedSquares(A);
        System.out.println();
    }

}

