package site.teamo.leetcode2.q628;

/**
 * @author 爱做梦的锤子
 * @create 2021/1/20
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 628. 三个数的最大乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 * <p>
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 */

public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int max1 = nums[0] * nums[1] * nums[nums.length - 1];
        int max2 = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        return max1 > max2 ? max1 : max2;
    }
}
