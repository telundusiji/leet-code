package site.teamo.sword.o26;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/16 21:06
 * @Description:
 */

/**
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 B：
 * <p>
 * 4
 * /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 10000
 */
public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        /**
         * 两个节点，任意一个空，则返回false
         */
        if (A == null || B == null) {
            return false;
        }
        /**
         * 当前节点的值相同时，进行是否子树判断
         */
        if (A.val == B.val) {
            if (judge(A, B)) {
                return true;
            }
        }
        /**
         * 以上没返回true，则说明还没有相同的子树，则递归的取判断A的左右子树中是否包含B结构
         */
        return isSubStructure(A.left, B)
                || isSubStructure(A.right, B);
    }

    public boolean judge(TreeNode A, TreeNode B) {
        /**
         * 当B节点为空时，终止递归
         */
        if (B == null) {
            return true;
        }
        /**
         * A节点为空，B节点不为空，则说明相同位置A不包含B，则返回false
         */
        if (A == null && B != null) {
            return false;
        }
        /**
         * 同一位置A和B的节点的值不同，则返回false
         */
        if (B.val != A.val) {
            return false;
        }
        /**
         * 递归的依次去比较，A和B的所有节点
         */
        return judge(A.left, B.left)
                && judge(A.right, B.right);
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

