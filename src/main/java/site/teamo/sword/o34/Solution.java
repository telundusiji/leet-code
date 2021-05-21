package site.teamo.sword.o34;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/18 21:06
 * @Description:
 */

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * <p>
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 target = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 10000
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) return new LinkedList<>();
        List<List<Integer>> ways = new LinkedList<>();
        find(root, target, new LinkedList<Integer>(), ways);
        return ways;
    }

    public void find(TreeNode node, int maxTarget, LinkedList<Integer> way, List<List<Integer>> ways) {
        if (node==null) {
            return;
        }
        way.addLast(node.val);
        maxTarget = maxTarget-node.val;
        if (maxTarget == 0 && node.left == null && node.right == null) {
            ways.add(new LinkedList<>(way));
        }
        find(node.left, maxTarget, way, ways);
        find(node.right, maxTarget, way, ways);
        way.removeLast();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-3);
        root.right = new TreeNode(-2);
        List<List<Integer>> lists = new Solution().pathSum(root, -5);
        System.out.println(lists);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

