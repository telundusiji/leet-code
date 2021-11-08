package site.teamo.sword.o57;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/23 16:02
 * @Description:
 */

import java.util.LinkedList;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 */
public class Solution2 {
    public int[][] findContinuousSequence(int target) {
        LinkedList<int[]> list = new LinkedList<>();
        int end = target / 2 + 1;
        for (int i = 1; i < end; i++) {
            int find = find(i, target);
            if (find == -1) continue;
            list.add(build(i, find));
        }
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public int find(int start, int target) {
        for (; target > 0; start++) {
            target = target - start;
            if (target == 0) return start;
        }
        return -1;
    }

    public int[] build(int start, int end) {
        int[] array = new int[end - start + 1];
        for (int i = 0; start <= end; start++, i++) {
            array[i] = start;
        }
        return array;
    }

    public static void main(String[] args) {
        int[][] continuousSequence = new Solution2().findContinuousSequence(9);
        System.out.println(continuousSequence);
    }
}
