package com.example.common;

/**
 * 树节点
 * @author xiejx
 * @date 2024/1/10 19:22
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {
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
