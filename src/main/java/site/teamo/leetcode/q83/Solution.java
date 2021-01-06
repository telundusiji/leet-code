package site.teamo.leetcode.q83;

/**
 * @author 爱做梦的锤子
 * @create 2020/12/3
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pointer = newHead;
        Map<Integer, Integer> counter = new HashMap<>();
        while (pointer.next != null) {
            if (counter.get(pointer.next.val) == null) {
                counter.put(pointer.next.val, 1);
                pointer = pointer.next;
                continue;
            }
            pointer.next = pointer.next.next;
        }
        return newHead.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (fast.val != slow.val) {
                fast = fast.next;
                slow = slow.next;
                continue;
            }
            slow.next = fast.next;
            fast = fast.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
