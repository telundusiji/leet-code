package site.teamo.sword.o24;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/16 20:43
 * @Description:
 */

/**
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        /**
         * 三个指针，分别指向连接要反转的前一节点，要翻转的节点，和要翻转的下一个节点
         * left  mid  right
         * null   1 ->  2  -> 3  -> 4  -> 5
         *
         *      left   mid  right
         * null<- 1     2  -> 3  -> 4  -> 5
         *
         *             left   mid  right
         * null<- 1 <-  2     3  -> 4  -> 5
         *
         *                  left   mid  right
         * null<- 1 <-  2  <- 3     4  -> 5
         *
         *                         left   mid  right
         * null<- 1 <-  2  <- 3  <- 4     5     null
         *
         * 跳出循环
         *                         left   mid  right
         * null<- 1 <-  2  <- 3  <- 4  <- 5     null
         *
         */
        ListNode left = null;
        ListNode mid = head;
        ListNode right = head.next;
        while (right != null) {
            mid.next = left;
            left = mid;
            mid = right;
            right = right.next;
        }
        mid.next = left;
        return mid;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

