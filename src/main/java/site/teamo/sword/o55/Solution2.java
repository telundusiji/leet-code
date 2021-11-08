package site.teamo.sword.o55;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/23 15:12
 * @Description:
 */

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 树的结点个数 <= 10000
 */
public class Solution2 {

    public boolean isBalanced(TreeNode root) {
        return scan(root);
    }

    /**
     * 前序遍历，判断每个节点是不是平衡的
     * @param node
     * @return
     */
    private boolean scan(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (Math.abs(deep(node.left) - deep(node.right)) > 1) return false;
        return scan(node.left) &&
                scan(node.right);
    }

    /**
     * 计算树的深度
     * @param node
     * @return
     */
    private int deep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(deep(node.left), deep(node.right)) + 1;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

