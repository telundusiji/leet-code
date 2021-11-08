package site.teamo.sword.o51;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/24 16:14
 * @Description:
 */

import java.util.Arrays;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 */
public class Solution {
    int counter = 0;

    public int reversePairs(int[] nums) {
        sort(nums, 0, nums.length);
        return counter;
    }

    private void sort(int[] nums, int start, int end) {
        if (end - start <= 1) {
            return;
        }
        int mid = (start + end) / 2;
        sort(nums, start, mid);
        sort(nums, mid, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] leftArray = Arrays.copyOfRange(nums, start, mid);
        int[] rightArray = Arrays.copyOfRange(nums, mid, end);
        for (int index = start, l = 0, r = 0; index < end; index++) {
            if (l >= leftArray.length) {
                System.arraycopy(rightArray, r, nums, index, rightArray.length - r);
                break;
            }
            if (r >= rightArray.length) {
                System.arraycopy(leftArray, l, nums, index, leftArray.length - l);
                break;
            }

            if (leftArray[l] > rightArray[r]) {
                nums[index] = rightArray[r];
                counter += leftArray.length - l;
                r++;
            } else {
                nums[index] = leftArray[l];
                l++;
            }
        }
    }


}
