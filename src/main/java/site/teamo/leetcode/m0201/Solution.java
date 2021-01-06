package site.teamo.leetcode.m0201;

/**
 * @author 爱做梦的锤子
 * @create 2020/12/3
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 02.01. 移除重复节点
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * 示例2:
 * <p>
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * 提示：
 * <p>
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 * <p>
 * 如果不得使用临时缓冲区，该怎么解决？
 */
public class Solution {

    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pointer = newHead;
        Map<Integer, Integer> counter = new HashMap<>();
        while (pointer.next != null) {
            if (counter.get(pointer.next.val) == null) {
                counter.put(pointer.next.val, 1);
                pointer = pointer.next;
                continue;
            }
            pointer.next = pointer.next.next;
        }
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
