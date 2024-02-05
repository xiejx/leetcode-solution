package com.example.problem11xx;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Medium
 * CPU: 15.85% Memory: 5.69%
 * @author xiejx
 * @date 2024/2/2 17:42
 */
public class Solution1140 {
    private Map<Pair<Integer, Integer>, Integer> map;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + piles[i - 1];
        }
        map = new HashMap<>();
        int temp = dfs(prefix, 1, 0);
        return (prefix[n] + temp) / 2;
    }

    private int dfs(int[] prefix, int M, int start) {
        if (start + 1 >= prefix.length) {
            return 0;
        }
        Pair<Integer, Integer> pair = new Pair<>(start, M);
        if (map.containsKey(pair)) {
            return map.get(pair);
        }
        int max = Integer.MIN_VALUE;
        // 可以取走的石头的数量为[1, 2M]
        for (int i = 1; i <= 2 * M; i++) {
            if (i + start >= prefix.length) {
                break;
            }
            max = Math.max(max, prefix[i + start] - prefix[start] - dfs(prefix, Math.max(M, i), i + start));
        }
        map.put(pair, max);
        return max;
    }

    public static void main(String[] args) {
        Solution1140 test = new Solution1140();
        // 3
        System.out.println(test.stoneGameII(new int[]{1,2}));
        // 10
        System.out.println(test.stoneGameII(new int[]{2,7,9,4,4}));
        // 104
        System.out.println(test.stoneGameII(new int[]{1,2,3,4,5,100}));
    }
}
