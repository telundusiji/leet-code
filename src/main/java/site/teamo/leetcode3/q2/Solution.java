package site.teamo.leetcode3.q2;

/**
 * @author haocongshun
 * @date 2021/11/4 19:40
 */

/**
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * 通过次数1,048,860提交次数2,559,667
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode ph = head;
        ListNode p1 = l1;
        ListNode p2 = l2;
        boolean carry = false;
        while (p1 != null || p2 != null) {
            int pv1 = 0;
            if (p1 != null) {
                pv1 = p1.val;
                p1 = p1.next;
            }
            int pv2 = 0;
            if (p2 != null) {
                pv2 = p2.val;
                p2 = p2.next;
            }
            int r = pv1 + pv2 + (carry ? 1 : 0);
            carry = false;
            ph.next = new ListNode(r % 10);
            if (r > 10) {
                carry = true;
            }
            ph = ph.next;
        }
        if (carry) {
            ph.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        final ListNode listNode = new Solution().addTwoNumbers(l1, l2);
        System.out.println();
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
