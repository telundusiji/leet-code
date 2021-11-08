package site.teamo.sword.o55;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/22 21:41
 * @Description:
 */

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * 例如：
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 10000
 */
public class Solution {
    int deep = 0;
    int maxDeep = 0;

    public int maxDepth(TreeNode root) {
        scan(root);
        return maxDeep;
    }

    private void scan(TreeNode node) {
        if (node == null) {
            return;
        }
        deep++;
        if (node.left == null && node.right == null) {
            if (maxDeep < deep) {
                maxDeep = deep;
            }
            deep--;
            return;
        }
        scan(node.left);
        scan(node.right);
        deep--;
    }
}
