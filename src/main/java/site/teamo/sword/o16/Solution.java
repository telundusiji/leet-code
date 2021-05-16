package site.teamo.sword.o16;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/14 15:02
 * @Description:
 */

/**
 * 剑指 Offer 16. 数值的整数次方
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * <p>
 * 提示：
 * <p>
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 */
public class Solution {

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        /**
         * 二分法
         */
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        /**
         * x^n = x^(n/2)*x^(n/2)*x^(n%2)
         */
        return half * half * mod;
    }

    public double myPow2(double x, int n) {
        if (x == 0D && n <= 0) {
            return 0;
        }
        if (n == 0 && x > 0) {
            return 1;
        }
        return n >= 0 ? pow(x, n) : 1 / pow(x, -n);
    }

    private double pow(double x, int n) {
        if (n == 1) {
            return x;
        }
        return n % 2 == 0 ? pow2(x, n) : pow2(x, n - 1) * x;
    }

    private double pow2(double x, int n) {
        double result = pow(x, n >> 1);
        return result * result;
    }

    public static void main(String[] args) {
        double v = new Solution().myPow(2.0, -2);
        System.out.println(Math.abs(Integer.MIN_VALUE + 1));
        System.out.println(Integer.MAX_VALUE);
    }
}
