package com.dgangle.tree.tree02_levelTraversal;

import com.dgangle.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 *
 * @author gqshuang
 * @version 1.0
 * @date 2022/9/7 17:13
 */
public class Q102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        // root.left.left = new TreeNode(3);
        // root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(Arrays.toString(levelOrder(root).toArray()));


        // List<Integer> list = new ArrayList<>();
        // initList(list);
        // System.out.println(Arrays.toString(list.toArray()));
    }

    /* 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        List<Integer> integerList = new ArrayList<>();
        addList(list, root.left, root.right);
        // list.add(integerList);
        return list;
    }

    public static List<List<Integer>> addList(List<List<Integer>> list, TreeNode l, TreeNode r) {
        if (l != null && r != null) return list;
        List<Integer> valList = new ArrayList<>();
        list.add(valList);
        if (l != null) {
            valList.add(l.val);
            addList(list, l.left, l.right);
        }
        if (r != null) {
            valList.add(r.val);
            addList(list, r.left, r.right);
        }
        return list;
    }

    public static void initList(List<Integer> list){
        list.add(1);
        list.add(2);
        list.add(3);
    }

}
