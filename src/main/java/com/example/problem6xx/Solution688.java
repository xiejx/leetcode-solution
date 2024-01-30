package com.example.problem6xx;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Medium
 * CPU: 6.20% Memory: 5.23%
 * @author xiejx
 * @date 2024/1/30 19:25
 */
public class Solution688 {
    // 方向
    private int[][] directions = new int[][]{{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
    private Map<Pair<Integer, Integer>, Double> map;
    public double knightProbability(int n, int k, int row, int column) {
        map = new HashMap<>();
        return dfs(n, row, column, k);
    }

    private double dfs(int n, int curX, int curY, int k) {
        if (curX < 0 || curX >= n || curY < 0 || curY >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        Pair<Integer, Integer> pair = new Pair<>(curX * n + curY, k);
        if (map.containsKey(pair)) {
            return map.get(pair);
        }
        double result = 0;
        for (int[] direction: directions) {
            result += 0.125 * dfs(n, curX + direction[0], curY + direction[1], k - 1);
        }
        map.put(pair, result);
        return result;
    }

    public static void main(String[] args) {
        Solution688 test = new Solution688();
        // 0.06250
        System.out.println(test.knightProbability(3,2,0,0));
        // 1
        System.out.println(test.knightProbability(1,0,0,0));
        // 0.22589
        System.out.println(test.knightProbability(10, 10,5,5));

        long start = System.currentTimeMillis();
        System.out.println(test.knightProbability(25,100,12,13));
        long end = System.currentTimeMillis();
        System.out.println("耗时： " + (end - start) + " 毫秒");
    }
}
