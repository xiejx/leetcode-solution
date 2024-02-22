package com.example.problem8xx;

import com.example.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Medium
 * CPU: 16.63% Memory: 32.26%
 * @author xiejx
 * @date 2024/2/22 9:36
 */
public class Solution889 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(postorder[i], i);
        }
        buildTree(preorder, postorder, map, root, 1, n - 1, 0, n - 2);
        return root;
    }

    private void buildTree(int[] preorder, int[] postorder, Map<Integer, Integer> map, TreeNode root,
                           int start1, int end1, int start2, int end2) {
        if (start1 > end1) {
            return;
        }
        int leftRoot = preorder[start1];
        int rightRootIndex = map.get(leftRoot);
        if (rightRootIndex == end2) {
            TreeNode leftTree = new TreeNode(leftRoot);
            root.left = leftTree;
            buildTree(preorder, postorder, map, leftTree, start1 + 1, end1, start2, end2 - 1);
        } else {
            TreeNode leftTree = new TreeNode(leftRoot);
            int leftTreeNum = rightRootIndex - start2 + 1;
            int rightRoot = preorder[start1 + leftTreeNum];
            TreeNode rightTree = new TreeNode(rightRoot);
            root.left = leftTree;
            root.right = rightTree;
            buildTree(preorder, postorder, map, leftTree, start1 + 1, start1 + leftTreeNum - 1, start2, rightRootIndex - 1);
            buildTree(preorder, postorder, map, rightTree, start1 + leftTreeNum + 1, end1, rightRootIndex + 1, end2 - 1);
        }

    }
}
