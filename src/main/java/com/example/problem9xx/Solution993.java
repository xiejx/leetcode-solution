package com.example.problem9xx;

import com.example.common.TreeNode;

/**
 * Easy
 * CPU: 100% Memory: 73.97%
 * @author xiejx
 * @date 2024/2/20 16:43
 */
public class Solution993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        int[][] temp = new int[2][2];
        preOrder(root, temp, x, y, 0);
        return temp[0][0] == temp[1][0] && temp[0][1] != temp[1][1];
    }

    private void preOrder(TreeNode root, int[][] record, int x, int y, int level) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            int val = root.left.val;
            if (val == x) {
                record[0][0] = level + 1;
                record[0][1] = root.val;
            } else if (val == y) {
                record[1][0] = level + 1;
                record[1][1] = root.val;
            }
            preOrder(root.left, record, x, y, level + 1);
        }
        if (root.right != null) {
            int val = root.right.val;
            if (val == x) {
                record[0][0] = level + 1;
                record[0][1] = root.val;
            } else if (val == y) {
                record[1][0] = level + 1;
                record[1][1] = root.val;
            }
            preOrder(root.right, record, x, y, level + 1);
        }
    }
}
