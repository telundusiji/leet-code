package site.teamo.sword.o57;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/23 15:37
 * @Description:
 */

/**
 * 剑指 Offer 57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * <p>
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (find(nums, target - nums[i])) {
                result[0] = nums[i];
                result[1] = target - nums[i];
                return result;
            }
        }
        return new int[0];
    }

    /**
     * 二分查找判断，数字是否在数组中
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean find(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target < nums[mid]) end = mid - 1;
            if (target > nums[mid]) start = mid + 1;
            if (target == nums[mid]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = new Solution().find(new int[]{1, 2, 4, 6, 8}, 7);
        System.out.println(b);
    }
}
