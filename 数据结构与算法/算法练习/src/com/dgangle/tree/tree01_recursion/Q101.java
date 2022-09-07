package com.dgangle.tree.tree01_recursion;

import com.dgangle.tree.TreeNode;
import com.sun.source.tree.Tree;

/**
 * 101. 对称二叉树
 * AC (没答出来, 看的题解)
 *
 * @author gqshuang
 * @version 1.0
 * @date 2022/9/6 16:14
 */
public class Q101 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }

    /* 给你一个二叉树的根节点 root ， 检查它是否轴对称。 */
    public static boolean isSymmetric(TreeNode root) {
        // 1. 比较两个子节点
        // 2. 比较l子节点的l 和 R子节点的R
        // 3. 比较l子节点的R 和 R子节点的L
        return isSample(root, root);
    }

    // 两个节点相同
    public static boolean isSample(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true; // 都为空
        if (l == null || r == null) return false; // 只有一个为空
        return l.val == r.val && isSample(l.left, r.right) && isSample(l.right, r.left);
        // return l.left == r.right && l.right == r.left;
    }


}
