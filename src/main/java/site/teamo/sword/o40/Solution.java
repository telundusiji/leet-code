package site.teamo.sword.o40;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/21 16:10
 * @Description:
 */

import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[0];
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        int maxIndex = getMaxIndex(result);
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < result[maxIndex]) {
                result[maxIndex] = arr[i];
                maxIndex = getMaxIndex(result);
            }
        }
        return result;
    }

    private int getMaxIndex(int[] arr) {
        int index = 0;
        int max = arr[index];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                index = i;
                max = arr[i];
            }
        }
        return index;
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        if (arr.length == 0 || k == 0) return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int i : arr) {
            if (queue.size() < k) {
                queue.offer(i);
                continue;
            }
            if (i < queue.peek()) {
                queue.poll();
                queue.offer(i);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = queue.remove();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] leastNumbers = new Solution().getLeastNumbers(new int[]{0, 0, 1, 2, 4, 2, 2, 3, 1, 4}, 8);
        System.out.println(leastNumbers);
    }
}
