package site.teamo.sword.o30;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/17 18:57
 * @Description:
 */

/**
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 各函数的调用总次数不超过 20000 次
 */
public class MinStack {

    /**
     * initialize your data structure here.
     */

    private Node head;

    public MinStack() {

    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
            return;
        }
        Node newNode = new Node(x, head.min < x ? head.min : x);
        newNode.next = head;
        head = newNode;
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        if (head == null) return Integer.MIN_VALUE;
        return head.val;
    }

    public int min() {
        if (head == null) return Integer.MIN_VALUE;
        return head.min;
    }

    private static class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
}
