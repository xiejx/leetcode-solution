package com.example.problem16xx;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Medium
 * CPU: 91.04% Memory: 26.05%
 */
public class Solution1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int result = 0;
        int n = heights.length;
        // 放置所有需要砖的地方
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < n; i++) {
            int diff = heights[i - 1] - heights[i];
            if (diff >= 0) {
                result = i;
                continue;
            }
            queue.add(diff);
            bricks += diff;
            while (bricks < 0 && !queue.isEmpty() && ladders > 0) {
                int temp = queue.poll();
                bricks -= temp;
                ladders -= 1;
            }
            if (bricks >= 0) {
                result = i;
            } else {
                break;
            }
        }
        return result;
    }
}
