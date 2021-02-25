package site.teamo.leetcode2.q888;

/**
 * @author 爱做梦的锤子
 * @create 2021/2/1
 */

import java.util.HashSet;

/**
 * 888. 公平的糖果棒交换
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 * <p>
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * <p>
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * <p>
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 * 示例 2：
 * <p>
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 * 示例 4：
 * <p>
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 1 <= B.length <= 10000
 * 1 <= A[i] <= 100000
 * 1 <= B[i] <= 100000
 * 保证爱丽丝与鲍勃的糖果总量不同。
 * 答案肯定存在。
 */

public class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        for (int i : A) {
            sumA = sumA + i;
        }
        for (int i : B) {
            sumB = sumB + i;
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (isFair(A[i], B[j], sumA, sumB)) {
                    int[] result = new int[2];
                    result[0] = A[i];
                    result[1] = B[j];
                    return result;
                }
            }
        }
        return null;
    }

    private boolean isFair(int ai, int bj, int sumA, int sumB) {
        return sumA - ai + bj == sumB - bj + ai;
    }

    public int[] fairCandySwap2(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : A) {
            sumA = sumA + i;
        }
        for (int i : B) {
            sumB = sumB + i;
            set.add(i);
        }
        /**
         * sumA - ai + bj == sumB - bj + ai
         * bj = (sumB-sumA+2ai)/2 = (sumB-sumA)/2 +ai
         */
        int temp = (sumB - sumA) / 2;

        for (int i : A) {
            if (set.contains(temp + i)) {
                int[] result = new int[2];
                result[0] = i;
                result[1] = temp + i;
                return result;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] result = new Solution().fairCandySwap2(new int[]{1, 1}, new int[]{2, 2});
        System.out.println();
    }
}
