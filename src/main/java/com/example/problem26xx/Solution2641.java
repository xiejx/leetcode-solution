package com.example.problem26xx;

import com.example.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Medium
 * CPU: 33.79% Memory: 28.85%
 * @author xiejx
 * @date 2024/2/20 16:24
 */
public class Solution2641 {
    // 记录第level层之和
    Map<Integer, Integer> map;
    public TreeNode replaceValueInTree(TreeNode root) {
        map = new HashMap<>();
        preOrderForLevelSum(root, 0);
        preOrderForSetVal(root, 0);
        root.val = 0;
        return root;
    }


    private void preOrderForLevelSum(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        int val = map.getOrDefault(level, 0) + root.val;
        map.put(level, val);
        preOrderForLevelSum(root.left, level + 1);
        preOrderForLevelSum(root.right, level + 1);
    }

    private void preOrderForSetVal(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        int leftVal = root.left == null ? 0 : root.left.val;
        int rightVal = root.right == null ? 0 : root.right.val;
        int levelSum = map.getOrDefault(level + 1, 0) - leftVal - rightVal;
        if (root.left != null) {
            root.left.val = levelSum;
        }
        if (root.right != null) {
            root.right.val = levelSum;
        }
        preOrderForSetVal(root.left, level + 1);
        preOrderForSetVal(root.right, level + 1);
    }
}
