package site.teamo.sword.o54;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/22 19:20
 * @Description:
 */

import java.util.ArrayList;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 ≤ k ≤ 二叉搜索树元素个数
 */
public class Solution {
    int counter;
    int k;
    int result;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        scan(root);
        return result;
    }

    public void scan(TreeNode node) {
        if (node == null) return;
        scan(node.right);
        counter++;
        if (counter == k) {
            result = node.val;
            return;
        }
        scan(node.left);
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


