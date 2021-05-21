package site.teamo.sword.o36;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/19 15:42
 * @Description:
 */

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * <p>
 * <p>
 * <p>
 * 为了让您更好地理解问题，以下面的二叉搜索树为例：
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * <p>
 * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 */
public class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        Node leftHead = treeToDoublyList(root.left);
        /**
         * 记录一下接下来递归的右子树的节点
         */
        /**
         * 如果左子树形成的链表为空，则之间将当前节点设置为循环链表节点
         */
        Node nextRight = root.right;
        if (leftHead == null) {
            leftHead = root;
            leftHead.left = root;
            leftHead.right = root;
        } else {
            /**
             * 否则将当前节点加入循环链表
             */
            leftHead.left.right = root;
            root.left = leftHead.left;
            root.right = leftHead;
            leftHead.left = root;
        }
        Node rightHead = treeToDoublyList(nextRight);
        /**
         * 若当前节点右子树形成的循环链表为空，则之前的循环链表就是结果
         */
        if (rightHead == null) {
            return leftHead;
        } else {
            /**
             * 若当前节点右子树形成的循环链表不为空，则将有子树循环链表加入之前的循环链表中
             */
            leftHead.left.right = rightHead;
            rightHead.left.right = leftHead;
            Node temp = leftHead.left;
            leftHead.left = rightHead.left;
            rightHead.left = temp;
        }
        return leftHead;
    }

    public static void main(String[] args) {
        Node node = new Solution().treeToDoublyList(new Node(1));
        System.out.println(node);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

