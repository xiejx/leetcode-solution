package com.example.problem5xx;

import com.example.common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy
 * CPU: 100% Memory: 97.65%
 */
public class Solution589 {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        preOrder0(root, result);
        return result;
    }

    private void preOrder0(Node root, List<Integer> list) {
        list.add(root.val);
        for (Node node: root.children) {
            preOrder0(node, list);
        }
    }
}
