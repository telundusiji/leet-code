package site.teamo.sword.o7;

import java.util.Arrays;

/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * <p>
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length <= 0 || inorder.length <= 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = findIndex(inorder, preorder[0]);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + index), Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + index, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return root;
    }

    public int findIndex(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder.length <= 0 || inorder.length <= 0) {
            return null;
        }
        return buildTreeDo(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode buildTreeDo(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (pe - ps <= 0 || ie - is <= 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[ps]);
        int index = findIndex(inorder, preorder[ps]);
        root.left = buildTreeDo(preorder, ps + 1, ps + 1 + (index-is), inorder, is, index+1);
        root.right = buildTreeDo(preorder, ps + 1 + (index-is), pe, inorder, index + 1, ie);
        return root;
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
