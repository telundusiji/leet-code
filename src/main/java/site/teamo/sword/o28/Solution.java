package site.teamo.sword.o28;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/17 17:02
 * @Description:
 */

/**
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 1000
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        TreeNode sourceTree = copyTree(root);
        TreeNode mirrorTree = mirrorTree(root);
        return judge(sourceTree, mirrorTree);
    }

    private TreeNode copyTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode newNode = new TreeNode(node.val);
        newNode.left = copyTree(node.left);
        newNode.right = copyTree(node.right);
        return newNode;
    }

    private TreeNode mirrorTree(TreeNode node) {
        if (node == null) {
            return node;
        }
        TreeNode temp = node.left;
        node.left = mirrorTree(node.right);
        node.right = mirrorTree(temp);
        return node;
    }

    private boolean judge(TreeNode sourceTree, TreeNode mirrorTree) {
        if (sourceTree == null && mirrorTree == null) {
            return true;
        } else if (sourceTree == null || mirrorTree == null) {
            return false;
        }
        if (sourceTree.val != mirrorTree.val) {
            return false;
        }
        return judge(sourceTree.left, mirrorTree.left)
                && judge(sourceTree.right, mirrorTree.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        boolean symmetric = new Solution().isSymmetric(root);
        System.out.println(symmetric);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null)
            return true;
        return judge2(root.left, root.right);
    }

    public boolean judge2(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return root1.val == root2.val && judge2(root1.left, root2.right) &&
                judge2(root1.right, root2.left);
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

