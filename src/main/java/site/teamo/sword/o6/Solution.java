package site.teamo.sword.o6;

import java.util.Stack;

public class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> data = new Stack<>();
        while (head != null) {
            data.push(head.val);
            head = head.next;
        }
        int[] result = new int[data.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = data.pop();
        }
        return result;
    }

    public int[] reversePrint2(ListNode head) {
        int count = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            count++;
        }
        int[] result = new int[count];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = head.val;
            head = head.next;
        }
        return result;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

