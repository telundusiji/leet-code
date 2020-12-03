package site.teamo.leetcode.q234;

/**
 * @author 爱做梦的锤子
 * @create 2020/12/2
 */

import java.util.Stack;

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode pointer = head;
        Stack<Integer> stack = new Stack<Integer>();
        while (pointer != null) {
            stack.push(pointer.val);
            pointer = pointer.next;
        }
        while (head != null) {
            if (stack.pop() != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
