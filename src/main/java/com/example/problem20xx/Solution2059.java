package com.example.problem20xx;

import java.util.*;

/**
 * Medium
 * CPU: 93.85% Memory: 75.38%
 * @author xiejx
 * @date 2024/1/22 14:36
 */
public class Solution2059 {
    public int minimumOperations(int[] nums, int start, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> queue = new LinkedList<>();
        map.put(start, 0);
        queue.addLast(start);
        while (!queue.isEmpty()) {
            int cur = queue.pollFirst();
            int nextVal = map.get(cur) + 1;
            for (int num: nums) {
                int temp1 = cur + num;
                int temp2 = cur - num;
                int temp3 = cur ^ num;
                if (temp1 == goal || temp2 == goal || temp3 == goal) {
                    return nextVal;
                }
                if (temp1 >= 0 && temp1 <= 1000 && !map.containsKey(temp1)) {
                    map.put(temp1, nextVal);
                    queue.addLast(temp1);
                }
                if (temp2 >= 0 && temp2 <= 1000 && !map.containsKey(temp2)) {
                    map.put(temp2, nextVal);
                    queue.addLast(temp2);
                }
                if (temp3 >= 0 && temp3 <= 1000 && !map.containsKey(temp3)) {
                    map.put(temp3, nextVal);
                    queue.addLast(temp3);
                }
            }
        }
        return -1;
    }
}
