package site.teamo.leetcode.q1290;

/**
 * @author 爱做梦的锤子
 * @create 2020/12/2
 */

/**
 * 1290. 二进制链表转整数
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * <p>
 * 请你返回该链表所表示数字的 十进制值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * 示例 2：
 * <p>
 * 输入：head = [0]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 * 示例 5：
 * <p>
 * 输入：head = [0,0]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表不为空。
 * 链表的结点总数不超过 30。
 * 每个结点的值不是 0 就是 1。
 */

//[1,0,0]

public class Solution {
    public int getDecimalValue(ListNode head) {
        return sum(head).intValue();
    }

    public int flag = 0;

    public Double sum(ListNode head) {
        if (head == null) {
            return 0.0;
        }
        return sum(head.next) + head.val * Math.pow(2, flag++);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(0);
        int decimalValue = new Solution().getDecimalValue(head);
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
