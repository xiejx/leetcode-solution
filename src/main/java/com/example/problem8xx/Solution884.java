package com.example.problem8xx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Easy
 * CPU: 99.37% Memory: 6.62%
 */
public class Solution884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String str: str1) {
            int value = map.getOrDefault(str, 0) + 1;
            map.put(str, value);
        }
        for (String str: str2) {
            int value = map.getOrDefault(str, 0) + 1;
            map.put(str, value);
        }
        List<String> resultList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) {
                resultList.add(entry.getKey());
            }
        }
        String[] result = new String[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
