package com.example.problem25xx;

import com.example.common.TreeNode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Medium
 * CPU: 84.09% Memory: 89.34%
 * @author xiejx
 * @date 2024/2/20 15:58
 */
public class Solution2583 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());

        Queue<TreeNode> integerQueue = new LinkedList<>();
        integerQueue.add(root);
        while (!integerQueue.isEmpty()) {
            long val = 0;
            Queue<TreeNode> tempQueue = new LinkedList<>();
            while (!integerQueue.isEmpty()) {
                TreeNode node = integerQueue.poll();
                if (node.left != null) {
                    tempQueue.add(node.left);
                }
                if (node.right != null) {
                    tempQueue.add(node.right);
                }
                val += node.val;
            }
            queue.add(val);
            integerQueue = tempQueue;
        }
        while (k > 1 && !queue.isEmpty()) {
            queue.poll();
            k--;
        }
        return queue.isEmpty() ? -1 : queue.peek();
    }
}
