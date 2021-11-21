package site.teamo.leetcode3.q1218;

import java.util.HashMap;

/**
 * @author haocongshun
 * @date 2021/11/5 16:39
 */
public class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            Integer integer = map.get(arr[i] - difference);
            if (integer == null) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], integer + 1);
                max = Math.max(max, integer + 1);
            }
        }
        return max;
    }

    public int handle(int[] arr, int start, int difference) {
        int temp = 1;
        int next = arr[start] + difference;
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] == next) {
                next = arr[i] + difference;
                temp++;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int i = new Solution().longestSubsequence(new int[]{1, 2, 3, 4}, 1);
    }
}
