package com.example.problem5xx;

import com.example.common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy
 * CPU: 100% Memory: 99.72%
 */
public class Solution590 {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        postOrder0(root, result);
        return result;
    }

    private void postOrder0(Node root, List<Integer> list) {
        for (Node node: root.children) {
            postOrder0(node, list);
        }
        list.add(root.val);
    }
}
