package com.example.problem28xx;

import com.example.common.ListUtil;

import java.util.*;

/**
 * Medium
 * CPU: 100% Memory: 39.44%
 * @author xiejx
 * @date 2024/1/30 9:35
 */
public class Solution2808 {
    public int minimumSeconds(List<Integer> nums) {
        int n = nums.size();
        int result = n / 2;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer num = nums.get(i);
            if (map.containsKey(num)) {
                map.get(num).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(num, list);
            }
        }
        for (List<Integer> list: map.values()) {
            int m = list.size();
            int tempMax = 0;
            // 和右边的间隔
            if (m == 1) {
                tempMax = n;
            } else {
                for (int i = 0; i < m; i++) {
                    int rightIndex = (i + 1) % m;
                    int diff = (list.get(rightIndex) - list.get(i) + n) % n;
                    tempMax = Math.max(tempMax, diff);
                }
            }
            result = Math.min(tempMax / 2, result);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2808 test = new Solution2808();
        // 2
        System.out.println(test.minimumSeconds(ListUtil.fromArray(new int[]{2,1,3,3,2})));
        // 1
        System.out.println(test.minimumSeconds(ListUtil.fromArray(new int[]{8,13,3,3})));
        // 0
        System.out.println(test.minimumSeconds(ListUtil.fromArray(new int[]{5,5,5,5})));
        // 1
        System.out.println(test.minimumSeconds(ListUtil.fromArray(new int[]{4,18})));
    }
}
