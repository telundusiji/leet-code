package site.teamo.sword.o45;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/22 15:43
 * @Description:
 */

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * <p>
 * <p>
 * 提示:
 * <p>
 * 0 < nums.length <= 100
 * 说明:
 * <p>
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 */
public class Solution {
    public String minNumber(int[] nums) {
        return Arrays.stream(nums)
                .mapToObj(i->String.valueOf(i))
                .sorted((o1, o2) -> (o1+o2).compareTo(o2+o1))
                .collect(Collectors.joining(""));
    }
}
