package site.teamo.sword.o44;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/22 15:02
 * @Description:
 */

/**
 * 剑指 Offer 44. 数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * <p>
 * 请写一个函数，求任意第n位对应的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：n = 11
 * 输出：0
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= n < 2^31
 */
public class Solution {
    public int findNthDigit(int n) {
        int w = wei(n);
        int offset = offset(n, w);
        int startNum = startNum(w);
        int i = startNum + offset / (w + 1);
        int y = offset % (w + 1);
        char result = String.valueOf(i).charAt(y);
        return Integer.valueOf(result + "");
    }

    private static final int[] nums = new int[]{0, 10, 90, 900, 9000, 90_000, 900_000, 9_000_000, 90_000_000, 900_000_000};

    private int wei(int n) {
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            flag = flag + i * nums[i];
            if (n < flag) {
                return i - 1;
            }
        }
        return nums.length - 2;
    }

    private int offset(int n, int w) {
        for (int i = 0; i <= w; i++) {
            n = n - nums[i] * i;
        }
        return n;
    }

    private int startNum(int w) {
        if (w + 1 == 1) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        for (int i = 0; i < w; i++) {
            sb.append(0);
        }
        return Integer.valueOf(sb.toString());
    }

    public static void main(String[] args) {
        int wei = new Solution().findNthDigit(1000000000);
        System.out.println(wei);
    }
}
