package com.example.problem11xx;

import com.example.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Medium
 * CPU: 30.39% Memory: 41.32%
 * @author xiejx
 * @date 2024/2/20 16:11
 */
public class Solution1161 {
    public int maxLevelSum(TreeNode root) {
        int result = 0;
        long max = Long.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            Queue<TreeNode> tempQueue = new LinkedList<>();
            long val = 0;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                val += node.val;
                if (node.left != null) {
                    tempQueue.add(node.left);
                }
                if (node.right != null) {
                    tempQueue.add(node.right);
                }
            }
            if (val > max) {
                result = level;
                max = val;
            }
            level++;
            queue = tempQueue;
        }
        return result;
    }
}
