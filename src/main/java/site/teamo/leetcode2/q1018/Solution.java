package site.teamo.leetcode2.q1018;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 爱做梦的锤子
 * @create 2021/1/14
 */
public class Solution {

    /**
     *
     * @param A
     * @return
     */
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> answer = new ArrayList<>();
        int flag = 0;
        for (int i = 0; i < A.length; i++) {
            flag = ((flag << 2) + A[i]) % 5;
            answer.add(flag == 0 ? true : false);
        }
        return answer;
    }

    public static void main(String[] args) {
        new Solution().prefixesDivBy5(new int[]{1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1});
    }
}
