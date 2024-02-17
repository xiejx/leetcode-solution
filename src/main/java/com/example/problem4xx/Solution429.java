package com.example.problem4xx;

import com.example.common.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Medium
 * CPU: 78.03% Memory: 65.75%
 */
public class Solution429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (true) {
            List<Integer> tempList = new ArrayList<>();
            Queue<Node> tempQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                tempList.add(node.val);
                for (Node node1: node.children) {
                    tempQueue.add(node1);
                }
            }
            result.add(tempList);
            if (tempQueue.isEmpty()) {
                break;
            } else {
                queue = tempQueue;
            }
        }
        return result;
    }
}

