package site.teamo.sword.o41;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/21 16:41
 * @Description:
 */

import java.util.PriorityQueue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 * <p>
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 * <p>
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 最多会对 addNum、findMedian 进行 50000 次调用。
 */
public class MedianFinder {

    PriorityQueue<Integer> smallQueue;
    PriorityQueue<Integer> bigQueue;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        smallQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        bigQueue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        smallQueue.offer(num);
        bigQueue.offer(smallQueue.poll());
        if (smallQueue.size() < bigQueue.size()) {
            smallQueue.offer(bigQueue.poll());
        }
    }

    public double findMedian() {
        if (smallQueue.isEmpty() && bigQueue.isEmpty()) {
            return -1;
        }
        if ((smallQueue.size() + bigQueue.size()) % 2 == 0) {
            return (smallQueue.peek() + bigQueue.peek()) / 2.0;
        }
        return smallQueue.size() > bigQueue.size() ? smallQueue.peek() + 0.0 : bigQueue.peek() + 0.0;
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        Double param_2 = obj.findMedian();
        obj.addNum(1);
        Double median = obj.findMedian();
        obj.addNum(2);
        Double median1 = obj.findMedian();
        obj.addNum(3);
        double median2 = obj.findMedian();
        System.out.println("");
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
