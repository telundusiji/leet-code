package site.teamo.sword.o8;

/**
 * 给定一个二叉树和其中一个节点，找出中序遍历的下一个节点并且返回，树中节点不仅包括左右子树节点，还包含指向父节点的指针
 */
public class Solution {
    public TreeNode getNext(TreeNode pNode) {
        /**
         * 如果给出空节点，则返回空
         */
        if (pNode == null) {
            return null;
        }

        /**
         * 当前节点存在右子树，则其中序遍历的下一个节点就是其右子树中，最左边的节点
         */
        if (pNode.right != null) {
            TreeNode temp = pNode.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }

        /**
         * 当前节点的右子树等于空，且指向父节点指针为空,则其为根节点，其中序遍历无下一个节点
         */
        if (pNode.parent == null) {
            return null;
        }
        /**
         * 当前节点右子树为空，且其是父节点的左孩子节点，所以其中序遍历下一个节点就是其父节点
         */
        if(pNode.parent.left==pNode){
            return pNode.parent;
        }
        /**
         * 当前节点右子树为空，且其是父节点的右孩子节点，所以其中序遍历的下一个节点，在其父节点中去寻找
         */
        TreeNode temp = pNode;
        while (temp.parent!=null&&temp.parent.right==temp){
            temp = temp.parent;
        }
        return temp.parent;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    TreeNode(int x) {
        val = x;
    }
}
