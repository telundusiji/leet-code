package site.teamo.leetcode2.m0402;

/**
 * @author 爱做梦的锤子
 * @create 2021/1/21
 */

import java.util.Arrays;

/**
 * 面试题 04.02. 最小高度树
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * <p>
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length);
    }

    public TreeNode build(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int mid = (end - start) / 2 + start;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = build(nums, start, mid);
        treeNode.right = build(nums, mid + 1, end);
        return treeNode;
    }

    public static void main(String[] args) {
        System.out.println(5 / 2);

        TreeNode treeNode = new Solution().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println();
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
