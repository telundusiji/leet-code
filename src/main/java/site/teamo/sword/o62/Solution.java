package site.teamo.sword.o62;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/23 17:13
 * @Description:
 */

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 * <p>
 * 输入: n = 10, m = 17
 * 输出: 2
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 */
public class Solution {

    public int lastRemaining2(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        for (int index = 0; n > 1; n--) {
            index = (index + m - 1) % n;
            list.remove(index);
        }
        return list.get(0);
    }

    public int lastRemaining(int n, int m) {
        Node head = build(n);
        for (head = next(head, m); head != head.next; head = next(head, m)) {
            Node temp = head;
            head = head.next;
            temp.pre.next = temp.next;
            temp.next.pre = temp.pre;
            temp.pre = null;
            temp.next = null;
        }
        return head.val;
    }

    private Node next(Node node, int m) {
        for (int i = 1; i < m; i++) {
            node = node.next;
        }
        return node;
    }

    private Node build(int n) {
        Node head = new Node(0);
        Node p = head;
        for (int i = 1; i < n; i++) {
            p.next = new Node(i);
            p.next.pre = p;
            p = p.next;
        }
        p.next = head;
        head.pre = p;
        return head;
    }

    private static final class Node {
        int val;
        Node next;
        Node pre;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int i = new Solution().lastRemaining(70866, 116922);
        System.out.println(i);
    }
}
