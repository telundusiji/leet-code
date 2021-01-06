package site.teamo.leetcode.q1512;

/**
 * @author 爱做梦的锤子
 * @create 2021/1/6
 */

import java.util.HashMap;

/**
 * 1512. 好数对的数目
 * 给你一个整数数组 nums 。
 * <p>
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 * <p>
 * 返回好数对的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1]
 * 输出：6
 * 解释：数组中的每组数字都是好数对
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */

public class Solution {
    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (counter.keySet().contains(nums[i])) {
                result = result + counter.get(nums[i]);
            }
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
        }
        return result;
    }

    public int numIdenticalPairs2(int[] nums) {
        int result = 0;
        int[] counter = new int[101];
        for (int i = 0; i < nums.length; i++) {
            if (counter[nums[i]] > 0) {
                result = result + counter[nums[i]];
            }
            counter[nums[i]]++;
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3});
    }
}
