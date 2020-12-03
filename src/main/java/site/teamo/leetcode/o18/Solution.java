package site.teamo.leetcode.o18;

/**
 * @author 爱做梦的锤子
 * @create 2020/12/2
 */

/**
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * <p>
 * 说明：
 * <p>
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 */
public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pointer = new ListNode(-1);
        pointer.next = head;
        ListNode newHead = pointer;
        while (pointer != null && pointer.next != null) {
            if (pointer.next.val != val) {
                pointer = pointer.next;
                continue;
            }
            pointer.next = pointer.next.next;
            break;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(-99);
        new Solution().deleteNode(head, -99);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
