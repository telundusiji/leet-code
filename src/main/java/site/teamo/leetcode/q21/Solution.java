package site.teamo.leetcode.q21;

/**
 * @author 爱做梦的锤子
 * @create 2020/12/2
 */

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode();
        ListNode result = newList;
        while (l1 != null || l2 != null) {
            if (l1 == null || (l2 != null && l2.val < l1.val)) {
                newList.next = new ListNode(l2.val);
                l2 = l2.next;
                newList = newList.next;
                continue;
            }

            if (l2 == null || l1.val <= l2.val) {
                newList.next = new ListNode(l1.val);
                l1 = l1.next;
                newList = newList.next;
                continue;
            }
        }
        return result.next;
    }

    /**
     * 优化一点，就是当有一个链表为空时，则将另一个链表直接连接到结果链表的next中
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode();
        ListNode result = newList;
        while (l1 != null && l2 != null) {
            if (l2.val < l1.val) {
                newList.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                newList.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            newList = newList.next;
        }
        newList.next = l1 == null ? l2 : l1;
        return result.next;
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
