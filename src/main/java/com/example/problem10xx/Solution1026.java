package com.example.problem10xx;

import com.example.common.TreeNode;

/**
 * @author xiejx
 * @date 2024/1/11 9:49
 */
public class Solution1026 {
    private int maxDiff;
    public int maxAncestorDiff(TreeNode root) {
        maxDiff = 0;
        postOrder(root);
        return maxDiff;
    }

    private int[] postOrder(TreeNode root) {
        if (root == null) {
            return null;
        }

        int[] leftRes = postOrder(root.left);
        int[] rightRes = postOrder(root.right);
        int[] temp;
        if (leftRes == null && rightRes == null) {
            temp = new int[]{root.val, root.val};
        } else if (leftRes == null) {
            maxDiff = Math.max(Math.max(Math.abs(root.val - rightRes[0]), Math.abs(root.val - rightRes[1])), maxDiff);
            temp = new int[]{Math.max(rightRes[0], root.val), Math.min(rightRes[1], root.val)};
        } else if (rightRes == null) {
            maxDiff = Math.max(Math.max(Math.abs(root.val - leftRes[0]), Math.abs(root.val - leftRes[1])), maxDiff);
            temp = new int[]{Math.max(leftRes[0], root.val), Math.min(leftRes[1], root.val)};
        } else {
            maxDiff = Math.max(Math.max(Math.abs(root.val - rightRes[0]), Math.abs(root.val - rightRes[1])), maxDiff);
            maxDiff = Math.max(Math.max(Math.abs(root.val - leftRes[0]), Math.abs(root.val - leftRes[1])), maxDiff);
            temp = new int[]{Math.max(Math.max(leftRes[0], rightRes[0]), root.val),
                    Math.min(Math.min(leftRes[1], rightRes[1]), root.val)};
        }
        return temp;
    }
}
