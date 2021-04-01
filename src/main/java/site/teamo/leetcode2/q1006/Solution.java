package site.teamo.leetcode2.q1006;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Solution {

    /**
     * 1006. 笨阶乘
     * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
     * <p>
     * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
     * <p>
     * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
     * <p>
     * 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
     * <p>
     * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：4
     * 输出：7
     * 解释：7 = 4 * 3 / 2 + 1
     * 示例 2：
     * <p>
     * 输入：10
     * 输出：12
     * 解释：12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= N <= 10000
     * -2^31 <= answer <= 2^31 - 1  （答案保证符合 32 位整数。）
     *
     * @param N
     * @return
     */

    public int clumsy(int N) {
        /**
         * 0* 1/ 2+ 3-
         */
        ArrayList<Integer> resultList = new ArrayList<>(N);
        resultList.add(N);
        for (int i = N - 1, op = 0; i > 0; i--, op++) {
            if (op % 4 == 0) {
                resultList.add(resultList.remove(resultList.size() - 1) * i);
            } else if (op % 4 == 1) {
                resultList.add(resultList.remove(resultList.size() - 1) / i);
            } else if (op % 4 == 2) {
                resultList.add(i);
            } else {
                resultList.add(-1 * i);
            }
        }
        int result = 0;
        for (Integer integer : resultList) {
            result = result + integer;
        }
        return result;
    }

    public int clumsy2(int N) {
        if (N == 3) return 6;
        if (N == 2) return 2;
        if (N == 1) return 1;
        if (N == 0) return 0;
        int result = N * (N - 1) / (N - 2) + (N - 3);
        N = N - 4;
        while (N >= 4) {
            result = result - N * (N - 1) / (N - 2) + (N - 3);
            N = N - 4;
        }
        return result - clumsy2(N);
    }

    public static void main(String[] args) {
        int clumsy = new Solution().clumsy2(8);
        /**
         * 8*7/6+5-4*3/2+1
         */
        System.out.println(clumsy);
    }
}
