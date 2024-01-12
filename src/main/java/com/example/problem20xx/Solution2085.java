package com.example.problem20xx;

import java.util.HashMap;
import java.util.Map;

/**
 *  简单
 *  CPU: 38.35% Memory: 26.78%
 * @author xiejx
 * @date 2024/1/12 11:31
 */
public class Solution2085 {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int result = 0;
        for (String word: words1) {
            int value = map1.getOrDefault(word, 0) + 1;
            map1.put(word, value);
        }
        for (String word: words2) {
            int value = map2.getOrDefault(word, 0) + 1;
            map2.put(word, value);
        }
        for (Map.Entry<String, Integer> entry: map1.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (value == 1 && map2.getOrDefault(key, 0) == 1) {
                result++;
            }
        }
        return result;
    }
}
