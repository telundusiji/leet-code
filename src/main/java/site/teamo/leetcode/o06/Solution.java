package site.teamo.leetcode.o06;

/**
 * @author 爱做梦的锤子
 * @create 2020/12/3
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 */

public class Solution {
    int[] result = new int[8];
    int size = 0;

    public int[] reversePrint(ListNode head) {
        scan(head);
        int[] data = new int[size];
        System.arraycopy(result, 0, data, 0, size);
        return data;
    }

    private void scan(ListNode node) {
        if (node == null) {
            return;
        }
        scan(node.next);
        resize();
        result[size++] = node.val;
    }

    private void resize() {
        if (size >= result.length) {
            int[] newResult = new int[result.length * 2];
            System.arraycopy(result, 0, newResult, 0, size);
            result = newResult;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
