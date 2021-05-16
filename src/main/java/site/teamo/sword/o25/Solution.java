package site.teamo.sword.o25;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/16 20:58
 * @Description:
 */

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 1000
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode pNode = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pNode.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                pNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            pNode = pNode.next;
        }
        pNode.next = l1 == null ? l2 : l1;
        return newHead.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

