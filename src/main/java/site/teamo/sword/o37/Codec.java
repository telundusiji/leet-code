package site.teamo.sword.o37;

/**
 * @Created: 爱做梦的锤子
 * @Date: 2021/5/19 16:39
 * @Description:
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringJoiner;

/**
 * 剑指 Offer 37. 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 示例:
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.removeLast();
            if (treeNode == null) {
                sj.add("null");
                continue;
            }
            sj.add(String.valueOf(treeNode.val));
            queue.addFirst(treeNode.left);
            queue.addFirst(treeNode.right);
        }
        return sj.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String substring = data.substring(1, data.length() - 1).trim();
        if (substring == null || "".equals(substring)) {
            return null;
        }
        String[] split = substring.split(",");
        if (split.length == 0) {
            return null;
        }
        ArrayList<TreeNode> nodes = new ArrayList<>(split.length);
        int index = 1;
        for (int i = 0; i < split.length && index < split.length; i++) {
            if (nodes.isEmpty()) {
                nodes.add(getNode(split, i));
            }
            TreeNode node = nodes.get(i);
            if (node == null) {
                continue;
            }
            node.left = getNode(split, index++);
            nodes.add(node.left);
            node.right = getNode(split, index++);
            nodes.add(node.right);
        }
        return nodes.isEmpty() ? null : nodes.get(0);
    }

    private static TreeNode getNode(String[] split, int i) {
        return "null".equals(split[i]) ? null : new TreeNode(Integer.valueOf(split[i]));
    }

    public static void main(String[] args) {
        TreeNode deserialize = new Codec().deserialize("[]");
        System.out.println(deserialize);
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
