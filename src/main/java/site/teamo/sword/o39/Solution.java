package site.teamo.sword.o39;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/21 15:45
 * @Description:
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * <p>
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= 数组长度 <= 50000
 */
public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        int result = nums[0];
        for (int num : nums) {
            if (counter.containsKey(num)) {
                int showNum = counter.get(num) + 1;
                if (showNum > nums.length / 2) return num;
                counter.put(num, showNum);
            } else {
                counter.put(num, 1);
            }
        }
        return result;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static void main(String[] args) {
        int i = new Solution().majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2});
        System.out.println(i);
    }
}
