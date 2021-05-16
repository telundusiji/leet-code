package site.teamo.sword.o17;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/14 15:50
 * @Description:
 */

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 用返回一个整数列表来代替打印
 * n 为正整数
 */
public class Solution {
    public int[] printNumbers(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('9');
        }
        int max = Integer.valueOf(sb.toString());
        int[] result = new int[max];
        for (int i = 0; i < result.length; i++) {
            result[i] = i+1;
        }
        return result;
    }
}
