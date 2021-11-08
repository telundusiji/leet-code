package site.teamo.sword.o56;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/24 17:21
 * @Description:
 */

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 2 <= nums.length <= 10000
 */
public class Solution {
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum ^ num;
        }
        int flag = sum & (-sum);
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & flag) == 0) {
                result[0] = result[0] ^ num;
            } else {
                result[1] = result[1] ^ num;
            }
        }
        return result;
    }
}
