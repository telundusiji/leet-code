package site.teamo.sword.o61;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/23 16:32
 * @Description:
 */

import java.util.Arrays;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 * <p>
 * <p>
 * 限制：
 * <p>
 * 数组长度为 5
 * <p>
 * 数组的数取值为 [0, 13] .
 */
public class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int index = findIndex(nums);
        if (index == -1) return true;
        int countZero = countZero(nums);
        for (int i = index, start = nums[index]; i < nums.length; i++, start++) {
            if (nums[i] == start) continue;
            if (nums[i] < start) return false;
            if (countZero == 0) return false;
            i--;
            countZero--;
        }
        return true;
    }

    /**
     * 找到第一个非0数字的索引
     * @param nums
     * @return
     */
    public int findIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return i;
        }
        return -1;
    }

    /**
     * 计算0的数量
     * @param nums
     * @return
     */
    public int countZero(int[] nums) {
        int counter = 0;
        for (int num : nums) {
            if (num == 0) counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        boolean straight = new Solution().isStraight(new int[]{0, 1, 3, 4, 5});
        System.out.println(straight);
    }
}
