package com.dgangle.tree;

import com.dgangle.tree.tree01_recursion.Q222;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2022/8/26 16:01
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
