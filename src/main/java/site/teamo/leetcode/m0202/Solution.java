package site.teamo.leetcode.m0202;

/**
 * @author 爱做梦的锤子
 * @create 2020/12/2
 */

/**
 * 面试题 02.02. 返回倒数第 k 个节点
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例：
 * <p>
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 * <p>
 * 给定的 k 保证是有效的。
 */
public class Solution {

    /**
     * 翻转链表，再从尾部遍历相应节点，同理辅助数据结构栈
     *
     * @param head
     * @param k
     * @return
     */
    public int kthToLast(ListNode head, int k) {
        ListNode newHead = new ListNode(head.val);
        while (head.next != null) {
            ListNode temp = newHead;
            newHead = new ListNode(head.next.val);
            newHead.next = temp;
            head = head.next;
        }
        for (int i = 0; i < k - 1; i++) {
            newHead = newHead.next;
        }
        return newHead.val;
    }

    /**
     * 使用双指针
     *
     * @param head
     * @param k
     * @return
     */
    public int kthToLast2(ListNode head, int k) {
        ListNode pointerFast = head;
        ListNode pointerSlow = head;
        int i = 0;
        while (pointerFast != null) {
            if (i >= k) {
                pointerSlow = pointerSlow.next;
            }
            i++;
            pointerFast = pointerFast.next;
        }
        return pointerSlow.val;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int i = new Solution().kthToLast2(head, 2);
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