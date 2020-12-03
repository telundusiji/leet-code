package site.teamo.leetcode.q203;

/**
 * @author 爱做梦的锤子
 * @create 2020/12/2
 */

/**
 * 203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */

// 1 2 3 3

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pointer = new ListNode(-1);
        pointer.next = head;
        ListNode newHead = pointer;
        while (pointer != null && pointer.next != null) {
            if (pointer.next.val != val) {
                pointer = pointer.next;
                continue;
            }
            pointer.next = pointer.next.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        int[] a = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(1);
        ListNode newHead = head;
        for (int i = 1; i < a.length; i++) {
            head.next = new ListNode(a[i]);
            head = head.next;
        }
        ListNode listNode = new Solution().removeElements(newHead, 6);
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