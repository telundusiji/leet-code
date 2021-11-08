package site.teamo.sword.o53;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/22 18:42
 * @Description:
 */

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int index = findIndex(nums, target);
        if (index == -1) return 0;
        int result = 1;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] == target) {
                result++;
            } else {
                break;
            }
        }
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] == target) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }

    public int findIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        for (; end - start > 1; ) {
            int mid = (end + start) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                start = mid;
            } else if (target < nums[mid]) {
                end = mid;
            }
        }
        if (target == nums[start]) {
            return start;
        }
        return -1;
    }

    public static void main(String[] args) {
        int search = new Solution().search(new int[]{}, 0);
        System.out.println(search);
    }
}
