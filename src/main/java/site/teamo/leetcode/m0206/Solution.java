package site.teamo.leetcode.m0206;

/**
 * @author 爱做梦的锤子
 * @create 2020/12/2
 */

import java.util.List;

/**
 * 面试题 02.06. 回文链表
 * 编写一个函数，检查输入的链表是否是回文的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 * <p>
 * 输入： 1->2->2->1
 * 输出： true
 */

public class Solution {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        /**
         * 找到中间节点
         */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        /**
         * 翻转后半部分，将翻转后的链表与原链表的前部分比较
         */
        ListNode flip = flip(slow);
        while (flip != null) {
            if (flip.val != head.val) {
                return false;
            }
            flip = flip.next;
            head = head.next;
        }
        return true;

    }

    private ListNode flip(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = newHead;
            newHead = new ListNode(head.val);
            newHead.next = temp;
            head = head.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        boolean palindrome = new Solution().isPalindrome(head);
        System.out.println();
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
