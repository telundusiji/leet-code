package site.teamo.sword.o33;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/18 17:29
 * @Description:
 */

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * <p>
 * <p>
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 数组长度 <= 1000
 */
public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return handle(postorder, 0, postorder.length);
    }

    /**
     * 要判断的数据，及起始范围
     * @param postorder
     * @param s
     * @param e
     * @return
     */
    public boolean handle(int[] postorder, int s, int e) {
        if (s >= e) {
            return true;
        }
        /**
         * 获取左子树和有子树的分界
         */
        int index = getIndex(postorder, s, e);
        /**
         * 判断当前数据是否符合二分搜索树要求
         */
        if (!judge(postorder, index, e)) {
            return false;
        }
        /**
         * 递归的去判断当前节点的左子树和右子树
         */
        return handle(postorder, s, index)
                && handle(postorder, index, e - 1);
    }

    public boolean judge(int[] postorder, int index, int e) {
        int root = postorder[e - 1];
        for (int i = index; i < e - 1; i++) {
            if (postorder[i] < root) {
                return false;
            }
        }
        return true;
    }

    private int getIndex(int[] postorder, int s, int e) {
        int root = postorder[e - 1];
        int index = e - 1;
        for (int i = s; i < e - 1; i++) {
            if (postorder[i] > root) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        boolean b = new Solution().verifyPostorder(new int[]{7, 4, 6, 5});
        System.out.println(b);
    }
}
