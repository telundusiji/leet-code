package site.teamo.sword.o32;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/18 17:05
 * @Description:
 */

import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 */
public class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        list.addFirst(root);
        /**
         * 每一层使用null作为分隔符
         */
        list.addFirst(null);
        LinkedList<Integer> row = new LinkedList<>();
        while (!list.isEmpty()) {
            TreeNode treeNode = list.removeLast();
            /**
             * 当从队列中取出null时代表一行已经处理完，就将row放入结果集中，重新声明list存储下一行
             */
            if (treeNode == null) {
                result.add(row);
                row = new LinkedList<>();
                if (list.size() == 0) break;
                list.addFirst(null);
                continue;
            }
            row.add(treeNode.val);
            if (treeNode.left != null) list.addFirst(treeNode.left);
            if (treeNode.right != null) list.addFirst(treeNode.right);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = new Solution2().levelOrder(root);
        System.out.println(lists);
    }
}
