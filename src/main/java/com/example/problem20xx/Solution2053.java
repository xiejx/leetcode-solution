package com.example.problem20xx;

import java.util.HashMap;
import java.util.Map;

/**
 * Easy
 * CPU: 81.66% Memory: 29.15%
 */
public class Solution2053 {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String str: arr) {
            int value = map.getOrDefault(str, 0) + 1;
            map.put(str, value);
        }
        for (String str: arr) {
            if (map.get(str) == 1) {
                k--;
            }
            if (k == 0) {
                return str;
            }
        }
        return "";
    }
}
