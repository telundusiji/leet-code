package site.teamo.sword.o21;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/16 20:21
 * @Description:
 */

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 */
public class Solution {
    public int[] exchange(int[] nums) {
        int p = 0;
        int q = nums.length - 1;
        while (p < q) {
            /**
             * 如果前面是奇数，前标后移一位
             */
            if (nums[p] % 2 == 1) {
                p++;
                continue;
            }
            /**
             * 如果后面的偶数，后标前移一位
             */
            if (nums[q] % 2 == 0) {
                q--;
                continue;
            }
            /**
             * 前面既不是奇数，后面既不是偶数，则交换
             */
            swap(nums, p, q);
            p++;
            q--;
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
