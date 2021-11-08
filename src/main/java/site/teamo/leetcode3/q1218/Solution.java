package site.teamo.leetcode3.q1218;

import java.util.HashMap;

/**
 * @author haocongshun
 * @date 2021/11/5 16:39
 */
public class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, arr[arr.length - 1]);

        for (int i = arr.length - 2; i >= 0; i--) {
            int temp = arr[i];
            map.entrySet()
                    .forEach(entry -> {
                        if (temp + difference == entry.getValue()) {
                            
                        }
                    });
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
}
