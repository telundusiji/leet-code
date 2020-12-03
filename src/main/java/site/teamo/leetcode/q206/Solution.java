package site.teamo.leetcode.q206;

/**
 * @author 爱做梦的锤子
 * @create 2020/12/2
 */

import java.util.List;

/**
 * 206. 反转链表
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */

public class Solution {
    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = newHead;
            newHead = new ListNode(head.val);
            newHead.next = temp;
            head = head.next;
        }
        return newHead;
    }

    /**
     * 递归
     * 1 2 3
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode result = listNode;
        scan(head);
        return result.next;
    }

    private ListNode listNode = new ListNode(-1);

    private void scan(ListNode head) {
        if (head == null) {
            return;
        }
        scan(head.next);
        listNode.next = new ListNode(head.val);
        listNode = listNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


