package com.example.problem12xx;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Hard
 * CPU: 13.53% Memory: 50.50%
 * @author xiejx
 * @date 2024/1/31 9:53
 */
public class Solution1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // 结束的时候，能获得的最大利润
        TreeMap<Integer, Integer> treeMap = new TreeMap();
        treeMap.put(0, 0);
        int n = startTime.length;
        int[][] temp = new int[n][3];
        for (int i = 0; i < n; i++) {
            temp[i][0] = startTime[i];
            temp[i][1] = endTime[i];
            temp[i][2] = profit[i];
        }
        Arrays.sort(temp, (arr1, arr2) -> {
            if (arr2[1] == arr1[1]) {
                return arr1[0] - arr2[0];
            } else {
                return arr1[1] - arr2[1];
            }
        });
        for (int i = 0; i < n; i++) {
            Integer key = treeMap.floorKey(temp[i][0]);
            int tempMax = treeMap.get(treeMap.floorKey(temp[i][1] - 1));
            int value = treeMap.getOrDefault(temp[i][1], 0);
            int max = Math.max(tempMax, Math.max(treeMap.get(key) + temp[i][2], value));
            treeMap.put(temp[i][1], max);
        }
        int max = 0;
        for (int value: treeMap.values()) {
            max = Math.max(value, max);
        }
        return max;
    }
}
