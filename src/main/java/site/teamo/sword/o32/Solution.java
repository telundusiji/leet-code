package site.teamo.sword.o32;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/18 09:30
 * @Description:
 */

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 * <p>
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回：
 * <p>
 * [3,9,20,15,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 */
public class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addFirst(root);
        LinkedList<Integer> result = new LinkedList<>();
        while (!list.isEmpty()) {
            TreeNode treeNode = list.removeLast();
            result.add(treeNode.val);
            if (treeNode.left != null) list.addFirst(treeNode.left);
            if (treeNode.right != null) list.addFirst(treeNode.right);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
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


