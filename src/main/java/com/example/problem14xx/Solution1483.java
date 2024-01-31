package com.example.problem14xx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hard
 * CPU: 60.96% Memory: 65.78%
 * @author xiejx
 * @date 2024/1/31 19:31
 */
public class Solution1483 {

}

class TreeAncestor {
    // 节点i的第2^j个祖先
    private int[][] ancestor;

    public TreeAncestor(int n, int[] parent) {
        ancestor = new int[n][16];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ancestor[i], -1);
        }
        for (int i = 0; i < n; i++) {
            ancestor[i][0] = parent[i];
        }
        for (int j = 1; j < 16; j++) {
            for (int i = 0; i < n; i++) {
                if (ancestor[i][j - 1] != - 1) {
                    ancestor[i][j] = ancestor[ancestor[i][j - 1]][j - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < 16; j++) {
            if (((k >> j) & 1) != 0) {
                node = ancestor[node][j];
                if (node == -1) {
                    return -1;
                }
            }
        }
        return node;
    }
}


