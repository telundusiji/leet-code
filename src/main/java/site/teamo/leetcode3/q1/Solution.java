package site.teamo.leetcode3.q1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 *
 * @author haocongshun
 * @date 2021/8/17 18:52
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new LinkedList<>());
            }
            map.get(nums[i]).add(i);
        }
        int[] ints = new int[2];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Integer need = target - entry.getKey();
            if (map.containsKey(need)) {
                ints[0] = entry.getValue().remove(0);
                ints[1] = map.get(need).get(0);
                return ints;
            }
        }
        return null;
    }

    public int[] twoSum1(int[] nums, int target) {
        int[] ints = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (nums[i] + nums[i] == target) {
                    ints[0] = map.get(nums[i]);
                    ints[1] = i;
                    return ints;
                }
            }
            map.put(nums[i], i);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int need = target - entry.getKey();
            if (map.containsKey(need)) {
                ints[1] = map.get(need);
                ints[0] = entry.getValue();
                return ints;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] ints = new Solution().twoSum1(new int[]{2, 7, 11, 15}, 9);
        System.out.println();
    }
}
